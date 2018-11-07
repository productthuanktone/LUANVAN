package com.nguyenvanthuan.controller;

import static org.hamcrest.CoreMatchers.theInstance;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.GioHang;

@Controller
@RequestMapping("api/")
@SessionAttributes("giohang")
public class ApiController {

	@GetMapping("themgiohang")
	public void ThemGioHang(@RequestParam int machitiet, @RequestParam int soluong, HttpSession httpSession) {
		if (null == httpSession.getAttribute("giohang")) {
			GioHang gioHang = new GioHang();
			List<GioHang> giohangs = new ArrayList<>();
			gioHang.setMachitietsanpham(machitiet);
			gioHang.setSoluong(soluong);
			giohangs.add(gioHang);
			httpSession.setAttribute("giohang", giohangs);
		} else {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraGioHang(listgiohang,machitiet,httpSession);
			if(vitri==-1) {
				GioHang gioHang = new GioHang();
				gioHang.setMachitietsanpham(machitiet);
				gioHang.setSoluong(1);
				listgiohang.add(gioHang);
			}
			else {
				int soluongmoi = listgiohang.get(vitri).getSoluong() + soluong;
				listgiohang.get(vitri).setSoluong(soluongmoi);
			}

		}
		List<GioHang> giohangs=(List<GioHang>) httpSession.getAttribute("giohang");
		for (GioHang gioHang : giohangs) {
			System.out.println(gioHang.getMachitietsanpham() + " so luong :" + gioHang.getSoluong());
		}
		
	}

	private int KiemTraGioHang(List<GioHang> listgiohang, int machitiet, HttpSession httpSession) {
		for (int i = 0; i < listgiohang.size(); i++) {
			if (listgiohang.get(i).getMachitietsanpham() == machitiet) {
				return i;
			}
		}
		return -1;
	}
}