package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Management_Dialog_Ctrl implements ActionListener {
	Management_Dialog_View management_Dialog_View; // 매니져 수정창 선언
	
	Management_Dialog_Ctrl(Management_Dialog_View management_Dialog_View){
	this.management_Dialog_View = management_Dialog_View; // 매니져 수정창 동기화
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			Object obj = e.getSource();
			
			//확인버튼 액션
		 if (management_Dialog_View.jbtn_Submit==obj) {
			System.out.println("확인버튼");
			///////// 각 텍스프 필드에서 값을 받아옴
			String xxx = management_Dialog_View.jtf_MemNO.getText(); // 창에 입력한 사원번호 값받아오기 변수 변경 필요
			String yyy = management_Dialog_View.jtf_MemName.getText();// 창에 입력한  사원이름 값받아오기 변수 변경 필요
			String aaa = management_Dialog_View.jtf_DeptName.getText();// 창에 입력한  부서이름 값받아오기 변수 변경 필요
			String ccc = management_Dialog_View.jtf_Level.getText(); // 창에 입력한  직급 값받아오기 변수 변경 필요
			
		}
		
		//수정창 닫기버튼 액션
		else if (management_Dialog_View.jbtn_Cancel==obj) {
			System.out.println("닫기 버튼");
			this.management_Dialog_View.dispose();
		}
		
	}
	
}
