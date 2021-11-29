package com.watching.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.watching.dao.AdminDAO;
import com.watching.dto.AdminDTO;
import com.watching.dto.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject    //dao를 호출하기때문에 의존성을 주입한다.
    AdminDAO adao;

	@Override
	public boolean loginCheck(AdminDTO adto, HttpSession session) throws Exception {
		
		boolean result = adao.loginCheck(adto);
		
		if(result) {
			session.setAttribute("aId", adto.getaId());
			session.setAttribute("aPw", adto.getaPw());
		}
		
		return result;
	}

	@Override
	public void admin_member_forced_evictionCheck(MemberDTO mdto) throws Exception {
		
		//adao.admin_member_forced_evictionCheck(mdto);
	}

}
