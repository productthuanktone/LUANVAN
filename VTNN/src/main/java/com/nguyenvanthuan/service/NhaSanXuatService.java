package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.NhaSanXuatDAO;
import com.nguyenvanthuan.daoImp.NhaSanXuatImp;
import com.nguyenvanthuan.entity.NhaSanXuat;

@Service
public class NhaSanXuatService implements NhaSanXuatImp{
	@Autowired
	NhaSanXuatDAO nhasanxuatdao;
	@Override
	public List<NhaSanXuat> listnhasanxuat() {
		// TODO Auto-generated method stub
		return nhasanxuatdao.listnhasanxuat();
	}

}
