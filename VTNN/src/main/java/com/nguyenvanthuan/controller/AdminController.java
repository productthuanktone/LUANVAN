package com.nguyenvanthuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.entity.TaiKhoan;
import com.nguyenvanthuan.service.ChiTietHoaDonService;
import com.nguyenvanthuan.service.HoaDonService;
import com.nguyenvanthuan.service.TaiKhoanSevice;

@Controller
@RequestMapping("admin/")
@SessionAttributes("tendangnhap")
public class AdminController {
	@Autowired
	HoaDonService hoadonService;
	@Autowired
	ChiTietHoaDonService chitiethoadonService;
	@Autowired
	TaiKhoanSevice taikhoanservice;

	@GetMapping
	public String getadmin(ModelMap modelMap, HttpSession httpSession) {
		if ((null != httpSession.getAttribute("tendangnhap"))) {
			String tendangnhap = (String) httpSession.getAttribute("tendangnhap");
			TaiKhoan taiKhoan = taikhoanservice.laytaikhoan(tendangnhap);
			int quyen = taiKhoan.getQUYEN();
			if (quyen == 1) {
				List<HoaDon> listhoadon = hoadonService.listHoaDon();
				modelMap.addAttribute("hoadon", listhoadon);
				return "admin";
			} else {
				return "redirect:/";
			}

		} else {
			return "redirect:/";
		}

	}

	@GetMapping("{id}")
	public String chitiethoadon(ModelMap modelMap, @PathVariable int id) {
		List<HoaDon> listhoadon = hoadonService.listHoaDon();
		modelMap.addAttribute("hoadon", listhoadon);
		List<ChiTietHoaDon> chitiethoadons = chitiethoadonService.listchitiethoadonid(id);
		modelMap.addAttribute("listchitiet", chitiethoadons);
		return "admin";
	}
}
