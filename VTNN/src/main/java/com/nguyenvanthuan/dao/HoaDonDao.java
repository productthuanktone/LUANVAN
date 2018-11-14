package com.nguyenvanthuan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.HoaDonImp;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDao implements HoaDonImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean ThemHoaDon(HoaDon hoadon) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		int id=(int) session.save(hoadon);
		if(0<id) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	@Transactional
	public List<HoaDon> listHoaDon() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<HoaDon> Listhoadon=(List<HoaDon>) session.createQuery("from hoadon").getResultList();
		return Listhoadon;
	}
}
