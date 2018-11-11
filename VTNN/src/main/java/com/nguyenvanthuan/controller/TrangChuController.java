package com.nguyenvanthuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.entity.SanPham;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.SanPhamService;

@Controller
@RequestMapping("/")
@SessionAttributes("giohang,tendangnhap")
public class TrangChuController {
	@Autowired
	SanPhamService sanphamService;
	SessionFactory sessionFactory;
	@Autowired
	ChiTietSanPhamService chitietsasnphamservice;

	@GetMapping
	@Transactional
	public String TrangChu(ModelMap modelMap,HttpSession httpSession) {

//		for (SanPham sanPham : ListSP) {
//			for (ChiTietSanPham listchiTietSanPham : sanPham.getChitietsanpham()) {
//				System.out.println("Hinf  " +listchiTietSanPham.getHinh().getHINH());
//			}
//		}
		// tra vef danh sach san pham cho index
		if(null!=httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluonggiohang",listgiohang.size());
		}
		List<ChiTietSanPham> ListChiTietSP=chitietsasnphamservice.ListChiTietSanPham();
		modelMap.addAttribute("danhsachchitiet",ListChiTietSP);
		return "index";
	}
}
