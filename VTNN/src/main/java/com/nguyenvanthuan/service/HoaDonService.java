package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.HoaDonDao;
import com.nguyenvanthuan.daoImp.HoaDonImp;
import com.nguyenvanthuan.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp{
	@Autowired
	HoaDonDao hoaDonDao;

	@Override
	public boolean ThemHoaDon(HoaDon hoadon) {
		// TODO Auto-generated method stub
		return hoaDonDao.ThemHoaDon(hoadon);
	}

	@Override
	public List<HoaDon> listHoaDon() {
		// TODO Auto-generated method stub
		return hoaDonDao.listHoaDon();
	}

	@Override
	public HoaDon hoaDonid(int id) {
		// TODO Auto-generated method stub
		return hoaDonDao.hoaDonid(id);
	}

	@Override
	public void SaveHoaDon(int tinhtrang, int id) {
		hoaDonDao.SaveHoaDon(tinhtrang, id);
		
	}

	@Override
	public List<HoaDon> tingtranghoaDons(int tinhtrang) {
		// TODO Auto-generated method stub
		return hoaDonDao.tingtranghoaDons(tinhtrang);
	}
}
