package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class login1 extends JFrame {
	JTextField logView_EmpNo_TextField;
	JTextField logView_EmpPw_TextField;
	JPanel	   logView_Panel ;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		login1 window = new login1();
	}

	/**
	 * Create the application.
	 */
	public login1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		logView_Panel  = new JPanel();
		logView_Panel.setSize(346, 473);
		logView_Panel.setLocation(0, 0);
		logView_Panel.setLayout(null);
		
		Label logView_EmpNo_Label = new Label("EmployeeNO");
		logView_EmpNo_Label.setFont(new Font("굴림", Font.BOLD, 14));
		logView_EmpNo_Label.setBounds(44, 253, 130, 30);
		logView_Panel.add(logView_EmpNo_Label);
		
		Label logView_EmpPw_Label = new Label("Password");
		logView_EmpPw_Label.setFont(new Font("Arial Black", Font.BOLD, 14)); 
		logView_EmpPw_Label.setBounds(47, 302, 120, 25);
		logView_Panel.add(logView_EmpPw_Label);
		
		logView_EmpNo_TextField = new JTextField();
		logView_EmpNo_TextField.setBounds(181, 259, 106, 25);
		logView_Panel.add(logView_EmpNo_TextField);
		logView_EmpNo_TextField.setColumns(10);
		
		logView_EmpPw_TextField = new JTextField();
		logView_EmpPw_TextField.setBounds(181, 302, 106, 25);
		logView_Panel.add(logView_EmpPw_TextField);
		logView_EmpPw_TextField.setColumns(10);
		
		JButton logView_Login_Button = new JButton("LOGIN");
		logView_Login_Button.setFont(new Font("Arial Black", Font.BOLD, 11));
		logView_Login_Button.setBounds(194, 388, 108, 30);
		getContentPane().add(logView_Login_Button);
		
		JButton logView_Join_Button = new JButton("Join");
		logView_Join_Button.setFont(new Font("Arial Black", Font.BOLD, 11));
		logView_Join_Button.setBounds(43, 388, 108, 30);
		getContentPane().add(logView_Join_Button);
		
		getContentPane().add(logView_Panel);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255, 245, 238));
		this.setBounds(0, 0, 350, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setDefaultLookAndFeelDecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
