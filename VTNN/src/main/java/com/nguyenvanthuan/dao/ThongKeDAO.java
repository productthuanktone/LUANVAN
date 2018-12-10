package com.nguyenvanthuan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.ThongKeImp;
import com.nguyenvanthuan.entity.HoaDon;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ThongKeDAO implements ThongKeImp {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<HoaDon> hoaDons(int day, int thang) {
		Session session=sessionFactory.getCurrentSession();
		List<HoaDon> Listhoadon=(List<HoaDon>) session.createQuery("from hoadon where DAY(TIMECREATE)="+day+" and MONTH(TIMECREATE)="+thang+"and TINHTRANG=1").getResultList();
		return Listhoadon;
	}

}
