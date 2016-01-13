package com.fafukeji.common.persistence.test;

import com.fafukeji.common.web.BaseController;
import com.fafukeji.controller.MessageController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by java on 2015/8/24 0024.
 */
@Controller
@RequestMapping("registered")
public class RegisteredController extends BaseController{
    public static Logger log = Logger.getLogger(MessageController.class);

  @RequestMapping("index")
    public  String jump(){
      return "register";
  }
}
