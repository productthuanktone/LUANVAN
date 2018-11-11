package com.nguyenvanthuan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "chitiethoadon")
public class ChiTietHoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MACHITIETHOADON;
	int SOLUONG;
	float TONGGIA;
	int MACHITIETSANPHAM;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAHOADON")
	HoaDon hoadon;

	
	public int getMACHITIETHOADON() {
		return MACHITIETHOADON;
	}

	public void setMACHITIETHOADON(int mACHITIETHOADON) {
		MACHITIETHOADON = mACHITIETHOADON;
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


	public int getMACHITIETSANPHAM() {
		return MACHITIETSANPHAM;
	}

	public void setMACHITIETSANPHAM(int mACHITIETSANPHAM) {
		MACHITIETSANPHAM = mACHITIETSANPHAM;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

}
