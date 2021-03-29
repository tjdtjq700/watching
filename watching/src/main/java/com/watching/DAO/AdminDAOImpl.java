package com.watching.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.watching.DTO.AdminDTO;
import com.watching.DTO.MemberDTO;

public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(AdminDTO dto) throws Exception {
		String aname = sqlSession.selectOne("admin.login_check", dto);

		// 조건식 ? true일때의 값 : false일때의 값
		return (aname == null) ? false : true;
	}

	@Override
	public void admin_member_forced_evictionCheck(MemberDTO dto) throws Exception {
		sqlSession.delete("admin.admin_member_forced_evictionCheck", dto);
	}

}
