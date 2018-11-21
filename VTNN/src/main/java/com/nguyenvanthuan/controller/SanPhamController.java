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
import com.nguyenvanthuan.service.ChiTietHoaDonService;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.DanhMucSanPhamService;

@Controller
@RequestMapping("sanpham/")
public class SanPhamController {
	@Autowired
	ChiTietSanPhamService chitietsanphamservice;
	@Autowired
	DanhMucSanPhamService danhmucservice;
	@GetMapping("{id}")
	@Transactional
	public String SanPham(ModelMap modelMap,HttpSession httpSession,@PathVariable int id) {
		List<ChiTietSanPham>chiTietSanPhams=chitietsanphamservice.listsanphamdanhmuc(id);
		List<DanhMucSanPham> danhMucSanPhams=danhmucservice.listdanhmuc();
		modelMap.addAttribute("listsanpham", chiTietSanPhams);
		modelMap.addAttribute("danhmucs", danhMucSanPhams);
		return "sanpham";
	}
}
