package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			
			login_view.dispose();
			
			MenuList_View menuList_View = new MenuList_View();
			
		}
		if (obj==login_view.logView_Join_Button) {
			System.out.println("회원 가입 버튼 호출 성공");
			SignUp_View signUp_View = new SignUp_View();
		}
	}
	
	
}
