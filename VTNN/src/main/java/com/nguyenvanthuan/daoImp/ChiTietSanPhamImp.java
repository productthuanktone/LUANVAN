package com.nguyenvanthuan.daoImp;

import java.util.List;

import com.nguyenvanthuan.entity.ChiTietSanPham;

public interface ChiTietSanPhamImp {

	List<ChiTietSanPham> ListChiTietSanPham();
	ChiTietSanPham chiTietSanPham(int id);
	List<ChiTietSanPham> listsanphamdanhmuc(int iddanhmuc);
}
