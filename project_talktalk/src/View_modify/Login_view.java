package View_modify;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JTextPane;

public class Login_view extends JFrame {

//Declare
	LogView_Panel 	logView_Panel                    ;  // 로그인 베이스 패널 임포트 
	JTextField 		logView_MemberNo_jtf         	 ; // 사원번호 입력창 
	JTextField		logView_MemberPw_jtf         	 ; // 비밀번호 입력창
	JTextPane 		logView_MemberPw_jtp             ; // 패스워드 안내 라벨
	JTextPane 		logView_MemberNo_jtp             ; // 사원번호 안내 라벨
	JButton 		logView_Login_Button             ; // 로그인 버튼
	JButton 		logView_Join_Button              ; // 회원 가입 버튼
	JLabel 			lbl_img                          ; // 이미지 라벨
	///End of Declare///End of Declare///End of Declare///End of Declare///End of Declare///End of Declare///End of Declare
	/**
	 * Create the application.
	 */
	public Login_view() { //생성자
		initialize(); // 화면 출력 메소드 실행
	}
	/////End of Const	/////End of Const	/////End of Const	/////End of Const	/////End of Const
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { // 화면 출력 메소드

		this.setContentPane(logView_Panel = new LogView_Panel()); // 로그인 페널 생성 및 프레임에 부착
		
		this.add(logView_MemberNo_jtp = new JTextPane()); // 사원번호 안내  페인 생성 사원번호 안내 프레임에 부착
		logView_MemberNo_jtp.setForeground(Color.WHITE); // 사원 번호안내 페인 글자색
		logView_MemberNo_jtp.setText("EmployeeNO"); // 사원 번호 안내 페인 문구 
		logView_MemberNo_jtp.setFont(new Font("Arial Black", Font.BOLD, 14)); // 사원번호 안내 페인 문구 지정
		logView_MemberNo_jtp.setOpaque(false); // 사원번호 안내 페인 내부 채우기 해제
		logView_MemberNo_jtp.setBorder(null); // 사원번 호 안내 페인 경계 없애기
		logView_MemberNo_jtp.setBounds(44, 253, 130, 30); // 사원번호 안내 페인 위치 지정
		
		this.add(logView_MemberPw_jtp = new JTextPane()); //비밀번호 안내 페인 생성  및 부착 
		logView_MemberPw_jtp.setForeground(Color.WHITE); //비밀번호 안내 페인 글자색 지정
		logView_MemberPw_jtp.setText("PASSWORD"); //페인 내부 글자 생성
		logView_MemberPw_jtp.setOpaque(false); // 페인 내부 채우기 해제
		logView_MemberPw_jtp.setBorder(null); // 비밀번호 페인 경계값 0 
		logView_MemberPw_jtp.setFont(new Font("Arial Black", Font.BOLD, 14)); // 비밀번호 폐인   문구 지정
		logView_MemberPw_jtp.setBounds(47, 302, 120, 25); // 비밀번호 문구 위치 지정
		
		this.add(logView_MemberNo_jtf = new JTextField()); // 사원번호 입력창 생성 및 부착
		logView_MemberNo_jtf.setBounds(181, 259, 106, 25); // 사원 번호 입력창 위치 지정
		logView_MemberNo_jtf.setColumns(10); // 사원 번호 입력창 컬럼추가
		
		this.add(logView_MemberPw_jtf = new JTextField()); //비밀번호 입력창 생성 및 프레임에 부착
		logView_MemberPw_jtf.setBounds(181, 302, 106, 25); // 비밀번호 입력창 위치 지정
		logView_MemberPw_jtf.setColumns(10); // 비밀번호 입력창에 컬럼 크기 추가
		
		
		this.add(logView_Login_Button = new JButton("LOGIN")); // 로그인 버튼 생성 및 프레임에 부착
		logView_Login_Button.setForeground(Color.WHITE); // 로그인버튼 글자색 지정
		logView_Login_Button.setBackground(SystemColor.activeCaption); //로그인 버튼 배경색 지정
		logView_Login_Button.setFont(new Font("Arial Black", Font.BOLD, 13)); //로그인 버튼  문구 서식 지정
		logView_Login_Button.setBounds(194, 388, 108, 30); // 로그인 버튼 위치 지정
		logView_Login_Button.addActionListener(new Login_Ctrl(this)); // 로그인 버튼 액션 리스너
		
		this.add(logView_Join_Button = new JButton("Join")); // 회원가입 버튼 생성 및 프레임에 부착
		logView_Join_Button.setForeground(Color.WHITE);  // 회원가입 버튼 글자색 지정
		logView_Join_Button.setBackground(SystemColor.activeCaption); // 회원가입 버튼 배경색 지정
		logView_Join_Button.setFont(new Font("Arial Black", Font.BOLD, 13)); // 회원 가입 버튼 글자색 세팅
		logView_Join_Button.setBounds(43, 388, 108, 30); //회원가입 버튼 위치 지정
		logView_Join_Button.addActionListener(new Login_Ctrl(this)); // 회원가입 버튼 액션 리스너
		
///// End of Set panel///// End of Set panel///// End of Set panel///// End of Set panel		
		this.setTitle("아라상사 메신져"); // 프레임 타이틀 세팅
		this.setResizable(false); //프레임 사이즈변경 잠금
		this.setBackground(new Color(255, 245, 238)); // 프레임 배경색 지정
		this.setBounds(0, 0, 350, 500); // 프레임 크기 지정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 프레임 종료시 할당 자원 반납
		this.setLayout(null); //프레임 레이아웃 앱솔루트
		this.setDefaultLookAndFeelDecorated(true); // 프레임 테마 전환
		this.setVisible(true); //프레임 출력
	///// End of Set base Frame	///// End of Set base Frame	///// End of Set base Frame	///// End of Set base Frame
	}
	/////End of initialize	/////End of initialize	/////End of initialize	/////End of initialize	/////End of initialize
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // 메인 문구
		Login_view window = new Login_view(); 
			}
			//////End of This Launch the application			//////End of This Launch the application			//////End of This Launch the application
}
///End of This Class ///End of This Class ///End of This Class ///End of This Class ///End of This Class 
