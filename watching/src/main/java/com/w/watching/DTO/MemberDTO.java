package com.w.watching.DTO;

import java.sql.Date;

public class MemberDTO {
	public String mid;
	public long mcode;
	public String mpw;
	public Date mmemsdate;
	public String mstate;
	public long mscode;
	
	public MemberDTO() {}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public long getMcode() {
		return mcode;
	}
	public void setMcode(long mcode) {
		this.mcode = mcode;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public Date getMmemsdate() {
		return mmemsdate;
	}
	public void setMmemsdate(Date mmemsdate) {
		this.mmemsdate = mmemsdate;
	}
	public String getMstate() {
		return mstate;
	}
	public void setMstate(String mstate) {
		this.mstate = mstate;
	}
	public long getMscode() {
		return mscode;
	}
	public void setMscode(long mscode) {
		this.mscode = mscode;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mcode=" + mcode + ", mpw=" + mpw + ", mmemsdate=" + mmemsdate + ", mstate="
				+ mstate + ", mscode=" + mscode + "]";
	}
		
}
