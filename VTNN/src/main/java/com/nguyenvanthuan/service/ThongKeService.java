package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.ThongKeDAO;
import com.nguyenvanthuan.daoImp.ThongKeImp;
import com.nguyenvanthuan.entity.HoaDon;
@Service
public class ThongKeService implements ThongKeImp{
@Autowired ThongKeDAO thongkedao;
	@Override
	public List<HoaDon> hoaDons(int day, int thang, int nam) {
		// TODO Auto-generated method stub
		return thongkedao.hoaDons(day,thang,nam);
	}

}
