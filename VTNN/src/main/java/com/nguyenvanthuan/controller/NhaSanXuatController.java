package com.nguyenvanthuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.entity.NhaSanXuat;
import com.nguyenvanthuan.service.NhaSanXuatService;

@Controller
@RequestMapping("nhasanxuat/")
public class NhaSanXuatController {
	@Autowired
	NhaSanXuatService nhasanxuatservice;

	@GetMapping
	public String defualt(ModelMap modelMap) {
		List<NhaSanXuat> nhaSanXuats = nhasanxuatservice.listnhasanxuat();
		modelMap.addAttribute("nhasanxuat", nhaSanXuats);
		return "nhasanxuat";
	}

	@GetMapping("{id}")
	public String deletenhasanxuat(ModelMap modelMap, @PathVariable int id) {
		nhasanxuatservice.deletenhasanxuat(id);
		List<NhaSanXuat> nhaSanXuats = nhasanxuatservice.listnhasanxuat();
		modelMap.addAttribute("nhasanxuat", nhaSanXuats);
		return "nhasanxuat";
	}

	@GetMapping("themnhasanxuat")
	public String themnhasanxuat(ModelMap modelMap) {

		return "themnhasanxuat";
	}

	@PostMapping("themnhasanxuat")
	public String themnhasanxuatpost(ModelMap modelMap, @RequestParam String tennsx, @RequestParam String diachi,
			@RequestParam int sodienthoai, @RequestParam String email) {
		nhasanxuatservice.Themnhasanxuat(tennsx, diachi, sodienthoai, email);

		List<NhaSanXuat> nhaSanXuats = nhasanxuatservice.listnhasanxuat();
		modelMap.addAttribute("nhasanxuat", nhaSanXuats);
		return "nhasanxuat";
	}

	@GetMapping("chinhsua/{id}")
	public String updatenhasanxuat(ModelMap modelMap, @PathVariable int id) {
		NhaSanXuat nhaSanXuat = nhasanxuatservice.nhaSanXuat(id);

		modelMap.addAttribute("nhasanxuat", nhaSanXuat);
		return "chinhsuanhasanxuat";
	}

	@PostMapping("chinhsua")
	public String update(ModelMap modelMap, @RequestParam String tennsx, @RequestParam int id,
			@RequestParam String diachi, @RequestParam int sodienthoai, @RequestParam String email) {
		if(nhasanxuatservice.updatenhasanxuat(id, tennsx, diachi, sodienthoai, email)==true) {
			List<NhaSanXuat> nhaSanXuats = nhasanxuatservice.listnhasanxuat();
			modelMap.addAttribute("nhasanxuat", nhaSanXuats);
			return "nhasanxuat";
		}else {
			String error="Lỗi nhập dữ liệu. Xin kiểm tra lại !";
			modelMap.addAttribute("loi", error);
			System.out.println(error);
			return "chinhsuanhasanxuat";
		}
		
		
	}
}
