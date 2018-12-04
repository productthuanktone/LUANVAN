package com.nguyenvanthuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		List<NhaSanXuat> nhaSanXuats=nhasanxuatservice.listnhasanxuat();
		modelMap.addAttribute("nhasanxuat", nhaSanXuats);
		return "nhasanxuat";
	}
}
