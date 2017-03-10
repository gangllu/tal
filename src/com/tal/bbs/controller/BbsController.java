package com.tal.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	@RequestMapping("/chat")
	public String chat(){
		return "bbs/chat";
	}
}
