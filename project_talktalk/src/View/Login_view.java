package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JTextPane;

import server.Protocol;
import server.TalkClient;
import server.TalkClientThread;

public class Login_view extends JFrame {
	//서버단--------------
	//////1-1-4. 나의 소켓을 넣을 통 생성	
	private Socket mySocket = null;
	//////1-1-5. 나의 말을 전달한 inputstream	
	private ObjectInputStream ois  = null;
	//////1-1-6. 다른 사람의 말을 받을 outputstream	
	private ObjectOutputStream oos = null;		
	//////1-1-7. Server의 ip와 port를 가져옴.
	String ip = "localhost";
	int port = 3002;
	/////////////////////////////
	TalkClient tc = null;
	private TalkClientThread tct = null;
	public void connect_process() {
		try {
			//////3-2.서버에 접속과 동시에  클라이언트의 소켓 생성
			//통신은 지연될 수 있다.-wait - try...catch해야함. 연결 ㄱㄱ TalkServer대로 작동 시작 ㄱㄱ
			setMySocket(new Socket(ip,port));
			//////3-3.내가 입력한 정보를 서버에게 보내는 통로
			setOos(new ObjectOutputStream
					(getMySocket().getOutputStream()));			
			//////3-4. 서버로부터 정보를 받는 통로
			setOis(new ObjectInputStream
						(getMySocket().getInputStream()));
			//////TalkServerThread안의 2-4인 이부분으로  String msg = (String)ois.readObject();부분으로 이 값이 넘어간다.
			//Protocol.ACCESS만 넣으면 숫자이기 때문에  +""을 붙여서 문자 처리 될 수 있게 해줌.
			getOos().writeObject(Protocol.ACCESS+"");
			//////3-10. 나의 스래드가 담긴 주소번지를 담아서 TalkClientThread에 넣어줌 ㄱㄱ
			setTct(new TalkClientThread(this));
			//////3-11. TalkClientThread의 run호출!
			getTct().start();//TalkClientThread의 run호출됨.-콜백함수
		} catch (Exception e) {
			//////3-12. 엘러를 알려줌
			System.out.println(e.toString());//에러 힌트문 출력.
		}		
	}	
	
	public void loginSuccess(int loginTrueFalse,String loginMsg) {
		JOptionPane.showMessageDialog(null, loginMsg, "로그인", JOptionPane.INFORMATION_MESSAGE);
		//////성공했을때만 루프가 돌아가면 됨.
		if(loginTrueFalse==1) {
			this.setVisible(false);
			tc = new TalkClient(this);
		}
	}
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
	public Login_view() {
		initialize();
		connect_process();
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

	public Socket getMySocket() {
		return mySocket;
	}

	public void setMySocket(Socket mySocket) {
		this.mySocket = mySocket;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public TalkClientThread getTct() {
		return tct;
	}

	public void setTct(TalkClientThread tct) {
		this.tct = tct;
	}
}
///End of This Class ///End of This Class ///End of This Class ///End of This Class ///End of This Class 
