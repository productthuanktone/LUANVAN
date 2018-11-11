package com.nguyenvanthuan.daoImp;

import com.nguyenvanthuan.entity.TaiKhoan;

public interface TaiKhoanImp {
boolean kiemtradangnhap(String tendangnhap,String matkhau);
TaiKhoan laytaikhoan(String tendangnhap);
}
