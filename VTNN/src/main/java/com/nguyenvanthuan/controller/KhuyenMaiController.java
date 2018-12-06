package com.nguyenvanthuan.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("deletekm/{id}")
	public String delete(ModelMap modelMap,@PathVariable int id) {
		khuyenmaiservice.deletekhuyenmai(id);
		return "redirect:/khuyenmai/";
	}
	@GetMapping("chinhsua/{id}")
	public String updatenhasanxuat(ModelMap modelMap, @PathVariable int id) {
		KhuyenMai khuyenMai = khuyenmaiservice.khuyenMai(id);
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		String datebt=dt1.format(khuyenMai.getTHOIGIANBATDAU());
		String datekt=dt1.format(khuyenMai.getTHOIGIANKETTHUC());
		modelMap.addAttribute("khuyenmai", khuyenMai);
		modelMap.addAttribute("datebt", datebt);
		modelMap.addAttribute("datekt", datekt);
		return "chinhsuakhuyenmai";
	}
	@PostMapping("chinhsua")
	public String update(ModelMap modelMap,@RequestParam int id, @RequestParam String tenkm, @RequestParam Date ngaybatdau,
			@RequestParam Date ngayketthuc, @RequestParam int phantram, @RequestParam String mota) {
		System.out.println(id+""+ ngaybatdau+" "+ngayketthuc);
		if(khuyenmaiservice.updateKhuyenmai(id, tenkm, ngaybatdau, ngayketthuc, phantram, mota)) {
			return "redirect:/khuyenmai/";
		}else {
			String error="Lỗi nhập dữ liệu. Xin kiểm tra lại !";
			modelMap.addAttribute("loi", error);
			System.out.println(error);
			return "chinhsuakhuyenmai";
		}
	}	
}
