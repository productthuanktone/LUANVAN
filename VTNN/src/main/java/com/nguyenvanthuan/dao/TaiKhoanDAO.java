package com.nguyenvanthuan.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.TaiKhoanImp;
import com.nguyenvanthuan.entity.TaiKhoan;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TaiKhoanDAO implements TaiKhoanImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean kiemtradangnhap(String tendangnhap, String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TaiKhoan taikhoan = (TaiKhoan) session
					.createQuery("from taikhoan where TENDANGNHAP='" + tendangnhap + "' and MATKHAU='" + matkhau + "'")
					.getSingleResult();
			if (taikhoan != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public TaiKhoan laytaikhoan(String tendangnhap) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		try {
			TaiKhoan taikhoan = (TaiKhoan) session.createQuery("from taikhoan where TENDANGNHAP='" + tendangnhap + "'").getSingleResult();
			return taikhoan;
		} catch (Exception e) {
			return null;
		}
		
		
	}

}
