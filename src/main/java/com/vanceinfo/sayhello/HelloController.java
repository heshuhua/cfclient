package com.vanceinfo.sayhello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	
	@RequestMapping("/hsh/test")
	public String test()
	{
		System.out.println("test");
		return "sayhello.html";
	}

}
