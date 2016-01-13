package com.fafukeji.V1.controller;

import com.fafukeji.V1.EvaluateResult;
import com.fafukeji.common.persistence.MobileProjectController;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.Evaluate;
import com.fafukeji.service.IEvaluateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 评论
 */
@Controller
@RequestMapping(value = "v1/project/", method = {RequestMethod.POST, RequestMethod.GET})
public class EvaluateProjectController extends BaseController {
    public static Logger log = Logger.getLogger(MobileProjectController.class);
    @Autowired
    private IEvaluateService evaluateService;
    @ResponseBody
    @RequestMapping("/evaluatejson")
    public EvaluateResult selectMessage(Evaluate evaluate, HttpServletRequest request,
                                        HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Evaluate> evaluatePage= new Page<Evaluate>(request,response,defaultPageSize);
        evaluate.setPage(evaluatePage);
        List<Evaluate> list = evaluateService.selectEvaluate(evaluate);
        evaluatePage.setList(list);

        EvaluateResult evaluateResult = new EvaluateResult();
        evaluateResult.setData(String.valueOf(list));
        evaluateResult.evaluateinfo(evaluateResult);
        return evaluateResult;
    }
}
