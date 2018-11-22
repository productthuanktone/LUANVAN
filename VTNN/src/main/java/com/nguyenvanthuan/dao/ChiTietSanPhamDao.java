package com.nguyenvanthuan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.ChiTietSanPhamImp;
import com.nguyenvanthuan.entity.ChiTietSanPham;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietSanPhamDao implements ChiTietSanPhamImp {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<ChiTietSanPham> ListChiTietSanPham() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ChiTietSanPham> ListSanPhham = (List<ChiTietSanPham>) session.createQuery("from chitietsanpham where ISDELETE=0")
				.setFirstResult(0).setMaxResults(20).getResultList();
		return ListSanPhham;
	}

	@Override
	@Transactional
	public ChiTietSanPham chiTietSanPham(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		ChiTietSanPham SanPham = (ChiTietSanPham) session.createQuery("from chitietsanpham where MACHITIETSANPHAM="+id+"").getSingleResult();
		return SanPham;
	}

	@Override
	@Transactional
	public List<ChiTietSanPham> listsanphamdanhmuc(int iddanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ChiTietSanPham> ListSanPhamdm = (List<ChiTietSanPham>) session.createQuery("from chitietsanpham where MADANHMUC="+iddanhmuc+" and ISDELETE=0").getResultList();
		return ListSanPhamdm;
	}

	@Override
	@Transactional
	public boolean Deletechitietsanpham(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			ChiTietSanPham SanPham = (ChiTietSanPham) session.createQuery("from chitietsanpham where MACHITIETSANPHAM="+id+"").getSingleResult();
			SanPham.setISDELETE(1);
			session.save(SanPham);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
}
