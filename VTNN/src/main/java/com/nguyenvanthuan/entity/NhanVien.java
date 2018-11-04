package com.nguyenvanthuan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="nhanvien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MANHANVIEN;
	String HOTEN;
	Boolean GIOITINH;
	String DIACHI;
	String EMAIL;
	int SODIENTHOAI;
	int ISDELETE;
	int DELETEID;
	Date TIMEDELETE;
	int CREATEID;
	Date TIMECREATE;
	int UPDATEID;
	Date TIMEUPDATE;
	public int getMANHANVIEN() {
		return MANHANVIEN;
	}
	public void setMANHANVIEN(int mANHANVIEN) {
		MANHANVIEN = mANHANVIEN;
	}
	public String getHOTEN() {
		return HOTEN;
	}
	public void setHOTEN(String hOTEN) {
		HOTEN = hOTEN;
	}
	public Boolean getGIOITINH() {
		return GIOITINH;
	}
	public void setGIOITINH(Boolean gIOITINH) {
		GIOITINH = gIOITINH;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public int getSODIENTHOAI() {
		return SODIENTHOAI;
	}
	public void setSODIENTHOAI(int sODIENTHOAI) {
		SODIENTHOAI = sODIENTHOAI;
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
