package com.nguyenvanthuan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "chitietphieunhap")
public class ChiTietPhieuNhap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MACHITIETPHIEUNHAP;
	int SOLUONG;
	float TONGGIA;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MACHITIETSANPHAM")
	ChiTietSanPham chitietsanpham;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAPHIEUNHAP")
	PhieuNhap phieunhap;

	public int getMACHITIETPHIEUNHAP() {
		return MACHITIETPHIEUNHAP;
	}

	public void setMACHITIETPHIEUNHAP(int mACHITIETPHIEUNHAP) {
		MACHITIETPHIEUNHAP = mACHITIETPHIEUNHAP;
	}

	public int getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(int sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public float getTONGGIA() {
		return TONGGIA;
	}

	public void setTONGGIA(float tONGGIA) {
		TONGGIA = tONGGIA;
	}

	public ChiTietSanPham getChitietsanpham() {
		return chitietsanpham;
	}

	public void setChitietsanpham(ChiTietSanPham chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}

	public PhieuNhap getPhieunhap() {
		return phieunhap;
	}

	public void setPhieunhap(PhieuNhap phieunhap) {
		this.phieunhap = phieunhap;
	}
	
}
