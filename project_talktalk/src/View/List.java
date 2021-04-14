package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
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
import javax.swing.JScrollBar;

public class List extends JFrame {

	 JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		List window = new List();
			}

	/**
	 * Create the application.
	 */
	public List() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		//String imgPath = "D:/Users/rsmoo/eclipse-workspace/Project2/src/imgs";
		String imgPath = "D://Users/rsmoo/eclipse-workspace/Project2/src/imgs/";
		
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(Color.WHITE);
		MenuPanel.setForeground(Color.PINK);
		MenuPanel.setBounds(0, 0, 65, 463);
		MenuPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		this.getContentPane().add(MenuPanel);
		///////////////////////////////////
		
		JButton empList = new JButton(
				new ImageIcon(imgPath+"empList.png"));
		empList.setOpaque(false);
		empList.setBorderPainted(false);
		empList.setContentAreaFilled(true);
		empList.setBackground(Color.WHITE);
		MenuPanel.add(empList);
		
		JButton chatList = new JButton(
				new ImageIcon(imgPath+"chatList.png"));
		chatList.setOpaque(false);
		chatList.setBorderPainted(false);
		chatList.setContentAreaFilled(true);
		chatList.setBackground(Color.WHITE);
		MenuPanel.add(chatList);
		
		JButton groupChatList = new JButton(
				new ImageIcon(imgPath+"groupChatList.png"));
		groupChatList.setOpaque(false);
		groupChatList.setBorderPainted(false);
		groupChatList.setContentAreaFilled(true);
		groupChatList.setBackground(Color.WHITE);
		MenuPanel.add(groupChatList);
		
		JButton config = new JButton(
				new ImageIcon(imgPath+"config.png"));
		config.setOpaque(false);
		config.setBorderPainted(false);
		config.setContentAreaFilled(true);
		config.setBackground(Color.WHITE);
		MenuPanel.add(config);
		///////////////////////////////
		
		JPanel empListPanel = new JPanel();
		empListPanel.setBackground(Color.WHITE);
		empListPanel.setBounds(65, 0, 269, 431);
		getContentPane().add(empListPanel);
		empListPanel.setLayout(null);
		
		
		JTextField jtf_empListSearch = new JTextField();
		jtf_empListSearch.setBounds(50, 22, 134, 20);
		jtf_empListSearch.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		empListPanel.add(jtf_empListSearch);
		jtf_empListSearch.setColumns(10);
		
		JLabel jbl_ListTitle = new JLabel("DEPARTMENT LIST★");
		jbl_ListTitle.setFont(new Font("굴림", Font.BOLD, 12));
		jbl_ListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jbl_ListTitle.setBounds(40, 57, 160, 20);
		empListPanel.add(jbl_ListTitle);
		
		JLabel jbl_ListTitleBackDecoBox = new JLabel();
		jbl_ListTitleBackDecoBox.setBackground(Color.darkGray);
		jbl_ListTitleBackDecoBox.setBounds(35, 70, 160, 20);
		empListPanel.add(jbl_ListTitleBackDecoBox);
		
		
		JButton jbtn_search = new JButton(
		new ImageIcon(imgPath+"search.png"));
		jbtn_search.setOpaque(false);
		jbtn_search.setBorderPainted(false);
		jbtn_search.setContentAreaFilled(true);
		jbtn_search.setBounds(205, 17, 30, 30);
		jbtn_search.setBackground(Color.WHITE);
		empListPanel.add(jbtn_search);
		
		JButton jbtn_CreateChat = new JButton(
				new ImageIcon(imgPath+"plus.png"));
		jbtn_CreateChat.setOpaque(false);
		jbtn_CreateChat.setBorderPainted(false);
		jbtn_CreateChat.setContentAreaFilled(true);
		jbtn_CreateChat.setBounds(205, 53, 30, 30);
		jbtn_CreateChat.setBackground(Color.WHITE);
		empListPanel.add(jbtn_CreateChat);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
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
				}
			}
		));
		tree.setBounds(12, 100, 248, 320);
		empListPanel.add(tree);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(228, 0, 20, 320);
		tree.add(scrollBar);
		
		
		JPanel BottomTimePanel = new JPanel();
		BottomTimePanel.setBackground(Color.WHITE);
		BottomTimePanel.setBounds(65, 430, 272, 33);
		this.getContentPane().add(BottomTimePanel);
		BottomTimePanel.setLayout(null);
		
		JLabel TimeLabel = new JLabel("시간");
		TimeLabel.setFont(new Font("굴림", Font.BOLD, 12));
		TimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		TimeLabel.setBounds(60, 10, 200, 15);
		BottomTimePanel.add(TimeLabel);
		
		this.getContentPane().setBackground(Color.WHITE);
		this.setBounds(100, 100, 350, 500 );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setTitle("아라 상사 메신져");
		this.setVisible(true);
	}
}
