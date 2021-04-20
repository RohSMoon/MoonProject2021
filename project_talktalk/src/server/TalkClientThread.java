package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import View.Login_view;

public class TalkClientThread extends Thread{
	TalkClient tc = null;	
	login2 login2 = null;
	///이건 클라이언트
	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}
	@Override
	public void run() {
		////// ois로 메세지를 전달 받으면 담을 통
		String msg = null;
		List<String> list = null;
		Map<Object,String> map = null;
		List<ConversationVO> csvList = null; //대화 내용 담을 통
		boolean isStop = false;
		////// 클라이언트는 여기서 기다리다가, 이제 값이 들어올때마다 들어간다.(화면이 꺼지는 그 순간까지~!)
		while(!isStop) {
			//////TalkServerThread를 통해서 값을 받음.
			try {
				msg = (String)tc.ois.readObject();
				System.out.println(msg);
				////// 값을 쪼갤 StringTokenizer를 선언함.
				StringTokenizer st = null;
				////// 프로토콜을 선언
				int protocol = 0;
				if(msg!=null) {
					////// Protocol.seperator기준으로 문자를 쪼갠다.
					st = new StringTokenizer(msg,Protocol.seperator);
					////// 전부 String으로 되어 있으므로 처음 받아오는 프로토콜 부분은 숫자로 바꿔 준다음에 넣어준다. 
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					////// 맞는 프로토콜에 따라서 넣어준다.  
					//로그인 프로토콜
					case Protocol.LOGIN :{
						int    loginTrueFalse = Integer.parseInt(st.nextToken());
						String loginMsg       = st.nextToken();
						tc.login_view.loginSuccess(loginTrueFalse,loginMsg);
					}break;
					////// 회원가입 프로토콜  
					case Protocol.SIGNUP :{
						String signupResult = st.nextToken();
						tc.login_view.signupSuccess(signupResult);
					}break;
					///// 나를 제외한 사원들 정보 보여주기
					case Protocol.MEMLIST :{
						list= (List)tc.ois.readObject();
						for(String i:list) {
							System.out.println(i);
						}
						System.out.println("---------------------");
					}break;
					///// 내가 속한 방 리스트 다 받아서 뷰에다가 보여주기
					case Protocol.ROOMLIST :{
						//****여기서 중요 나중에 방 넣어줄때 key도 숨김처리해서 같이 넣어줘야한다.
						//그래야 나중에 방에 들어갈때 몇 번 방인지를 내가 찾을 수 있기 때문이다.
						map= (Map)tc.ois.readObject();
						for(Object key:map.keySet()) {
							System.out.println(map.get(key));
						}
						System.out.println("---------------------");
					}break;
					///// 내가 속하지 않은 그룹 방 리스트 다 받아서 뷰에다가 보여주기
					case Protocol.GROUPLIST :{
						//****여기서 중요 나중에 방 넣어줄때 key도 숨김처리해서 같이 넣어줘야한다.
						//그래야 나중에 방에 들어갈때 몇 번 방인지를 내가 찾을 수 있기 때문이다.
						map= (Map)tc.ois.readObject();
						for(Object key:map.keySet()) {
							System.out.println(map.get(key));
						}
						System.out.println("---------------------");
					}break;
					/////나의 방 목록에 추가하거나 없애기
					case Protocol.ROOM_CREATE :{
						String room_GI       = st.nextToken();
						int    room_GI_num   = Integer.parseInt(st.nextToken()); 
						String room_GI_title = st.nextToken(); 
						//방 목록에 추가해주기
						if("ADD".equals(room_GI)){							
							System.out.println(room_GI_num+" "+room_GI_title);
							System.out.println("방 리스트에 생성시켜주기");
						}
						else if("DEL".equals(room_GI)){							
							System.out.println(room_GI_num+" ");
							System.out.println("방 리스트에서 삭제 시켜주기");
						}

					}break;
					/////그룹방 목록에 추가하거나 없애기
					case Protocol.GROUP_LIST :{
						String room_GI       = st.nextToken();
						int    room_GI_num   = Integer.parseInt(st.nextToken()); 
						String room_GI_title = st.nextToken(); 
						//만약 그룹이라면 그 그룹방에 초대받지 못한 사람은 없는 방에 생성해주기
						if("ADD".equals(room_GI)) {
							System.out.println(room_GI_num+" "+room_GI_title);
							System.out.println("그룹방 리스트에 생성시켜주기");				
						}
						else if("DEL".equals(room_GI)){							
							System.out.println("그룹방에서 삭제해주기");
						}
						
					}break;
					///// 방에 입장하기
					case Protocol.MYROOM_IN :{
						//여기에 나중에 방 창 켜지는 것도 구현 해줘야한다다다다다!
						list= (List)tc.ois.readObject();
						csvList = (List)tc.ois.readObject();
						//////방 안 사람들 뷰에 보이도록
						System.out.println("------------방 안 사람들-------------");
						for(String member:list) {
							System.out.println(member);
						}
						//////방 대화 다 보이도록
						System.out.println("--------------대화 내용-----------");
						if(csvList!=null) {
							for(ConversationVO csv:csvList) {
								System.out.println("["+csv.getName()+"] "+csv.getConver());
							}
						}
					}break;
					///// 내가 속하지 않은 그룹 방에 입장하기
					case Protocol.GROUPROOM_IN :{
						list= (List)tc.ois.readObject();
						csvList = (List)tc.ois.readObject();
						//////방 안 사람들 뷰에 보이도록
						System.out.println("------------방 안 사람들-------------");
						for(String member:list) {
							System.out.println(member);
						}
						//////방 대화 다 보이도록
						System.out.println("--------------대화 내용-----------");
						for(ConversationVO csv:csvList) {
							System.out.println("["+csv.getName()+"] "+csv.getConver());
						}
					}break;
					///// 내가 속하지 않은 그룹 방에 입장하기
					case Protocol.CHAT_IN:{
						//채팅창 목록에 추가할건지 삭제할건지
						String room_GI       = st.nextToken();
						int mem_no           = Integer.parseInt(st.nextToken()); 
						String mem_name      = st.nextToken();
						//////방 안 사람들 뷰에 보이도록
						if("ADD".equals(room_GI)) {
							System.out.println(mem_no+" "+mem_name);
							System.out.println("그룹채팅 리스트에 생성시켜주기");				
						}
						else if("DEL".equals(room_GI)){							
							System.out.println(mem_no+" "+mem_name);
							System.out.println("그룹채팅 리스트에 삭제해주기");
						}
					}break;
					/////새로운 사람이 방에 들어올때
					/////메세지 전송할 때
					case Protocol.MESSAGE :{
						String name   = st.nextToken();
						String conver = st.nextToken();
						System.out.println("["+name+"]"+conver);
					}break;
					///// 개인 상세 정보보기 
					case Protocol.MY_INFO :{
						System.out.println("내 정보 보기");
						System.out.println("[이름]"+st.nextToken());
						System.out.println("[부서]"+st.nextToken());
						System.out.println("[직급]"+st.nextToken());
						
					}break;
					///// 나의 상태 변경
					case Protocol.MY_STATE :{
						System.out.println("상태가 변경되었습니다.");
						System.out.println(st.nextToken());
					}break;
					///// 방 삭제
					case Protocol.ROOM_DEL:{
						System.out.println("방 나가게 하기 창 끄기");
					}break;
					///// 로그아웃 
					case Protocol.LOGOUT:{
						System.out.println("아예 꺼버리기");
					}break;
					///// 승인된 사원 추가하거나 또는 업데이트, 삭제하기
					case Protocol.MANAGER_APPROVE_DEL :{
						int    client_mem_no   = Integer.parseInt(st.nextToken());
						String client_mem_name = st.nextToken();
						String client_mem_info = st.nextToken();
						String room_GI         = st.nextToken();
						//멤버 목록에 추가
						if("ADD".equals(room_GI)){							
							System.out.println(client_mem_no+" "+client_mem_name);
							System.out.println("멤버 리스트에 생성시켜주기");
						}
						else if("UP".equals(room_GI)){							
							System.out.println(client_mem_no+" "+client_mem_name);
							System.out.println("멤버 정보 업데이트");
						}
						//멤버 목록에 삭제
						else if("DEL".equals(room_GI)){							
							System.out.println(client_mem_name+" ");
							System.out.println("멤버 리스트에서 삭제 시켜주기");
						}
					}break;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
