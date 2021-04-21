package View_modify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatDialog_Ctrl implements ActionListener {
	ChatDialog_View chatDialog_View; // 다이얼로그 선언
	public ChatDialog_Ctrl(ChatDialog_View chatDialog_View) { // 다이얼로그를 파라미터로 받는 생성자 
	this.chatDialog_View = chatDialog_View;  // 선언문과 값 동기화
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 악숀 감g 메숴드
		Object obj = e.getSource(); //오브젝트 타입 으로 담아
	if (obj==chatDialog_View.send_jbtn||obj==chatDialog_View.InputChat_jtf) { //예림이 그거  전송버튼이야? 까봐

		//전송 버튼을 누르거나 필드에 감지되면 String input에 넣어줄거야.
		String inputMsg = chatDialog_View.InputChat_jtf.getText(); 
		System.out.println("전송버튼"); // 확인 출력문
	}
	
	
	if (obj==chatDialog_View.closs_jbtn) { // 예림이 그패 까봐 닫기버튼인지
		System.out.println("닫기버튼"); //닫기버튼 확인 출력
		this.chatDialog_View.dispose(); // 그럼 꺼줘
	}
	
	
	if (obj==chatDialog_View.Emoji_jbtn) { // 이모티콘버튼?!
		System.out.println("이모티콘 버튼"); // 확인 출력
	}
	
	
	if (obj==chatDialog_View.SendFile_jbtn) { // 파일전송버튼? 
		System.out.println("파일전송 버튼"); // 확인문구 출력
	}
	
	
	if (obj==chatDialog_View.chatInvite_MenuItem) { // 초대하기 메뉴 ?
		System.out.println("초대하기 메뉴"); // 초대하기 메뉴 정상출력
	}
	
	
	if (obj==chatDialog_View.chatOut_MenuItem) { // 방..나가기로..했..어?... 
		System.out.println("방나가기"); // DO u wanna build a snow man?
		
		this.chatDialog_View.dispose(); // Ok bye..
	}
	
  }

}
