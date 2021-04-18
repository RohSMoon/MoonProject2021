package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JScrollBar;

public class ChatRoomListView extends JPanel {         
	///Declare
//	JPanel 				chatListPanel 				     ;
	JLabel 				jbl_chatListTitle 			     ;
	String 				cols[]		= {"번호","제목","인원"} ;
	String 		    	data[][] 	= new String[0][3]	 ;
	JTable			  	jtb 			                 ;
	JButton 			jbtn_chatSearch 			     ;
	JTextField 			jtf_chatListSearch		         ;
	JScrollPane 		scrollPane 		                 ;
	DefaultTableModel 	dtm                              ;
	////End of Declare 	////End of Declare 	////End of Declare 	////End of Declare 	////End of Declare 

	/**
	 * Create the application.
	 */
	public ChatRoomListView() {
		initialize();
	}////// End of Const////// End of Const////// End of Const////// End of Const
/// End of Const/// End of Const/// End of Const/// End of Const/// End of Const
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
/////////////추가패널 부분
		String imgPath = "/src/imgs/";
//		this = new JPanel();
		
		jbl_chatListTitle = new JLabel("ChatRoom LIST★");
		jbl_chatListTitle.setFont(new Font("굴림", Font.BOLD, 12));
		jbl_chatListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jbl_chatListTitle.setBounds(60, 57, 160, 20);
		this.add(jbl_chatListTitle);
	
		jtf_chatListSearch = new JTextField();
		jtf_chatListSearch = new JTextField();
		jtf_chatListSearch.setBounds(50, 22, 134, 20);
		jtf_chatListSearch.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		this.add(jtf_chatListSearch);
		jtf_chatListSearch.setColumns(10);
		
		jbtn_chatSearch = new JButton(
		new ImageIcon(imgPath+"search.png"));
		jbtn_chatSearch.setOpaque(false);
		jbtn_chatSearch.setBorderPainted(false);
		jbtn_chatSearch.setContentAreaFilled(true);
		jbtn_chatSearch.setBounds(205, 17, 30, 30);
		jbtn_chatSearch.setBackground(Color.WHITE);
		this.add(jbtn_chatSearch);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 87, 248, 343);
		this.add(scrollPane);
		dtm = new DefaultTableModel(data,cols);
		jtb = new JTable(dtm);
		scrollPane.setViewportView(jtb);
		jtb.setBorder(UIManager.getBorder("Tree.editorBorder"));
		jtb.setShowVerticalLines(false);
		
//////// 채팅 리스트 패널 ////  //// 마지막에 기준 프레임 지워서 치는 것///////
		
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 272, 430);
//		this.setBounds(65, 0, 272, 430);
//		getContentPane().add(this);
		this.setLayout(null);
////////////////
		
//		JPanel MenuPanel = new JPanel();
//		MenuPanel.setBackground(Color.WHITE);
//		MenuPanel.setForeground(Color.PINK);
//		MenuPanel.setBounds(0, 0, 65, 463);
//		MenuPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
//		getContentPane().add(MenuPanel);
//	
//		
//		this.setBackground(Color.WHITE);
//		this.setBounds(100, 100, 350, 500 );
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		getContentPane().setLayout(null);
//		this.setTitle("아라 상사 메신져");
//		this.setVisible(true);
//		
	//// Del Afte Part Test//// Del Afte Part Test//// Del Afte Part Test//// Del Afte Part Test
	}
////// End of initialize////// End of initialize////// End of initialize////// End of initialize////// End of initialize
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		ChatRoomListView window = new ChatRoomListView();
//		};
/// Del After Part Test
} ///End of This Class0 ///End of This Class ///End of This Class
