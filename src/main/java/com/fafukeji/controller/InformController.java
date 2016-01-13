package com.fafukeji.controller;

import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.*;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.EvaluateAbove;
import com.fafukeji.model.Goods;
import com.fafukeji.model.Inform;
import com.fafukeji.model.User;
import com.fafukeji.service.InformService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by java on 2015/7/28 0028.
 */

@Controller
@RequestMapping("Inform")
public class InformController extends BaseController {
    public static Logger log = Logger.getLogger(InformController.class);

    @Autowired
    private InformService informService;
    @RequestMapping("getAll")
    public String getinformAll(HttpServletRequest request,Model model) {
        try {
            List<Inform> list = informService.getAll();
            log.debug(list);
            model.addAttribute("informList", list);
            return "inform";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }
    @RequestMapping("select")
    public String selectinform(Inform inform, HttpServletRequest request,
                                     HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Inform> informPage = new Page<Inform>(request,response,defaultPageSize);
        inform.setPage(informPage);
        List<Inform> list = informService.selectinform(inform);

        for (int i = 0;i<list.size();i++){
            String in = list.get(i).getType();
            if (in.equals("0")){
                list.get(i).setType("物品与描述不符");
            }else if(in.equals("1")){
                list.get(i).setType("虚假欺诈信息");
            }
        }
        informPage.setList(list);
        model.addAttribute("List",informPage);
        return "inform/inform";
    }
//    @RequestMapping("update")
//    public String updateInform(Inform inform,HttpServletRequest request,Model model){
//        try {
//            String str = String.valueOf(informService.updateByPrimaryKey(inform));
//            model.addAttribute("InfoMessage", str);
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("InfoMessage", "更新信息失败！具体异常信息：" + e.getMessage());
//        } finally {
//            return "result";
//        }
//    }

    @SuppressWarnings("finally")
    @RequestMapping("/delete")
    public String deleteInformById(Integer id, HttpServletRequest request,Model model){
        try {
            Integer str = informService.deleteInformById(Integer.parseInt(String.valueOf(id)));
            model.addAttribute("list", str);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("InfoMessage", "删除信息失败！具体异常信息：" + e.getMessage());
        } finally {
            return "result";
        }
}
    @RequestMapping("selectid")
    public String selectid(Inform inform, HttpServletRequest request,
                              HttpServletResponse response, Model model){
        List<Inform>informList = informService.selecteid(inform);
        model.addAttribute("list",informList);
        return "inform/inform";
    }
}
