package com.fafukeji.V1.controller;
import com.fafukeji.V1.InformResult;
import com.fafukeji.common.persistence.MobileProjectController;
import com.fafukeji.common.persistence.Page;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.Inform;
import com.fafukeji.service.InformService;
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

/**
     * 举报
     */
    @Controller
    @RequestMapping(value = "v1/project/", method = {RequestMethod.POST, RequestMethod.GET})
    public class InformProjectController extends BaseController {
        public static Logger log = Logger.getLogger(MobileProjectController.class);
        @Autowired
        private InformService informService;

    @ResponseBody
    @RequestMapping("/informjson")
    public InformResult selectInform(Inform inform, HttpServletRequest request,
                                        HttpServletResponse response, Model model){
        int defaultPageSize = 2;
        Page<Inform> informPage= new Page<Inform>(request,response,defaultPageSize);
        inform.setPage(informPage);
        List<Inform> list = informService.selectinform(inform);
        informPage.setList(list);
        InformResult informResult = new InformResult();
        informResult.setMsg("获取成功");
        informResult.setData(String.valueOf(list));
        informResult.infrominfo(informResult);
        return informResult;
    }
}
