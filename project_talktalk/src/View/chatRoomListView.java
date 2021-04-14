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

public class chatRoomListView extends JFrame {
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		chatRoomListView window = new chatRoomListView();
		};

	/**
	 * Create the application.
	 */
	public chatRoomListView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
/////////////추가패널 부분
		
		String imgPath = "D://Users/rsmoo/eclipse-workspace/Project2/src/imgs/";

		JPanel chatListPanel = new JPanel();
		chatListPanel.setBackground(Color.WHITE);
		chatListPanel.setBounds(65, 0, 272, 430);
		getContentPane().add(chatListPanel);
		chatListPanel.setLayout(null);
		
				
		JTextField jtf_chatListSearch = new JTextField();
		jtf_chatListSearch = new JTextField();
		jtf_chatListSearch.setBounds(50, 22, 134, 20);
		jtf_chatListSearch.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		chatListPanel.add(jtf_chatListSearch);
		jtf_chatListSearch.setColumns(10);
		
		JButton jbtn_chatSearch = new JButton(
		new ImageIcon(imgPath+"search.png"));
		jbtn_chatSearch.setOpaque(false);
		jbtn_chatSearch.setBorderPainted(false);
		jbtn_chatSearch.setContentAreaFilled(true);
		jbtn_chatSearch.setBounds(205, 17, 30, 30);
		jbtn_chatSearch.setBackground(Color.WHITE);
		chatListPanel.add(jbtn_chatSearch);
		
		JLabel jbl_chatListTitle = new JLabel("ChatRoom LIST★");
		jbl_chatListTitle.setFont(new Font("굴림", Font.BOLD, 12));
		jbl_chatListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jbl_chatListTitle.setBounds(40, 57, 160, 20);
		chatListPanel.add(jbl_chatListTitle);
		

		String cols[] = {"부서번호","부서명","지역"};
		//데이터셋 선언
		DefaultTableModel dtm = new DefaultTableModel(cols,0);
		JTable			  jtb = new JTable(new DefaultTableModel(
			new Object[][] {
				{"\uC0AC\uC9C4\uCE78", "\uBAA9\uB85D\uC774\uB984", "\uC778\uC6D0\uC218"},
			},
			new String[] {
				"\uC0AC\uC9C4\uCE78", "\uBAA9\uB85D\uC774\uB984", "\uC778\uC6D0\uC218"
			}
		));
		jtb.setBounds(12, 87, 248, 343);
//		JScrollPane		  jsp = new JScrollPane(jtb);
		chatListPanel.add(jtb);
		
		table = new JTable();
		table.setBounds(12, 87, 248, 333);
		chatListPanel.add(table);
	
		

		
		
///기준	///기준	///기준	///기준	
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(Color.WHITE);
		MenuPanel.setForeground(Color.PINK);
		MenuPanel.setBounds(0, 0, 65, 463);
		MenuPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		getContentPane().add(MenuPanel);
	
		
		this.setBackground(Color.WHITE);
		this.setBounds(100, 100, 350, 500 );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setTitle("아라 상사 메신져");
		this.setVisible(true);
		
///기준 끝///기준 끝///기준 끝///기준 끝///기준 끝///기준 끝///기준 끝
	}
}
