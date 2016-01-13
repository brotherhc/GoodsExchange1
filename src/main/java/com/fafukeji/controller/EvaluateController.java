package com.fafukeji.controller;

import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.Evaluate;
import com.fafukeji.model.Message;
import com.fafukeji.service.IEvaluateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/24.
 */
@Controller
@RequestMapping("Evaluate")
public class EvaluateController extends BaseController {
    public static Logger log = Logger.getLogger(MessageController.class);

    @Autowired
    private IEvaluateService iEvaluateService;

    @RequestMapping("/index")
    public String selecte_id(Evaluate evaluate, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        List<Evaluate> evaluateList = iEvaluateService.selecte_id(evaluate);
        model.addAttribute("evaluateid", evaluateList);
        return "evaluate/update";
    }

    @RequestMapping("/insert")
    public String insertEvaluate(Evaluate evaluate, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iEvaluateService.insertSelective(evaluate)==1?"添加成功": "添加失败";
        addMessage(model,true,result);
        return "test";
    }

    @RequestMapping("/update")
    public String updateEvaluate(Evaluate evaluate, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iEvaluateService.updateByPrimaryKeySelective(evaluate)==1?"修改成功": "修改失败";
        addMessage(model,true,result);
        return "evaluate/list";
    }

    @RequestMapping("delete")
    public String deleteEvaluate(Integer id, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iEvaluateService.deleteByPrimaryKey(id)==1?"删除成功": "删除失败";
        addMessage(model,true,result);
        return "evaluate/list";
    }

    @RequestMapping("/select")
    public String selectMessage(Evaluate evaluate, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Evaluate> evaluatePage= new Page<Evaluate>(request,response,defaultPageSize);
        evaluate.setPage(evaluatePage);
        List<Evaluate> evaluateList = iEvaluateService.selectEvaluate(evaluate);
        evaluatePage.setList(evaluateList);
        model.addAttribute("evaluatePage", evaluatePage);
        return "evaluate/list";
    }
}
