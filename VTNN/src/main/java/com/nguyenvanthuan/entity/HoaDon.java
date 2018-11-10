package com.nguyenvanthuan.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "hoadon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MAHOADON;
	int TINHTRANG;
	int HINHTHUCGIAOHANG;
	String MOTA;
	String DIACHIGIAOHANG;
	float TONGGIA;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANHANVIEN")
	NhanVien nhanvien;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAKHACHHANG")
	KhachHang khachhang;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAHOADON")
	Set<ChiTietHoaDon> chitiethoadon;
	int ISDELETE;
	int DELETEID;
	Date TIMEDELETE;
	int CREATEID;
	Date TIMECREATE;
	int UPDATEID;
	Date TIMEUPDATE;

	public float getTONGGIA() {
		return TONGGIA;
	}

	public void setTONGGIA(float tONGGIA) {
		TONGGIA = tONGGIA;
	}

	public String getDIACHIGIAOHANG() {
		return DIACHIGIAOHANG;
	}

	public void setDIACHIGIAOHANG(String dIACHIGIAOHANG) {
		DIACHIGIAOHANG = dIACHIGIAOHANG;
	}

	public int getHINHTHUCGIAOHANG() {
		return HINHTHUCGIAOHANG;
	}

	public void setHINHTHUCGIAOHANG(int hINHTHUCGIAOHANG) {
		HINHTHUCGIAOHANG = hINHTHUCGIAOHANG;
	}

	public String getMOTA() {
		return MOTA;
	}

	public void setMOTA(String mOTA) {
		MOTA = mOTA;
	}

	public Set<ChiTietHoaDon> getChitiethoadon() {
		return chitiethoadon;
	}

	public void setChitiethoadon(Set<ChiTietHoaDon> chitiethoadon) {
		this.chitiethoadon = chitiethoadon;
	}

	public int getMAHOADON() {
		return MAHOADON;
	}

	public void setMAHOADON(int mAHOADON) {
		MAHOADON = mAHOADON;
	}

	public int getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTINHTRANG(int tINHTRANG) {
		TINHTRANG = tINHTRANG;
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

	public int getDELETEID() {
		return DELETEID;
	}

	public void setDELETEID(int dELETEID) {
		DELETEID = dELETEID;
	}

	public Date getTIMEDELETE() {
		return TIMEDELETE;
	}

	public void setTIMEDELETE(Date tIMEDELETE) {
		TIMEDELETE = tIMEDELETE;
	}

	public int getCREATEID() {
		return CREATEID;
	}

	public void setCREATEID(int cREATEID) {
		CREATEID = cREATEID;
	}

	public Date getTIMECREATE() {
		return TIMECREATE;
	}

	public void setTIMECREATE(Date tIMECREATE) {
		TIMECREATE = tIMECREATE;
	}

	public int getUPDATEID() {
		return UPDATEID;
	}

	public void setUPDATEID(int uPDATEID) {
		UPDATEID = uPDATEID;
	}

	public Date getTIMEUPDATE() {
		return TIMEUPDATE;
	}

	public void setTIMEUPDATE(Date tIMEUPDATE) {
		TIMEUPDATE = tIMEUPDATE;
	}

}
