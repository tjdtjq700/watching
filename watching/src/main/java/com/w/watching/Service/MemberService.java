package com.w.watching.Service;

import com.w.watching.DTO.MemberDTO;

public interface MemberService {
	// 회원 가입 (일반회원가입테이블에 sns계정 컬럼 추가하기)
	// 일반적으로는 DAO랑 같은 메소드명을 사용하여 일관성을 유지한다
	public void insertMember(MemberDTO dto) throws Exception;
	// 회원 정보 수정
	public void updateMember(MemberDTO dto) throws Exception;
	// 회원 탈퇴
	public void deleteMember(MemberDTO dto) throws Exception;
	
	// member
	// 로그인
	public MemberDTO login(MemberDTO dto) throws Exception;
	// 패스워드 체크
	public int passChk(MemberDTO dto) throws Exception;
	// 아이디 중복 체크
	public int idChk(MemberDTO dto) throws Exception;
}
