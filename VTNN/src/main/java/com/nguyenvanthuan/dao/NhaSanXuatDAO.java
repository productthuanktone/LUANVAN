package com.nguyenvanthuan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.NhaSanXuatImp;
import com.nguyenvanthuan.entity.NhaSanXuat;
import com.nguyenvanthuan.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhaSanXuatDAO implements NhaSanXuatImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<NhaSanXuat> listnhasanxuat() {
		Session session=sessionFactory.getCurrentSession();
		List<NhaSanXuat> listnhasanxuat=(List<NhaSanXuat>) session.createQuery("from nhasanxuat").setFirstResult(0).setMaxResults(20).getResultList();
		return listnhasanxuat;
	}
}
