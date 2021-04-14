package View;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JDialog {
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					SignUp window = new SignUp();
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. 
	 */
	private void initialize() {
		
		new JDialog();
		this.setBounds(100, 100, 400, 420);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel EmployeeNumber = new JLabel("EmployeeNumber");
		EmployeeNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		EmployeeNumber.setHorizontalAlignment(SwingConstants.CENTER);
		EmployeeNumber.setBounds(32, 37, 130, 15);
		panel.add(EmployeeNumber);
		
		JLabel PassWord = new JLabel("PassWord");
		PassWord.setFont(new Font("Dialog", Font.BOLD, 14));
		PassWord.setHorizontalAlignment(SwingConstants.CENTER);
		PassWord.setBounds(32, 79, 130, 15);
		panel.add(PassWord);
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Dialog", Font.BOLD, 14));
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setBounds(32, 137, 130, 15);
		panel.add(Name);
		
		JLabel Department = new JLabel("Department");
		Department.setFont(new Font("Dialog", Font.BOLD, 14));
		Department.setHorizontalAlignment(SwingConstants.CENTER);
		Department.setBounds(32, 196, 130, 15);
		panel.add(Department);
		
		JLabel Level = new JLabel("Level");
		Level.setFont(new Font("Dialog", Font.BOLD, 14));
		Level.setHorizontalAlignment(SwingConstants.CENTER);
		Level.setBounds(32, 257, 130, 15);
		panel.add(Level);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 134, 106, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(199, 76, 106, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(199, 34, 106, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(199, 192, 106, 23);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(199, 253, 106, 23);
		panel.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(65, 333, 95, 23);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("굴림", Font.BOLD, 14));
		btnCancel.setBounds(225, 333, 95, 23);
		panel.add(btnCancel);
		this.setVisible(true);
	}
}
