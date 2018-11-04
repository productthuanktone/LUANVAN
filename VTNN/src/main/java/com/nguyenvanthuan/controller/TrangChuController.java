package com.nguyenvanthuan.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.SanPham;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.SanPhamService;

@Controller
@RequestMapping("/")
public class TrangChuController {
	@Autowired
	SanPhamService sanphamService;
	SessionFactory sessionFactory;
	@Autowired
	ChiTietSanPhamService chitietsasnphamservice;

	@GetMapping
	@Transactional
	public String TrangChu(ModelMap modelMap) {

//		for (SanPham sanPham : ListSP) {
//			for (ChiTietSanPham listchiTietSanPham : sanPham.getChitietsanpham()) {
//				System.out.println("Hinf  " +listchiTietSanPham.getHinh().getHINH());
//			}
//		}
		// tra vef danh sach san pham cho index
		List<ChiTietSanPham> ListChiTietSP=chitietsasnphamservice.ListChiTietSanPham();
		modelMap.addAttribute("danhsachchitiet",ListChiTietSP);
		return "index";
	}
}
