package com.fafukeji.V1;


import com.fafukeji.common.persistence.MobileProjectController;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.model.Requirements;
import com.fafukeji.service.IDeviceTokenService;
import com.fafukeji.service.IGoodsService;
import com.fafukeji.service.IRequirementsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *–Ë«Û
 */
@Controller
@RequestMapping("v1/project/")
public class RequirementsProjectController {
    public static Logger log = Logger.getLogger(MobileProjectController.class);
    //	@Autowired
    //	SystemService systemService;
    @Autowired
    private IRequirementsService requirementsService;
    @Autowired
    private IDeviceTokenService deviceTokenService;


    @ResponseBody
    @RequestMapping("Demandjson")
    public RequirementsResult rs(Requirements requirements, HttpServletRequest request,
                                     HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Requirements> requirementsPage = new Page<Requirements>(request,response,defaultPageSize);
        requirements.setPage(requirementsPage);
        List<Requirements> list = requirementsService.selectRequirements(requirements);
        requirementsPage.setList(list);
        RequirementsResult requirementsResult = new RequirementsResult();
//        requirementsResult.setData(list);
        requirementsResult.RequirementsInfo(requirements);
        return requirementsResult;
    }
}
