package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public int memberKakao(MemberDTO memberDTO) {
		return memberDAO.memberKakao(memberDTO);
	}
	
	@Override
	public int memberWrite(MemberDTO memberDTO) {
		return memberDAO.memberWrite(memberDTO);
	}

	@Override
	public MemberDTO login(String user_id, String user_pw) {
		return memberDAO.login(user_id, user_pw);
	}
	
	@Override
	public MemberDTO memberNickCheck(String nickname) {
		return memberDAO.memberNickCheck(nickname);
		
	}
	
	@Override
	public MemberDTO userIdCheck(String user_id) {
		return memberDAO.userIdCheck(user_id);
	}
}