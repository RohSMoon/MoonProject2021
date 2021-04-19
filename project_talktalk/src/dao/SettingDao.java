package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;
import com.vo.MemberVO;

/*************************************************************************
 * @author frien
 * 설정창에 관련된 DAO입니다.
 *************************************************************************/
public class SettingDao {
	/* 선언부 */
	//설정목록창에 관련된 VO 불러오기
	DeptVO dVO = new DeptVO();
	MemberVO mVO = new MemberVO();
	//SqlSessionFactory를 통하여 MyBatis와 연결할 예정
	SqlSessionFactory sqlSessionFactory = null;
	//sqlSession을 통하여 쿼리문을 받아올 예정
	SqlSession sqlSession = null;

	/* 5-1. 내 정보 불러오기 */
	public List<Map<String,Object>> get_MyInfo(Map<String,Object> myInFo){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//myChatList라는 변수명 선언해주기
		List<Map<String, Object>> My_Info = null;
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#28번에서 선언한 변수(My_Info)에 com.util.sqlproc.xml파일의 5-1.내 정보 불러오기 프로시저를 실행.(myInfo의 Value로 꺼내옴)
			My_Info = sqlSession.selectList("mybatis.ProcMapper.myInfo", myInFo);
		//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
		// 자원 반납하기
		} finally {
			sqlSession.close();
		}
		return My_Info;
	}///////////////////////////////////// [[[ 5-1. 내 정보 불러오기 종료 ]]] /////////////////////////////////////
	
	/* 5-2. 사용자 상태 수정하기 */
	public List<Map<String, Object>> Update_myState(Map<String,Object> Mystate_update){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//myChatList라는 변수명 선언해주기
		List<Map<String, Object>> update_MyState = null;
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#49번에서 선언한 변수(update_MyState)에 com.util.sqlproc.xml파일의 5-2.사용자 상태 수정하기 프로시저 실행.(Mystate_update의 Value로 꺼냄)
			update_MyState = sqlSession.selectList("mybatis.ProcMapper.update_MyState", Mystate_update);
		//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
		// 자원 반납하기
		} finally {
			sqlSession.close();
		}
		return update_MyState;
	}///////////////////////////////////// [[[ 5-2. 사용자 상태 수정하기 종료 ]]] /////////////////////////////////////
}
