package com.nguyenvanthuan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="nhasanxuat")
public class NhaSanXuat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MANHASANXUAT;
	String TENNHASANXUAT;
	String DIACHI;
	int SODIENTHOAI;
	String EMAIL;
	int ISDELETE;
	int DELETEID;
	Date TIMEDELETE;
	int CREATEID;
	Date TIMECREATE;
	int UPDATEID;
	Date TIMEUPDATE;
	public int getMANHASANXUAT() {
		return MANHASANXUAT;
	}
	public void setMANHASANXUAT(int mANHASANXUAT) {
		MANHASANXUAT = mANHASANXUAT;
	}
	public String getTENNHASANXUAT() {
		return TENNHASANXUAT;
	}
	public void setTENNHASANXUAT(String tENNHASANXUAT) {
		TENNHASANXUAT = tENNHASANXUAT;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	public int getSODIENTHOAI() {
		return SODIENTHOAI;
	}
	public void setSODIENTHOAI(int sODIENTHOAI) {
		SODIENTHOAI = sODIENTHOAI;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
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
