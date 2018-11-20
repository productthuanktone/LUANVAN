package com.nguyenvanthuan.entity;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "taikhoan")
public class TaiKhoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MATAIKHOAN;
	String TENDANGNHAP;
	String MATKHAU;
	String MATKHAU2;
	int QUYEN;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANHANVIEN")
	NhanVien nhanvien;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAKHACHHANG")
	KhachHang khachhang;
	int ISDELETE;
	public int getMATAIKHOAN() {
		return MATAIKHOAN;
	}
	public void setMATAIKHOAN(int mATAIKHOAN) {
		MATAIKHOAN = mATAIKHOAN;
	}
	public String getTENDANGNHAP() {
		return TENDANGNHAP;
	}
	public void setTENDANGNHAP(String tENDANGNHAP) {
		TENDANGNHAP = tENDANGNHAP;
	}
	public String getMATKHAU() {
		return MATKHAU;
	}
	public void setMATKHAU(String mATKHAU) {
		MATKHAU = mATKHAU;
	}
	public String getMATKHAU2() {
		return MATKHAU2;
	}
	public void setMATKHAU2(String mATKHAU2) {
		MATKHAU2 = mATKHAU2;
	}

	public int getQUYEN() {
		return QUYEN;
	}
	public void setQUYEN(int qUYEN) {
		QUYEN = qUYEN;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public int getISDELETE() {
		return ISDELETE;
	}
	public void setISDELETE(int iSDELETE) {
		ISDELETE = iSDELETE;
	}

}