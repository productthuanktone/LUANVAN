package com.nguyenvanthuan.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.KhuyenMaiImp;
import com.nguyenvanthuan.entity.KhuyenMai;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class KhuyenMaiDAO implements KhuyenMaiImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<KhuyenMai> khuyenMais() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<KhuyenMai> khuyenMais = (List<KhuyenMai>) session.createQuery("from khuyenmai where ISDELETE=0")
				.getResultList();
		return khuyenMais;
	}

	@Override
	@Transactional
	public KhuyenMai khuyenMai(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		KhuyenMai khuyenMai = (KhuyenMai) session.createQuery("from khuyenmai where MAKHUYENMAI=" + id)
				.getSingleResult();
		return khuyenMai;
	}

	@Override
	@Transactional
	public boolean deletekhuyenmai(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			KhuyenMai khuyenMai = (KhuyenMai) session.createQuery("from khuyenmai where MAKHUYENMAI=" + id)
					.getSingleResult();
			khuyenMai.setISDELETE(1);
			session.save(khuyenMai);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	@Transactional
	public boolean updateKhuyenmai(int id, String tenkm, Date ngaybatdau, Date ngayketthuc, int phantram, String mota) {
		Session session = sessionFactory.getCurrentSession();
		try {
			KhuyenMai khuyenmai = (KhuyenMai) session.createQuery("from khuyenmai where MAKHUYENMAI=" + id).getSingleResult();
			khuyenmai.setTENKHUYENMAI(tenkm);
			khuyenmai.setTHOIGIANBATDAU(ngaybatdau);
			khuyenmai.setTHOIGIANKETTHUC(ngayketthuc);
			khuyenmai.setPHANTRAM(phantram);
			khuyenmai.setMOTA(mota);
			session.save(khuyenmai);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	@Transactional
	public boolean savekhuyenmai(String tenkm, Date ngaybatdau, Date ngayketthuc, int phantram, String mota) {
		Session session=sessionFactory.getCurrentSession();
		try {
			KhuyenMai khuyenmai1=new KhuyenMai();
			khuyenmai1.setTENKHUYENMAI(tenkm);
			khuyenmai1.setTHOIGIANBATDAU(ngaybatdau);
			khuyenmai1.setTHOIGIANKETTHUC(ngayketthuc);
			khuyenmai1.setPHANTRAM(phantram);
			khuyenmai1.setMOTA(mota);
			session.save(khuyenmai1);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
