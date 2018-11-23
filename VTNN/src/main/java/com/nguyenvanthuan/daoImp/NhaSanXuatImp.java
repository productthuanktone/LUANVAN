package com.nguyenvanthuan.daoImp;

import java.util.List;

import com.nguyenvanthuan.entity.NhaSanXuat;

public interface NhaSanXuatImp {
	List<NhaSanXuat> listnhasanxuat();

	NhaSanXuat nhaSanXuat(int id);
}
