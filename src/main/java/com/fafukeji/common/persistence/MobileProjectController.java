package com.fafukeji.common.persistence;
import com.fafukeji.V1.GoodsResult;
import com.fafukeji.V1.UserResult;
import com.fafukeji.common.utils.Constants;
import com.fafukeji.common.web.BaseController;
import com.fafukeji.model.*;
import com.fafukeji.service.IDeviceTokenService;
import com.fafukeji.service.IUserService;
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
 * 手机请求控制类
 * 
 * @author wjx
 * 
 */
//@Controller
//@RequestMapping("${mobilePath}/v1/project/")
//public class MobileProjectController extends BaseController {
//	public static Logger log = Logger.getLogger(MobileProjectController.class);
//	@Autowired
//	SystemService systemService;
//
//	@Autowired
//	private IProjectService projectService;
//
//	@Autowired
//	private IDeviceTokenService deviceTokenService;
//
//
//
//	/**
//     * 获取项目列表
//     *
//     * @param request
//     * @param response
//     * @param model
//     * @return
//     */
//	@ResponseBody
//	@RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
//    public BaseResult getProjectList(HttpServletRequest request,
//    		HttpServletResponse response, Model model) {
//    	Project project = new Project();
//		project.setResType(MyConstants.RES_TYPE_PROJECT);
//		Page<Project> page = new Page<Project>(request, response, Constants.DEFAULT_PAGE_SIZE);
//		List<Project> projects = projectService.getAll(project);
//		page.setList(projects);
//		BaseResult baseResult = new BaseResult();
//		baseResult.setMsg("获取成功");
//		baseResult.setData(projects);
//		baseResult = baseResult.generateMobilePageInfo(page);
//		return baseResult;
//    }
//
//}
@Controller
@RequestMapping("v1/project/")
public class MobileProjectController extends BaseController {
	public static Logger log = Logger.getLogger(MobileProjectController.class);
//	@Autowired
//	SystemService systemService;

	@Autowired
	private IUserService iUserService;
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
	public BaseResult getProjectList(HttpServletRequest request,
									 HttpServletResponse response, Model model) {
		User user = new User();
//		user.setResType(MyConstants.RES_TYPE_PROJECT);
		Page<User> page = new Page<User>(request, response, Constants.DEFAULT_PAGE_SIZE);
		List<User> projects = iUserService.getAll(user);
		page.setList(projects);
		BaseResult baseResult = new BaseResult();
		baseResult.setMsg("获取成功");
		baseResult.setData(projects);
		baseResult = baseResult.generateMobilePageInfo(page);
		return baseResult;
	}

	/**
	 * 用户
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/userjson", method = {RequestMethod.POST, RequestMethod.GET})
	public UserResult user(HttpServletRequest request, HttpServletResponse response, Model model){
		User  user= new User();
		int defaultPageSize = 10;
		Page<User> userPage = new Page<User>(request,response,defaultPageSize);
		user.setPage(userPage);
		List<User> userlist = iUserService.selectUser(user);
		userPage.setList(userlist);
		UserResult userResult = new UserResult();
		userResult.setMsg("获取成功");
		userResult.setData(userlist);
		userResult = userResult.generateMobilePageInfo(user);
		return userResult;
	}


}

