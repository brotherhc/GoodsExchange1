package com.fafukeji.controller;

import com.fafukeji.common.persistence.Page;
import com.fafukeji.model.User;
import com.fafukeji.service.IUserService;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
@RequestMapping("/user")
public class BaseController extends com.fafukeji.common.web.BaseController {
    public static Logger log = Logger.getLogger(UserController.class);

    private IUserService userService;

    public IUserService userService() {
        return userService;
    }
    @Autowired
    public void setBaseService(IUserService userService) {
        this.userService = userService;
    }
    //跳主页
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "modules/adminIndex";
    }

    @RequestMapping("selectid")
    public String selecteid(User user, HttpServletRequest request,
                             HttpServletResponse response, Model model){
        List<User> userList = userService.selecteid(user);
        model.addAttribute("list", userList);
        return "users/update";
    }
    //搜索
    @RequestMapping("Search")
    public String Search(User user,String username, HttpServletRequest request,
                            HttpServletResponse response, Model model){
        int defaultPageSize = 1;
        Page<User> userPage = new Page<User>(request,response,defaultPageSize);
        user.setPage(userPage);
        List<User> list = (List<User>) userService.userInfo(username);
        for (int i = 0; i<list.size();i++){
            String a = list.get(i).getAccountType();
            if (a.equals("1")){
                list.get(i).setAccountType("网站账号");
            }
            else if (a.equals("2")){
                list.get(i).setAccountType("facebook ");
            }
            else if(a.equals("3")){
                list.get(i).setAccountType("google");
            }
        }for (int i = 0;i <list.size();i++) {
            String b = list.get(i).getUserLevel();
            if (b.equals("1")) {
                list.get(i).setUserLevel("一级");

            } else if (b.equals("2")) {
                list.get(i).setUserLevel("二级");
            }
        }for(int a  = 0;a<list.size();a++){
            String  state =list.get(a).getState();
            if (state.equals("0")){
                list.get(a).setState("正常");
            }else if (state.equals("1")){
                list.get(a).setState("被封");
            }
        }for (int i = 0;i <list.size();i++) {
            String isverify = list.get(i).getIsVerify();
            if (isverify.equals("1")) {
                list.get(i).setIsVerify("未验证");

            } else if (isverify.equals("2")) {
                list.get(i).setIsVerify("已验证");
            }
        }
        userPage.setList(list);
        model.addAttribute("list", userPage);
        return "users/list";
    }
    @RequestMapping("insert")
    public String add(User user,Model model){
        //获取当前系统时间
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        int month=ca.get(Calendar.MONTH);//获取月份
        int day=ca.get(Calendar.DATE);//获取日
        String a = String.valueOf(year);
        String b = String.valueOf(month);
        String c = String.valueOf(day);
        long i = Long.parseLong(a+b+c);
        user.setCreatedAt(i);
        String result = (userService.insert(user) ==1 )?"添加成功":"添加失败";
        addMessage(model, true, result);
        return "users/list";
    }

    //跳转添加页面
    @RequestMapping("add")
    public String add(){
        return "users/add";
    }

    @RequestMapping("/list")
    public String selectuser(User user, HttpServletRequest request,
                               HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<User> userPage = new Page<User>(request,response,defaultPageSize);
        user.setPage(userPage);
        List<User> list = (List<User>) userService.selectUser(user);

        for (int i = 0; i<list.size();i++){
            String a = list.get(i).getAccountType();
            if (a.equals("1")){
                list.get(i).setAccountType("网站账号");
            }
            else if (a.equals("2")){
                list.get(i).setAccountType("facebook ");
            }
            else if(a.equals("3")){
                list.get(i).setAccountType("google");
            }
        }for (int i = 0;i <list.size();i++) {
            String b = list.get(i).getUserLevel();
            if (b.equals("1")) {
                list.get(i).setUserLevel("一级");

            } else if (b.equals("2")) {
                list.get(i).setUserLevel("二级");
            }
        }for(int a  = 0;a<list.size();a++){
            String  state =list.get(a).getState();
                if (state.equals("0")){
                    list.get(a).setState("正常");
                }else if (state.equals("1")){
                    list.get(a).setState("被封");
                }
            }for (int i = 0;i <list.size();i++) {
            String isverify = list.get(i).getIsVerify();
            if (isverify.equals("1")) {
                list.get(i).setIsVerify("未验证");

            } else if (isverify.equals("2")) {
                list.get(i).setIsVerify("已验证");
            }
        }
        userPage.setList(list);
        model.addAttribute("list",userPage);
        return "users/list";
    }

//    @RequestMapping("modify")
//    public String modify(Integer  id,HttpServletRequest request,Model model){
//        try {
//            User user = userService.selectUserById(id);
//            model.addAttribute("user",user);
//            return "modify";
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
//            return "result";
//        }
//    }


    @RequestMapping("update")
    public String update(User user,BindingResult result, Model model){
        String result1 =userService.updateByPrimaryKeySelective(user)==1?"更新成功":"更新失败";
        addMessage(model,true,result1);
        return "users/list";
    }



    @RequestMapping(value = "/del/{id}" ,method = RequestMethod.GET)
    public String delete(@PathVariable int id,Model model){

        String result =(userService.deleteUserById(id) ==1) ?"删除成功":"删除失败";
        addMessage(model, true, result);
        return "redirect:/user/list";
    }
//    @RequestMapping("report")
//    public String repott(Integer  id,HttpServletRequest request,Model model){
//        try {
//            User user = userService.selectUserById(id);
//            model.addAttribute("user",user);
//            return "modify";
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
//            return "result";
//        }
//    }
//@ResponseBody
//@RequestMapping(value = "/hello")
//public String json(User user, HttpServletRequest request,
//                         HttpServletResponse response, Model model){
//    int defaultPageSize = 2;
//    Page<User> userPage = new Page<User>(request,response,defaultPageSize);
//    user.setPage(userPage);
//    List<User> list = (List<User>) userService.selectUser(user);
//    userPage.setList(list);
//    model.addAttribute("list",userPage);
//    return "users/list";
//}

}