package com.finalPj.testpj.dto;

import java.sql.Date;

public class ProductDTO {
	private int pCode;
	private String kCode;
	private String tCode;
	private String pName;
	private String aId;
	private int pUphit;
	private String pContent;
	
	//product와 data 테이블 합침
	private String pImg;
<<<<<<< HEAD
	private Date pUploadDate;
	
	public ProductDTO() {}

	public ProductDTO(int pCode, String kCode, String tCode, String pName, String aId, int pUphit, String pContent,
			String pImg, Date pUploadDate) {
=======
	private Timestamp pUploadDate;
	
	public ProductDTO() {}

	public ProductDTO(int pCode, String kCode, String tCode, String pName, String aId, int pUphit, String pImg,
			Timestamp pUploadDate) {
>>>>>>> d5a29378ce99780a825098239b6633788a12b478
		super();
		this.pCode = pCode;
		this.kCode = kCode;
		this.tCode = tCode;
		this.pName = pName;
		this.aId = aId;
		this.pUphit = pUphit;
<<<<<<< HEAD
		this.pContent = pContent;
=======
>>>>>>> d5a29378ce99780a825098239b6633788a12b478
		this.pImg = pImg;
		this.pUploadDate = pUploadDate;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getkCode() {
		return kCode;
	}

	public void setkCode(String kCode) {
		this.kCode = kCode;
	}

	public String gettCode() {
		return tCode;
	}

	public void settCode(String tCode) {
		this.tCode = tCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public int getpUphit() {
		return pUphit;
	}

	public void setpUphit(int pUphit) {
		this.pUphit = pUphit;
	}

<<<<<<< HEAD
	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

=======
>>>>>>> d5a29378ce99780a825098239b6633788a12b478
	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

<<<<<<< HEAD
	public Date getpUploadDate() {
		return pUploadDate;
	}

	public void setpUploadDate(Date pUploadDate) {
=======
	public Timestamp getpUploadDate() {
		return pUploadDate;
	}

	public void setpUploadDate(Timestamp pUploadDate) {
>>>>>>> d5a29378ce99780a825098239b6633788a12b478
		this.pUploadDate = pUploadDate;
	}

	@Override
	public String toString() {
		return "ProductDTO [pCode=" + pCode + ", kCode=" + kCode + ", tCode=" + tCode + ", pName=" + pName + ", aId="
<<<<<<< HEAD
				+ aId + ", pUphit=" + pUphit + ", pContent=" + pContent + ", pImg=" + pImg + ", pUploadDate="
				+ pUploadDate + "]";
	}

	
=======
				+ aId + ", pUphit=" + pUphit + ", pImg=" + pImg + ", pUploadDate=" + pUploadDate + "]";
	}
>>>>>>> d5a29378ce99780a825098239b6633788a12b478

}