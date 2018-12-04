package com.nguyenvanthuan.daoImp;

import java.util.List;



import com.nguyenvanthuan.entity.ChiTietSanPham;

public interface ChiTietSanPhamImp {

	List<ChiTietSanPham> ListChiTietSanPham();

	ChiTietSanPham chiTietSanPham(int id);

	List<ChiTietSanPham> listsanphamdanhmuc(int iddanhmuc);

	boolean Deletechitietsanpham(int id);

	boolean updatechitietsanpham(int id, String tensanpham, int soluong, float gia, String mota, int idnhasanxuat,
			int khuyenmai, int danhmuc, String hinh, int donvitinh);

	boolean updatesoluongsanpham(int id, int soluongmoi);

	boolean savechitietsanpham(String tensp, int nhasanxuat,
			int soluong, int khuyenmai, float gia, int danhmuc,
			String mota, String hinh, int donvitinh);
}
