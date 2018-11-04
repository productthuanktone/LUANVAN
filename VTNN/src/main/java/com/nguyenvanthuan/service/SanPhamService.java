package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.SanPhamDao;
import com.nguyenvanthuan.daoImp.SanPhamImp;
import com.nguyenvanthuan.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{
	@Autowired
	SanPhamDao sanPhamDao;

	@Override
	public List<SanPham> ListSanPham() {
		// TODO Auto-generated method stub
		return sanPhamDao.ListSanPham();
	}

}
