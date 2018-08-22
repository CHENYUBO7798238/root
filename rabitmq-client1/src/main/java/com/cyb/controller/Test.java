package com.cyb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	@RequestMapping("/getStr")
	public String getStr() {
		return "sdsd是否是";
	}
}
