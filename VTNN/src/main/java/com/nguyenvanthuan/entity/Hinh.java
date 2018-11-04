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

@Entity(name = "hinh")
public class Hinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MAHINH;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAHINH")
	Set<ChiTietSanPham> chiTietSanPhams;
	int MAKHUYENMAI;
	int MADANHMUC;
	String HINH;
	int ISDELETE;
	int DELETEID;
	Date TIMEDELETE;
	int CREATEID;
	Date TIMECREATE;
	int UPDATEID;
	Date TIMEUPDATE;

	public int getMAHINH() {
		return MAHINH;
	}

	public void setMAHINH(int mAHINH) {
		MAHINH = mAHINH;
	}

	public Set<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(Set<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public int getMAKHUYENMAI() {
		return MAKHUYENMAI;
	}

	public void setMAKHUYENMAI(int mAKHUYENMAI) {
		MAKHUYENMAI = mAKHUYENMAI;
	}

	public int getMADANHMUC() {
		return MADANHMUC;
	}

	public void setMADANHMUC(int mADANHMUC) {
		MADANHMUC = mADANHMUC;
	}

	public String getHINH() {
		return HINH;
	}

	public void setHINH(String hINH) {
		HINH = hINH;
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
