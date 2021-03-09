
package com.w.watching.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.w.watching.DTO.MemberDTO;
import com.w.watching.Service.MemberService;

@Controller
@RequestMapping("/watching/*")
public class MemberController {
	
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	// 회원 관련 컨트롤
	// 회원가입 GET
	@RequestMapping(value="/insertMember",method=RequestMethod.GET)
	public void getinsertMember( ) throws Exception {
		logger.info("get insertMember");
	}
	// 회원가입 POST
	@RequestMapping(value="/insertMember",method=RequestMethod.POST)
	public String postinsertMember(MemberDTO dto) throws Exception {
		logger.info("post insertMember");
		int result = service.idChk(dto);
		try {
			if(result == 1) {
				return "/member/insertMember";
			}else if(result == 0) {
				service.insertMember(dto);
			}
			// 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기
		}catch(Exception e) {
			throw new RuntimeException();
		}	
		return "insertMember:/";	
	}
	
	// 회원정보 수정 -GET과 POST
	@RequestMapping(value="/updateMemberView",method=RequestMethod.GET)
	public String insertUpdateView() {
		return "member/updateMemberView";
		
	}
	@RequestMapping(value="/updateMemberView",method=RequestMethod.POST)
	public String insertUpdate(MemberDTO dto,HttpSession session) throws Exception {
		
		service.updateMember(dto);
		
		session.invalidate();
		
		return "insertMember:/";
		
	}
	
	// 회원탈퇴 -GET과 POST
	@RequestMapping(value="/deleteMemberView",method=RequestMethod.GET)
	public String deleteMemberView() throws Exception{
		return "member/deleteMemberView";
	}
	@RequestMapping(value="/deleteMember",method=RequestMethod.POST)
	public String deleteMember(MemberDTO dto,HttpSession session,RedirectAttributes rttr) throws Exception {
		
		// 세션에 있는 member를 가져와 member변수에 넣기
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		String sessionPW = member.getMpw();
		
		String dtoPW = dto.getMpw();
		
		if(!(sessionPW.equals(dtoPW))) {
			rttr.addFlashAttribute("msg",false);
			return "insertMember:/member/deleteMemberView";
		}
		service.deleteMember(dto);
		session.invalidate();
		return null;
	}
	
	
	
	// 로그인 관련 컨트롤
	// 로그인
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String login(MemberDTO dto,HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");
		
		HttpSession session = req.getSession();
		MemberDTO login = service.login(dto);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg",false);
		}else {
			session.setAttribute("member", login);
		}		
		return "insertMember:/";
	}
	
	// 로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "insertMember:/";
	}
	
	// 패스워드 체크
	@ResponseBody
	@RequestMapping(value="/passChk",method = RequestMethod.POST)
	public int passChk(MemberDTO dto ) throws Exception {
		
		int result = service.passChk(dto);
		
		return result;
	}
	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/idChk",method = RequestMethod.POST)
	public int idChk(MemberDTO dto) throws Exception {
		
		int result = service.idChk(dto);
		
		return result;
	}
}
