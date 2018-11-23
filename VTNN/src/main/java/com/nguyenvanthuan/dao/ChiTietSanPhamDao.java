package com.nguyenvanthuan.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.nguyenvanthuan.entity.DanhMucSanPham;
import com.nguyenvanthuan.entity.Gia;
import com.nguyenvanthuan.entity.KhuyenMai;
import com.nguyenvanthuan.entity.NhaSanXuat;
import com.nguyenvanthuan.service.DanhMucSanPhamService;
import com.nguyenvanthuan.service.KhuyemMaiService;
import com.nguyenvanthuan.service.NhaSanXuatService;

import sun.invoke.empty.Empty;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietSanPhamDao implements ChiTietSanPhamImp {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	NhaSanXuatService nhasanxuatservice;
	@Autowired
	KhuyemMaiService khuyemmaiservice;
	@Autowired
	DanhMucSanPhamService danhmucservice;

	@Override
	@Transactional
	public List<ChiTietSanPham> ListChiTietSanPham() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ChiTietSanPham> ListSanPhham = (List<ChiTietSanPham>) session
				.createQuery("from chitietsanpham where ISDELETE=0").setFirstResult(0).setMaxResults(20)
				.getResultList();
		return ListSanPhham;
	}

	@Override
	@Transactional
	public ChiTietSanPham chiTietSanPham(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		ChiTietSanPham SanPham = (ChiTietSanPham) session
				.createQuery("from chitietsanpham where MACHITIETSANPHAM=" + id + "").getSingleResult();
		return SanPham;
	}

	@Override
	@Transactional
	public List<ChiTietSanPham> listsanphamdanhmuc(int iddanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ChiTietSanPham> ListSanPhamdm = (List<ChiTietSanPham>) session
				.createQuery("from chitietsanpham where MADANHMUC=" + iddanhmuc + " and ISDELETE=0").getResultList();
		return ListSanPhamdm;
	}

	@Override
	@Transactional
	public boolean Deletechitietsanpham(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			ChiTietSanPham SanPham = (ChiTietSanPham) session
					.createQuery("from chitietsanpham where MACHITIETSANPHAM=" + id + "").getSingleResult();
			SanPham.setISDELETE(1);
			session.save(SanPham);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	@Transactional
	public boolean updatechitietsanpham(int id, String tensanpham, int soluong, float gia, String mota,
			int idnhasanxuat, int khuyenmai, int danhmuc, String hinh) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietSanPham SanPham = (ChiTietSanPham) session
				.createQuery("from chitietsanpham where MACHITIETSANPHAM=" + id + "").getSingleResult();
		SanPham.getSanpham().setTENSANPHAM(tensanpham);
		SanPham.setSOLUONG(soluong);
		SanPham.getSanpham().setMOTA(mota);
		NhaSanXuat nhasanxuat = nhasanxuatservice.nhaSanXuat(idnhasanxuat);
		SanPham.setNhasanxuat(nhasanxuat);
		KhuyenMai khuyenMai = khuyemmaiservice.khuyenMai(khuyenmai);
		SanPham.setKhuyenmai(khuyenMai);
		DanhMucSanPham danhMucSanPham = danhmucservice.danhMucSanPham(danhmuc);
		SanPham.setDanhMucSanPham(danhMucSanPham);
		if (hinh != "") {
			SanPham.getHinh().setHINH(hinh);
		}
		if (gia != chiTietSanPham(id).getGia().getGIA()) {
			Gia gia1 = new Gia();
			gia1.setGIA(gia);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			gia1.setNGAYCAPNHAT(date);
			SanPham.setGia(gia1);
		}
		System.out.println("tao hinh ne"+hinh);
		session.save(SanPham);
		return true;

	}
}
