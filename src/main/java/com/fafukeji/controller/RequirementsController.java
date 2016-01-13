package com.fafukeji.controller;


import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.utils.Constants;
import com.fafukeji.model.Requirements;
import com.fafukeji.service.IRequirementsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("Requirements")
public class RequirementsController extends com.fafukeji.common.web.BaseController{
    public static Logger log = Logger.getLogger(MessageController.class);
    @Autowired
    private IRequirementsService iRequirementsService;


    @RequestMapping("select")
    public String selectRequirements(Requirements requirements, HttpServletRequest request,
                              HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Requirements> requirementsPage = new Page<Requirements>(request,response,defaultPageSize);
        requirements.setPage(requirementsPage);
        List<Requirements> list = iRequirementsService.selectRequirements(requirements);
        for (Requirements item:list){
            switch (item.getState()) {
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
        requirementsPage.setList(list);
        model.addAttribute("List",requirementsPage);
        return "requirements/demand";
    }
    @RequestMapping("selectid")
    public String selecte_id(Requirements requirements, HttpServletRequest request,
                             HttpServletResponse response, Model model){
        List<Requirements> requirementsList = iRequirementsService.selectid(requirements);
        for (Requirements item:requirementsList){
            switch (item.getState()) {
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
        model.addAttribute("List", requirementsList);
        return "requirements/x_demand";
    }

    @RequestMapping("getAll")
    public String selectRequirements(HttpServletRequest request,Model model) {
        try {
            List<Requirements> list = iRequirementsService.getAll();
            model.addAttribute("List", list);
            log.debug(list);
            return "requirements";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }
    @RequestMapping("index")
    public String index(){
        return "requirements/x_demand";
    }
    @RequestMapping("insert")
    public String insertRequirements(Requirements requirements, HttpServletRequest request,
                              HttpServletResponse response, Model model){
        String result = iRequirementsService.insertSelective(requirements)==1?"添加成功": "添加失败";
        addMessage(model,true,result);
        return "requrements";
    }

    @RequestMapping("update")
    public String updateRequirements(Requirements requirements, HttpServletRequest request,
                                 HttpServletResponse response, Model model){
        String result = iRequirementsService.updateByPrimaryKeySelective(requirements)==1?"修改成功": "修改失败";
        addMessage(model,true,result);
        return "requirements/demand";
    }

    @RequestMapping("delete")
    public String deleteeRequirements(Integer id, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iRequirementsService.deleteByPrimaryKey(id)==1?"删除成功": "删除失败";
        addMessage(model,true,result);
        return "requirements/demand";
    }

}

