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
		Session session = sessionFactory.getCurrentSession();
		List<NhaSanXuat> listnhasanxuat = (List<NhaSanXuat>) session.createQuery("from nhasanxuat where ISDELETE=0")
				.setFirstResult(0).setMaxResults(20).getResultList();
		return listnhasanxuat;
	}

	@Override
	public NhaSanXuat nhaSanXuat(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		NhaSanXuat nhasanxuat = (NhaSanXuat) session.createQuery("from nhasanxuat where MANHASANXUAT=" + id)
				.getSingleResult();
		return nhasanxuat;
	}

	@Override
	@Transactional
	public boolean deletenhasanxuat(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			NhaSanXuat nhasanxuat = (NhaSanXuat) session.createQuery("from nhasanxuat where MANHASANXUAT=" + id)
					.getSingleResult();
			nhasanxuat.setISDELETE(1);
			session.save(nhasanxuat);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	@Transactional
	public boolean Themnhasanxuat(String tennsx, String diachi, int sodienthoai, String email) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			NhaSanXuat nhaSanXuat = new NhaSanXuat();
			nhaSanXuat.setTENNHASANXUAT(tennsx);
			nhaSanXuat.setDIACHI(diachi);
			nhaSanXuat.setSODIENTHOAI(sodienthoai);
			nhaSanXuat.setEMAIL(email);
			session.save(nhaSanXuat);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
}
