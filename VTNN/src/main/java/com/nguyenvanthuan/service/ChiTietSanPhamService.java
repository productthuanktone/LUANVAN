package com.nguyenvanthuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvanthuan.dao.ChiTietSanPhamDao;
import com.nguyenvanthuan.daoImp.ChiTietSanPhamImp;
import com.nguyenvanthuan.entity.ChiTietSanPham;

@Service
public class ChiTietSanPhamService implements ChiTietSanPhamImp {

	@Autowired
	ChiTietSanPhamDao chiTietSanPhamDao;

	@Override
	public List<ChiTietSanPham> ListChiTietSanPham() {

		return chiTietSanPhamDao.ListChiTietSanPham();
	}

	@Override
	public ChiTietSanPham chiTietSanPham(int id) {
		
		return chiTietSanPhamDao.chiTietSanPham(id);
	}

	@Override
	public List<ChiTietSanPham> listsanphamdanhmuc(int iddanhmuc) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDao.listsanphamdanhmuc(iddanhmuc);
	}

	@Override
	public boolean Deletechitietsanpham(int id) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDao.Deletechitietsanpham(id);
	}

	@Override
	public boolean updatechitietsanpham(int id, String tensanpham, int soluong, float gia, String mota,
			int idnhasanxuat, int khuyenmai, int danhmuc, String hinh) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDao.updatechitietsanpham(id, tensanpham, soluong, gia, mota, idnhasanxuat, khuyenmai, danhmuc, hinh);
	}

	@Override
	public boolean updatesoluongsanpham(int id, int soluongmoi) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDao.updatesoluongsanpham(id, soluongmoi);
	}
}
