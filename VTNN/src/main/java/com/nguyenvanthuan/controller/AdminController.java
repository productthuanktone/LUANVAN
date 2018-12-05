package com.nguyenvanthuan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.TaiKhoan;

import com.nguyenvanthuan.service.TaiKhoanSevice;

@Controller
@RequestMapping("admin/")
@SessionAttributes("tendangnhap")
public class AdminController {

	@Autowired
	TaiKhoanSevice taikhoanservice;

	@GetMapping
	public String getadmin(ModelMap modelMap, HttpSession httpSession) {
		if ((null != httpSession.getAttribute("tendangnhap"))) {
			String tendangnhap = (String) httpSession.getAttribute("tendangnhap");
			TaiKhoan taiKhoan = taikhoanservice.laytaikhoan(tendangnhap);
			int quyen = taiKhoan.getQUYEN();
			if (quyen == 1 || quyen==2) {
				modelMap.addAttribute("quyen", quyen);
				return "admin";
			} else {
				return "redirect:/";
			}

		} else {
			return "redirect:/";
		}

	}

}
