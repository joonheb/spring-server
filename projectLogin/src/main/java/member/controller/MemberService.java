package member.controller;

import member.dto.MemberDTO;

public interface MemberService {
	// CRUD 기능의 메소드
	public int memberWrite(MemberDTO memberDTO);
	public MemberDTO login(String user_id, String user_pw);
	public int memberKakao(MemberDTO memberDTO);
	public MemberDTO memberNickCheck(String nickname);
	public MemberDTO userIdCheck(String user_id);
}