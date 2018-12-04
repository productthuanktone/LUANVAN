package com.nguyenvanthuan.daoImp;

import com.nguyenvanthuan.entity.TaiKhoan;

public interface TaiKhoanImp {
boolean kiemtradangnhap(String tendangnhap,String matkhau);
TaiKhoan laytaikhoan(String tendangnhap);
boolean Themtaikhoan(String email, String matkhau1, String matkhau2,String hoten, int sodienthoai,String diachi, int gioitinh);
}
