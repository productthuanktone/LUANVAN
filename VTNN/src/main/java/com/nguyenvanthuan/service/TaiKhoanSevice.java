package com.nguyenvanthuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.TaiKhoanDAO;
import com.nguyenvanthuan.daoImp.TaiKhoanImp;
@Service
public class TaiKhoanSevice implements TaiKhoanImp {
	@Autowired
	TaiKhoanDAO taikhoandao;
	@Override
	public boolean kiemtradangnhap(String tendangnhap, String matkhau) {
		// TODO Auto-generated method stub
		return taikhoandao.kiemtradangnhap(tendangnhap, matkhau);
	}

}
