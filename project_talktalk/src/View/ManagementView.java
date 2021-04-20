package View;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ManagementView extends JFrame{
	
	JMenu				jmenu				;	// 메뉴바에 메뉴 생성
	JMenuBar			jmenubar			;	// 메뉴바
	JMenuItem			selectAllMenuItem	;	// 전체조회 메뉴바 안의 메뉴의 메뉴아이템 
	JMenuItem			checkSignUpMenuItem ;	// 회원가입승인 메뉴바 안의 메뉴의 메뉴아이템
	JMenuItem			updateMenuItem		;	// 수정 메뉴바 안의 메뉴의 메뉴아이템
	JMenuItem			deleteMenuItem		;	// 삭제 메뉴바 안의 메뉴의 메뉴아이템
	String 				cols[] 				= {"사원번호","사원이름","부서이름","직급"}; // 컬럼헤더
	String data[][] 						= new String[0][4];	// 테이블 크기 초기화
	DefaultTableModel   dtm_SignUP          ;	// 테이블 모델 데이타셋
	JTable              jtb_SignUP          ;	// 테이블
	JScrollPane         jsp_SignUP          ;	// 스크롤 페인 
	JTableHeader		jth_SignUP			;	// 테이블 헤더
	Management_Ctrl		management_Ctrl		;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ManagementView window = new ManagementView();
		
	}

	/**
	 * Create the application.
	 */
	public ManagementView() {
		initialize();	// 생성자 안의 화면출력부 메소드
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setLayout(null);		//FRAME 앱솔루트 레이아웃
		jmenubar				= new JMenuBar();	//메뉴바 생성
		jmenu					= new JMenu("메뉴");	//메뉴 바의 메뉴
		selectAllMenuItem		= new JMenuItem("전체조회");	//전체조회 메뉴
		checkSignUpMenuItem		= new JMenuItem("회원가입 승인 관리");		//승인관리 메뉴
		updateMenuItem			= new JMenuItem("수정");	// 수정 메뉴
		deleteMenuItem			= new JMenuItem("삭제");	// 삭제 메뉴
		dtm_SignUP              = new DefaultTableModel(data,cols); //데이타셋 생성  
		jtb_SignUP              = new JTable(dtm_SignUP); //테이블 생성과 데이타셋 주입
		jtb_SignUP.setAutoResizeMode(5); //오토리사이즈 모드 5번
		jsp_SignUP              = new JScrollPane(jtb_SignUP,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
															,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
								//스크롤 페인에 테이블 추가, 스크롤바 종횡으로 필요시 생성
		jth_SignUP				= jtb_SignUP.getTableHeader(); // 테이블 헤더 추가
		jsp_SignUP.setBounds(0, 00, 335, 450);	//스크롤페인 위치 
		
		
		jmenubar.add(			jmenu				); //메뉴바에 메뉴추가
		
		jmenu.add(		selectAllMenuItem			); //메뉴에 전체조회 추가
		selectAllMenuItem.addActionListener(new Management_Ctrl(this));
		
		jmenu.add(		checkSignUpMenuItem			); //메뉴에 회원가입관리 추가
		checkSignUpMenuItem.addActionListener(new Management_Ctrl(this));
		
		jmenu.add(		updateMenuItem				); //메뉴에 수정 추가
		updateMenuItem.addActionListener(new Management_Ctrl(this));
		
		jmenu.add(		deleteMenuItem				); //삭제 추가
		deleteMenuItem.addActionListener(new Management_Ctrl(this));
		
		
		this.setTitle("관리자");		//창 타이틀 
		this.setResizable(false);	//창 크기조절 불가
		this.add(jsp_SignUP);	// 프레임에 스크롤 페인추가
		this.setJMenuBar(			jmenubar		  );// 메뉴바 추가
		this.setBounds(500, 100, 350, 500);	// 프레임 크기와 생성 위치
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//닫기 옵션 추가 
		this.setVisible(true);// 화면 출력
	}

}
