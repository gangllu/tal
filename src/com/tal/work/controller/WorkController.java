package com.tal.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tal.dao.TbWorkMapper;
import com.tal.model.TbWork;
import com.tal.util.page.Page;
import com.tal.util.page.PageObject;
import com.tal.work.service.WorkService;

@Controller
@RequestMapping("/work")
public class WorkController {
	
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
	public PageObject<TbWork> listWork(@RequestParam Integer draw,
			@RequestParam Integer length,HttpServletRequest request){
		
		TbWork b = new TbWork();
		Page pageInfo = new Page(draw,length);
		b.setPage(pageInfo);
		
		b.setWorkTile(request.getParameter("workTitle"));
		
		PageObject<TbWork> pageModel = workService.listPageworkByUser(b);
		return pageModel;
	}

}
