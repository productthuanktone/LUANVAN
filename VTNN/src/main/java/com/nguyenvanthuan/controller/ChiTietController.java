package com.nguyenvanthuan.controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chitiet/")
public class ChiTietController {
	@GetMapping
	@Transactional
	public String index(ModelMap modelMap) {

		return "chitiet";
	}
}
