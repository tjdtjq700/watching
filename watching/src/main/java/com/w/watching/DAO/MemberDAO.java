package com.w.watching.DAO;

import com.w.watching.DTO.MemberDTO;

public interface MemberDAO {
	
//	public String getTime();
//	
	// 회원가입
	public void insertMember(MemberDTO dto) throws Exception;	
	// 회원 정보 수정
	public void updateMember(MemberDTO dto) throws Exception;
	// 회원 탈퇴
	public void deleteMember(MemberDTO dto) throws Exception;
	
	
	// 로그인
	public MemberDTO login(MemberDTO dto) throws Exception;
	// 패스워드 체크
	public int passChk(MemberDTO dto) throws Exception;
	// 아이디 중복 체크
	public int idChk(MemberDTO dto) throws Exception;
}
