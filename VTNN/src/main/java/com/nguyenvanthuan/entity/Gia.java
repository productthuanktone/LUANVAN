package com.nguyenvanthuan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="gia")
public class Gia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MAGIA;
	Float GIA;
	Date NGAYCAPNHAT;
	public int getMAGIA() {
		return MAGIA;
	}
	public void setMAGIA(int mAGIA) {
		MAGIA = mAGIA;
	}
	public Float getGIA() {
		return GIA;
	}
	public void setGIA(Float gIA) {
		GIA = gIA;
	}
	public Date getNGAYCAPNHAT() {
		return NGAYCAPNHAT;
	}
	public void setNGAYCAPNHAT(Date nGAYCAPNHAT) {
		NGAYCAPNHAT = nGAYCAPNHAT;
	}
	
	
}
