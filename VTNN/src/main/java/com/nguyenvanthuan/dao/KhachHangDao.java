package com.nguyenvanthuan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.KhachHangImp;
import com.nguyenvanthuan.entity.KhachHang;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class KhachHangDao implements KhachHangImp {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public KhachHang khachhang(int makhachkang) {
		Session session=sessionFactory.getCurrentSession();
		KhachHang khachhang = (KhachHang) session.createQuery("from khachhang where MAKHACHHANG=" + makhachkang).getSingleResult();
		return khachhang;
	}

}
