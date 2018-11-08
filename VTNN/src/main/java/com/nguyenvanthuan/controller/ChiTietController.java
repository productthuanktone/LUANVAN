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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.service.ChiTietSanPhamService;

@Controller
@RequestMapping("chitiet/")
@SessionAttributes("giohang")
public class ChiTietController {
	@Autowired
	ChiTietSanPhamService chitietsasnphamservice;
	@GetMapping("/{id}")
	@Transactional
	public String index(ModelMap modelMap,@PathVariable int id,HttpSession httpSession) {
		ChiTietSanPham chiTietSanPham=chitietsasnphamservice.chiTietSanPham(id);
		if(null!=httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluonggiohang",listgiohang.size());
		}
		modelMap.addAttribute("chitiet",chiTietSanPham);
		return "chitiet";
	}
}
