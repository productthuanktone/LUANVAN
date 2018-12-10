package com.nguyenvanthuan.daoImp;

import java.util.List;

import com.nguyenvanthuan.entity.HoaDon;

public interface HoaDonImp {
	boolean ThemHoaDon (HoaDon hoadon);
	List<HoaDon> listHoaDon();
	HoaDon hoaDonid(int id);
	void SaveHoaDon(int tinhtrang,int id);
	List<HoaDon> tingtranghoaDons(int tinhtrang);
}
