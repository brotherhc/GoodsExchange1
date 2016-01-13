package com.fafukeji.controller;

import com.fafukeji.common.web.*;
import com.fafukeji.model.Match;
import com.fafukeji.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by java on 2015/8/5 0005.
 */
@Controller
@RequestMapping("Match")
public class MatchController extends com.fafukeji.common.web.BaseController{
        @Autowired
        private IMatchService matchService;
    @RequestMapping("getAll")
        public String getAll(HttpServletRequest request,Model model){
        try {
            List<Match> list = matchService.getAll();
            model.addAttribute("userLists", list);
            return "listAll";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }
}
