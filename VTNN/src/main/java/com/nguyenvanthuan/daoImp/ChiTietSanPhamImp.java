package com.nguyenvanthuan.daoImp;

import java.util.List;

import com.nguyenvanthuan.entity.ChiTietSanPham;

public interface ChiTietSanPhamImp {

	List<ChiTietSanPham> ListChiTietSanPham();

	ChiTietSanPham chiTietSanPham(int id);

	List<ChiTietSanPham> listsanphamdanhmuc(int iddanhmuc);

	boolean Deletechitietsanpham(int id);

	boolean updatechitietsanpham(int id, String tensanpham, int soluong, float gia, String mota, int idnhasanxuat,
			int khuyenmai, int danhmuc, String hinh);

	boolean updatesoluongsanpham(int id, int soluongmoi);
}
