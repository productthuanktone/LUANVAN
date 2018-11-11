package com.nguyenvanthuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.KhachHangDao;
import com.nguyenvanthuan.daoImp.KhachHangImp;
import com.nguyenvanthuan.entity.KhachHang;

@Service
public class KhachHangSevice implements KhachHangImp{
	@Autowired
	KhachHangDao khachhangdao;

	@Override
	public KhachHang khachhang(int makhachkang) {
		// TODO Auto-generated method stub
		return khachhangdao.khachhang(makhachkang);
	}
}
