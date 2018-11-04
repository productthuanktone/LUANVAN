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

@Entity(name = "donvitinh")
public class DonViTinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MADONVITINH;
	String TENDONVITINH;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MADONVITINH")
	Set<DonViTinh> donvitinh;
	int ISDELETE;
	int DELETEID;
	Date TIMEDELETE;
	int CREATEID;
	Date TIMECREATE;
	int UPDATEID;
	Date TIMEUPDATE;

	public int getMADONVITINH() {
		return MADONVITINH;
	}

	public void setMADONVITINH(int mADONVITINH) {
		MADONVITINH = mADONVITINH;
	}

	public String getTENDONVITINH() {
		return TENDONVITINH;
	}

	public void setTENDONVITINH(String tENDONVITINH) {
		TENDONVITINH = tENDONVITINH;
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

	public Set<DonViTinh> getDonvitinh() {
		return donvitinh;
	}

	public void setDonvitinh(Set<DonViTinh> donvitinh) {
		this.donvitinh = donvitinh;
	}

}
