package member.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 입력
	public int memberWrite(MemberDTO memberDTO) {
		return sqlSession.insert("mybatis.loginMapper.memberWrite", memberDTO);
	}
	
	public int memberKakao(MemberDTO memberDTO) {
		return sqlSession.insert("mybatis.loginMapper.memberKakao", memberDTO);
	}
	
	// 로그인
	public MemberDTO login(String user_id, String user_pw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		return sqlSession.selectOne("mybatis.loginMapper.login", map);
		
	}
	
	public MemberDTO memberNickCheck(String nickname) {
		return sqlSession.selectOne("mybatis.loginMapper.memberNickCheck", nickname);
	}
	
	public MemberDTO userIdCheck(String user_id) {
		return sqlSession.selectOne("mybatis.loginMapper.userIdCheck", user_id);
	}
}