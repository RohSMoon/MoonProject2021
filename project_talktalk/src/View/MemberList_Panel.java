package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MemberList_Panel extends JPanel{
	JTree memberListTree								  ;		                                 
	JPanel memberListPanel					              ;
	JLabel listTitle_jbl 				                  ;
	JLabel listTitleBackDecoBox_jbl		                  ;
	JButton CreateChat_jbtn 				              ;
	JButton search_jbtn 				                  ;
	JTextField memeberListSearch_jtf_MemberListPanel      ;
	JScrollPane memberListTreeScrollPane		          ;
	
	public MemberList_Panel() {
		initialize();
	}
	
	private void initialize() {	
	String imgPath = "/src/imgs/";		
		
	memeberListSearch_jtf_MemberListPanel = new JTextField();
	memeberListSearch_jtf_MemberListPanel.setBounds(50, 22, 134, 20);
	memeberListSearch_jtf_MemberListPanel.setBorder
	(new TitledBorder(new LineBorder(Color.black,1)));
	memeberListSearch_jtf_MemberListPanel.setColumns(10);
	this.add(memeberListSearch_jtf_MemberListPanel);
	
	listTitle_jbl = new JLabel("DEPARTMENT LIST★");
	listTitle_jbl.setFont(new Font("굴림", Font.BOLD, 12));
	listTitle_jbl.setHorizontalAlignment(SwingConstants.CENTER);
	listTitle_jbl.setBounds(40, 57, 160, 20);
	this.add(listTitle_jbl);
	
	listTitleBackDecoBox_jbl = new JLabel();
	listTitleBackDecoBox_jbl.setBackground(Color.darkGray);
	listTitleBackDecoBox_jbl.setBounds(35, 70, 160, 20);
	this.add(listTitleBackDecoBox_jbl);
	
	
	search_jbtn = new JButton(
	new ImageIcon(imgPath+"search.png"));
	search_jbtn.setOpaque(false);
	search_jbtn.setBorderPainted(false);
	search_jbtn.setContentAreaFilled(true);
	search_jbtn.setBounds(205, 17, 30, 30);
	search_jbtn.setBackground(Color.WHITE);
	this.add(search_jbtn);
	
	CreateChat_jbtn = new JButton(
			new ImageIcon(imgPath+"plus.png"));
	CreateChat_jbtn.setOpaque(false);
	CreateChat_jbtn.setBorderPainted(false);
	CreateChat_jbtn.setContentAreaFilled(true);
	CreateChat_jbtn.setBounds(205, 53, 30, 30);
	CreateChat_jbtn.setBackground(Color.WHITE);
	this.add(CreateChat_jbtn);
	
	memberListTreeScrollPane = new JScrollPane();
	memberListTreeScrollPane.setBounds(12, 100, 248, 320);
	this.add(memberListTreeScrollPane);
	
	memberListTree = new JTree();
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
	
//	memberListPanel = new JPanel();
	this.setBackground(Color.WHITE);
	this.setBounds(0, 0, 269, 431);
//	this.setBounds(65, 0, 269, 431);
	this.setLayout(null);
//	this.setVisible(true);
//	this.add(memberListPanel);
	}
	
//	public static void main(String[] args) {
//		MemberList_Panel memberList_Panel = new MemberList_Panel();
//	}
}

