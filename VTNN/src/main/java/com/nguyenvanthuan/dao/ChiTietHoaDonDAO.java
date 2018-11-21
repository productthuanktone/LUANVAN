package com.nguyenvanthuan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.ChiTietHoaDonImp;
import com.nguyenvanthuan.entity.ChiTietHoaDon;



@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS )
public class ChiTietHoaDonDAO implements ChiTietHoaDonImp {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<ChiTietHoaDon> listchitiethoadonid(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ChiTietHoaDon> ListChiTietHoaDon = (List<ChiTietHoaDon>) session.createQuery("from chitiethoadon where MAHOADON="+id).getResultList();
		for (ChiTietHoaDon chiTietHoaDon : ListChiTietHoaDon) {
			System.out.println("No ne"+chiTietHoaDon.getSOLUONG());
		}
		return ListChiTietHoaDon;
	}

	

	
}
