package com.fafukeji.controller;

import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.EvaluateAbove;
import com.fafukeji.service.IEvaluateAboveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/28.
 */
@Controller
@RequestMapping("EvaluateAbove")
public class EvaluateAboveController extends BaseController{
    public static Logger log = Logger.getLogger(MessageController.class);

    @Autowired
    private IEvaluateAboveService iEvaluateAboveService;

    @RequestMapping("/index")
    public String index(){
        return "test";
    }

    @RequestMapping("/insert")
    public String insertEvaluateAbove( EvaluateAbove evaluateAbove,HttpServletRequest request, HttpServletResponse response, Model model){
        String result = iEvaluateAboveService.insertSelective(evaluateAbove)==1?"添加成功": "添加失败";
        addMessage(model,true,result);
        return "test";
    }

    @RequestMapping("/update")
    public String updateEvaluateAbove( EvaluateAbove evaluateAbove,HttpServletRequest request, HttpServletResponse response, Model model){
        String result = iEvaluateAboveService.updateByPrimaryKeySelective(evaluateAbove)==1?"修改成功": "修改失败";
        addMessage(model,true,result);
        return "test";
    }

    @RequestMapping("/delete")
    public String deleteEvaluateAbove(Integer id,HttpServletRequest request, HttpServletResponse response, Model model){
        String result = iEvaluateAboveService.deleteByPrimaryKey(id)==1?"删除成功": "删除失败";
        addMessage(model,true,result);
        return "test";
    }

    @RequestMapping("/select")
    public String selectEvaluateAbove(EvaluateAbove evaluateAbove,HttpServletRequest request, HttpServletResponse response, Model model){
        int defaultPageSize = 10;
        Page<EvaluateAbove> evaluateAbovePage = new Page<EvaluateAbove>(request,response,defaultPageSize);
        evaluateAbove.setPage(evaluateAbovePage);
        List<EvaluateAbove> evaluateAboveList = iEvaluateAboveService.selectEvaluateAbove(evaluateAbove);
        log.debug("============================" +evaluateAboveList);
        evaluateAbovePage.setList(evaluateAboveList);
        model.addAttribute("evaluatePage", evaluateAbovePage);
        return "test";
    }
}
