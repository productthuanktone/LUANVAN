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
import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.entity.SanPham;
import com.nguyenvanthuan.service.ChiTietSanPhamService;

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

	@Override
	@Transactional
	public HoaDon hoaDonid(int id) {
		Session session=sessionFactory.getCurrentSession();
		HoaDon hoadonid=(HoaDon) session.createQuery("from hoadon where MAHOADON="+id).getSingleResult();
		return hoadonid;
	}

	@Override
	@Transactional
	public void SaveHoaDon(int tinhtrang,int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		HoaDon hoadon=(HoaDon) session.createQuery("from hoadon where MAHOADON="+id).getSingleResult();
		hoadon.setTINHTRANG(tinhtrang);
		session.save(hoadon);
	}
}
