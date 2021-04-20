package View;

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
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JTextPane;

import server.TalkClient;

public class Login_view extends JFrame {

	//////로그인 메소드
	public void loginSuccess(int loginTrueFalse,String loginMsg) {
		JOptionPane.showMessageDialog(null, loginMsg, "로그인", JOptionPane.INFORMATION_MESSAGE);
		//////성공했을때만 루프가 돌아가면 됨.
		if(loginTrueFalse==1) {
			this.setVisible(false);
			//login_view.dispose(); /////////얘뭐야
			MenuList_View menuList_View = new MenuList_View();
		}
	}
	//////회원가입 메소드
	public void signupSuccess(String signupResult) {
			System.out.println(signupResult);
			JOptionPane.showMessageDialog(null, "정보 메시지 내용", "정보 메시지 제목", JOptionPane.INFORMATION_MESSAGE);
	}
	//////////////////////////////////////////
//Declare
	LogView_Panel 	logView_Panel                    ;
	JTextField 		logView_MemberNo_jtf         	 ;
	JTextField		logView_MemberPw_jtf         	 ;
	JTextPane 		logView_MemberPw_jtp             ;
	JTextPane 		logView_MemberNo_jtp             ;
	JButton 		logView_Login_Button             ;
	JButton 		logView_Join_Button              ;
	JLabel 			lbl_img                          ;
	Login_Ctrl		login_Ctrl						 ;
	///End of Declare///End of Declare///End of Declare///End of Declare///End of Declare///End of Declare///End of Declare
	/**
	 * Create the application.
	 */
	TalkClient tc = null;
	public Login_view() {
		initialize();
		//소켓이 생성되면서 서버와 연결
		tc = new TalkClient(this);
	}
	/////End of Const	/////End of Const	/////End of Const	/////End of Const	/////End of Const
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		logView_Panel = new LogView_Panel();
		this.setContentPane(logView_Panel);
		
		logView_MemberNo_jtp = new JTextPane();
		logView_MemberNo_jtp.setForeground(Color.WHITE);
		logView_MemberNo_jtp.setText("EmployeeNO");
		logView_MemberNo_jtp.setFont(new Font("Arial Black", Font.BOLD, 14));
		logView_MemberNo_jtp.setOpaque(false);
		logView_MemberNo_jtp.setBorder(null);
		logView_MemberNo_jtp.setBounds(44, 253, 130, 30);
		this.add(logView_MemberNo_jtp);
		
		logView_MemberPw_jtp = new JTextPane();
		logView_MemberPw_jtp.setForeground(Color.WHITE);
		logView_MemberPw_jtp.setText("PASSWORD");
		logView_MemberPw_jtp.setOpaque(false);
		logView_MemberPw_jtp.setBorder(null);
		logView_MemberPw_jtp.setFont(new Font("Arial Black", Font.BOLD, 14)); 
		logView_MemberPw_jtp.setBounds(47, 302, 120, 25);
		this.add(logView_MemberPw_jtp);
		
		logView_MemberNo_jtf = new JTextField();
		logView_MemberNo_jtf.setBounds(181, 259, 106, 25);
		this.add(logView_MemberNo_jtf);
		logView_MemberNo_jtf.setColumns(10);
		
		logView_MemberPw_jtf = new JTextField();
		logView_MemberPw_jtf.setBounds(181, 302, 106, 25);
		this.add(logView_MemberPw_jtf);
		logView_MemberPw_jtf.setColumns(10);
		
		login_Ctrl = new Login_Ctrl(this);
		
		logView_Login_Button = new JButton("LOGIN");
		logView_Login_Button.setForeground(Color.WHITE);
		logView_Login_Button.setBackground(SystemColor.activeCaption);
		logView_Login_Button.setFont(new Font("Arial Black", Font.BOLD, 13));
		logView_Login_Button.setBounds(194, 388, 108, 30);
		this.add(logView_Login_Button);
		logView_Login_Button.addActionListener(login_Ctrl);
		
		logView_Join_Button = new JButton("Join");
		logView_Join_Button.setForeground(Color.WHITE);
		logView_Join_Button.setBackground(SystemColor.activeCaption);
		logView_Join_Button.setFont(new Font("Arial Black", Font.BOLD, 13));
		logView_Join_Button.setBounds(43, 388, 108, 30);
		this.add(logView_Join_Button);
		logView_Join_Button.addActionListener(login_Ctrl);
		
		lbl_img = new JLabel("중앙패널");
		lbl_img.setForeground(Color.WHITE);
		lbl_img.setBackground(Color.WHITE);
		lbl_img.setIcon(new ImageIcon(Login_view.class.getResource("/imgs/login.png")));
		this.add(lbl_img, BorderLayout.CENTER);
///// End of Set panel///// End of Set panel///// End of Set panel///// End of Set panel		
		this.setTitle("아라상사 메신져");
		this.setResizable(false);
		this.setBackground(new Color(255, 245, 238));
		this.setBounds(0, 0, 350, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setDefaultLookAndFeelDecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	///// End of Set base Frame	///// End of Set base Frame	///// End of Set base Frame	///// End of Set base Frame
	}
	/////End of initialize	/////End of initialize	/////End of initialize	/////End of initialize	/////End of initialize
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login_view window = new Login_view();
			}
			//////End of This Launch the application			//////End of This Launch the application			//////End of This Launch the application
	
}
///End of This Class ///End of This Class ///End of This Class ///End of This Class ///End of This Class 
