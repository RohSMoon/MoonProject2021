package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import project_talk.Protocol;

public class Login_Ctrl implements ActionListener{
	Login_view login_view ;
	public Login_Ctrl(Login_view login_view) {
		this.login_view = login_view;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj==login_view.logView_Login_Button) {
			System.out.println("로그인버튼 호출 성공");
			//로그인 받는 부분 
			String mem_no = login_view.logView_MemberNo_jtf.getText();
			String mem_pw = login_view.logView_MemberPw_jtf.getText();
			try {
				//로그인 회원 번호랑 비밀번호를 서버에게 전송
				login_view.tc.oos.writeObject(Protocol.LOGIN+Protocol.seperator+mem_no+Protocol.seperator+mem_pw);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (obj==login_view.logView_Join_Button) {
			System.out.println("회원 가입 버튼 호출 성공");
			SignUp_View signUp_View = new SignUp_View();
		}
	}
	
	
}
