package com.nguyenvanthuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.DanhMucSanPham;
import com.nguyenvanthuan.service.ChiTietSanPhamService;

@Controller
@RequestMapping("adminsanpham/")
public class AdminSanPhamController {
	@Autowired
	ChiTietSanPhamService chitietsanphamservice;
	@GetMapping
	@Transactional
	public String SanPham(ModelMap modelMap,HttpSession httpSession) {
		List<ChiTietSanPham>chiTietSanPhams=chitietsanphamservice.ListChiTietSanPham();
		modelMap.addAttribute("listsanpham", chiTietSanPhams);

		return "adminsanpham";
	}
	@GetMapping("{id}")
	public String deletesp(@PathVariable int id,ModelMap modelMap) {
		System.out.println(id);
		if(chitietsanphamservice.Deletechitietsanpham(id)) {
			List<ChiTietSanPham>chiTietSanPhams=chitietsanphamservice.ListChiTietSanPham();
			modelMap.addAttribute("listsanpham", chiTietSanPhams);
			return "adminsanpham";
		}
		else {
			String error="Xóa Thất Bại !";
			List<ChiTietSanPham>chiTietSanPhams=chitietsanphamservice.ListChiTietSanPham();
			modelMap.addAttribute("listsanpham", chiTietSanPhams);
			modelMap.addAttribute("error", error);
			return "adminsanpham";
		}
		
	}
}
