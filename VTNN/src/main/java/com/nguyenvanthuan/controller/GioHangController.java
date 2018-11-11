package com.nguyenvanthuan.controller;

import static org.hamcrest.CoreMatchers.endsWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.entity.KhachHang;
import com.nguyenvanthuan.entity.TaiKhoan;
import com.nguyenvanthuan.service.HoaDonService;
import com.nguyenvanthuan.service.KhachHangSevice;
import com.nguyenvanthuan.service.TaiKhoanSevice;

@Controller
@RequestMapping("giohang/")
@SessionAttributes("giohang,tendangnhap")
public class GioHangController {
	@Autowired
	HoaDonService hoadonservice;
	@Autowired
	SessionFactory sesionFactory;
	@Autowired
	TaiKhoanSevice taikhoanSV;
	@Autowired
	KhachHangSevice khachhangservice;
	@GetMapping
	@Transactional
	public String GioHang(ModelMap modelMap, HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			@SuppressWarnings("unchecked")
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluonggiohang", listgiohang.size());
			modelMap.addAttribute("giohang", listgiohang);
		}
		String tendangnhap=(String) httpSession.getAttribute("tendangnhap");
		TaiKhoan taiKhoan=taikhoanSV.laytaikhoan(tendangnhap);
		System.out.println(taiKhoan.getKhachhang().getHOTEN());
		//System.out.println(tendangnhap);
		modelMap.addAttribute("taikhoan",taiKhoan);
		return "GioHang";
	}

	@PostMapping
	@Transactional
	public String MuaHang( @RequestParam int hinhthucgiaohang,
			@RequestParam String diachigiaohang, @RequestParam String mota,
			 HttpSession httpSession,ModelMap modelMap) {
		System.out.println("adssdfasdad");
		 if (null != httpSession.getAttribute("giohang")) {
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
		 String tendangnhap=(String) httpSession.getAttribute("tendangnhap");
			TaiKhoan taiKhoan=taikhoanSV.laytaikhoan(tendangnhap);
			int makhachhang=taiKhoan.getKhachhang().getMAKHACHHANG();
			KhachHang khachHang=khachhangservice.khachhang(makhachhang);
		 HoaDon hoaDon = new HoaDon();
		 hoaDon.setHINHTHUCGIAOHANG(hinhthucgiaohang);
		 hoaDon.setDIACHIGIAOHANG(diachigiaohang);
		 hoaDon.setMOTA(mota);
		 hoaDon.setTIMECREATE((date));
		 hoaDon.setKhachhang(khachHang);
		 hoaDon.setChitiethoadon(chiTietHoaDons);
		 if (hoadonservice.ThemHoaDon(hoaDon)) {
		 System.out.println("Them TC");
		 httpSession.removeAttribute("giohang");
		 String thanhcong="Đặt Hàng Thành Công!";
		 modelMap.addAttribute("tc", thanhcong);
		 } else {
		 System.out.println("Them TB");
		 String thatbai="Đặt Hàng không Thành Công!";
		 modelMap.addAttribute("tc", thatbai);
		 }
	 }
	// @RequestParam float tonggia,

	return"GioHang";
}}
