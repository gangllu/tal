package com.tal.work.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tal.app.BaseResult;
import com.tal.dao.TbWorkMapper;
import com.tal.model.TbUser;
import com.tal.model.TbWork;
import com.tal.util.DateUtil;
import com.tal.util.page.Page;
import com.tal.util.page.PageObject;
import com.tal.work.service.WorkService;

@Controller
@RequestMapping("/work")
public class WorkController {
	
	private static final Log log = LogFactory.getLog(WorkController.class);
	
	@Autowired
	TbWorkMapper workMapper;
	
	@Autowired
	WorkService workService;
	
	@RequestMapping("/listPage")
	public String listPage(){
		return "work/work";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public PageObject<TbWork> listWork(@RequestParam Integer start,
			@RequestParam Integer length,HttpServletRequest request){
		
		TbWork b = new TbWork();
		Page pageInfo = new Page((start/length) + 1,length);
		b.setPage(pageInfo);
		
		b.setWorkTile(request.getParameter("workTitle"));
		b.setWorkDate1Start(request.getParameter("workDate1Start"));
		b.setWorkDate1End(request.getParameter("workDate1End"));
		
		PageObject<TbWork> pageModel = workService.listPageworkByUser(b);
		return pageModel;
	}
	
	//新增更新美容师
	@RequestMapping(value = "/addOrUpdateWork", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult addOrUpdateWork(HttpServletRequest request, @RequestParam String workText1,
			@RequestParam String workTitle) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			TbWork work = new TbWork();
			work.setWorkTile(workTitle);
			work.setWorkText1(workText1);
			TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
			work.setUserId(user.getUserId());
			work.setWorkDate1(DateUtil.getCurrentTime());

			String workId = request.getParameter("workId");
			if (null == workId || "".equals(workId)) {
				// 新增

				workMapper.insertSelective(work);
				message = "新增成功！";

			} else {
				// 更新
				work.setWorkId(Long.parseLong(workId));
				workMapper.updateByPrimaryKeySelective(work);
				message = "更新成功！";
			}

		} catch (Exception e) {
			message = "处理失败！";
			log.error(message, e);
			status = "0";
		}

		result.setStatus(status);
		result.setMessage(message);
		/*
		 * try { response.getWriter().write("<script type=\"text/javascript\">"
		 * ); response.getWriter().write("alert('" + message + "');");
		 * response.getWriter().write("window.parent.manager.reload();");
		 * response.getWriter().write("window.parent.dialog.close();");
		 * response.getWriter().write("</script>"); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		return result;
	}

}
