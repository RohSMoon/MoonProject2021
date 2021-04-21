package View;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Management_Dialog_View extends JDialog{
		JLabel jbl_Title;  // 창 타이틀 라벨
		JLabel jbl_MemNO;  // 사원번호 알림 라벨
		JLabel jbl_MemName;	// 사원 이름 알림 라벨
		JLabel jbl_DeptName; // 부서 번호 알림 라벨
		JLabel jbl_Level;	// 직급 알림 라벨
		JTextField jtf_MemNO; // 사원번호 입력창   
		JTextField jtf_MemName; //사원 이름 입력창
		JTextField jtf_DeptName; //부서번호 입력창
		JTextField jtf_Level;   // 직급 입력창
		JButton jbtn_Submit; // 확인버튼
		JButton jbtn_Cancel; // 취소 버튼
		


	/**
	 * Create the application.
	 */
	public Management_Dialog_View() { // 생성자
		initialize();  //  화면 구성 메소드
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {  //화면 출력 메소드
		
		jbl_Title		= new JLabel("관리자 수정");// 관리자 수정 문구 라벨 생성
		jbl_Title.setBounds(130, 20, 100, 20);// 라벨 위치 크기
		jbl_Title.setFont(new Font("굴림", Font.BOLD, 14));// 라벨 문구 
			this.add(jbl_Title); // 창에 라벨 추가
			
		
		jbl_MemNO       = new JLabel("사원번호"); //사원번호 안내 라벨 생성
		jbl_MemNO.setBounds(75, 65, 100, 20); //라벨 위치 
		jbl_MemNO.setFont(new Font("굴림", Font.PLAIN , 13)); //라벨 문구
			this.add(jbl_MemNO); // 창에 라벨 추가
		
		jbl_MemName     = new JLabel("사원이름"); // 사원이름 라벨 생성
		jbl_MemName.setBounds(75, 120, 100, 20); // 사원 이름 라벨 위치
		jbl_MemName.setFont(new Font("굴림", Font.PLAIN, 13)); // 라벨 문구
			this.add(jbl_MemName); // 창에 라벨 추가
		
		jbl_DeptName    = new JLabel("부서이름"); // 부서이름 라벨 생성
		jbl_DeptName.setBounds(75, 175, 100, 20); // 부서이름 라벨 위치
		jbl_DeptName.setFont(new Font("굴림", Font.PLAIN, 13)); // 부서이름라벨 문구 
			this.add(jbl_DeptName); // 창에 라벨 추가
		
		jbl_Level       = new JLabel("직      급"); // 직급 라벨 생성
		jbl_Level.setBounds(75, 230, 100, 20); // 직급 라벨 위치
		jbl_Level.setFont(new Font("굴림", Font.PLAIN, 13)); // 직급 라벨 문구
			this.add(jbl_Level);// 창에 직급 라벨 추가
		
	//////////////////////////////////////	
		 
		 jtf_MemNO      = new JTextField(); // 사원 번호 입력창 생성
		 jtf_MemNO.setBounds(170, 65, 100, 20); // 사원번호 입력창 위치
			this.add(jtf_MemNO); // 사원번호 입력창 추가
		 
		 jtf_MemName    = new JTextField(); // 사원 이름 입력창 생성
		 jtf_MemName.setBounds(170, 120, 100, 20); // 사원 이름 입력창 위치
			this.add(jtf_MemName); // 창에 사원 이름 추가
		 
		 jtf_DeptName   = new JTextField(); // 부서 이름 입력창 생성 
		 jtf_DeptName.setBounds(170, 175, 100, 20); // 부서 이름 입력창 위치
			this.add(jtf_DeptName);// 창에 부서 이름 추가.
		 
		 jtf_Level      = new JTextField(); // 직급 입력창 생성
		 jtf_Level.setBounds(170, 230, 100, 20); // 직급 입력창 위치
			this.add(jtf_Level); // 창에 직급 입력창 추가
		
		jbtn_Submit      = new JButton("확인"); // 확인버튼 생성
		jbtn_Submit.setBounds(65, 280, 80, 35); // 버튼 위치
		jbtn_Submit.setFont(new Font("굴림", Font.BOLD, 14)); // 버튼 문구
		jbtn_Submit.setForeground(Color.WHITE); // 버튼 글자색
		jbtn_Submit.setBackground(SystemColor.activeCaption); // 버튼 배경색
		jbtn_Submit.addActionListener(new Management_Dialog_Ctrl(this)); // 버튼 액션 리스너 추가
			this.add(jbtn_Submit);//창에 버튼 추가
		
		jbtn_Cancel      = new JButton("취소"); // 취소버튼 생성
		jbtn_Cancel.setBounds(195, 280, 80, 35); // 취소버튼 위치
		jbtn_Cancel.setFont(new Font("굴림", Font.BOLD, 14)); // 취소버튼 문구
		jbtn_Cancel.setForeground(Color.WHITE); // 취소버튼 글자 색
		jbtn_Cancel.setBackground(SystemColor.activeCaption); // 버튼 배경색
		jbtn_Cancel.addActionListener(new Management_Dialog_Ctrl(this)); // 버튼 액션리스너
			this.add(jbtn_Cancel); // 창에 버튼 추가
			
			
		this.setLayout(null); // 레아이웃 앱솔루트
		this.setTitle("관리자 수정"); // 창 타이틀 설정
		this.setBounds(200, 200, 350, 400); // 창크기 위치
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //창 닫기 옵션 추가
		this.setVisible(true);// 창 출력
	}

}
