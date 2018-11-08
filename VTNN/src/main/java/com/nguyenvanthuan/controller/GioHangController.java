package com.nguyenvanthuan.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("giohang/")
@SessionAttributes("giohang")
public class GioHangController {
	@GetMapping
	@Transactional
	public String GioHang(ModelMap modelMap,HttpSession httpSession) {


		return "GioHang";
	}
}
