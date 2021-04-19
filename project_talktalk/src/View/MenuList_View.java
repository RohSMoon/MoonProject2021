package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JScrollPane;

public class MenuList_View extends JFrame {
	JTree memberListTree								  ;	
	JPanel basementPanel									  ;
	JPanel memberListPanel					              ;
	JPanel MenuPanel 					                  ;
	JPanel bottomTimePanel                                ;
	JLabel listTitle_jbl 				                  ;
	JLabel listTitleBackDecoBox_jbl		                  ;
	JLabel TimeLabel                                      ;
	JButton memberList_jbtn_MenuPanel 	                  ;
	JButton chatList_jbtn_MenuPanel		                  ;
	JButton groupChatList_jbtn_MenuPanel                  ;
	JButton config_jbtn_MenuPanel	                      ;
	JButton search_jbtn 				                  ;
	JButton CreateChat_jbtn 				              ;
	JTextField memeberListSearch_jtf_MemberListPanel      ;
	JScrollPane memberListTreeScrollPane		          ;
	CardLayout cardLayout								  ;
	MenuList_Ctrl menuList_Ctrl						  	  ;
	
///////End of Var///////End of Var///////End of Var///////End of Var///////End of Var///////End of Var///////End of Var//
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MenuList_View window = new MenuList_View();
			}

	/**
	 * Create the application.
	 */
	public MenuList_View() {
		initialize();
	}
	///End of Const//////	///End of Const//////	///End of Const//////	///End of Const//////	///End of Const//////	///End of Const//////
	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		String imgPath = "src/imgs/";
		///////////////////////////////////
		
		MenuPanel = new JPanel();
		MenuPanel.setBackground(Color.WHITE);
		MenuPanel.setForeground(Color.PINK);
		MenuPanel.setBounds(0, 0, 65, 463);
		this.add(MenuPanel);
		///////////////////////////////////
		menuList_Ctrl = new MenuList_Ctrl(this);
		
		
		memberList_jbtn_MenuPanel = new JButton(
				new ImageIcon(imgPath+"memberList.png"));
		memberList_jbtn_MenuPanel.setOpaque(false);
		memberList_jbtn_MenuPanel.setBorderPainted(false);
		memberList_jbtn_MenuPanel.setContentAreaFilled(true);
		memberList_jbtn_MenuPanel.setBackground(Color.WHITE);
		MenuPanel.add(memberList_jbtn_MenuPanel);
		memberList_jbtn_MenuPanel.addActionListener(menuList_Ctrl);
		
		
		chatList_jbtn_MenuPanel = new JButton(
				new ImageIcon(imgPath+"chatList.png"));
		chatList_jbtn_MenuPanel.setOpaque(false);
		chatList_jbtn_MenuPanel.setBorderPainted(false);
		chatList_jbtn_MenuPanel.setContentAreaFilled(true);
		chatList_jbtn_MenuPanel.setBackground(Color.WHITE);
		MenuPanel.add(chatList_jbtn_MenuPanel);
		chatList_jbtn_MenuPanel.addActionListener(menuList_Ctrl);
		
		groupChatList_jbtn_MenuPanel = new JButton(
				new ImageIcon(imgPath+"groupchatlist.png"));
		groupChatList_jbtn_MenuPanel.setOpaque(false);
		groupChatList_jbtn_MenuPanel.setBorderPainted(false);
		groupChatList_jbtn_MenuPanel.setContentAreaFilled(true);
		groupChatList_jbtn_MenuPanel.setBackground(Color.WHITE);
		MenuPanel.add(groupChatList_jbtn_MenuPanel);
		groupChatList_jbtn_MenuPanel.addActionListener(menuList_Ctrl);
		
		config_jbtn_MenuPanel = new JButton(
				new ImageIcon(imgPath+"config.png"));
		config_jbtn_MenuPanel.setOpaque(false);
		config_jbtn_MenuPanel.setBorderPainted(false);
		config_jbtn_MenuPanel.setContentAreaFilled(true);
		config_jbtn_MenuPanel.setBackground(Color.WHITE);
		MenuPanel.add(config_jbtn_MenuPanel);
		config_jbtn_MenuPanel.addActionListener(menuList_Ctrl);
		
		/////////////////////////////////
		
		basementPanel = new JPanel();
		basementPanel.setBounds(65, 0, 269, 431);		
		basementPanel.setLayout(null);		
		
		///////////////////////////////
		
		memberListPanel = new JPanel();
		memberListPanel.setLayout(null);
		memberListPanel.setBackground(Color.WHITE);
	//	memberListPanel.setBounds(65, 0, 269, 431);
		memberListPanel.setBounds(0, 0, 269, 431);
		basementPanel.add(memberListPanel);
		//memberListPanel.setLayout(null);
		this.add(basementPanel);
		
	//////////////////////////////	
		memeberListSearch_jtf_MemberListPanel = new JTextField();
		memeberListSearch_jtf_MemberListPanel.setBounds(50, 22, 134, 20);
		memeberListSearch_jtf_MemberListPanel.setBorder
		(new TitledBorder(new LineBorder(Color.black,1)));
		memeberListSearch_jtf_MemberListPanel.setColumns(10);
		memberListPanel.add(memeberListSearch_jtf_MemberListPanel);
		
		listTitle_jbl = new JLabel("DEPARTMENT LIST★");
		listTitle_jbl.setFont(new Font("굴림", Font.BOLD, 12));
		listTitle_jbl.setHorizontalAlignment(SwingConstants.CENTER);
		listTitle_jbl.setBounds(40, 57, 160, 20);
		memberListPanel.add(listTitle_jbl);
		
		listTitleBackDecoBox_jbl = new JLabel();
		listTitleBackDecoBox_jbl.setBackground(Color.darkGray);
		listTitleBackDecoBox_jbl.setBounds(35, 70, 160, 20);
		memberListPanel.add(listTitleBackDecoBox_jbl);
		
		
		search_jbtn = new JButton(
		new ImageIcon(imgPath+"search.png"));
		search_jbtn.setOpaque(false);
		search_jbtn.setBorderPainted(false);
		search_jbtn.setContentAreaFilled(true);
		search_jbtn.setBounds(205, 17, 30, 30);
		search_jbtn.setBackground(Color.WHITE);
		memberListPanel.add(search_jbtn);
		
		CreateChat_jbtn = new JButton(
				new ImageIcon(imgPath+"plus.png"));
		CreateChat_jbtn.setOpaque(false);
		CreateChat_jbtn.setBorderPainted(false);
		CreateChat_jbtn.setContentAreaFilled(true);
		CreateChat_jbtn.setBounds(205, 53, 30, 30);
		CreateChat_jbtn.setBackground(Color.WHITE);
		memberListPanel.add(CreateChat_jbtn);
		CreateChat_jbtn.addActionListener(menuList_Ctrl);
		
		memberListTreeScrollPane = new JScrollPane();
		memberListTreeScrollPane.setBounds(12, 100, 248, 320);
		memberListPanel.add(memberListTreeScrollPane);
		
		memberListTree = new JTree();
		memberListTree.addMouseListener(new MemberList_Ctrl(this));
		memberListTree.addTreeSelectionListener(new MemberList_Ctrl(this));
		memberListTreeScrollPane.setViewportView(memberListTree);
		memberListTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("memberListTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Dept");
						node_1.add(new DefaultMutableTreeNode("Wolverine"+"(상태메시지)"));
						node_1.add(new DefaultMutableTreeNode("Venom"+"(상태메시지)"));
						node_1.add(new DefaultMutableTreeNode("Iron-Man"+"(상태메시지)"));
						add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
						node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
						node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
						node_1.add(new DefaultMutableTreeNode("Thor"));
						node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Dept");
					node_1.add(new DefaultMutableTreeNode("Wolverine"));
					node_1.add(new DefaultMutableTreeNode("Venom"));
					node_1.add(new DefaultMutableTreeNode("Iron-Man"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Dept");
					node_1.add(new DefaultMutableTreeNode("Wolverine"));
					node_1.add(new DefaultMutableTreeNode("Venom"));
					node_1.add(new DefaultMutableTreeNode("Iron-Man"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Dept");
					node_1.add(new DefaultMutableTreeNode("Wolverine"));
					node_1.add(new DefaultMutableTreeNode("Venom"));
					node_1.add(new DefaultMutableTreeNode("Iron-Man"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Dept");
					node_1.add(new DefaultMutableTreeNode("Wolverine"));
					node_1.add(new DefaultMutableTreeNode("Venom"));
					node_1.add(new DefaultMutableTreeNode("Iron-Man"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Dept");
					node_1.add(new DefaultMutableTreeNode("Wolverine"));
					node_1.add(new DefaultMutableTreeNode("Venom"));
					node_1.add(new DefaultMutableTreeNode("Iron-Man"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Dept");
					node_1.add(new DefaultMutableTreeNode("Wolverine"));
					node_1.add(new DefaultMutableTreeNode("Venom"));
					node_1.add(new DefaultMutableTreeNode("Iron-Man"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"+"(상태메시지)"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Dept");
					node_1.add(new DefaultMutableTreeNode("Wolverine"));
					node_1.add(new DefaultMutableTreeNode("Venom"));
					node_1.add(new DefaultMutableTreeNode("Iron-Man"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("CityWar");
					node_1.add(new DefaultMutableTreeNode("CaptainAmerica"));
					node_1.add(new DefaultMutableTreeNode("DoctorStrange"));
					node_1.add(new DefaultMutableTreeNode("Thor"));
					node_1.add(new DefaultMutableTreeNode("Hawk-eye"));
					add(node_1);
					
				}
			}
		));
		
		bottomTimePanel = new JPanel();
		bottomTimePanel.setBackground(Color.WHITE);
		bottomTimePanel.setBounds(65, 430, 272, 33);
		bottomTimePanel.setLayout(null);
		this.add(bottomTimePanel);
		
		TimeLabel = new JLabel("시간");
		TimeLabel.setFont(new Font("굴림", Font.BOLD, 12));
		TimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		TimeLabel.setBounds(60, 10, 200, 15); 
		bottomTimePanel.add(TimeLabel);
		
		this.setBackground(Color.WHITE);
		this.setBounds(100, 100, 350, 500 );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("아라 상사 메신져");
		this.setVisible(true);
	}////End of initialize////End of initialize////End of initialize////End of initialize////End of initialize
}////End of this Class   /// End of this Class////}////End of this Class   /// End of this Class////}////End of this Class   /// End of this Class//// 
