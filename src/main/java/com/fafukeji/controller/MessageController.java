package com.fafukeji.controller;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.Message;
import com.fafukeji.service.IMessageService;
import com.fafukeji.service.impl.MessageServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/23.
 */
@Controller
@RequestMapping("Message")
public class MessageController extends BaseController {
    public static Logger log = Logger.getLogger(MessageController.class);

    @Autowired
    private IMessageService iMessageService;

    @RequestMapping("/insert")
    public String insertMessage(Message message, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iMessageService.insertSelective(message)==1?"添加成功": "添加失败";
        addMessage(model,true,result);
        return "test";
    }

    @RequestMapping("/update")
    public String updateMessage(Message message, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iMessageService.updateByPrimaryKeySelective(message)==1?"修改成功": "修改失败";
        addMessage(model,true,result);
        return "test";
    }

    @RequestMapping("/delete")
    public String deleteMessage(Integer id, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        String result = iMessageService.deleteByPrimaryKey(id)==1?"删除成功": "删除失败";
        addMessage(model,true,result);
        return "Message/email_Message";
    }

    @RequestMapping("/select")
    public String selectMessage(Message message, HttpServletRequest request,
                                HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Message> messagePage = new Page<Message>(request,response,defaultPageSize);
        message.setPage(messagePage);
        List<Message> messageList = iMessageService.selectMessage(message);
        for (int i = 0; i<messageList.size();i++){
            String a = messageList.get(i).getType();
            if (a.equals("0")){
                messageList.get(i).setType("用户发送私信");
            }
            else if (a.equals("1")){
                messageList.get(i).setType("系统发送通知");
            }
        }
        messagePage.setList(messageList);
        model.addAttribute("messagePage", messagePage);
        return "Message/email_Message";
    }

}
