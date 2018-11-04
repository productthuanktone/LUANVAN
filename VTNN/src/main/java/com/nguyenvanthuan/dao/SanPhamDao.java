package com.nguyenvanthuan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenvanthuan.daoImp.SanPhamImp;
import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.DanhMucSanPham;
import com.nguyenvanthuan.entity.Gia;
import com.nguyenvanthuan.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<SanPham> ListSanPham() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<SanPham> ListSanPhham=(List<SanPham>) session.createQuery("from sanpham where MASANPHAM=1").getResultList();
		for (SanPham sanPham : ListSanPhham) {
			for (ChiTietSanPham chiTietSanPham : sanPham.getChitietsanpham()) {
				System.out.println("Thông tin sản phẩm:"+sanPham.getTENSANPHAM()+chiTietSanPham.getSOLUONG()+sanPham.getMOTA()+chiTietSanPham.getGia().getGIA()+chiTietSanPham.getNhasanpham().getTENNHASANXUAT()+chiTietSanPham.getHinh().getHINH()+chiTietSanPham.getDonvitinh().getTENDONVITINH());
			}
			
			
		}
		return null;
	}

}
