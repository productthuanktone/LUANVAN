package com.nguyenvanthuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.GioHang;

@Controller
@RequestMapping("giohang/")
@SessionAttributes("giohang")
public class GioHangController {
	@GetMapping
	@Transactional
	public String GioHang(ModelMap modelMap, HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluonggiohang", listgiohang.size());
			modelMap.addAttribute("giohang",listgiohang);
		}
		

		return "GioHang";
	}
}
