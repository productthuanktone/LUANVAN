package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.DonViTinhDAO;
import com.nguyenvanthuan.daoImp.DonViTinhImp;
import com.nguyenvanthuan.entity.DonViTinh;

@Service
public class DonViTinhService implements DonViTinhImp {
	@Autowired
	DonViTinhDAO donvitinhdao;

	@Override
	public DonViTinh donViTinhid(int id) {
		// TODO Auto-generated method stub
		return donvitinhdao.donViTinhid(id);
	}

	@Override
	public List<DonViTinh> donViTinhs() {
		// TODO Auto-generated method stub
		return donvitinhdao.donViTinhs();
	}

}
