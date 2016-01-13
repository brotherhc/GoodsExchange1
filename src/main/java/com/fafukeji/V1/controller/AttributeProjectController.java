package com.fafukeji.V1.controller;

import com.fafukeji.V1.AttributeResult;
import com.fafukeji.common.persistence.MobileProjectController;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.Attribute;
import com.fafukeji.service.IAttributeService;
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
 * 关键字
 */
@Controller
@RequestMapping(value = "v1/project/", method = {RequestMethod.POST, RequestMethod.GET})
public class AttributeProjectController extends BaseController{
    public static Logger log = Logger.getLogger(MobileProjectController.class);
    @Autowired
    private IAttributeService attributeService;


    @ResponseBody
    @RequestMapping("/keyword")
    public AttributeResult selectAttribute(Attribute attribute, HttpServletRequest request,
                                           HttpServletResponse response, Model model){
        AttributeResult attributeResult = new AttributeResult();
        int defaultPageSize = 2;
        Page<Attribute> attributePage = new Page<Attribute>(request,response,defaultPageSize);
        attribute.setPage(attributePage);
        List<Attribute> list = attributeService.selectattribute(attribute);
        attributePage.setList(list);
//        log.debug("<<<<<<<<<<<<<<<<<<<<"+attributePage);
        attributeResult.setData(String.valueOf(list));
        attributeResult.attributeinfo(attribute);
        return attributeResult;
    }

}
