package com.fafukeji.V1.controller;

import com.fafukeji.V1.CategoriesResult;
import com.fafukeji.common.persistence.MobileProjectController;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.Categories;
import com.fafukeji.service.ICategoriesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by java on 2015/8/31 0031.
 */
@Controller
@RequestMapping(value = "v1/project/")
public class CategoriesProjectController extends BaseController {
    public static Logger log = Logger.getLogger(MobileProjectController.class);
    @Autowired
    private ICategoriesService categoriesService;

    @ResponseBody
    @RequestMapping("catejson")
    public CategoriesResult select(HttpServletRequest request, HttpServletResponse response){
        Categories categories = new Categories();

        CategoriesResult categoriesResult = new CategoriesResult();
        int defaultPageSize = 2;
        Page<Categories> categoriesPage = new Page<Categories>(request,response,defaultPageSize);
        categories.setPage(categoriesPage);
        List<Categories> fication = categoriesService.getAll();
            if (fication.size()==0){
                categoriesResult.setMsg("获取失败");
                categoriesResult.setResult(0);
                return categoriesResult;
        } else {
                categoriesPage.setList(fication);
                log.debug("<<<<<<<<<<<<<<<<<<<<<"+categoriesPage);
                categoriesResult.setMsg("获取成功");
                categoriesResult.setData(String.valueOf(fication));
                categoriesResult = categoriesResult.cateInfo(categoriesResult);
            }
        return categoriesResult;
    }

}
