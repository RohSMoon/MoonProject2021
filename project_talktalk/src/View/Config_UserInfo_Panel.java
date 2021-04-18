package View;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Config_UserInfo_Panel extends JPanel {
	///Declare
	JLabel  userInfo_status_jbl				;
	JLabel  userInfo_statusChange_jbl 		;
	JButton userInfo_Update_jbtn			;
	JComboBox userInfo_Status_comboBox		;
	///End of Declare	///End of Declare	///End of Declare	///End of Declare	///End of Declare
	/**
	 * Create the panel.
	 */
	public Config_UserInfo_Panel() {
		Initialize();
	}
	///End of Const ///End of Const ///End of Const ///End of Const ///End of Const
	public void Initialize() {
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(null);
		this.setSize(272, 430);
		this.setBounds(0, 0, 272, 430);  
	/// Panel Position Declare And Color/////// Panel Position Declare And Color/////// Panel Position Declare And Color//// 
		userInfo_status_jbl = new JLabel("상    태");
		userInfo_status_jbl.setEnabled(false);
		userInfo_status_jbl.setHorizontalAlignment(SwingConstants.CENTER);
		userInfo_status_jbl.setBackground(new Color(255, 160, 122));
		userInfo_status_jbl.setBounds(43, 189, 52, 15);
		this.add(userInfo_status_jbl);

		userInfo_statusChange_jbl = new JLabel("상태 변경");
		userInfo_statusChange_jbl.setHorizontalAlignment(SwingConstants.CENTER);
		userInfo_statusChange_jbl.setBounds(64, 32, 130, 17);
		userInfo_statusChange_jbl.setFont(new Font("굴림", Font.BOLD, 14));
		this.add(userInfo_statusChange_jbl);
		
		userInfo_Update_jbtn = new JButton("수  정");
		userInfo_Update_jbtn.setBackground(new Color(100, 149, 237));
		userInfo_Update_jbtn.setBounds(167, 348, 75, 23);
		this.add(userInfo_Update_jbtn);
		
		userInfo_Status_comboBox = new JComboBox();
		userInfo_status_jbl.setLabelFor(userInfo_Status_comboBox);
		userInfo_Status_comboBox.setBackground(new Color(100, 149, 237));
		userInfo_Status_comboBox.setModel(new DefaultComboBoxModel(new String[] {"온라인", "샘플", "샘플", "샘플", "샘플"}));
		userInfo_Status_comboBox.setBounds(102, 185, 130, 23);
		this.add(userInfo_Status_comboBox);
	/// End of Set Panel	
/////////////  
//		JFrame frame = new JFrame();
//		frame.add(this);
//		frame.setSize(272, 430);
//		frame.setVisible(true);
//////////////  Del after Part Test ///  Del after Part Test ///  Del after Part Test 
	}
////// End of Initialize////// End of Initialize////// End of Initialize////// End of Initialize
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		Config_UserInfo_Panel cup = new Config_UserInfo_Panel();
//	}  ///  Del after Part Test ///  Del after Part Test ///  Del after Part Test ///  Del after Part Test ///  Del after Part Test 
}///End of This Class///End of This Class///End of This Class///End of This Class///End of This Class