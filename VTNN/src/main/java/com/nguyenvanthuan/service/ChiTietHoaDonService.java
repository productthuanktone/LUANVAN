package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.ChiTietHoaDonDAO;
import com.nguyenvanthuan.daoImp.ChiTietHoaDonImp;
import com.nguyenvanthuan.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {
	@Autowired
	ChiTietHoaDonDAO chitiethdDao;
	@Override
	public List<ChiTietHoaDon> listchitiethoadonid(int id) {
		// TODO Auto-generated method stub
		return chitiethdDao.listchitiethoadonid(id);
	}

}
