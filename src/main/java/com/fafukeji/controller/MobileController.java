package com.fafukeji.controller;

import com.fafukeji.common.utils.Message;
import com.fafukeji.common.utils.RandomUtil;
import com.fafukeji.model.DeviceToken;
import com.fafukeji.model.MessageInfo;
import com.fafukeji.model.User;
import com.fafukeji.service.IDeviceTokenService;
import com.fafukeji.service.IUserService;
import com.fafukeji.service.SystemService;
import com.fafukeji.utils.UserUtils;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 手机请求控制
 */
@Controller
@RequestMapping("${mobilePath}/")
public class MobileController extends BaseController{
    public static Logger log = Logger.getLogger(MobileController.class);
    @Autowired
    SystemService systemService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IDeviceTokenService deviceTokenService;
    /**
     * 注册
     *
     * @param request
     * @param response
     * @param model
     * @return
     *
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(required=true) String mobile,
                           @RequestParam(required=true) String password, @RequestParam(required=true) String captcha,
                           HttpServletRequest request, HttpServletResponse response, Model model) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setChid(0);
        messageInfo.setMobiles("18716804591");
        messageInfo.setSendtime("");
        messageInfo.setContents("test");
        Message message = new Message();
        message.sendMessage(messageInfo);

        //验证验证码是否正确
        if (!systemService.judgeCaptchaRight(mobile, captcha)) {
            addMessage(model, false, "验证码错误,请重新输入或获取！");
            return renderString(response, model);
        }
        User user = new User();
        //验证用户名是否被注册
        String username = "tel_" + mobile;
        user.setUsername(username);
        if (userService.getByMobileAndUsername(user).size() > 0) {
            addMessage(model, false,  "用户名或手机号已经存在，请重新输入！");
            return renderString(response, model);
        }
        user.setMobile(mobile);
        user.setPassword(UserUtils.entryptPassword(password));
//        user.preInsert();
        user.setUpdatedAt(user.getCreatedAt());
        user.setIsAdmin(User.USER);
        user.setImei(request.getParameter("imei"));
        userService.insertSelective(user);
        user.setId(user.getId());
        UserUtils.sessionUserInfo(request, user);
        DeviceToken deviceToken = new DeviceToken();
        String accessToken = RandomUtil.getRandomString(20);
        deviceToken.setDeviceToken(accessToken);
        Byte deviceType = Byte.parseByte(request.getParameter("device_type"));
        deviceToken.setDeviceType(deviceType);
//        deviceToken.preInsert();
        deviceToken.setUserId(user.getId());
        deviceTokenService.insertSelective(deviceToken);
        addMessage(model, true, "用户名注册成功!");
        model.addAttribute("access_token", accessToken);
        return renderString(response, model);
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.POST)
    public @ResponseBody String all(String mobile ,HttpServletRequest request){
        request.getParameter("mobile");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<" + request.getParameter("mobile"));
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
        JSONArray json =  JSONArray.fromObject(mobile);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+json);
        return  mobile;
    }
}
