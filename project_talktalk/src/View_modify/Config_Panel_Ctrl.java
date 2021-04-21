package View_modify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Config_Panel_Ctrl implements ActionListener {
	Config_Main_Panel config_Main_Panel; // 주입되는 패널 클래스 선언
	Config_Base_Panel config_Base_Panel; // 주입되는 패널 클래스 선언
	MenuList_View menuList_View;//주입되는 패널 클래스 선언
	Config_Panel_Ctrl(Config_Main_Panel config_Main_Panel, Config_Base_Panel config_Base_Panel, MenuList_View menuList_View){ // 생성자 파라미터 뷰
		this.config_Base_Panel = config_Base_Panel; // 선언문과 동기화
		this.config_Main_Panel = config_Main_Panel; // 선언문과 동기화
		this.menuList_View = menuList_View; // 선언문과 동기화
	}
	private void Remover() { // 지우는 메소드

		this.config_Base_Panel.removeAll(); // 베이스 패널 위에 모두 지워준다
		this.config_Base_Panel.revalidate(); // 베이스 패널 조정
		this.config_Base_Panel.repaint(); // 베이스 패널을 다시 출력 리 페인팅
		
	}

	@Override
	public void actionPerformed(ActionEvent cae) {// 액션 리스너
		Object obj = cae.getSource(); // 느껴지는 액션 담아
		if (config_Main_Panel.userInfo_jbtn==obj) {// 사용자 정보 감지되면
			Remover();
			this.config_Base_Panel.add(new Config_UserInfo_Panel()); // 인포패널 쨘
			
		}
		if (config_Main_Panel.changeStatus_jbtn==obj) { // 상태 바꾸기창 버튼 느껴진다면
			Remover();
			this.config_Base_Panel.add(new Config_Status_Change_Panel()); //짜잔하고열어 재껴 상태창
		}
		if (config_Main_Panel.LogOut_jbtn==obj) { //로그아웃 버튼이 온다면
			System.exit(0); // JVM 꺼진닷
		}
	}
}
