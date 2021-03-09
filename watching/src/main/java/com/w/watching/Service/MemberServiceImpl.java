package com.w.watching.Service;

import javax.inject.Inject;

import com.w.watching.DAO.MemberDAO;
import com.w.watching.DTO.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO mdao;
	
	// 회원가입
	@Override
	public void insertMember(MemberDTO dto) throws Exception {
		mdao.insertMember(dto);
	}
	// 회원정보 수정
	@Override
	public void updateMember(MemberDTO dto) throws Exception {
		// 받은 dto를 DAO로 보내줍니다.
		mdao.updateMember(dto);
	}
	// 회원 탈퇴
	@Override
	public void deleteMember(MemberDTO dto) throws Exception {
		mdao.deleteMember(dto);		
	}
	
	//member
	// 로그인
	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		return mdao.login(dto);
	}
	// 패스워드 체크
	@Override
	public int passChk(MemberDTO dto) throws Exception {
		int result = mdao.passChk(dto);
		return result;
	}
	// 아이디 중복 체크
	@Override
	public int idChk(MemberDTO dto) throws Exception {
		int result = mdao.idChk(dto);
		return result;
	}




}
