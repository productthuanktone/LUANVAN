package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.DanhMucSanPhamDAO;
import com.nguyenvanthuan.daoImp.DanhMucSanPhamImp;
import com.nguyenvanthuan.entity.DanhMucSanPham;

@Service
public class DanhMucSanPhamService implements DanhMucSanPhamImp {
	@Autowired
	DanhMucSanPhamDAO danhmucdao;

	@Override
	public List<DanhMucSanPham> listdanhmuc() {
		// TODO Auto-generated method stub
		return danhmucdao.listdanhmuc();
	}

	@Override
	public List<DanhMucSanPham> listdanhmucid(int id) {
		// TODO Auto-generated method stub
		return danhmucdao.listdanhmucid(id);
	}

	@Override
	public DanhMucSanPham danhMucSanPham(int id) {
		// TODO Auto-generated method stub
		return danhmucdao.danhMucSanPham(id);
	}

}
