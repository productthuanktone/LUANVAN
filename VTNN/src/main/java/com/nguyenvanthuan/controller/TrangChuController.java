package com.nguyenvanthuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.DanhMucSanPham;
import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.entity.SanPham;
import com.nguyenvanthuan.entity.TaiKhoan;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.DanhMucSanPhamService;
import com.nguyenvanthuan.service.SanPhamService;
import com.nguyenvanthuan.service.TaiKhoanSevice;

@Controller
@RequestMapping("/")
@SessionAttributes("giohang,tendangnhap")
public class TrangChuController {
	@Autowired
	SanPhamService sanphamService;
	SessionFactory sessionFactory;
	@Autowired
	ChiTietSanPhamService chitietsasnphamservice;
	@Autowired
	DanhMucSanPhamService danhmucservice;
	@Autowired
	TaiKhoanSevice taikhoanservice;

	@GetMapping
	@Transactional
	public String TrangChu(ModelMap modelMap, HttpSession httpSession) {

		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluonggiohang", listgiohang.size());
		}
		List<ChiTietSanPham> ListChiTietSP = chitietsasnphamservice.ListChiTietSanPham();
		String tendangnhap = (String) httpSession.getAttribute("tendangnhap");
		try {
			TaiKhoan taiKhoan = taikhoanservice.laytaikhoan(tendangnhap);
			int quyen = taiKhoan.getQUYEN();
			modelMap.addAttribute("quyen", quyen);
		} catch (Exception e) {
			String quyen = "";
			modelMap.addAttribute("quyen", quyen);
		}

		List<DanhMucSanPham> danhMucSanPhams = danhmucservice.listdanhmuc();
		modelMap.addAttribute("danhsachchitiet", ListChiTietSP);
		modelMap.addAttribute("tendangnhap", tendangnhap);

		modelMap.addAttribute("danhmucs", danhMucSanPhams);
		return "index";
	}

	@GetMapping("dangxuat")
	public String DangXuat(HttpSession httpSession) {
		httpSession.removeAttribute("tendangnhap");
		return "redirect:/";
	}
}
