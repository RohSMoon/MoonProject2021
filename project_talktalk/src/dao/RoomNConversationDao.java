package dao;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.ConversationVO;
import com.vo.RoomPplVO;

public class RoomNConversationDao {
	/* 선언부 */
	// 방, 대화에 관련된 VO 가져오기
	ConversationVO 	cVO 	= new ConversationVO();
	RoomPplVO 		rpVO 	= new RoomPplVO();
	//SqlSessionFactory를 통하여 MyBatis와 연결할 예정
	SqlSessionFactory sqlSessionFactory = null;
	// sqlSession을 통하여 쿼리문을 받아올 예정
	SqlSession 		  sqlSession 		= null;
	
	/* 4-1. 방 이름 가져오기 */
	public List<Map<String, Object>> getRoom_title(Map<String,Object> room_Title){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//roomTitle이라는 변수명 선언해주기
		List<Map<String,Object>> roomTitle = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#29번에서 선언한 변수(roomTitle)에 com.util.sqlproc.xml파일의 4-1.방 이름 가져오기 프로시저를 실행 (Value값은 room_Title에서 꺼내온다.)
			roomTitle = sqlSession.selectList("mybatis.ProcMapper.getRoom_title", room_Title);
		//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
		//자원 반납하기
		} finally {
			sqlSession.close();
		}
		return roomTitle;
	} //////////////////////////////////////////// [[[ 4-1. 방 이름 가져오기 종료 ]]] ////////////////////////////////////////////
	
	/* 4-2. 방 초대하기 */
	public List<Map<String, Object>> getInviteRoom(Map<String,Object> invite_Room){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//inviteRoom이라는 변수명 선언해주기
		List<Map<String,Object>> inviteRoom = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#50번에서 선언한 변수(roomTitle)에 com.util.sqlproc.xml파일의 4-2. 방 초대하기 프로시저를 실행 (Value값은 invite_Room에서 꺼내온다.)
			inviteRoom = sqlSession.selectList("mybatis.ProcMapper.invite_Room", invite_Room);
			//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
			//자원 반납하기
		} finally {
			sqlSession.close();
		}
		return inviteRoom;
	} //////////////////////////////////////////// [[[ 4-2. 방 이름 가져오기 종료 ]]] ////////////////////////////////////////////
	
	/* 4-3. 방 나가기 */
	public List<Map<String, Object>> getExitRoom(Map<String,Object> exit_Room){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//exitRoom이라는 변수명 선언해주기
		List<Map<String,Object>> exitRoom = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#71번에서 선언한 변수(roomTitle)에 com.util.sqlproc.xml파일의 4-3. 방 나가기 프로시저를 실행 (Value값은 exit_Room에서 꺼내온다.)
			exitRoom = sqlSession.selectList("mybatis.ProcMapper.exit_Room", exit_Room);
			//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
			//자원 반납하기
		} finally {
			sqlSession.close();
		}
		return exitRoom;
	}//////////////////////////////////////////// [[[ 4-3. 방 나가기 종료 ]]] ////////////////////////////////////////////
	
	/* 4-4.대화 내용 불러오기 */
	public List<Map<String, Object>> getConverRoom(Map<String,Object> get_Conversation){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//ConverRoom이라는 변수명 선언해주기
		List<Map<String,Object>> ConverRoom = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#92번에서 선언한 변수(ConverRoom)에 com.util.sqlproc.xml파일의 4-4. 대화 내용 불러오기 프로시저를 실행 (Value값은 get_Conversation에서 꺼내온다.)
			ConverRoom = sqlSession.selectList("mybatis.ProcMapper.getConver", get_Conversation);
			//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
			//자원 반납하기
		} finally {
			sqlSession.close();
		}
		return ConverRoom;
	}//////////////////////////////////////////// [[[ 4-4.대화 내용 불러오기 종료 ]]] ////////////////////////////////////////////
	
	/* 4-5. 메시지 전송 */
	public List<Map<String, Object>> getSendMsg(Map<String,Object> send_Msg){
		//SqlSessionFactory를 통하여 MyBatis와 연결 (싱글톤)
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		//sendMsg이라는 변수명 선언해주기
		List<Map<String,Object>> sendMsg = new Vector<>();
		try {
			//MyBatis를 통하여 쿼리문 또는 프로시저를 실행하려고 열었음
			sqlSession = sqlSessionFactory.openSession();
			//#113번에서 선언한 변수(sendMsg)에 com.util.sqlproc.xml파일의 4-5. 메시지 전송 프로시저를 실행 (Value값은 send_Msg에서 꺼내온다.)
			sendMsg = sqlSession.selectList("mybatis.ProcMapper.sendMessage", send_Msg);
			//단계별 예외처리
		} catch (Exception e) {
			e.printStackTrace();
			//자원 반납하기
		} finally {
			sqlSession.close();
		}
		return sendMsg;
	}//////////////////////////////////////////// [[[ 4-5. 메시지 전송 종료 ]]] ////////////////////////////////////////////
	
}
