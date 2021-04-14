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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ChatDialog {

	private JDialog jdialog;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ChatDialog window = new ChatDialog();
		window.jdialog.setVisible(true);
	}
	/**
	 * Create the application.
	 */
	public ChatDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the jdialog.
	 */
	private void initialize() {
		jdialog = new JDialog();
		jdialog.setBounds(100, 100, 790, 460);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		jdialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 26, 582, 272);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(623, 26, 128, 292);
		panel.add(textArea_1);
		
		textField = new JTextField();
		textField.setBounds(12, 340, 560, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("시간표기");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 375, 764, 25);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("전송");
		btnNewButton.setBounds(597, 341, 60, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("닫기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(669, 341, 60, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("이모티콘");
		btnNewButton_2.setBounds(22, 307, 81, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("파일전송");
		btnNewButton_2_1.setBounds(115, 308, 81, 23);
		panel.add(btnNewButton_2_1);
		
		JMenuBar menuBar = new JMenuBar();
		jdialog.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("초대하기");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("방 나가기");
		mnNewMenu.add(mntmNewMenuItem);
	}
}
