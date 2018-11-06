package com.nguyenvanthuan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "hinh")
public class Hinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int MAHINH;
	String HINH;
	int LOAIHINH;
	public int getMAHINH() {
		return MAHINH;
	}
	public void setMAHINH(int mAHINH) {
		MAHINH = mAHINH;
	}
	public String getHINH() {
		return HINH;
	}
	public void setHINH(String hINH) {
		HINH = hINH;
	}
	public int getLOAIHINH() {
		return LOAIHINH;
	}
	public void setLOAIHINH(int lOAIHINH) {
		LOAIHINH = lOAIHINH;
	}
	
}