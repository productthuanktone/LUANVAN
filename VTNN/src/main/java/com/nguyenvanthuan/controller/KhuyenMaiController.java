package com.nguyenvanthuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanthuan.entity.KhuyenMai;

import com.nguyenvanthuan.service.KhuyemMaiService;

@Controller
@RequestMapping("khuyenmai/")
public class KhuyenMaiController {
	@Autowired
	KhuyemMaiService khuyenmaiservice;
	@GetMapping
	public String defualt(ModelMap modelMap) {
		List<KhuyenMai> khuyenmais = khuyenmaiservice.khuyenMais();
		modelMap.addAttribute("khuyenmai", khuyenmais);
		return "khuyenmai";
	}
}
