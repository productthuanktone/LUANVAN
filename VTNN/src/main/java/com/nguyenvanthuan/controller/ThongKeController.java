package com.nguyenvanthuan.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.ThongKeService;

@Controller
@RequestMapping("thongke/")
public class ThongKeController {
	@Autowired
	ThongKeService thongkeservice;
	@Autowired 
	ChiTietSanPhamService chitietsanphamservice;

	@GetMapping
	public String defualt(ModelMap modelMap) {

		return "thongke";
	}

	@GetMapping("thongkesanphamthang")
	@ResponseBody
	public String indexthongke(@RequestParam int thang,@RequestParam int nam) {
//		System.out.println("thang: "+thang+"nam: "+nam);
		List<JsonObject> jsonObjects = new ArrayList<JsonObject>();
		for (int i = 1; i < 31; i++) {
			JsonObject object = new JsonObject();
			List<HoaDon> hoaDons = thongkeservice.hoaDons(i, thang,nam);
			float tien = 0;
			for (HoaDon hoaDon : hoaDons) {
				tien = tien + hoaDon.getTONGGIA();

			}
			object.addProperty("tongtien", tien);
			jsonObjects.add(object);
		}
		return jsonObjects.toString();
	}
	@GetMapping("thongkesanphamtrongkho")
	@ResponseBody
	public String thongkesanphamtrongkho() {
		List<JsonObject> jsonObjects = new ArrayList<JsonObject>();
		List<ChiTietSanPham> chiTietSanPhams=chitietsanphamservice.ListChiTietSanPham();
		for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
			JsonObject object = new JsonObject();
				object.addProperty("sanpham", chiTietSanPham.getSanpham().getTENSANPHAM());
				object.addProperty("soluong", chiTietSanPham.getSOLUONG());
				jsonObjects.add(object);
		}
		
		return jsonObjects.toString();
	}
}
