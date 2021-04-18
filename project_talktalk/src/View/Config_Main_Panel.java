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
import java.awt.SystemColor;

public class Config_Main_Panel extends JPanel {
	//// Declare	//// Declare	//// Declare
	JPanel 		config_Main_Panel 	     ;
	JButton 	userInfo_jbtn 		     ;
	JButton 	changeStatus_jbtn 	     ;
	JButton 	LogOut_jbtn 		     ;
	JLabel 		jbl_chatListTitle 	     ;
	String 		imgPath = "/src/imgs/"   ;
	Config_Panel_Ctrl config_Panel_Ctrl	 ;
	MenuList_View menuList_View			 ;
	/////End of Declare	/////End of Declare	/////End of Declare  

	/**
	 * Create the application.
	 * @param menuList_View 
	 */
	public Config_Main_Panel(MenuList_View menuList_View) {
		initialize(menuList_View);
	}
	//////// End of Const //////End of Const///// End of Const///////// End of Const///////// End of Const///////// End of Const/////

	/**
	 * Initialize the contents of the frame.
	 * @param menuList_View2 
	 */
	private void initialize(MenuList_View menuList_View) {
/////////////추가패널 부분
		this.menuList_View = menuList_View;
//		config_Main_Panel = new JPanel();
//		config_Main_Panel.setBackground(Color.WHITE);
//		config_Main_Panel.setBounds(65, 0, 272, 430);
//		config_Main_Panel.setBounds(0, 0, 272, 430);
//		this.add(config_Main_Panel);
//		config_Main_Panel.setLayout(null);
		
		this.setBackground(Color.WHITE); 
		this.setBounds(0, 0, 272, 430);  
		this.setLayout(null);            
		
		config_Panel_Ctrl= new Config_Panel_Ctrl(this, this.menuList_View);
		
		userInfo_jbtn = new JButton("사용자 정보");
		userInfo_jbtn.setForeground(new Color(240, 255, 240));
		userInfo_jbtn.setOpaque(true);
		userInfo_jbtn.setBorderPainted(true);
		userInfo_jbtn.setContentAreaFilled(true);
		userInfo_jbtn.setBounds(51, 132, 170, 30);
		userInfo_jbtn.setBackground(new Color(30, 144, 255));
		this.add(userInfo_jbtn);
		userInfo_jbtn.addActionListener(config_Panel_Ctrl);
		
		
		changeStatus_jbtn = new JButton("상태 변경");
		changeStatus_jbtn.setForeground(new Color(240, 255, 240));
		changeStatus_jbtn.setOpaque(true);
		changeStatus_jbtn.setBorderPainted(true);
		changeStatus_jbtn.setContentAreaFilled(true);
		changeStatus_jbtn.setBounds(51, 232, 170, 30);
		changeStatus_jbtn.setBackground(new Color(30, 144, 255));
		this.add(changeStatus_jbtn);
		changeStatus_jbtn.addActionListener(config_Panel_Ctrl);

		LogOut_jbtn = new JButton("로그아웃");
		LogOut_jbtn.setForeground(new Color(240, 255, 240));
		LogOut_jbtn.setOpaque(true);
		LogOut_jbtn.setBorderPainted(true);
		LogOut_jbtn.setContentAreaFilled(true);
		LogOut_jbtn.setBounds(51, 332, 170, 30);
		LogOut_jbtn.setBackground(new Color(30, 144, 255));
		this.add(LogOut_jbtn);
		LogOut_jbtn.addActionListener(config_Panel_Ctrl);
		
		jbl_chatListTitle = new JLabel("Configuration★");
		jbl_chatListTitle.setFont(new Font("굴림", Font.BOLD, 12));
		jbl_chatListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jbl_chatListTitle.setBounds(56, 25, 160, 20);
		this.add(jbl_chatListTitle);
		///////////////End of set inside Panel

////////////////////////////////////
//		JPanel MenuPanel = new JPanel();
//		MenuPanel.setBackground(Color.WHITE);
//		MenuPanel.setForeground(Color.PINK);
//		MenuPanel.setBounds(0, 0, 65, 463);
//		MenuPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
//		getContentPane().add(MenuPanel);
	
		
//		this.setBackground(Color.WHITE);
//		this.setBounds(100, 100, 350, 500 );
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		getContentPane().setLayout(null);
//		this.setTitle("아라 상사 메신져");
//		this.setVisible(true);
		
		/// Del after part Test/// Del after part Test/// Del after part Test/// Del after part Test
	}
	//////End of initialize	//////End of initialize	//////End of initialize	//////End of initialize
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		Config_Main_Panel window = new Config_Main_Panel();
//		};
////////End of 	 * Launch the application. Del after part Test////////End of 	 * Launch the application. Del after part Test
}
///End of This Class   ///End of This Class///End of This Class///End of This Class///End of This Class
