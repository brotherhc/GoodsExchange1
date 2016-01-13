package com.fafukeji.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.fafukeji.common.utils.DateUtils;
import com.fafukeji.common.utils.RandomUtil;
import com.fafukeji.model.MobileCaptcha;
import com.fafukeji.service.IMobileCaptchaService;
import com.fafukeji.service.SystemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.fafukeji.common.config.Global;
import com.fafukeji.common.utils.CookieUtils;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.SessionInfo;
import com.fafukeji.model.User;
import com.fafukeji.service.IUserService;
import com.fafukeji.utils.UserUtils;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户控制器类
 *
 * @author wjx
 */
@Controller
@RequestMapping("${adminPath}")
public class UserController extends BaseController {
    @Autowired
    private SystemService systemService;
    @Autowired
    private IMobileCaptchaService mobileCaptchaService;
    @Autowired
    private IUserService userService;

    public static Logger log = Logger.getLogger(UserController.class);
    /**
     * 进入登陆页面
     *
     * @param user
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request,
                        HttpServletResponse response, Model model) {
    	HttpSession session = request.getSession();
		session.setAttribute(Global.getConfig("user_info"), null);
        response = CookieUtils.removeCookie(request, response, "/");
        return "login";
    }
@RequestMapping("remove")
public String remove(User user,HttpServletRequest request,
                     HttpServletResponse response,Model model){
    HttpSession session = request.getSession();
    session.removeAttribute("user_info");
    return "login";
}

    /**
     * 登陆系统
     *
     * @param user
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String userLogin(User user, HttpServletRequest request,
                            HttpServletResponse response, Model model) {
        List<User> users = userService.getByUsername(user);
        log.debug("=========rememberMe============" + request.getParameter("rememberMe"));
        if (users.size() == 0) {
            addMessage(model, false, "用户不存在");
            return "login";
        }
        if (users.size() > 1) {
            addMessage(model, false, "用户信息异常，请联系管理员处理！");
            return "login";
        }
        User loginUser = users.get(0);
        if (!UserUtils.validatePassword(user.getPassword(), loginUser.getPassword())) {
            addMessage(model, false, "用户密码错误！");
            return "login";
        }
        UserUtils.sessionUserInfo(request, loginUser);
        if ("on".equals(request.getParameter("rememberMe")) && loginUser.getIsAdmin() == User.USER){
        	response = UserUtils.generateLoginCookie(request, response, loginUser,  "/");
        }
        model.addAttribute("user", loginUser);
        return "redirect:index";
    }


    /**
     * 个人用户首页
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(User user, HttpServletRequest request,
                        HttpServletResponse response, Model model) {
    	HttpSession session = request.getSession();
    	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Global.getConfig("user_info"));
    	model.addAttribute("username", sessionInfo.getUsername());
    	model.addAttribute("user_id", sessionInfo.getUserId());
    	if (sessionInfo.getIsAdmin() == User.ADMIN) {
    		return "modules/adminIndex";
        }
        return "index";
    }
    /**
     * 找回密码获取验证码
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/getFindPasswordVerifyCode", method = RequestMethod.POST)
    public String getFindPasswordVerificationCode(HttpServletRequest request,
                                                  HttpServletResponse response, Model model) {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.selectUserById(user_id);
        if (user==null){
            addMessage(model, false ,"用户不存在，请稍后重试！");
            return renderString(response, model);
        }
        // TODO 获取短信验证码并且发送短信
        String mobile = user.getMobile();
        if (mobile == null){
            addMessage(model, false ,"用户手机号不存在，不能够获取！");
            return renderString(response, model);
        }
        systemService.getCaptchaAndSendMsg(mobile, "");
        addMessage(model, true, "获取成功！");
        return renderString(response, model);
    }

    /**
     * 找回密码，验证验证码是否正确，并发送新的密码
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/sendNewPwdMessage", method = RequestMethod.POST)
    public String sendNewPwdMessage(MobileCaptcha mobileCaptcha, HttpServletRequest request,
                                    HttpServletResponse response, Model model) {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.selectUserById(user_id);
        if (user==null){
            addMessage(model, false ,"用户不存在，请稍后重试！");
            return renderString(response, model);
        }
        String mobile = user.getMobile();
        if (mobile.equals(mobileCaptcha.getMobile())){
            addMessage(model, false ,"用户输入的手机号与注册手机号不一致，请重新输入！");
            return renderString(response, model);
        }
        mobileCaptcha.setValidTime(DateUtils.getCurrentTimeStamp());
        if(mobileCaptchaService.getByProps(mobileCaptcha)==null){
            addMessage(model, false ,"输入验证码不正确，请重新获取！");
            return renderString(response, model);
        };
        int randomNum = RandomUtil.getSixLengthRandomNum();
        //Todo 发送新密码短信
        addMessage(model, true, "新的短信已经发送到你手机，请及时的修改密码！");
        return renderString(response, model);
    }

    /**
     *测试
     *
     * @return
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, Model model) {
        log.debug("===========username=====" + user.getUsername());

        if(result.hasErrors()){

            return "test";
        }
        return null;
    }

    /**
     *测试
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request,
                           HttpServletResponse response, Model model) {
        return "test";
    }
    /**
     *邮箱测试
     *
     */
////发送密码重置邮件user/sendPasswordEmail
//    @RequestMapping("/user/sendPasswordEmail")
//    public String sendPasswordEmail(HttpServletRequest request, @RequestParam("1014472352@qq.com") String email) throws Exception {
//        userService.forgetPassword(email, request);
//        return "user/passwordSent";
//    }

}
