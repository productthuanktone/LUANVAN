package com.nguyenvanthuan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.DanhMucSanPhamImp;
import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDAO implements DanhMucSanPhamImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<DanhMucSanPham> listdanhmuc() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DanhMucSanPham> Listdanhmuc = (List<DanhMucSanPham>) session.createQuery("from danhmucsanpham").getResultList();
		return Listdanhmuc;
	}

	@Override
	public List<DanhMucSanPham> listdanhmucid(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DanhMucSanPham> Listdanhmucid = (List<DanhMucSanPham>) session.createQuery("from danhmucsanpham where MADANHMUC="+id).getResultList();
		return Listdanhmucid;
	}

}
