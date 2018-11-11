package com.nguyenvanthuan.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.TaiKhoan;
import com.nguyenvanthuan.service.TaiKhoanSevice;

@Controller
@RequestMapping("dangnhap/")
@SessionAttributes("tendangnhap")
public class DangNhapController {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	TaiKhoanSevice taikhoanService;

	@GetMapping
	public String ViewDangNhap() {

		return "DangNhap";
	}

	@PostMapping
	@Transactional
	public String XuLyDangNhap(@RequestParam String tendangnhap, @RequestParam String matkhau, ModelMap map,HttpSession httpSession,ModelMap modelMap) {
		System.out.println(tendangnhap + matkhau);
		boolean kiemtra = taikhoanService.kiemtradangnhap(tendangnhap, matkhau);
		if (kiemtra) {
			map.addAttribute("tendangnhap", tendangnhap);
			System.out.println("Success");
			httpSession.setAttribute("tendangnhap", tendangnhap);
			
			return "redirect:/";
		} else {
			String error = "Lỗi đăng nhập!Sai email hoặc mật khẩu";
			System.out.println("failure");
			map.addAttribute("error", error);
			return "DangNhap";
		}

	}
}
