package com.nguyenvanthuan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.DanhMucSanPhamImp;
import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.DanhMucSanPham;
import com.nguyenvanthuan.entity.KhuyenMai;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDAO implements DanhMucSanPhamImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DanhMucSanPham> listdanhmuc() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DanhMucSanPham> Listdanhmuc = (List<DanhMucSanPham>) session.createQuery("from danhmucsanpham")
				.getResultList();
		return Listdanhmuc;
	}

	@Override
	@Transactional
	public List<DanhMucSanPham> listdanhmucid(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DanhMucSanPham> Listdanhmucid = (List<DanhMucSanPham>) session
				.createQuery("from danhmucsanpham where MADANHMUC=" + id).getResultList();
		return Listdanhmucid;
	}

	@Override
	@Transactional
	public DanhMucSanPham danhMucSanPham(int id) {
		Session session = sessionFactory.getCurrentSession();
		DanhMucSanPham danhMucSanPham = (DanhMucSanPham) session
				.createQuery("from danhmucsanpham where madanhmuc=" + id).getSingleResult();
		return danhMucSanPham;
	}

}
