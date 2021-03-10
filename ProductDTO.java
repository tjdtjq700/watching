package com.watching.dto;

import java.sql.Timestamp;

public class ProductDTO {
	
	private int pCode;
	private int kCode;
	private int tCode;
	private String pName;
	private int pUphit;
	private String aId;
	private String dName;
	private String dType;
	private Timestamp dUploadDate;
	
	public ProductDTO() {}

	public ProductDTO(int pCode, int kCode, int tCode, String pName, int pUphit, String aId, String dName, String dType,
			Timestamp dUploadDate) {
		super();
		this.pCode = pCode;
		this.kCode = kCode;
		this.tCode = tCode;
		this.pName = pName;
		this.pUphit = pUphit;
		this.aId = aId;
		this.dName = dName;
		this.dType = dType;
		this.dUploadDate = dUploadDate;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public int getkCode() {
		return kCode;
	}

	public void setkCode(int kCode) {
		this.kCode = kCode;
	}

	public int gettCode() {
		return tCode;
	}

	public void settCode(int tCode) {
		this.tCode = tCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpUphit() {
		return pUphit;
	}

	public void setpUphit(int pUphit) {
		this.pUphit = pUphit;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public Timestamp getdUploadDate() {
		return dUploadDate;
	}

	public void setdUploadDate(Timestamp dUploadDate) {
		this.dUploadDate = dUploadDate;
	}

	@Override
	public String toString() {
		return "ProductDTO [pCode=" + pCode + ", kCode=" + kCode + ", tCode=" + tCode + ", pName=" + pName + ", pUphit="
				+ pUphit + ", aId=" + aId + ", dName=" + dName + ", dType=" + dType + ", dUploadDate=" + dUploadDate
				+ "]";
	}

	
}