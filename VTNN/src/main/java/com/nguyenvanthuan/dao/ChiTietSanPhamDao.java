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
import com.nguyenvanthuan.entity.DonViTinh;
import com.nguyenvanthuan.entity.Gia;
import com.nguyenvanthuan.entity.Hinh;
import com.nguyenvanthuan.entity.KhuyenMai;
import com.nguyenvanthuan.entity.NhaSanXuat;
import com.nguyenvanthuan.entity.SanPham;
import com.nguyenvanthuan.service.DanhMucSanPhamService;
import com.nguyenvanthuan.service.DonViTinhService;
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
	@Autowired
	DonViTinhService donvitinhservice;

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
			int idnhasanxuat, int khuyenmai, int danhmuc, String hinh, int dovitinh) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietSanPham chitietsanpham = (ChiTietSanPham) session
				.createQuery("from chitietsanpham where MACHITIETSANPHAM=" + id + "").getSingleResult();
		chitietsanpham.getSanpham().setTENSANPHAM(tensanpham);
		chitietsanpham.setSOLUONG(soluong);
		chitietsanpham.getSanpham().setMOTA(mota);
		NhaSanXuat nhasanxuat = nhasanxuatservice.nhaSanXuat(idnhasanxuat);
		chitietsanpham.setNhasanxuat(nhasanxuat);
		KhuyenMai khuyenMai = khuyemmaiservice.khuyenMai(khuyenmai);
		chitietsanpham.setKhuyenmai(khuyenMai);
		DanhMucSanPham danhMucSanPham = danhmucservice.danhMucSanPham(danhmuc);
		chitietsanpham.setDanhMucSanPham(danhMucSanPham);
		DonViTinh donViTinh=donvitinhservice.donViTinhid(dovitinh);
		chitietsanpham.setDonvitinh(donViTinh);
		if (hinh != null) {
			chitietsanpham.getHinh().setHINH(hinh);
		}
		if (gia != chitietsanpham.getGia().getGIA()) {
			Gia gia1 = new Gia();
			gia1.setGIA(gia);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			gia1.setNGAYCAPNHAT(date);
			chitietsanpham.setGia(gia1);
		}
		session.save(chitietsanpham);
		return true;

	}

	@Override
	@Transactional
	public boolean updatesoluongsanpham(int id, int soluongmoi) {
		Session session = sessionFactory.getCurrentSession();
		try {
			ChiTietSanPham chiTietSanPham = (ChiTietSanPham) session
					.createQuery("from chitietsanpham where MACHITIETSANPHAM=" + id).getSingleResult();
			chiTietSanPham.setSOLUONG(soluongmoi);
			session.save(chiTietSanPham);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	@Transactional
	public boolean savechitietsanpham(String tensp, int nhasanxuat, int soluong, int khuyenmai, float gia, int danhmuc,
			String mota, String hinh, int donvitinh) {
		Session session = sessionFactory.getCurrentSession();
		try {
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			chiTietSanPham.setSOLUONG(soluong);
			chiTietSanPham.setISDELETE(0);
			SanPham sanPham = new SanPham();
			sanPham.setTENSANPHAM(tensp);
			sanPham.setMOTA(mota);
			sanPham.setISDELETE(0);
			sanPham.setCREATEID(0);
			sanPham.setDELETEID(0);
			sanPham.setUPDATEID(0);
			chiTietSanPham.setSanpham(sanPham);
			// DonViTinh donViTinh=donvitinhservice.donViTinhid(donvitinh);
			// chiTietSanPham.setDonvitinh(donViTinh);
			 NhaSanXuat nhasanxuat1 = nhasanxuatservice.nhaSanXuat(nhasanxuat);
			 chiTietSanPham.setNhasanxuat(nhasanxuat1);
			 KhuyenMai khuyenMai = khuyemmaiservice.khuyenMai(khuyenmai);
			 chiTietSanPham.setKhuyenmai(khuyenMai);
			 DanhMucSanPham danhMucSanPham = danhmucservice.danhMucSanPham(danhmuc);
			 chiTietSanPham.setDanhMucSanPham(danhMucSanPham);
			 Hinh hinhs=new Hinh();
			 hinhs.setHINH(hinh);
			 hinhs.setLOAIHINH(1);
			 chiTietSanPham.setHinh(hinhs);
			 Gia gia2=new Gia();
			 gia2.setGIA(gia);
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 Date date = new Date();
			 gia2.setNGAYCAPNHAT(date);
			session.save(chiTietSanPham);
			chiTietSanPham.setGia(gia2);
			System.out.println("them thanh cong");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("them that bai");
			return false;
		}

	}
}
