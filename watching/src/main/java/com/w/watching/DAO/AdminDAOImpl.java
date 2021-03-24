package com.w.watching.DAO;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.w.watching.VO.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public String adminlogin(MemberVO vo) {
		return sqlSession.selectOne("admin.login_check",vo);
	}

}
