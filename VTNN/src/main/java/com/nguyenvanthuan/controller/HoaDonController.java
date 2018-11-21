package com.nguyenvanthuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.service.ChiTietHoaDonService;
import com.nguyenvanthuan.service.HoaDonService;

@Controller
@RequestMapping("hoadon/")
@SessionAttributes("tendangnhap")
public class HoaDonController {
	@Autowired
	HoaDonService hoadonService;
	@Autowired
	ChiTietHoaDonService chitiethoadonService;

	@GetMapping
	public String getHoaDon(ModelMap modelMap) {
		List<HoaDon> listhoadon = hoadonService.listHoaDon();
		modelMap.addAttribute("hoadon", listhoadon);
		return "hoadon";
	}

	@GetMapping("{id}")
	public String chitiethoadon(ModelMap modelMap, @PathVariable int id) {
		List<ChiTietHoaDon> chitiethoadons = chitiethoadonService.listchitiethoadonid(id);
		HoaDon hoaDon = hoadonService.hoaDonid(id);
		modelMap.addAttribute("listchitiet", chitiethoadons);
		modelMap.addAttribute("hoadon", hoaDon);
		return "chitiethoadon";
	}
	@GetMapping("duyenhoadon/{tinhtrang}/{id}")
	public String XuLyHoaDon(ModelMap modelMap,@PathVariable int id,@PathVariable int tinhtrang) {
		hoadonService.SaveHoaDon(tinhtrang, id);
		List<HoaDon> listhoadon = hoadonService.listHoaDon();
		modelMap.addAttribute("hoadon", listhoadon);
		return "hoadon";
	}
}
