package com.nguyenvanthuan.service;

import java.sql.Date;
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

	@Override
	public KhuyenMai khuyenMai(int id) {
		// TODO Auto-generated method stub
		return khuyenMaiDAO.khuyenMai(id);
	}

	@Override
	public boolean deletekhuyenmai(int id) {
		// TODO Auto-generated method stub
		return khuyenMaiDAO.deletekhuyenmai(id);
	}

	@Override
	public boolean updateKhuyenmai(int id, String tenkm, Date ngaybatdau, Date ngayketthuc, int phantram, String mota) {
		// TODO Auto-generated method stub
		return khuyenMaiDAO.updateKhuyenmai(id, tenkm, ngaybatdau, ngayketthuc, phantram, mota);
	}

	@Override
	public boolean savekhuyenmai(String tenkm, Date ngaybatdau, Date ngayketthuc, int phantram, String mota) {
		// TODO Auto-generated method stub
		return khuyenMaiDAO.savekhuyenmai(tenkm, ngaybatdau, ngayketthuc, phantram, mota);
	}
}
