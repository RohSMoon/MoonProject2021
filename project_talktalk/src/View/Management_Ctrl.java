package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JTextField;

public class Management_Ctrl implements ActionListener {
	ManagementView managementView; // 매니져창 선언
	
	
	Management_Ctrl(ManagementView managementView){
	this.managementView = managementView; // 선언된 창과 동기화
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Object obj = e.getSource(); 
		
		
		//전체조회메뉴 액션
		if (this.managementView.selectAllMenuItem==obj) {
			System.out.println("전체 조회");
		}
		
		//회원가입승인메뉴 액션
		else if (this.managementView.checkSignUpMenuItem==obj) {
			System.out.println("회원가입 관리");
		}
		
		//수정메뉴 액션
		else if (this.managementView.updateMenuItem==obj) {
			System.out.println("수정 ");
			new Management_Dialog_View();
		}
		
		//삭제메뉴 액션
		else if (this.managementView.deleteMenuItem==obj) {
			System.out.println("삭제");
			
		}
		
		
	}
	
}
