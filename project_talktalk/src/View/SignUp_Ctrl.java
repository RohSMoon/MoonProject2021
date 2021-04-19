package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp_Ctrl implements ActionListener {
	SignUp_View signUp_View; 
	
	public SignUp_Ctrl(SignUp_View signUp_View) {
		this.signUp_View = signUp_View;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (signUp_View.signUpView_Submit_jbtn == obj) {
	///***********************************************//// 회원가입 입력부		
			String aaa = signUp_View.signUpView_MemberName_Name.getText();
//			 JTEXTFIELD 에서 이름받아오는 거
			String bbb = signUp_View.signUpView_Pw_jtf.getText();
//			 JTEXTFIELD 에서 패스워드 받아오는거
			String ccc = signUp_View.signUpView_MemeberNo_jtf.getText();
//			JTEXTFIELD 에서 사원번호 받아오는거
			Object ddd = signUp_View.signUpView_DeptComboBox.getSelectedItem();
//			 부서 콤보박스에서 선택된거 받아오기
			Object eee = signUp_View.signUpView_EmpLevelComboBox.getSelectedItem();
//			직급 콤보에서 선택된거 받아오기
			System.out.println("제출버튼");
//			이 뒤로는 제출버튼 눌리고 서버 -> DB 실행문
		}
		 
		if (signUp_View.signUpView_Cancel_jbtn == obj) {
			signUp_View.dispose();
		}
		
	}

}
