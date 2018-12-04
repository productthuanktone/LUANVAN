package com.nguyenvanthuan.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.HinhImp;
import com.nguyenvanthuan.entity.Hinh;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HinhDAO implements HinhImp{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	@Transactional
	public boolean themhinh(String hinh) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Hinh hinh2=new Hinh();
			hinh2.setHINH(hinh);
			hinh2.setLOAIHINH(1);
			session.save(hinh2);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
