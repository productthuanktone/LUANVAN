package com.nguyenvanthuan.daoImp;

import java.util.List;

import com.nguyenvanthuan.entity.DanhMucSanPham;

public interface DanhMucSanPhamImp {
	List<DanhMucSanPham> listdanhmuc();
	List<DanhMucSanPham>listdanhmucid(int id);
}
