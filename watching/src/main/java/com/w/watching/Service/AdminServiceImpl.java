package com.w.watching.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.w.watching.DAO.AdminDAO;
import com.w.watching.DTO.AdminDTO;
import com.w.watching.VO.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	AdminDAO admindao;

	@Override
	public String adminlogin(MemberVO vo) {
		return admindao.adminlogin(vo);
	}

}
