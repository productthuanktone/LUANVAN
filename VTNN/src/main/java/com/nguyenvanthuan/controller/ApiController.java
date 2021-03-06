package com.nguyenvanthuan.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.service.TaiKhoanSevice;


@Controller
@RequestMapping("api/")
@SessionAttributes("giohang")
public class ApiController {
	@Autowired
	TaiKhoanSevice taikhoanService;
	@GetMapping("themgiohang")
	@ResponseBody
	public String ThemGioHang(HttpSession httpSession,@RequestParam int machitiet, @RequestParam int soluong,@RequestParam String tensanpham,@RequestParam String hinh,@RequestParam float gia) {
		if (null == httpSession.getAttribute("giohang")) {
			GioHang gioHang = new GioHang();
			List<GioHang> giohangs = new ArrayList<>();
			gioHang.setMachitietsanpham(machitiet);
			gioHang.setSoluong(soluong);
			gioHang.setHinh(hinh);
			gioHang.setGia(gia);
			gioHang.setTensanpham(tensanpham);
			giohangs.add(gioHang);
			httpSession.setAttribute("giohang", giohangs);
			List<GioHang> giohangss=(List<GioHang>) httpSession.getAttribute("giohang");
			System.out.println(giohangss.size());
			return giohangss.size()+"";
		} else {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraGioHang(listgiohang,machitiet,httpSession);
			if(vitri==-1) {
				GioHang gioHang = new GioHang();
				gioHang.setMachitietsanpham(machitiet);
				gioHang.setSoluong(1);
				gioHang.setHinh(hinh);
				gioHang.setGia(gia);
				gioHang.setTensanpham(tensanpham);
				listgiohang.add(gioHang);
			}
			else {
				int soluongmoi = listgiohang.get(vitri).getSoluong() + soluong;
				listgiohang.get(vitri).setSoluong(soluongmoi);
			}
			System.out.println(listgiohang.size());
			return listgiohang.size()+"";
		}
//		List<GioHang> giohangs=(List<GioHang>) httpSession.getAttribute("giohang");
//		for (GioHang gioHang : giohangs) {
//			System.out.println(gioHang.getMachitietsanpham() + " so luong :" + gioHang.getSoluong());
//		}
		
	}

	private int KiemTraGioHang(List<GioHang> listgiohang, int machitiet, HttpSession httpSession) {
		for (int i = 0; i < listgiohang.size(); i++) {
			if (listgiohang.get(i).getMachitietsanpham() == machitiet) {
				return i;
			}
		}
		return -1;
	}
	@GetMapping("Laysoluonggiohang")
	@ResponseBody
	public String ThemSanPPham(HttpSession httpSession) {
		if(null!=httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
				return listgiohang.size()+"";
		}
		return "";
	}
	@GetMapping("thaydoisoluong")
	@ResponseBody
	public void capnhatgiohang(HttpSession httpSession,@RequestParam int machitiet, @RequestParam int soluong) {
		if(null!=httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraGioHang(listgiohang,machitiet,httpSession);
		
			listgiohang.get(vitri).setSoluong(soluong);
		}
		
	}
	@GetMapping("xoasanphamtronggiohang")
	@ResponseBody
	public void xoasanphamtronggiohang(HttpSession httpSession,@RequestParam int machitiet) {
		if(null!=httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraGioHang(listgiohang,machitiet,httpSession);
		
			listgiohang.remove(vitri);
		}
		
	}
	@PostMapping
	@Transactional
	public String XuLyDangNhap(@RequestParam String tendangnhap, @RequestParam String matkhau,ModelMap map) {
		boolean kiemtra = taikhoanService.kiemtradangnhap(tendangnhap, matkhau);
		if(kiemtra) {
			map.addAttribute("tendangnhap", tendangnhap);
			System.out.println("Success");
			return "redirect:quanly";
		}
		else {
			String error="Lỗi đăng nhập!Sai email hoặc mật khẩu";
			System.out.println("failure");
			map.addAttribute("error", error);
			return "dangnhap";
		}

	}
	@Autowired
	ServletContext context;
	@PostMapping("uploadfile")
	@Transactional
	public String uploadfile(MultipartHttpServletRequest request) {
		String path_save_file=context.getRealPath("/resources/img/sanpham/");
		Iterator<String> listNames=request.getFileNames();
		MultipartFile mpf=request.getFile(listNames.next());
		String tenhinh=mpf.getOriginalFilename();
		File file_save=new File(path_save_file + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mpf.getOriginalFilename());
		return tenhinh;
	}
}
