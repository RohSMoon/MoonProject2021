package View_modify;

import java.awt.Color;

import javax.swing.JPanel;

public class Config_Base_Panel extends JPanel {
	MenuList_View menuList_View; //베이스페널을 계속 갖고 있기 때문에 들고 있어야해
	
	public Config_Base_Panel(MenuList_View menuList_View ) { // 생성자
		this.menuList_View = menuList_View; // 동기화
		initialize(); // 화면 출력 메소드 실행
	}
	
	private void initialize() { 
		
	
	this.setBackground(Color.WHITE);   // 패널 배경색 지정    
	this.setBounds(0, 0, 272, 430);    // 패널  위치지정     
	this.setLayout(null);              // 패널 레이아웃 앱솔루트 
	
	this.add(new Config_Main_Panel(this, menuList_View));//베이스가 실행될때 기본적으로 메인패널이 붙는다.
	}
	
}
