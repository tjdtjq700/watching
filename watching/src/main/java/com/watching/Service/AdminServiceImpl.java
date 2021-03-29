package com.watching.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.watching.DAO.AdminDAO;
import com.watching.DTO.AdminDTO;
import com.watching.DTO.MemberDTO;

public class AdminServiceImpl implements adminService {

	@Inject    //dao를 호출하기때문에 의존성을 주입한다.
    AdminDAO admindao;
	
	@Override
	public boolean loginCheck(AdminDTO dto, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void admin_member_forced_evictionCheck(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
