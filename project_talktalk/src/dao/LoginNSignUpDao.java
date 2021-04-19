package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;
import com.vo.MemberVO;

public class LoginNSignUpDao {
	MemberVO mVO = null;
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	
	public List<Map<String,Object>> getLogin(List<Map<String,Object>> M_login) {
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		Map<String, Object> loginMap = new HashMap<>();
		loginMap.put("p_no", 0);
		loginMap.put("p_pw", "");
		try {
			sqlSession = sqlSessionFactory.openSession();
			M_login = sqlSession.selectList("mybatis.ProcMapper.chat_login", loginMap);
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(, arg1, arg2, arg3);
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return M_login;
	}
	
	public List<Map<String,Object>> getSiguUp(List<Map<String,Object>> M_signUp) {
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		Map<String, Object> signUpMap = new HashMap<>();
		signUpMap.put("","");
		signUpMap.put("","");
//		signUpMap = sqlSession.
		return M_signUp;
	}
}
