package View_modify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Ctrl implements ActionListener{  // 로그인 컨트롤러 작동
	Login_view login_view ; //로그인 뷰 선언
	public Login_Ctrl(Login_view login_view) { // 생성자 파라미터 값으로 해당 정보 받음
		this.login_view = login_view; // 변수에 동기화
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); // 반응 되는 이벤트는 객체형으로 모두 받는다.
		if (obj==login_view.logView_Login_Button) { // 만약 로그인 버튼 눌러
			System.out.println("로그인버튼 호출 성공"); // 확인용 출력문구
//  ******** 로그인 받는 부분 
		String abc = login_view.logView_MemberNo_jtf.getText(); // 입력창에 받은 사원번호 값 받기
		String abcd = login_view.logView_MemberPw_jtf.getText(); // 비밀번호 입력창에 값 받기
			
			
			login_view.dispose();  // 맞으면 로그인뷰 꺼진다			
			MenuList_View menuList_View = new MenuList_View(); // 메뉴리스트가 켜진다
			
			
		}
		if (obj==login_view.logView_Join_Button) {  //회원가입버튼을 누른다
			System.out.println("회원 가입 버튼 호출 성공"); // 확인용 출력문구
			SignUp_View signUp_View = new SignUp_View(); // 회원가입 창 생성.
		}
	}
	
	
}
