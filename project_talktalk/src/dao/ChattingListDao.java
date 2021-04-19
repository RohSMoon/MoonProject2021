package dao;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.RoomPplVO;
import com.vo.RoomVO;
/******************************************************************************
 * @author frien
 * 채팅목록창과 관련된 DAO입니다.
 ******************************************************************************/
public class ChattingListDao {
	/* 선언부 */
	//채팅목록창과 관련된 Table 선언하기
	RoomVO 		rVO		= new RoomVO();
	RoomPplVO 	rpVO 	= new RoomPplVO();
	//SqlSessionFactory를 통하여 MyBatis와 연결할 예정
	SqlSessionFactory sqlSessionFactory = null;
	// sqlSession을 통하여 쿼리문을 받아올 예정
	SqlSession 		  sqlSession 		= null; 
	
	/* 3.1 내 채팅방만 띄우기 */
	public List<Map<String, Object>> getMyChat(Map<String,Object> myChat_List){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//myChatList라는 변수명 선언해주기
		List<Map<String, Object>> myChatList = null;
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#32번에서 선언한 변수(myChatList)에 com.util.sqlproc.xml파일의 3-1.내 채팅방만 띄우기 프로시저를 실행하여 myChat_List에서 꺼내온다.
			myChatList = sqlSession.selectList("mybatis.ProcMapper.myChat_list", myChat_List);
		//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
		// 자원 반납하기
		} finally {
			sqlSession.close();
		}
		return myChatList;
	}//////////////////////////////////////////// [[[ 3.1 내 채팅방만 띄우기 종료 ]]] ////////////////////////////////////////////
	
	/* 3.2 입장되지 않은 그룹 채팅방만 띄우기 */
	public List<Map<String, Object>> getGroupChat(Map<String,Object> groupChat_List){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//groupChatList라는 변수명을 Vector로 선언해주기
		List<Map<String, Object>> groupChatList = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#53번에서 선언한 변수(groupChatList)에 com.util.sqlproc.xml파일의 3-2.입장되지 않은 그룹 채팅방만 띄우기 프로시저를 실행하여 groupChat_List에서 꺼내온다.
			groupChatList = sqlSession.selectList("mybatis.ProcMapper.notEgroup_list", groupChat_List);
		//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
		//자원 반납하기
		} finally {
			sqlSession.close();
		}
		return groupChatList;
	}//////////////////////////////////////////// [[[ 3.2 입장되지 않은 그룹 채팅방만 띄우기 종료 ]]] ////////////////////////////////////////////
}
