package com.nguyenvanthuan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.KhuyenMaiImp;
import com.nguyenvanthuan.entity.KhuyenMai;
import com.nguyenvanthuan.entity.NhaSanXuat;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class KhuyenMaiDAO implements KhuyenMaiImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<KhuyenMai> khuyenMais() {
		Session session = sessionFactory.getCurrentSession();
		List<KhuyenMai> khuyenMais = (List<KhuyenMai>) session.createQuery("from khuyenmai").getResultList();
		return khuyenMais;
	}

	@Override
	public KhuyenMai khuyenMai(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		KhuyenMai khuyenMai = (KhuyenMai) session.createQuery("from khuyenmai where MAKHUYENMAI=" + id)
				.getSingleResult();
		return khuyenMai;
	}

}
