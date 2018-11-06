package com.nguyenvanthuan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "chitietsanpham")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MACHITIETSANPHAM;
	int SOLUONG;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MASANPHAM")
	SanPham sanpham;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAGIA")
	Gia gia;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAHINH")
	Hinh hinh;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANHASANXUAT")
	NhaSanXuat nhasanxuat;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MADONVITINH")
	DonViTinh donvitinh;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAKHUYENMAI")
	KhuyenMai khuyenmai;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MADANHMUC")
	DanhMucSanPham danhMucSanPham;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MACHITIETSANPHAM")
	Set<ChiTietHoaDon> chitiethoadon;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MACHITIETSANPHAM")
	Set<ChiTietPhieuNhap> chitietphieunhap;

	public Hinh getHinh() {
		return hinh;
	}

	public void setHinh(Hinh hinh) {
		this.hinh = hinh;
	}

	public Set<ChiTietPhieuNhap> getChitietphieunhap() {
		return chitietphieunhap;
	}

	public void setChitietphieunhap(Set<ChiTietPhieuNhap> chitietphieunhap) {
		this.chitietphieunhap = chitietphieunhap;
	}

	public KhuyenMai getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(KhuyenMai khuyenmai) {
		this.khuyenmai = khuyenmai;
	}

	public Set<ChiTietHoaDon> getChitiethoadon() {
		return chitiethoadon;
	}

	public void setChitiethoadon(Set<ChiTietHoaDon> chitiethoadon) {
		this.chitiethoadon = chitiethoadon;
	}

	public int getMACHITIETSANPHAM() {
		return MACHITIETSANPHAM;
	}

	public void setMACHITIETSANPHAM(int mACHITIETSANPHAM) {
		MACHITIETSANPHAM = mACHITIETSANPHAM;
	}

	public int getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(int sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public Gia getGia() {
		return gia;
	}

	public void setGia(Gia gia) {
		this.gia = gia;
	}


	public NhaSanXuat getNhasanxuat() {
		return nhasanxuat;
	}

	public void setNhasanxuat(NhaSanXuat nhasanxuat) {
		this.nhasanxuat = nhasanxuat;
	}

	public DonViTinh getDonvitinh() {
		return donvitinh;
	}

	public void setDonvitinh(DonViTinh donvitinh) {
		this.donvitinh = donvitinh;
	}

	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}

	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}

}
