package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.KhuyenMaiDAO;
import com.nguyenvanthuan.daoImp.KhuyenMaiImp;
import com.nguyenvanthuan.entity.KhuyenMai;

@Service
public class KhuyemMaiService implements KhuyenMaiImp {
	@Autowired
	KhuyenMaiDAO khuyenMaiDAO;

	@Override
	public List<KhuyenMai> khuyenMais() {
		// TODO Auto-generated method stub
		return khuyenMaiDAO.khuyenMais();
	}
}
