package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.ChiTietSanPhamDao;
import com.nguyenvanthuan.daoImp.ChiTietSanPhamImp;
import com.nguyenvanthuan.entity.ChiTietSanPham;

@Service
public class ChiTietSanPhamService implements ChiTietSanPhamImp {

	@Autowired
	ChiTietSanPhamDao chiTietSanPhamDao;

	@Override
	public List<ChiTietSanPham> ListChiTietSanPham() {

		return chiTietSanPhamDao.ListChiTietSanPham();
	}
}
