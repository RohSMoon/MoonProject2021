package View;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Font;


public class ChatDialog_View extends JDialog {
	///Declare                        
	JMenu chatDialogMenu			  ;
	JMenuBar chatDialogMenuBar 		  ;
	JPanel chatDialog_panel		 	  ;
	JLabel timeCheck_jlb			  ;
	JButton send_jbtn				  ;
	JButton closs_jbtn				  ;
	JButton Emoji_jbtn				  ;
	JButton SendFile_jbtn			  ;
	JDialog ChatDialog                ;
	JMenuItem chatInvite_MenuItem 	  ;
	JMenuItem chatOut_MenuItem 		  ;
	JTextArea showChat_jta			  ;
	JTextArea showWhochatJoined_jta	  ;
	JTextField InputChat_jtf          ;
	ChatDialog_Ctrl	chatDialog_Ctrl	  ;
	
	///End of Declare
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {	
//		ChatDialog_View window = new ChatDialog_View();
//
//	}
	/////// Del after Part Test	/////// Del after Part Test	/////// Del after Part Test	/////// Del after Part Test
	/**
	 * Create the application.
	 */
	public ChatDialog_View() {
		initialize();
	}
	///End of Const///End of Const///End of Const///End of Const///End of Const///End of Const
	
	/**
	 * Initialize the contents of the jdialog.
	 */
	private void initialize() {
		chatDialog_Ctrl = new ChatDialog_Ctrl(this);
		
		chatDialog_panel = new JPanel();
		chatDialog_panel.setBackground(Color.PINK);
		this.add(chatDialog_panel, BorderLayout.CENTER);
		chatDialog_panel.setLayout(null);
		
		showChat_jta = new JTextArea();
		showChat_jta.setBounds(12, 26, 582, 272);
		chatDialog_panel.add(showChat_jta);
		showChat_jta.enable(false);
		
		showWhochatJoined_jta = new JTextArea();
		showWhochatJoined_jta.setBounds(623, 26, 128, 272);
		chatDialog_panel.add(showWhochatJoined_jta);
		showWhochatJoined_jta.enable(false);
		
		InputChat_jtf = new JTextField();
		InputChat_jtf.setBounds(12, 340, 560, 25);
		chatDialog_panel.add(InputChat_jtf);
		InputChat_jtf.setColumns(10);
		
		timeCheck_jlb = new JLabel("시간표기");
		timeCheck_jlb.setBackground(Color.WHITE);
		timeCheck_jlb.setHorizontalAlignment(SwingConstants.RIGHT);
		timeCheck_jlb.setBounds(10, 373, 762, 25);
		chatDialog_panel.add(timeCheck_jlb);
		
		
		send_jbtn = new JButton("전송");
		send_jbtn.setFont(new Font("굴림", Font.PLAIN, 14));
		send_jbtn.setBounds(597, 340, 70, 30);
		send_jbtn.setForeground(new Color(255, 255, 255));
		send_jbtn.setOpaque(true);
		send_jbtn.setBorderPainted(true);
		send_jbtn.setContentAreaFilled(true);
		send_jbtn.setBackground(new Color(255, 204, 102));
		chatDialog_panel.add(send_jbtn);
		send_jbtn.addActionListener(chatDialog_Ctrl);
		
		closs_jbtn = new JButton("닫기");
		closs_jbtn.setFont(new Font("굴림", Font.PLAIN, 14));
		closs_jbtn.setBounds(691, 340, 70, 30);
		closs_jbtn.setForeground(new Color(255, 255, 255));
		closs_jbtn.setOpaque(true);
		closs_jbtn.setBorderPainted(true);
		closs_jbtn.setContentAreaFilled(true);
		closs_jbtn.setBackground(new Color(255, 204, 102));
		chatDialog_panel.add(closs_jbtn);
		closs_jbtn.addActionListener(chatDialog_Ctrl);
		
		
		Emoji_jbtn = new JButton("이모티콘");
		Emoji_jbtn.setBounds(22, 308 , 95, 23);
		Emoji_jbtn.setForeground(new Color(255, 255, 255));
		Emoji_jbtn.setOpaque(true);
		Emoji_jbtn.setBorderPainted(true);
		Emoji_jbtn.setContentAreaFilled(true);
		Emoji_jbtn.setBackground(new Color(255, 204, 102));
		chatDialog_panel.add(Emoji_jbtn);
		Emoji_jbtn.addActionListener(chatDialog_Ctrl);

		SendFile_jbtn = new JButton("파일전송");
		SendFile_jbtn.setBounds(130, 308, 95, 23);
		SendFile_jbtn.setForeground(new Color(255, 255, 255));
		SendFile_jbtn.setOpaque(true);
		SendFile_jbtn.setBorderPainted(true);
		SendFile_jbtn.setContentAreaFilled(true);
		SendFile_jbtn.setBackground(new Color(255, 204, 102));
		chatDialog_panel.add(SendFile_jbtn);
		SendFile_jbtn.addActionListener(chatDialog_Ctrl);
		
		chatDialogMenuBar = new JMenuBar();
		this.setJMenuBar(chatDialogMenuBar);

		chatDialogMenu = new JMenu("메뉴");
		chatDialogMenuBar.add(chatDialogMenu);
		
		chatInvite_MenuItem = new JMenuItem("초대하기");
		chatDialogMenu.add(chatInvite_MenuItem);
		chatInvite_MenuItem.addActionListener(chatDialog_Ctrl);
		
		chatOut_MenuItem = new JMenuItem("방 나가기");
		chatDialogMenu.add(chatOut_MenuItem);
		chatOut_MenuItem.addActionListener(chatDialog_Ctrl);
		this.setTitle("대화방 제목");
		this.setBounds(100, 100, 790, 460);
		this.setVisible(true);
	}
}
// End of initialize// End of initialize// End of initialize// End of initialize// End of initialize// End of initialize