package dao;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;
import com.vo.MemberVO;

/*******************************************************
 * @author frien
 * 로그인 후 보이는 목록창에 대한 DAO 입니다.
 ******************************************************/
public class ListDao {
	/* 선언부 */
	//목록창을 불러오는 member와 dept의 VO 불러오기 (조인되어 있는 부분)
	MemberVO mVO = new MemberVO();
	DeptVO   dVO = new DeptVO();
	//SqlSessionFactory를 통하여 MyBatis와 연결할 예정
	SqlSessionFactory sqlSessionFactory = null;
	// sqlSession을 통하여 쿼리문을 받아올 예정
	SqlSession sqlSession = null;
	
	/* 2-1. 메인 List창 불러오기(로그인 직후 나타나는 목록창) */
	public List<Map<String, Object>> getList(Map<String,Object> m_List){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		// mainList 변수 안에 List와 Map을 넣어줄 예정이라 선언함
		List<Map<String, Object>> mainList = null;
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#33번에서 선언한 변수에 com.util.sqlproc.xml파일의 2-1.메인 목록창 불러오기 프로시저를 실행하여 M_List에 넣어줌
			mainList = sqlSession.selectList("mybatis.ProcMapper.chat_mainList", m_List);
		//예외처리(단계별로 표시함)
		} catch (Exception e) {
			e.printStackTrace();
		//자원반납하기	
		} finally {
			sqlSession.close();
		}
		return mainList;
	}//////////////////////////////////////////// [[[ 2-1.메인 List창 불러오기(로그인 직후 나타나는 목록창) 종료 ]]] ////////////////////////////////////////////
	
	/* 2-2. 사원 검색하기 */
	public List<Map<String,Object>> getSearch_Member(List<Map<String,Object>> search_Member){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		// searchMember 변수 안에 List와 Map을 넣어줄 예정이라 선언함
		List<Map<String,Object>> searchMember = null;
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#54번에서 선언한 Vector변수에 com.util.sqlproc.xml파일 2-2. 사원 검색 프로시저를 실행하고 search_Member에 넣어줌
			searchMember = sqlSession.selectList("mybatis.ProcMapper.chat_searchMember", search_Member);
		//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
		// 자원 반납하기
		} finally {
			sqlSession.close();
		}
		return searchMember;
	}//////////////////////////////////////////// [[[ 2-2. 사원 검색하기 종료 ]]] ////////////////////////////////////////////
		
	/* 2-3. 방 개설하기 */
	public List<Map<String,Object>> getCreate_Room(Map<String,Object> create_Room){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		// createRoom 변수 안에 List와 Map을 넣어줄 예정이라 선언함
		List<Map<String, Object>> createRoom = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#75번에서 선언한 Vector변수(createRoom)에 com.util.sqlproc.xml파일 2-3.방 개설 프로시저를 실행하고 create_Room에 넣어줌
			createRoom = sqlSession.selectOne("mybatis.ProcMapper.create_Room", create_Room);
		//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
		//자원반납
		} finally {
			sqlSession.close();
		}
		return createRoom;
	} //////////////////////////////////////////// [[[ 2-3. 방 개설하기 종료 ]]] //////////////////////////////////////////////
	
	/* 2-4. 방 안에 사람 넣기 */
	public List<Map<String, Object>> getInput_Member(Map<String,Object> input_Member){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		// inputMember 변수 안에 List와 Map을 넣어줄 예정이라 선언함
		List<Map<String, Object>> inputMember = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#96번에서 선언한 Vector변수(inputMember)에 com.util.sqlproc.xml파일 2-4.방 안에 사람 넣기 프로시저를 실행하고 input_Member에 넣어줌
			inputMember = sqlSession.selectList("mybatis.ProcMapper.inChat_Member", input_Member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return inputMember;
	} //////////////////////////////////////////// [[[ 2-4. 방 안에 사람 넣기 종료 ]]] ////////////////////////////////////////////
	
}
