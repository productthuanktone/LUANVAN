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
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.HoaDonService;

@Controller
@RequestMapping("hoadon/")
@SessionAttributes("tendangnhap")
public class HoaDonController {
	@Autowired
	HoaDonService hoadonService;
	@Autowired
	ChiTietHoaDonService chitiethoadonService;
	@Autowired
	ChiTietSanPhamService chitietsanphamservice;
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
	public String XuLyHoaDon(ModelMap modelMap, @PathVariable int id, @PathVariable int tinhtrang) {
		if (kiemtrasoluong(id)) {
			List<ChiTietHoaDon> chiTietHoaDonlist = chitiethoadonService.listchitiethoadonid(id);
			for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonlist) {
				int soluongmoi=Math.abs(chiTietHoaDon.getSOLUONG() - chiTietHoaDon.getChiTietSanPham().getSOLUONG());
				System.out.println(soluongmoi);
				chitietsanphamservice.updatesoluongsanpham(chiTietHoaDon.getChiTietSanPham().getMACHITIETSANPHAM(), soluongmoi);
			}
			hoadonService.SaveHoaDon(tinhtrang, id);
			List<HoaDon> listhoadon = hoadonService.listHoaDon();
			modelMap.addAttribute("hoadon", listhoadon);
			return "hoadon";
		}
		else {
			String hethang="Số lượng trong kho không đủ đáp ứng.";
			modelMap.addAttribute("hethang", hethang);
			List<ChiTietHoaDon> chitiethoadons = chitiethoadonService.listchitiethoadonid(id);
			HoaDon hoaDon = hoadonService.hoaDonid(id);
			modelMap.addAttribute("listchitiet", chitiethoadons);
			modelMap.addAttribute("hoadon", hoaDon);
			return "chitiethoadon";
		}

	}

	public boolean kiemtrasoluong(int id) {
		List<ChiTietHoaDon> chiTietHoaDonlist = chitiethoadonService.listchitiethoadonid(id);
		int tong = 0;
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonlist) {
			if (chiTietHoaDon.getSOLUONG() > chiTietHoaDon.getChiTietSanPham().getSOLUONG()) {
				tong = tong + 1;
			} 
		}
		if (tong == 0) {
			return true;
		} else {
			return false;
		}
	}
}