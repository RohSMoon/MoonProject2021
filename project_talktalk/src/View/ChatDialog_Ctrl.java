package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatDialog_Ctrl implements ActionListener {
	ChatDialog_View chatDialog_View;
	public ChatDialog_Ctrl(ChatDialog_View chatDialog_View) {
	this.chatDialog_View = chatDialog_View;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
	if (obj==chatDialog_View.send_jbtn) {
		System.out.println("전송버튼");
	}
	
	
	if (obj==chatDialog_View.closs_jbtn) {
		System.out.println("닫기버튼");
		this.chatDialog_View.dispose();
	}
	
	
	if (obj==chatDialog_View.Emoji_jbtn) {
		System.out.println("이모티콘 버튼");
	}
	
	
	if (obj==chatDialog_View.SendFile_jbtn) {
		System.out.println("파일전송 버튼");
	}
	
	
	if (obj==chatDialog_View.chatInvite_MenuItem) {
		System.out.println("초대하기 메뉴");
	}
	
	
	if (obj==chatDialog_View.chatOut_MenuItem) {
		System.out.println("방나가기");
		
		this.chatDialog_View.dispose();
	}
	
  }

}
