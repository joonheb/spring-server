package member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/member_kakao.do")
	public ModelAndView memberKakao(HttpServletRequest request) {
		//한글 인코딩 설정
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 데이터
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");

		// DB
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setNickname(nickname);
		memberDTO.setEmail(email);

		System.out.println(nickname);
		System.out.println(email);

		int su = memberService.memberKakao(memberDTO);
		// JSON으로 결과값 반환
		String rt = null;
		
		if(su > 0) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		// JSON
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		
		// 검색 결과를 서블릿으로 리턴
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("member_write.jsp");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/member/member_write.do")
	public ModelAndView memberWrite(HttpServletRequest request) {
		//한글 인코딩 설정
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 데이터
		String user_id = request.getParameter("user_id");
		String nickname = request.getParameter("nickname");
		String user_pw = request.getParameter("user_pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id(user_id);
		memberDTO.setUser_pw(user_pw);
		memberDTO.setName(name);
		memberDTO.setNickname(nickname);
		memberDTO.setEmail(email);

		System.out.println(user_id);
		System.out.println(nickname);
		System.out.println(user_pw);
		System.out.println(name);
		System.out.println(email);
		
		MemberDAO memberDAO = new MemberDAO();
		int su = memberService.memberWrite(memberDTO);
		// JSON으로 결과값 반환
		String rt = null;
		
		if(su > 0) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
	
		// JSON
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		
		// 검색 결과를 서블릿으로 리턴
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("member_write.jsp");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/member/member_login.do")
	public ModelAndView memberLogin(HttpServletRequest request) {
		//한글 인코딩 설정
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 데이터
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// DB
		MemberDTO memberDTO = memberService.login(user_id, user_pw);
		// JSON으로 결과값 반환
		String rt = null;
		
		if(memberDTO != null) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		// JSON
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		JSONObject member = new JSONObject();
		member.put("projectId", memberDTO.getUser_id());
		member.put("name", memberDTO.getName());
		member.put("nickname", memberDTO.getNickname());
		member.put("email", memberDTO.getEmail());
		member.put("token", memberDTO.getToken());
		json.put("member", member);
		// 검색 결과를 서블릿으로 리턴
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("member_login.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/member_nickCheck.do")
	public ModelAndView memberNickCheck(HttpServletRequest request) {
		//한글 인코딩 설정
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 데이터
		String nickname = request.getParameter("nickname");
		
		// DB
		MemberDTO memberDTO = memberService.memberNickCheck(nickname);
		// JSON으로 결과값 반환
		String rt = null;
		
		if(memberDTO != null) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		// JSON
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		// 검색 결과를 서블릿으로 리턴
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("member_nickCheck.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/member/member_userIdCheck.do")
	public ModelAndView userIdCheck(HttpServletRequest request) {
		//한글 인코딩 설정
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 데이터
		String user_id = request.getParameter("user_id");
		
		// DB
		MemberDTO memberDTO = memberService.userIdCheck(user_id);
		// JSON으로 결과값 반환
		String rt = null;
		
		if(memberDTO != null) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		// JSON
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		// 검색 결과를 서블릿으로 리턴
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("member_userIdCheck.jsp");
		return modelAndView;
	}
	
	
}