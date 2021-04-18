package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class TalkServerThread extends Thread {
	//////TalkServer 3-5를 통해서 여기로 넘어옴.
	//////1-1. 새로온 클라이언트의 스래드를 담을 통 선언
	TalkServer ts = null;
	//////1-2. 새로온 클라이언트로부터 말을 받을 통로 선언
	ObjectInputStream ois  = null;
	//////1-3. 새로온 클라이언트로부터 말을 내보낼 통로 선언
	ObjectOutputStream oos = null;
	//////1-4. 새로온 클라이언트의 아이디 선언
	int mem_no = 0;
	//////1-4. 새로온 클라이언트의 이름
	String mem_name = null;
	//톡방에 입장한 사람의 대화명 담기
	//////1-5. 새로운 클라이언트의 현재상태 - 대기방인지 방 안 인지 등등
	//String g_title = null;
	//////1-6. 단톡방의 사람 수 담을 변수 선언
	//int g_current = 0;//현재인원수 담기
	//Room room = new Room();
	public TalkServerThread(TalkServer ts) {
		//////TalkServer 3-5를 통해서 여기로 넘어옴.
		//////2-1. 클라이언트의 소켓 정보가 들어있는 TalkServer주소값을 받아와서 넣어줌.
		this.ts = ts;
		try {
			//////2-2. 클라이언트의 소켓을 통해서 oos를 인스턴스화 해줌(소켓으로 누군지 구분할 수 있으니깐)
			oos = new ObjectOutputStream
					(ts.client.getOutputStream());			
			//////2-3. 클라이언트의 소켓을 통해서 ois를 인스턴스화 해줌(소켓으로 누군지 구분할 수 있으니깐)
			ois = new ObjectInputStream
						(ts.client.getInputStream());
			//////2-4. TalkClientVer2의 3-9.으로 인해서 msg가 선언, 초기화 됨.
			String msg = (String)ois.readObject();
			//////2-5. 서버 창 위에다가 프로그램 접속 메세지를 띄어줌. 프로토콜 번호와 클라이언트의 이름과 현재상태
			ts.jta_log.append("[프로그램 접속 프로토콜번호]"+msg+"\n");
			//////2-6. (스크롤이 생길 경우를 대비해서) jsp_log를 가장 하단부로 창을 보여준다.
			ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());

		} catch (Exception e) {
			System.out.println("TalkServerThread:"+e.getMessage()+","+e.toString());
		}
	}
	
	//특정 방 사람들에게 정보전달하기 위해서 필요
	private void broadCasting(String msg,Room grouproom) {
		synchronized(this) {
			for(TalkServerThread tst:grouproom.userList) {
				tst.send(msg);
			}
		}
	}
	//특정 방 사람들에게 정보전달하기 위해서 필요
	private void broadCastingAll(String msg) {
		synchronized(this) {
			for(TalkServerThread tst:ts.globalList) {
				tst.send(msg);
			}
		}
	}
	
	private void send(String msg) {
		try {
			////// 클라이언트에게 보내는 역할을 하는 send 메소드.
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendList(List list) {
		try {
			////// 클라이언트에게 보내는 역할을 하는 send 메소드.
			oos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendMap(Map map) {
		try {
			////// 클라이언트에게 보내는 역할을 하는 send 메소드.
			oos.writeObject(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		boolean isStop = false;
		if(ois==null || ts.client==null) {
			isStop = true;
		}
		try {
			run_start://while문 같은 반복문 전체를 빠져 나가도록 처리할때
			while(!isStop) {
				/////// 받아온 문자를 읽어냄.
				String msg = (String)ois.readObject();
				/////// 방 만들때 사람들 이름 list
				List<Integer> member_nos = null;
				/////// 읽어온 값을 서버 창에 넣어줌.
				ts.jta_log.append("[들어온 요청 프로토콜]"+msg+"\n");
				/////// (스크롤이 생길 경우를 대비해서) jsp_log를 가장 하단부로 창을 보여준다.
				ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
				/////// 프로토콜 번호.
				int protocol = 0;
				/////// StringTokenizer 쪼갤 통 선언.
				StringTokenizer st = null;
				if(msg!=null) {
					/////// msg를 #을 기준으로 쪼개기
					st = new StringTokenizer(msg,Protocol.seperator);
					/////// st의 첫번째 값인 프로토콜 번호는 숫자로 변환
					protocol = Integer.parseInt(st.nextToken());
				}
				/////// protocol기준으로 켜주기
				switch(protocol) {
					//////////////[매니저]//////////////////////////////////////
					case Protocol.LOGIN_MANAGER : {
						int manager_mem_no = Integer.parseInt(st.nextToken());
						String mem_pw = st.nextToken();
						int loginTrueFalse = 0;
						String loginMsg =null;
						if(ts.manager==1) {
							//이미 관리자가 들어와 있으므로 ts.manager가 1이면 이미 들어와있다는 것임
							loginTrueFalse = 0;
							loginMsg ="이미 접속되어있습니다.";
						}else if(ts.manager==0) {
							//return이 2개여야한다.
							//1.여기에 로그인 관련 dao 확인 호출 만약에 맞다면 값 가져오겠지. 1이면 로그인이랑 비번 일치
							//2.로그인한다, 아이디가 틀렷다, 비번이 틀렷다 등등.
							loginTrueFalse = 1; 
							loginMsg = "로그인 되었습니다.";
							if(loginTrueFalse == 1) {
								ts.manager=1; //이제 관리자가 접속할테니 1로
								ts.managertst = this;
							}
							
						}
						/////send()메소드로 값 전송 
						this.send(Protocol.LOGIN_MANAGER 
						         +Protocol.seperator+loginTrueFalse
						         +Protocol.seperator+loginMsg);
					}break;
					/////승인해야할 목록
					case Protocol.MANAGER_APPROVELIST : {
						////승인해야하는 사원목록 가져오는 DAO
						////사원번호도 무조건 가져와야함
						List<Object> approvelist = new ArrayList<Object>();
						approvelist.add("사과님");
						approvelist.add("딸기님");
						/////send()메소드로 값 전송 
						this.send(Protocol.MANAGER_APPROVELIST+"");
						/////승인해야하는 목록 여기다가 담아서 전송
						this.sendList(approvelist);	
					}break;
					/////승인해야할 목록, 업데이트할 사원, 삭제할 사원
					case Protocol.MANAGER_APP_UP_DEL : {
						/////사원번호 가져오기
						int    client_mem_no = Integer.parseInt(st.nextToken());
						String click_button  = st.nextToken();
						/////사원승인
						if("APP".equals(click_button)) {
							/////사원번호로 승인하기 - dao
							/////관리자의 사원 승인 목록창에서 승인한 사원 지우기
							this.send(Protocol.MANAGER_APPROVE_DEL
									+Protocol.seperator+client_mem_no
									+Protocol.seperator+"승인된 사원 이름"
									+Protocol.seperator+"사원 목록에 보이는 사원정보"
									+Protocol.seperator+"DEL"
									);
							/////현재 들어와있는 사원들에게 그 사원 목록 추가해주기
							this.broadCastingAll(Protocol.MANAGER_APPROVE_DEL
									+Protocol.seperator+client_mem_no
									+Protocol.seperator+"승인된 사원 이름"
									+Protocol.seperator+"사원 목록에 보이는 사원정보"
									+Protocol.seperator+"ADD"
									);
						}
						/////사원정보 업데이트 *******업데이트하면 대화 하는 사람 목록창이랑 대화에서도 다 업데이트해줘야한다...
						else if("UP".equals(click_button)) {
							/////사원번호로 업데이트기 - dao
							/////관리자의 사원 목록창에서 업데이트된 사원 정보 변경
							this.send(Protocol.MEMLIST_UP_DEL
									+Protocol.seperator+client_mem_no
									+Protocol.seperator+"승인된 사원 이름"
									+Protocol.seperator+"사원 목록에 보이는 사원정보"
									+Protocol.seperator+"UP"
									);
							/////현재 들어와있는 사원들에게 그 사원 정보 업데이트
							this.broadCastingAll(Protocol.MANAGER_APPROVE_DEL
									+Protocol.seperator+client_mem_no
									+Protocol.seperator+"승인된 사원 이름"
									+Protocol.seperator+"사원 목록에 보이는 사원정보"
									+Protocol.seperator+"UP"
									);
							/////*********사원 이름이 바뀌었다면 방 정보랑 방 안의 정보도 전부 변경
						}
						//////사원정보 삭제시
						else if("DEL".equals(click_button)) {
							/////*******사원삭제가 되면 현재 접속해있는 사람들 중에서 그와 관련된 방을 전부 삭제하고
							////*********그와 관련된 룸안에서도 그의 번호를 다 삭제해줘야한다.
							/////사원이 현재 접속중이라면 삭제 안돼게 정보를 전송시켜야한다.
							for(TalkServerThread tst:ts.globalList) {
								if(tst.mem_no==client_mem_no) {
									System.out.println("현재 접속이라서 삭제가 불가능하다는 메세지 전송 프로토콜 만들기");
								}
							}
							
							/////사원번호로 삭제 - dao
							/////관리자의 사원 목록창에서 사원삭제
							this.send(Protocol.MEMLIST_UP_DEL
									+Protocol.seperator+client_mem_no
									+Protocol.seperator+"승인된 사원 이름"
									+Protocol.seperator+"사원 목록에 보이는 사원정보"
									+Protocol.seperator+"DEL"
									);
							/////현재 들어와있는 사원들에게 그 사원 목록에서 삭제
							this.broadCastingAll(Protocol.MANAGER_APPROVE_DEL
									+Protocol.seperator+client_mem_no
									+Protocol.seperator+"승인된 사원 이름"
									+Protocol.seperator+"사원 목록에 보이는 사원정보"
									+Protocol.seperator+"DEL"
									);
						}

					}break;
					
				
				
					//////////////[클라이언트]//////////////////////////////////////
					///// 로그인 일시
					case Protocol.LOGIN :{
						int client_mem_no = Integer.parseInt(st.nextToken());
						String mem_pw = st.nextToken();
						//return이 2개여야한다.
						//1.여기에 로그인 관련 dao 확인 호출 만약에 맞다면 값 가져오겠지. 1이면 로그인이랑 비번 일치
						//2.말 받아오기 로그인되어잇다, 로그인한다, 아이디가 틀렷다, 비번이 틀렷다 등등.
						int loginTrueFalse = 1;
						String loginMsg = "로그인 되었습니다.";
						/////**이미로그인 한 상태인지 확인하는 메소드 추가
						if(loginTrueFalse == 1) {
							int login_State = 0;
							for(TalkServerThread tst:ts.globalList) {
								/////이미 접속되어있는 사람을 발견한 경우
								if(tst.mem_no==client_mem_no) {
									login_State=1;
									loginTrueFalse = 0;
									loginMsg ="이미 접속되어있습니다.";
									break;
								}
							}
							//////만약 새로 접속이 맞다면 스레드 받아주고, 이미 접속되있는 상태면 안받는다.
							if(login_State==0) {
								this.mem_no = client_mem_no;
								this.mem_name = "스파이더맨";
								ts.globalList.add(this);
							}
						}
						/////send()메소드로 값 전송 
						this.send(Protocol.LOGIN 
						         +Protocol.seperator+loginTrueFalse
						         +Protocol.seperator+loginMsg);
						//로그인 처리가 되므로 들어온 사람의 쓰래드 목록에 추가
					}break;
					///// 회원가입 일시
					case Protocol.SIGNUP :{
						int mem_no = Integer.parseInt(st.nextToken());
						String mem_pw = st.nextToken();
						//**dao에게 memberVO로 담아서 회원가입을 보내준다
						//회원 가입이 잘 처리되면 "잘 처리됬다는 문구"
						//안 되면 프로시저에서 String 받아서 왜 잘안됐는지 받아오겟지 "아이디가 겹친다던가"," 값입력 필요하다던가 등등"
						String signupResult = "회원가입이 완료됐습니다.";
						/////send()메소드로 값 전송 --broadCasting()로 ㄱㄱ
						this.send(Protocol.SIGNUP 
								+Protocol.seperator+signupResult);
						/////만약 관리자가 접속해 있는 상태라면 승인 목록에 추가시켜주기
						if(ts.manager==1) {
							this.send(Protocol.MANAGER_APPROVE_DEL
									+Protocol.seperator+2101 //회원가입하는 사원번호
									+Protocol.seperator+"승인된 사원 이름"
									+Protocol.seperator+"사원 목록에 보이는 사원정보"
									+Protocol.seperator+"ADD"
									);
						}
					}break;
					///// 사원 목록 가져오기
					case Protocol.MEMLIST :{
						
						//**dao로  나를 제외한 사람 정보들 다 받오기 - list<memberVO> 승인 해야되는 애 빼고
						//관리자도 이거 이용해서 받아옴
						List<String> mem_names = new ArrayList<>();
						mem_names.add("토끼");
						mem_names.add("호랑이");
						mem_names.add("돌고래");
						this.send(Protocol.MEMLIST+""); //보낼 프로토콜
						this.sendList(mem_names); //멤버 리스트 넣어주기
					}break;
					///// 내가 속한 방 리스트 가져오기
					case Protocol.ROOMLIST :{
						//**dao로  내가 속한 방 list 이름과 방 번호 가져오기 (0은 내가 나간 방이니깐 포함X)
						Map<Object,String> my_rooms = new HashMap<>();
						my_rooms.put(1,"영업부 그룹방");
						my_rooms.put(2,"토끼와 대화방");
						my_rooms.put(3,"에이스의 모임");
						this.send(Protocol.ROOMLIST+""); //보낼 프로토콜
						this.sendMap(my_rooms); //방 리스트 넣어주기
						
						//room 목록에 이미 방이 존재한다면, 나의 스래드만 추가해주고
						//room 목록에 방이 존재하지 않는다면, room도 추가하고 나의 스래드도 추가
						for(Object key:my_rooms.keySet()) {//내가 있는 방을 다 가져온다.
							//방이 존재한다면 1, 존재하지 않는다면 0
							int roomTrueFalse = 0;
							for(Room room:ts.roomList) {
								if(room.getRoom_num()==(int)key) {
									ts.jta_log.append("[이방은 이미 존재하네요]"+room.getTitle()+"\n");
									roomTrueFalse = 1;
									//방이 이미 존재하므로 나의 스래드만 그 방에 추가시켜준다.
									room.mem_no.add(this.mem_no);//나의 아이디 추가
									room.userList.add(this);//나의 스래드 추가
									break;
								}
							}
							//방이 존재하지 않으므로, room도 추가하고 나의 스래드도 추가
							if(roomTrueFalse==0) {
								Room room = new Room();
								room.mem_no.add(this.mem_no);//나의 아이디 추가
								room.userList.add(this);//나의 스래드 추가
								room.setTitle(my_rooms.get(key));//그 방의 이름
								ts.roomList.add(room); //룸 추가
							}
						}
					}break;
					/////내가 속하지 않은 그룹 방리스트
					case Protocol.GROUPLIST :{
						//**dao로  내가 속하지 않은 그룹방+(0으로 내가 나갔던 그룹방도 고려)
						Map<Object,String> RoomWithoutMe  = new HashMap<>();
						RoomWithoutMe.put(10,"있어도그만인 그룹방1");
						RoomWithoutMe.put(20,"안들어가고 싶은 그룹방2");
						RoomWithoutMe.put(30,"들어가고 싶은 그룹방3");
						this.send(Protocol.GROUPLIST+""); //보낼 프로토콜
						this.sendMap(RoomWithoutMe); //내가 없는 그룹방 리스트 넣어주기
					}break;
					/////방만들기
					case Protocol.ROOM_CREATE :{
						//방 넣기
						Room roomCreate = null;
						//방이 그룹인지 아니면 갠톡방인지
						String room_GI       = st.nextToken();
						//방 이름 가져오기
						String room_GI_title = st.nextToken();
						//사람들 번호 목록 가져오기
						member_nos = (List)ois.readObject();
						//member_nos로 방 사람 이름 가져오기
						List<String> roomMember = new ArrayList<>();
						List<ConversationVO> csvList = null;
						if("group".equals(room_GI)) {
							//그룹방 만들기 dao에서
							int room_GI_num = 10000; //방 번호 가져오기
							roomCreate = new Room();
							roomCreate.setTitle(room_GI_title); //이 방의 방제목 넣기
							roomCreate.setRoom_num(room_GI_num); //이방의 번호 넣기
							roomCreate.mem_no.add(this.mem_no); //방 만든 사람의 번호
							roomCreate.userList.add(this); // 방 만든 사람의 스래드를 담아준다.
							for(int i=0;i<member_nos.size();i++) {
								for(TalkServerThread tst:ts.globalList) {
									//그 사람이 현재 접속해 있는 상태라면 그 사람의 번호와 스래드를 담아준다.
									if(member_nos.get(i)==tst.mem_no) {
										roomCreate.mem_no.add(member_nos.get(0));
										roomCreate.userList.add(tst);
										break;
									}
								}
							}
							//방 목록에 추가하기
							ts.roomList.add(roomCreate);
							//방이 만약 생성된 것이라면 스래드가 있는(즉 접속한) 모든 사람들의 방 목록에도 추가해줘야한다.
							for(TalkServerThread tst:roomCreate.userList) {
								tst.send(Protocol.ROOM_CREATE
								 		+Protocol.seperator+"ADD"       //방 목록에 추가해준다는 의미
							  			+Protocol.seperator+room_GI_num //방번호
										+Protocol.seperator+room_GI_title //방이름
										);
							}
							roomMember.add(mem_name);
							roomMember.add("해리포터");
							roomMember.add("헤르미온느");
							roomMember.add("론위즐리");
						}
						else if("individual".equals(room_GI)) {
							//dao에다가 roomCreateMemno넣고 있는 방인지 없는 방인지 확인을 먼저한다.
							//없는 방이면 dao 에서 알아서 생성하고 있는 방이면 있는 방임.
							int roomIndividual_re = 0; //1이면 방이 새로 만들어진다는 거고, 0이면 방이 이미 존재한다는 것
							int room_GI_num = 10000; //방 번호 가져오기
							roomMember.add(mem_name);
							roomMember.add("해리포터");
							if(roomIndividual_re==1) {
								roomCreate = new Room();
								roomCreate.setTitle(room_GI_title); //이 방의 방제목 넣기
								roomCreate.setRoom_num(room_GI_num); //이방의 번호 넣기
								roomCreate.mem_no.add(this.mem_no); //방 만든 사람의 번호
								roomCreate.userList.add(this); // 방 만든 사람의 스래드를 담아준다.
								for(TalkServerThread tst:ts.globalList) {
									//그 사람이 현재 접속해 있는 상태라면 그 사람의 번호와 스래드를 담아준다.
									if(member_nos.get(0)==tst.mem_no) {
										roomCreate.mem_no.add(member_nos.get(0));
										roomCreate.userList.add(tst);
										break;
									}
								}
								//방 목록에 추가하기
								ts.roomList.add(roomCreate);
								//방이 만약 생성된 것이라면 스래드가 있는(즉 접속한) 모든 사람들의 방 목록에도 추가해줘야한다.
								for(TalkServerThread tst:roomCreate.userList) {
									tst.send(Protocol.ROOM_CREATE
											+Protocol.seperator+"ADD"       //방 목록에 추가해준다는 의미
								  			+Protocol.seperator+room_GI_num //방번호
											+Protocol.seperator+room_GI_title //방이름
											);
								}	
							}
							//방이 이미 존재하므로 창만 띄어주면 됨.
							//방이 이미 존재하므로 그 방에서 대화 내용 다 불러와야함.					
							else if(roomIndividual_re==0) {
								 csvList = new ArrayList<>();
								//대화한 사람이랑 대화 목록을 VO로 가져오겠지
								ConversationVO csv = new ConversationVO();
								csv.setConver("너 지금 어디야?");
								csv.setName("해리포터");
								csvList.add(csv);
								csv = new ConversationVO();
								csv.setConver("나 지금 외근나왔다");
								csv.setName(mem_name);
								csvList.add(csv);
							}
						}
						//이걸 해서 채팅방 창 다 켜줘야한다.
						this.send(Protocol.MYROOM_IN+""); //보낼 프로토콜
						this.sendList(roomMember); //대화방 안에 사람 목록
						this.sendList(csvList); //대화 내용
					}break;				
					/////내가 가진 방에 입장
					case Protocol.MYROOM_IN :{
						int room_no = Integer.parseInt(st.nextToken());
						//room_no를 다오에 넣어서 방 사람들 목록이랑 대화 내용을 다 가지고 온다.(이때 0으로 나가있는 사람 잘 고려해서 가져오기)
						List<String> roomMember = new ArrayList<>();
						roomMember.add("lucky님");
						roomMember.add("신신이다님");
						roomMember.add("어정쩡님");
						//대화한 사람이랑 대화 목록을 VO로 가져오겠지
						List<ConversationVO> csvList = new ArrayList<>();
						ConversationVO csv = new ConversationVO();
						csv.setConver("안녕 잘지내?");
						csv.setName("어정쩡님");
						csvList.add(csv);
						csv = new ConversationVO();
						csv.setConver("그냥 저냥 항상 똑같지뭐");
						csv.setName("lucky님");
						csvList.add(csv);
						this.send(Protocol.MYROOM_IN+""); //보낼 프로토콜
						this.sendList(roomMember); //대화방 안에 사람 목록
						this.sendList(csvList); //대화 내용
					}break;
					/////들어가고 싶은 그룹방 입장
					case Protocol.GROUPROOM_IN :{
						int    room_num   = Integer.parseInt(st.nextToken());
						String room_name = st.nextToken();
						//room_no를 다오에 넣어서 방 사람들 목록이랑 대화 내용을 다 가지고 온다.(이때 0으로 나가있는 사람 잘 고려해서 가져오기)
						List<String> roomMember = new ArrayList<>();
						roomMember.add("소용돌이님");
						roomMember.add("번개님");
						roomMember.add("태양님");
						//대화한 사람이랑 대화 목록을 VO로 가져오겠지
						List<ConversationVO> csvList = new ArrayList<>();
						ConversationVO csv = new ConversationVO();
						csv.setConver("오늘 노래방 ㄱㄱ?");
						csv.setName("번개님");
						csvList.add(csv);
						csv = new ConversationVO();
						csv.setConver("안갈래 나 오늘 바쁘다~");
						csv.setName("태양님");
						csvList.add(csv);
						
						//그 room의 스레드가 필요하다. 그렇기때문에 그 방이 존재하는지 안하는지를 먼저 확인한다.
						//roomList 존재한다면 그 room가져와서 지금 들어오는 클라이언트스래드를 넣고 broadCasting주고
						Room grouproom = null;
						for(Room room:ts.roomList) {
							if(room.getRoom_num() == room_num) {
								//그 방 안에서 사람들에게 자신이 들어왔음을 목록에 추가해줘야함.
								//새로운 애가 들어오기 전에 먼저 목록에 그 애를 추가 시켜준다.
								this.broadCasting(Protocol.CHAT_IN
												 +Protocol.seperator+"ADD" //특정 사람 삭제하기
										         +Protocol.seperator+mem_no
										         +Protocol.seperator+mem_name,grouproom);
								room.userList.add(this);
								room.mem_no.add(room_num);
								grouproom = room;
								break;
							}
						}
						//roomList 존재 안한다면 새로 roomList에 추가해주고 지금 들어오는 클라이언트스래드를 넣고 broadCasting
						if(grouproom==null) {
							grouproom= new Room();
							grouproom.setRoom_num(room_num);
							grouproom.setTitle(room_name);
							grouproom.userList.add(this);;
							ts.roomList.add(grouproom);
						}
						//들어오는 자신에게만 전달
						this.send(Protocol.GROUPROOM_IN+""); //보낼 프로토콜
						this.sendList(roomMember); //대화방 안에 사람 목록
						this.sendList(csvList); //대화 내용
						//내 방 리스트에 추가하기
						this.send(Protocol.ROOM_CREATE
								+Protocol.seperator+"ADD"     //방 목록에 추가해준다는 의미
					  			+Protocol.seperator+room_num //방번호
								+Protocol.seperator+room_name //방이름
								);
						//그룹 방 리스트에서 없애기
						this.send(Protocol.GROUP_LIST
								+Protocol.seperator+"DEL"    //그룹방 목록에서 뺀다는 얘기
								+Protocol.seperator+room_num //방번호
								+Protocol.seperator+room_name //방이름
								);
						//그 방 안 사람들과 자신에게 자신이 들어왔음을 다 전달 시켜주기
						this.broadCasting(Protocol.MESSAGE
								         +Protocol.seperator+mem_name
								         +Protocol.seperator+" 님이 입장하셨습니다.",grouproom); //보낼 프로토콜
						
						
					}break;
					
					/////나의 상태 보기
					case Protocol.MY_INFO :{
						//**dao로  내 상태 받아오기 아마 memberVO일듯
						String name  = "내이름";
						String dept  = "나의부서";
						String level = "나의직급";
						//내 정보 전송
						this.send(Protocol.MY_INFO
								 +Protocol.seperator+name
								 +Protocol.seperator+dept
								 +Protocol.seperator+level);
					}break;					
					/////나의 상태 변경
					case Protocol.MY_STATE :{
						String my_state = st.nextToken();
						//**dao로 my_state넣어서 상태를 변경해 줄 것 임.		
						this.send(Protocol.MY_STATE
								 +Protocol.seperator+my_state); //보낼 프로토콜
					}break;
					/////방 삭제하기
					case Protocol.ROOM_DEL:{
						////나가려는 방번호
						int room_num = Integer.parseInt(st.nextToken());
						String room_name = st.nextToken();
						//그룹에서 나간건지, 개인방에서 나간건지 dao로 받기
						//개인방일시에는 다오에서 두 명 전부 나갓다면 아예 삭제
						//한 명만 나갔다면 나머지 한명이 접속해있는지 받기
						
						//그룹방일시에는 다오에서 전부 나가면 비워버리기
						//나 나가도 사람이 남아있다면 받기
						int groupstate = 1; //그룹방이면서 현존한다면!
						/////그 방을 찾아서 스래드 삭제, 채팅 목록에서 삭제
						for(int i=0;i<ts.roomList.size();i++) {
							if(ts.roomList.get(i).getRoom_num()==room_num) {
								for(int j=0;j<ts.roomList.get(i).userList.size();j++) {
									//////나가는 사람의 스래드랑 번호 지워주기
									if(ts.roomList.get(i).userList.get(j)==this) {
										ts.roomList.get(i).userList.remove(j);
										ts.roomList.get(i).mem_no.remove(j);
										break;
									}
								}
								if(groupstate == 1) {
									/////그룹방이면서 현존한다면+지금 접속해 있는 사람들 중에 그 방에 들어가 있는 사람이라면, 나간 사람 표시해주기
									this.broadCasting(Protocol.CHAT_IN
											+Protocol.seperator+"DEL" //특정 사람 삭제하기
											+Protocol.seperator+mem_no
											+Protocol.seperator+mem_name,ts.roomList.get(i));
									/////그룹방이면서 현존한다면+그 방 안 사람들에게 나갔음을 알려주기
									this.broadCasting(Protocol.MESSAGE
											         +Protocol.seperator+mem_name
											         +Protocol.seperator+" 님이 나가셨습니다.",ts.roomList.get(i));
								}
								break;
							}
						}
						//내 방 리스트에 삭제하기
						this.send(Protocol.ROOM_CREATE
								+Protocol.seperator+"DEL"     //방 목록에 추가해준다는 의미
					  			+Protocol.seperator+room_num //방번호
								+Protocol.seperator+room_name //방이름
								);
						/////만약 그룹방이고 그 방이 남아있다면 그룹방 리스트에 추가하기
						if(groupstate ==1) {
							this.send(Protocol.GROUP_LIST
									+Protocol.seperator+"ADD"     //방 목록에 추가해준다는 의미
						  			+Protocol.seperator+room_num //방번호
									+Protocol.seperator+room_name //방이름
									);
						}
						this.send(Protocol.ROOM_DEL+""); //보낼 프로토콜
					}break;
					case Protocol.MESSAGE:{
						/////어느 방에서 말하는지
						int    conver_room_num = Integer.parseInt(st.nextToken());
						/////누가 말하는지
						int    conver_num      = Integer.parseInt(st.nextToken());
						/////말하는 사람 이름은 뭔지
						String conver_name     = st.nextToken();
						/////뭐라고 말하는지
						String conversation    = st.nextToken();
						/////dao안에다가 대화 내용 넣어주기
						/////대화내용 방찾아서 그 방에다가 뿌려주기
						this.send(Protocol.MESSAGE
								+Protocol.seperator+conver_name
								+Protocol.seperator+conversation);
						for(Room room:ts.roomList) {
							/////내가 찾던 방을 발견한다면,
							if(room.getRoom_num() == conver_room_num) {
								this.broadCasting(Protocol.MESSAGE
										         +Protocol.seperator+conver_name
										         +Protocol.seperator+conversation,room);

								break;
							}
						}
					}break;
					case Protocol.LOGOUT :{
						/////globalList에서 로그아웃해주는 사람의 스래드 지워주기
						for(int i=0;i<ts.globalList.size();i++) {
							if(this==ts.globalList.get(i)) {
								ts.globalList.remove(i);
							}
						}
						/////모든 방에서 그 사람과 관련된 스래드와 정보를 다 지워준다.
						for(int i=0;i<ts.roomList.size();i++) {
							for(int j=0;j<ts.roomList.get(i).userList.size();j++) {
								if(ts.roomList.get(i).userList.get(j)==this) {
									ts.roomList.get(i).userList.remove(j);
									ts.roomList.get(i).mem_no.remove(j);
								}
								
							}		
						}
						this.send(Protocol.LOGOUT+""); //보낼 프로토콜
					}break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
