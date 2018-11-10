package com.nguyenvanthuan.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.service.HoaDonService;

@Controller
@RequestMapping("giohang/")
@SessionAttributes("giohang")
public class GioHangController {
	@Autowired
	HoaDonService hoadonservice;

	@GetMapping
	@Transactional
	public String GioHang(ModelMap modelMap, HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluonggiohang", listgiohang.size());
			modelMap.addAttribute("giohang", listgiohang);
		}

		return "GioHang";
	}

	@PostMapping
	@Transactional
	public String MuaHang( @RequestParam int hinhthucgiaohang,
			@RequestParam String diachigiaohang, @RequestParam String mota,
			 HttpSession httpSession) {
		System.out.println("adssdfasdad");
		// if (null != httpSession.getAttribute("giohang")) {
		// List<GioHang> listgiohang = (List<GioHang>)
		// httpSession.getAttribute("giohang");
		// HoaDon hoaDon = new HoaDon();
		// hoaDon.setHINHTHUCGIAOHANG(hinhthucgiaohang);
		// hoaDon.setDIACHIGIAOHANG(diachigiaohang);
		// hoaDon.setMOTA(mota);
		// hoaDon.getKhachhang().setMAKHACHHANG(makhachhang);
		// hoaDon.setTIMECREATE(timecreate);
		// hoaDon.setTONGGIA(tonggia);
		// hoaDon.getNhanvien().setMANHANVIEN(0);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		 System.out.println(timeStamp);
		// Set<ChiTietHoaDon> chiTietHoaDons=new HashSet<>();
		// for (GioHang gioHang : listgiohang) {
		// ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
		// chiTietHoaDon.setMACHITIETSANPHAM(gioHang.getMachitietsanpham());
		// chiTietHoaDon.setSOLUONG(gioHang.getSoluong());
		// chiTietHoaDon.setTONGGIA(gioHang.getGia());
		// chiTietHoaDons.add(chiTietHoaDon);
		// }
		// hoaDon.setChitiethoadon(chiTietHoaDons);
		// if (hoadonservice.ThemHoaDon(hoaDon)) {
		// System.out.println("Them TC");
		// } else {
		// System.out.println("Them TB");
		// }
		// }
//		 @RequestParam float tonggia,
		
		return "GioHang";
	}
}
