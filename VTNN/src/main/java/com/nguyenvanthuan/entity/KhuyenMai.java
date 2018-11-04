package com.nguyenvanthuan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "khuyenmai")
public class KhuyenMai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MAKHUYENMAI;
	String TENKHUYENMAI;
	Date THOIGIANBATDAU;
	Date THOIGIANKETTHUC;
	int PHANTRAM;
	String MOTA;
	int ISDELETE;
	int DELETEID;
	Date TIMEDELETE;
	int CREATEID;
	Date TIMECREATE;
	int UPDATEID;
	Date TIMEUPDATE;

	

	public int getPHANTRAM() {
		return PHANTRAM;
	}

	public void setPHANTRAM(int pHANTRAM) {
		PHANTRAM = pHANTRAM;
	}

	public int getMAKHUYENMAI() {
		return MAKHUYENMAI;
	}

	public void setMAKHUYENMAI(int mAKHUYENMAI) {
		MAKHUYENMAI = mAKHUYENMAI;
	}

	public String getTENKHUYENMAI() {
		return TENKHUYENMAI;
	}

	public void setTENKHUYENMAI(String tENKHUYENMAI) {
		TENKHUYENMAI = tENKHUYENMAI;
	}

	public Date getTHOIGIANBATDAU() {
		return THOIGIANBATDAU;
	}

	public void setTHOIGIANBATDAU(Date tHOIGIANBATDAU) {
		THOIGIANBATDAU = tHOIGIANBATDAU;
	}

	public Date getTHOIGIANKETTHUC() {
		return THOIGIANKETTHUC;
	}

	public void setTHOIGIANKETTHUC(Date tHOIGIANKETTHUC) {
		THOIGIANKETTHUC = tHOIGIANKETTHUC;
	}

	public String getMOTA() {
		return MOTA;
	}

	public void setMOTA(String mOTA) {
		MOTA = mOTA;
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
