package com.fafukeji.controller;


import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.*;
import com.fafukeji.model.Attribute;
import com.fafukeji.service.IAttributeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;

@Controller
@RequestMapping(value = "/attribute")
public class AttributeController extends com.fafukeji.common.web.BaseController{
    public static Logger log = Logger.getLogger(InformController.class);
    @Autowired
    private IAttributeService attributeService;

    @RequestMapping("/select")
    public String selectAttribute(Attribute attribute, HttpServletRequest request,
                               HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Attribute> attributePage = new Page<Attribute>(request,response,defaultPageSize);
        attribute.setPage(attributePage);
        List<Attribute> list = attributeService.selectattribute(attribute);
        for (int i = 0; i<list.size();i++){
            String a = list.get(i).getAttributeType();
            if (a.equals("0")){
                list.get(i).setAttributeType("系统添加");
            }
            else if (a.equals("1")){
                list.get(i).setAttributeType("用户添加 ");
            }
        }  for (int i = 0; i<list.size();i++){
            String status = list.get(i).getStatus();
            if (status.equals("0")){
                list.get(i).setStatus("可用");
            }
            else if (status.equals("1")){
                list.get(i).setStatus("不可用 ");
            }
        }

        attributePage.setList(list);
        log.debug("=============================="+list);
        model.addAttribute("list", attributePage);
        return "attribute/list";
    }

    @RequestMapping("insert/add")
    public String call(){
        return "attribute/add";
    }

    @RequestMapping( "/update")
    public String update(Attribute attribute, HttpServletRequest request,
                         HttpServletResponse response, Model model){

        String result = attributeService.updateByPrimaryKeySelective(attribute)==1?"修改成功": "修改失败";
        addMessage(model,true,result);
        return"attribute/list" ;
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        attributeService.deleteByPrimaryKey(id);
        return "attribute/list";
    }


    @RequestMapping("add")
    public String selecte_id(Attribute attribute, HttpServletRequest request,
                             HttpServletResponse response, Model model){
        List<Attribute> attributeList = attributeService.selectid(attribute);
        model.addAttribute("List", attributeList);
        return "attribute/update";
    }

    @RequestMapping("insert")
    public String add(Attribute attr, Model model){

        String result = (attributeService.insertSelective(attr) ==1 )?"添加成功":"添加失败";
        addMessage(model, true, result);
        log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+result);
        return "users/list";
    }
    /**
     * 测试页面
     */
    @RequestMapping("test")
    public String test(){
        return "test";
    }

}
