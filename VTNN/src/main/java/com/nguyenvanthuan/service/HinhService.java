package com.nguyenvanthuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.HinhDAO;
import com.nguyenvanthuan.daoImp.HinhImp;

@Service
public class HinhService implements HinhImp{
	@Autowired
	HinhDAO hinhdao;
	@Override
	public boolean themhinh(String hinh) {
		// TODO Auto-generated method stub
		return hinhdao.themhinh(hinh);
	}

}
