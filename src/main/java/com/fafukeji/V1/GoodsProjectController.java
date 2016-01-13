package com.fafukeji.V1;

import com.fafukeji.common.persistence.MobileProjectController;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.utils.Constants;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.Goods;
import com.fafukeji.service.IDeviceTokenService;
import com.fafukeji.service.IGoodsService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *手机请求控制类
 */
@Controller
@RequestMapping("v1/project/")
public class GoodsProjectController extends BaseController{
    public static Logger log = Logger.getLogger(MobileProjectController.class);
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IDeviceTokenService deviceTokenService;

    /**
     * select
     *
     */
    @ResponseBody
    @RequestMapping(value = "/goodjson", method = {RequestMethod.POST, RequestMethod.GET})
    public GoodsResult goods(HttpServletRequest request, HttpServletResponse response) {
        Goods goods  = new Goods();
        GoodsResult goodsResult = new GoodsResult();
        int defaultPageSize = 2;
        Page<Goods> goodsPage = new Page<Goods>(request,response,defaultPageSize);
        goods.setPage(goodsPage);
        List<Goods> list = goodsService.selectGoods(goods);
        if (list.size()==0){
            goodsResult.setMsg("获取失败");
            goodsResult.setResult(0);
            return goodsResult;
        }else {
            for (Goods item:list){
                switch (item.getStatus()) {
                    case Constants.TASK_STATE_NEED_CONFIRM:
                        item.setTaskStateName("下线");
                        break;
                    case Constants.TASK_STATE_ONLINE:
                        item.setTaskStateName("已上线");
                        break;
                    case Constants.TASK_STATE_PAUSE:
                        item.setTaskStateName("锁定");
                        break;
                    default:
                        break;
                }
            }
            goodsPage.setList(list);
//            log.debug("<<<<<<<<<<<<<<<<<<<<<"+   goodsPage.setList(list));
//            goodsResult.setData(String.valueOf(goodsPage));
              goodsResult.setData(String.valueOf(list));
            goodsResult.GoodsInfo(goods);
            goodsResult.setMsg("获取成功");
        }
        return goodsResult;
    }



}
