package com.fafukeji.V1.controller;


import com.fafukeji.V1.UserResult;
import com.fafukeji.common.persistence.BaseResult;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.utils.Constants;
import com.fafukeji.common.utils.RandomUtil;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.*;
import com.fafukeji.service.IDeviceTokenService;
import com.fafukeji.service.IUserService;
import com.fafukeji.service.SystemService;
import com.fafukeji.utils.UserUtils;
import com.google.common.collect.Maps;
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
import java.util.Map;
/**
 * 手机请求控制类
 *
 * @author wjx
 *
 */
@Controller
@RequestMapping("${mobilePath}/v1/project/")
public class LoginProjectController extends BaseController {
    public static Logger log = Logger.getLogger(LoginProjectController.class);
    @Autowired
    SystemService systemService;
    @Autowired
    private IUserService userService;
    //    @Autowired
//    private IProjectService projectService;
    @Autowired
    private IDeviceTokenService deviceTokenService;



    /**
     * 获取项目列表
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public BaseResult getUserObtainTask(HttpServletRequest request,
                                        HttpServletResponse response, Model model) {
        User user = new User();
//		user.setResType(MyConstants.RES_TYPE_PROJECT);
        Page<User> page = new Page<User>(request, response, Constants.DEFAULT_PAGE_SIZE);
        List<User> projects = userService.getAll(user);
        page.setList(projects);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("获取成功");
        baseResult.setData(projects);
        baseResult = baseResult.generateMobilePageInfo(page);
        return baseResult;
    }


    /**
     * 登陆
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        Model model) {
        String clientId = request.getParameter("client_id");
        if (null == clientId || "".equals(clientId)){
            addMessage(model, false, "登陆失败，用户不安全途径登陆！");
            return renderString(response, model);
        }
        String username = request.getParameter("username");

        User user = new User();
        user.setMobile(username);
        List<User> users = userService.getByMobileOrUsername(user);
        if (users.size() == 0){
            addMessage(model, false, "用户不存在，请重新登陆！");
            return renderString(response, model);
        }
        String password = request.getParameter("password");
        User loginUser = users.get(0);
        if (!UserUtils.validatePassword(password, loginUser.getPassword())) {
            addMessage(model, false, "密码错误，请重新输入！");
            return renderString(response, model);
        }
        String imei = request.getParameter("imei");
        DeviceToken deviceToken = new DeviceToken();
        deviceToken.setUserId(loginUser.getId());
        DeviceToken deviceTokenGet = deviceTokenService.getByUserId(deviceToken);
        String accessToken = "";
        if (null == deviceTokenGet){
            accessToken = RandomUtil.getRandomString(20);
            deviceToken.setDeviceToken(accessToken);
            Byte deviceType = Byte.parseByte(request.getParameter("device_type"));
            deviceToken.setDeviceType(deviceType);
//			deviceToken.preInsert();
            deviceToken.setUserId(loginUser.getId());
            deviceTokenService.insertSelective(deviceToken);
        }
        else{
            accessToken = deviceTokenGet.getDeviceToken();
        }
        user.setImei(imei);
        user.setId(loginUser.getId());
        userService.updateUserImei(user);
        model.addAttribute("access_token", accessToken);
        addMessage(model, true, "登陆成功");
        return renderString(response, model);
    }

    /**
     * 注册
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response,
                           Model model) {
        return renderString(response, model);
    }


    /**
     * 用户信息
     * @param request
     * @param response
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String info(HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        int userId = (int) systemService.getObjectFromSession(request, "userId");
        if (userId == 0){

        }
        return renderString(response, model);
    }

}
