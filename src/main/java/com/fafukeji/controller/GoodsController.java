package com.fafukeji.controller;


import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.utils.Constants;
import com.fafukeji.common.web.*;
import com.fafukeji.model.Goods;
import com.fafukeji.model.Inform;
import com.fafukeji.service.IGoodsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by java on 2015/7/30 0030.
 */
@Controller
@RequestMapping("Goods")
public class GoodsController extends com.fafukeji.common.web.BaseController{
    public static Logger log = Logger.getLogger(MessageController.class);
    @Autowired
    private IGoodsService iGoodsService;
//
//    Integer nowpage = 1;
//    Integer pagesize = 10;
//    @RequestMapping("selectAll")
//    public ModelAndView selectAll(Integer nowpage, Integer pagesize){
//        ModelAndView mav = new ModelAndView();
//        nowpage=(nowpage-1)*pagesize;
//        List<Goods> glist =  iGoodsService.selectAllGood(nowpage, pagesize);
//        mav.addObject("glist",glist);
//        mav.setViewName("/");
//        return  mav;
//    }
//
///*
//* */


    @RequestMapping("add")
    public String insert(){
        return "modules/publish";
    }

    @RequestMapping("select")
    public String selectGoods(Goods goods, HttpServletRequest request,
                              HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Goods> goodsPage = new Page<Goods>(request,response,defaultPageSize);
        goods.setPage(goodsPage);

        List<Goods> list = iGoodsService.selectGoods(goods);
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
        model.addAttribute("goodsList", goodsPage);
        return "modules/goods";
    }
    @RequestMapping("getAll")
    public String selectGoods(HttpServletRequest request,Model model) {
        try {
            List<Goods> list = iGoodsService.getAll();
            log.debug(list);
            model.addAttribute("goodsList", list);
            return "goods";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }
    @RequestMapping("index")
    public String index(){
        return "add";
    }
    @RequestMapping("insert")
    public String insertGoods(Goods goods, HttpServletRequest request,
                              HttpServletResponse response, Model model){
        goods.setAttributes("1:1:");
        goods.setPics("");
        goods.setUrls("http:////");
        goods.setState(1);
        goods.setStatus(0);
//        goods.setUpdatedAt(2015);
//        goods.setCreatedAt(2015);
        String result = iGoodsService.insertSelective(goods)==1?"添加成功": "添加失败";
        addMessage(model,true,result);
        return "modules/goods";
    }

    @RequestMapping("update")
    public String updateEvaluate(Goods goods, HttpServletRequest request,
                                 HttpServletResponse response, Model model){
        String result = iGoodsService.updateByPrimaryKey(goods)==1?"修改成功": "修改失败";
        addMessage(model,true,result);
        return "goods";
    }

    @RequestMapping("delete")
    public String deleteMessage(Integer id, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iGoodsService.deleteByPrimaryKey(id)==1?"删除成功": "删除失败";
        addMessage(model,true,result);
        return "modules/goods";
    }

}
