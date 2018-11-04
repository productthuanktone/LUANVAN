	package com.nguyenvanthuan.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.transaction.Transactional;

import org.hibernate.Session;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanthuan.entity.DanhMucSanPham;
import com.nguyenvanthuan.entity.SanPham;
import com.nguyenvanthuan.service.SanPhamService;


@Controller
@RequestMapping("/")
public class TrangChuController {
	@Autowired
	SanPhamService sanphamService;
	SessionFactory sessionFactory;
	
	@GetMapping
	@Transactional
	public String TrangChu(ModelMap modelMap) {
		
//		SanPham sanPham1=new SanPham("ccc","vvv","sssss");
//		Set<SanPham> sanphams=new HashSet<>();
//		sanphams.add(sanPham1);
//		NhanVien nhanVien=new NhanVien("dd0,","ddd",4,"dfdf","ddd");
//		nhanVien.setSanphams(sanphams);
////		session.save(nhanVien);
//		Session session = sessionFactory.getCurrentSession();
//		NhanVien nv=new NhanVien();
//		nv.setIdNhanVien(246);
//		session.delete(nv);
//		SanPham p=new SanPham();
//		p.setMOTA("Thuoc tru mui");
//		p.setTENSANPHAM("Elephan");
//		p.setCREATEID(1);
//		
//		SanPham p1=new SanPham();
//		p1.setMOTA("Thuoc tru mui nhe");
//		p1.setTENSANPHAM("Elephan");
//		p1.setCREATEID(1);
//		Set<SanPham>sanphams=new HashSet<>();
//		sanphams.add(p1);
//		sanphams.add(p);
//		DanhMucSanPham dm=new DanhMucSanPham();
//		dm.setTENDANHMUC("Thuoc mui");
//		dm.setCREATEID(1);
//		dm.setSanPhamEntitys(sanphams);
//		session.save(dm);
	
		sanphamService.ListSanPham();
		
		return "index";
	}
}
