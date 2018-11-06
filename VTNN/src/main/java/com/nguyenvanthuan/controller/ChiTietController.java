package com.nguyenvanthuan.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.service.ChiTietSanPhamService;

@Controller
@RequestMapping("chitiet/")
public class ChiTietController {
	@Autowired
	ChiTietSanPhamService chitietsasnphamservice;
	@GetMapping("/{id}")
	@Transactional
	public String index(ModelMap modelMap,@PathVariable int id) {
		ChiTietSanPham chiTietSanPham=chitietsasnphamservice.chiTietSanPham(id);
		modelMap.addAttribute("chitiet",chiTietSanPham);
		return "chitiet";
	}
}
