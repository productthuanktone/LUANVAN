package com.nguyenvanthuan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.DonViTinhImp;

import com.nguyenvanthuan.entity.DonViTinh;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DonViTinhDAO implements DonViTinhImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public DonViTinh donViTinhid(int id) {
		Session session = sessionFactory.getCurrentSession();
		DonViTinh donViTinh = (DonViTinh) session.createQuery("from donvitinh where MADONVITINH=" + id).getSingleResult();
		return donViTinh;

	}

	@Override
	@Transactional
	public List<DonViTinh> donViTinhs() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<DonViTinh> donViTinhs = session.createQuery("from donvitinh").getResultList();
		return donViTinhs;
	}

}
