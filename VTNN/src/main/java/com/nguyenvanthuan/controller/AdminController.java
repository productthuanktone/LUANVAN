package com.nguyenvanthuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.service.ChiTietHoaDonService;
import com.nguyenvanthuan.service.HoaDonService;

@Controller
@RequestMapping("admin/")
public class AdminController {
	@Autowired
	HoaDonService hoadonService;
	@Autowired
	ChiTietHoaDonService chitiethoadonService;
	@GetMapping
	public String getadmin(ModelMap modelMap) {
		List<HoaDon> listhoadon=hoadonService.listHoaDon();
		modelMap.addAttribute("hoadon", listhoadon);
		return "admin";
	}
	@GetMapping("{id}")
	public String chitiethoadon(ModelMap modelMap,@PathVariable int id) {
		List<HoaDon> listhoadon=hoadonService.listHoaDon();
		modelMap.addAttribute("hoadon", listhoadon);
		List<ChiTietHoaDon> chitiethoadons=chitiethoadonService.listchitiethoadonid(id);
		modelMap.addAttribute("listchitiet", chitiethoadons);
		return "admin";
	}
}
