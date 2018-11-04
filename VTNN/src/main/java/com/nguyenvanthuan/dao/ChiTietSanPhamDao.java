package com.nguyenvanthuan.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.ChiTietSanPhamImp;
import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.SanPham;;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietSanPhamDao implements ChiTietSanPhamImp{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<ChiTietSanPham> ListChiTietSanPham() {
		Session session=sessionFactory.getCurrentSession();
		List<ChiTietSanPham> ListSanPhham=(List<ChiTietSanPham>) session.createQuery("from chitietsanpham").setFirstResult(0).setMaxResults(20).getResultList();
		for (ChiTietSanPham chiTietSanPham : ListSanPhham) {
			System.out.println("San Pham "+chiTietSanPham.getSanpham().getTENSANPHAM()+"  "+chiTietSanPham.getGia().getGIA()+" "+chiTietSanPham.getHinh().getHINH());
		}
		return ListSanPhham;
	}

}
