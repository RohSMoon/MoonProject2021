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

public class Config_Status_Change_Panel extends JPanel {
	///Declare ///Declare ///Declare ///Declare ///Declare 
	DefaultTableModel config_Status_dtm                               		 	;
	JTable	 		  showStatustable	                                        ;
	JLabel			  lblNewLabel		 								        ;
	String			  object[][]				 = {null, null,null}            ;
	String[] 		  cols	 					 = {"\uAD6C\uBD84", "\uAC12"}   ;
	//End ofDeclare 	//End ofDeclare	//End ofDeclare	//End ofDeclare	//End ofDeclare
	
	
	/**
	 * Create the panel.
	 */
	public Config_Status_Change_Panel() {
		Initialize();
	}
	////End of Const////End of Const////End of Const////End of Const
	public void Initialize() {	
		

		lblNewLabel = new JLabel("사용자 정보");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 32, 130, 17);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		this.add(lblNewLabel);
		
		showStatustable = new JTable();
		showStatustable.setFont(new Font("굴림", Font.PLAIN, 15));
		showStatustable.setEnabled(false);
		showStatustable.setBorder(UIManager.getBorder("Tree.editorBorder"));
		showStatustable.setBackground(new Color(255, 250, 240));
		showStatustable.setModel(
		config_Status_dtm = new DefaultTableModel(object,cols)
		); 	
		////End of setModel		////End of setModel		////End of setModel		////End of setModel
				
		showStatustable.getColumnModel().getColumn(0).setResizable(false);
		showStatustable.getColumnModel().getColumn(0).setPreferredWidth(50);
		showStatustable.getColumnModel().getColumn(0).setMinWidth(50);
		showStatustable.getColumnModel().getColumn(0).setMaxWidth(100);
		showStatustable.getColumnModel().getColumn(1).setResizable(false);
		showStatustable.getColumnModel().getColumn(1).setPreferredWidth(150);
		showStatustable.getColumnModel().getColumn(1).setMaxWidth(150);
		showStatustable.setBounds(41, 172, 175, 50);
		this.add(showStatustable);
		
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(null);
		this.setSize(272, 430);
		this.setBounds(0, 0, 272, 430);
		
	}
	///End of Initialize ///End of Initialize///End of Initialize///End of Initialize///End of Initialize
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		Config_Status_Change_Panel cup = new Config_Status_Change_Panel();
//	}
	
	//// Del after Part Test	//// Del after Part Test	//// Del after Part Test	//// Del after Part Test	//// Del after Part Test
}/////////////End of This Class/////////////End of This Class /////////////End of This Class /////////////End of This Class  
