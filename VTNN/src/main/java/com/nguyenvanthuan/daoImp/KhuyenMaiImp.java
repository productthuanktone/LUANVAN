package com.nguyenvanthuan.daoImp;

import java.sql.Date;
import java.util.List;

import com.nguyenvanthuan.entity.KhuyenMai;

public interface KhuyenMaiImp {
	List<KhuyenMai> khuyenMais();

	KhuyenMai khuyenMai(int id);

	boolean updateKhuyenmai(int id, String tenkm, Date ngaybatdau, Date ngayketthuc, int phantram, String mota);

	boolean deletekhuyenmai(int id);

	boolean savekhuyenmai(String tenkm, Date ngaybatdau, Date ngayketthuc, int phantram, String mota);
}
