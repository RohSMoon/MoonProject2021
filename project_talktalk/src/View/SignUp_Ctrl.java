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
			System.out.println("제출버튼");
		}
		 
		if (signUp_View.signUpView_Cancel_jbtn == obj) {
			signUp_View.dispose();
		}
		
	}

}
