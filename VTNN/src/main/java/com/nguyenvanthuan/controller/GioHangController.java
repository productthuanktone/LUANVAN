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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	@Autowired
	SessionFactory sesionFactory;

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
		Session session=sesionFactory.getCurrentSession();
		System.out.println("adssdfasdad");
		// if (null != httpSession.getAttribute("giohang")) {
		List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		Set<ChiTietHoaDon> chiTietHoaDons=new HashSet<>();
		 for (GioHang gioHang : listgiohang) {
		 ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
		 chiTietHoaDon.setSOLUONG(gioHang.getSoluong());
		 chiTietHoaDon.setTONGGIA(gioHang.getGia());
		 chiTietHoaDon.setMACHITIETSANPHAM(gioHang.getMachitietsanpham());
		 chiTietHoaDons.add(chiTietHoaDon);
		 }
//		 Set<ChiTietHoaDon> chiTietHoaDons=new HashSet<>();
//		 ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
//		 chiTietHoaDon.setSOLUONG(1);
//		 chiTietHoaDon.setTONGGIA(1);
//		 chiTietHoaDon.setMACHITIETSANPHAM(1);
//		 
//		 ChiTietHoaDon chiTietHoaDon1 = new ChiTietHoaDon();
//		 chiTietHoaDon1.setSOLUONG(2);
//		 chiTietHoaDon1.setTONGGIA(2);
//		 chiTietHoaDon1.setMACHITIETSANPHAM(2);
//		 
//		 chiTietHoaDons.add(chiTietHoaDon);
//		 chiTietHoaDons.add(chiTietHoaDon1);
		
		 HoaDon hoaDon = new HoaDon();
		 hoaDon.setHINHTHUCGIAOHANG(hinhthucgiaohang);
		 hoaDon.setDIACHIGIAOHANG(diachigiaohang);
		 hoaDon.setMOTA(mota);
		 hoaDon.setTIMECREATE((date));
		 hoaDon.setChitiethoadon(chiTietHoaDons);
		 session.save(hoaDon);
//		 if (hoadonservice.ThemHoaDon(hoaDon)) {
//		 System.out.println("Them TC");
//		 } else {
//		 System.out.println("Them TB");
//		 }
//		 }
//		 @RequestParam float tonggia,
		
		return "GioHang";
	}
}
