package com.w.watching.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.w.watching.DTO.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sql;

	// 회원가입
	@Override
	public void insertMember(MemberDTO dto) throws Exception {
		sql.insert("MemberMapper.insertMember", dto);
	}
	// 회원정보 수정
	@Override
	public void updateMember(MemberDTO dto) throws Exception {
		sql.update("MemberMapper.updateMember",dto);
	}
	// 회원 탈퇴
	@Override
	public void deleteMember(MemberDTO dto) throws Exception {
		sql.delete("MemberMapper.deleteMember",dto);
	}
	
	
	// 로그인
	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		return sql.selectOne("MemberMapper.login", dto);
	}
	// 패스워드 체크
	@Override
	public int passChk(MemberDTO dto) throws Exception {
		int result = sql.selectOne("MemberMapper.passChk",dto);
		return result;
	}
	// 아이디 중복 체크
	@Override
	public int idChk(MemberDTO dto) throws Exception {
		int result = sql.selectOne("MemberMapper.idChk",dto);
		return result;
	}

}
