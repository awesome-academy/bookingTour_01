package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminIndexController {
	@RequestMapping(value = "/admin/index",method = RequestMethod.GET)
	public String test() {
		return "admin/index/index";
	}
}
