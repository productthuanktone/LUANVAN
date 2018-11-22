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

import com.nguyenvanthuan.dao.NhaSanXuatDAO;
import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.DanhMucSanPham;
import com.nguyenvanthuan.entity.KhuyenMai;
import com.nguyenvanthuan.entity.NhaSanXuat;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.DanhMucSanPhamService;
import com.nguyenvanthuan.service.KhuyemMaiService;
import com.nguyenvanthuan.service.NhaSanXuatService;

@Controller
@RequestMapping("adminsanpham/")
public class AdminSanPhamController {
	@Autowired
	ChiTietSanPhamService chitietsanphamservice;
	@Autowired
	DanhMucSanPhamService danhmucservice;
	@Autowired
	KhuyemMaiService khuyemmaiservice;
	@Autowired
	NhaSanXuatService nhasanxuatservice;
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
	@GetMapping("chinhsua/{id}")
	@Transactional
	public String ThemSanPham(ModelMap modelMap,HttpSession httpSession,@PathVariable int id) {
		ChiTietSanPham chiTietSanPham=chitietsanphamservice.chiTietSanPham(id);
		List<DanhMucSanPham>danhMucSanPhams=danhmucservice.listdanhmuc();
		List<KhuyenMai>khuyenMais=khuyemmaiservice.khuyenMais();
		List<NhaSanXuat> nhaSanXuats=nhasanxuatservice.listnhasanxuat();
		modelMap.addAttribute("sanpham", chiTietSanPham);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		modelMap.addAttribute("khuyenmai", khuyenMais);
		modelMap.addAttribute("nhasanxuat", nhaSanXuats);
		for (KhuyenMai khuyemmai : khuyenMais) {
			System.out.println("ádasdasdasd"+khuyemmai.getMAKHUYENMAI());
		}
		return "chinhsuasanpham";
	}
}
