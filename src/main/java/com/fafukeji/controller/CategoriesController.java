package com.fafukeji.controller;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.model.Categories;
import com.fafukeji.service.ICategoriesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 */
@Controller
@RequestMapping(value = "/categories")
public class CategoriesController extends com.fafukeji.common.web.BaseController{
    public static Logger log = Logger.getLogger(InformController.class);
    @Autowired
    private ICategoriesService categoriesService;

    @RequestMapping("/getall")
    public String all(Categories categories, HttpServletRequest request,
                                  HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Categories> categoriesPage = new Page<Categories>(request,response,defaultPageSize);
        categories.setPage(categoriesPage);
        List<Categories>cate =  categoriesService.getAll();
        categoriesPage.setList(cate);
        model.addAttribute("list",cate);
        return"categories/Classification";
    }

    //第一层
    @RequestMapping("/selectcate")
    public String cate(Categories categories,HttpServletRequest request,HttpServletResponse response,Model model){
        int defaultPageSize = 2;
        Page<Categories> categoriesPage = new Page<Categories>(request,response,defaultPageSize);
        categories.setPage(categoriesPage);

        List<Categories> list = categoriesService.findname(categories);
        categoriesPage.setList(list);
        model.addAttribute("list", categoriesPage);
        return "categories/Classification_gl";
    }
    @RequestMapping("insert/add")
    public String call(){
        return "attribute/add";
    }
    //第二层
    @RequestMapping("/selecttwo")
    public String catetwo(Categories categories,String name , HttpServletRequest request,HttpServletResponse response,Model model){
        int defaultPageSize = 2;
        Page<Categories> categoriesPage = new Page<Categories>(request,response,defaultPageSize);
        categories.setPage(categoriesPage);
        System.out.println("++++++++++++++++++++++++++++++++"+categories.getName());
        List<Categories> list = categoriesService.findtwo(categories.getName());
        categoriesPage.setList(list);
        model.addAttribute("list", categoriesPage);
        log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+list.size());
        return "categories/Twoclassification";
    }
    //第二层
    @RequestMapping("/selectthree")
    public String three(Categories categories,HttpServletRequest request,HttpServletResponse response,Model model){

        int defaultPageSize = 2;
        Page<Categories> categoriesPage = new Page<Categories>(request,response,defaultPageSize);
        categories.setPage(categoriesPage);
        List<Categories> list = categoriesService.findtthree(categories);
        categoriesPage.setList(list);
        model.addAttribute("list", categoriesPage);
        return "categories/Threeclassification";
    }
}
