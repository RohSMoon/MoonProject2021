package View;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Composite;

class SignUp_View_Panel extends JPanel { // Inner Class for JPanel's Grade

	public void paint(Graphics g) {
		  Graphics2D g2 = (Graphics2D) g;
		  
		  GradientPaint gp = new GradientPaint(0,0, new Color(000, 000, 051), 
				  							250,250, new Color(30, 144, 255) );
		  
		  
		  Composite composite = g2.getComposite();
		  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));

		  
		  g2.setPaint(gp);
		  g2.fill(new Rectangle2D.Double(0,0,400,420));

	}/// End of paint method///End of paint method///End of paint method///End of
		/// paint method///End of paint method

}/// End of Inner Class SignUp_View_Paint///End of Inner Class
	/// SignUp_View_Paint///End of Inner Class SignUp_View_Paint

public class SignUp_View extends JDialog {
	// Var
	JPanel 			SignUp_View_jpl						             ;
	JLabel 			signUpView_Level_jbl		             ;
	JLabel 			signUpView_Pw_jbl 			             ;
	JLabel 			signUpView_Deptname_jbl		             ;
	JLabel 			signUpView_MemberName_jbl 	             ;
	JLabel 			signUpView_MemeberNo_jlb	             ;
	JButton 		signUpView_Submit_jbtn 		             ;
	JButton 		signUpView_Cancel_jbtn 		             ;
	JComboBox 		signUpView_DeptComboBox		             ;
	JComboBox 		signUpView_EmpLevelComboBox              ;
	JTextField 		signUpView_MemberName_Name               ;
	JTextField 		signUpView_Pw_jtf                        ;
	JTextField 		signUpView_MemeberNo_jtf                 ;
	SignUp_Ctrl		signUp_Ctrl								 ;
//////////End of Var ///////////////End of Var ///////////////End of Var ///////////////End of Var ///////////////End of Var /////	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		SignUp_View window = new SignUp_View();
//	} //////////End of Launch the application.//////////End of Launch the application.//////////End of Launch the application.//////////End of Launch the application.

	/**
	 * Create the application.
	 */
	public SignUp_View() {
		initialize();
	}// End of Method"initialize"// End of Method"initialize"// End of Method"initialize"// End of Method"initialize"// End of Method"initialize"
	////End of Const////End of Const////End of Const////End of Const////End of Const////End of Const////End of Const
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/*
		 * SignUp_View_Panel signUp_View_Panel = new SignUp_View_Panel();
		 * this.setContentPane(signUp_View_Panel);
		 */
		SignUp_View_jpl	 = new SignUp_View_Panel();
		SignUp_View_Panel signUp_View_Paint = new SignUp_View_Panel();
		SignUp_View_jpl	.add(signUp_View_Paint);// "Graphics2D" //panel.setBackground(Color.WHITE);
		SignUp_View_jpl	.setLayout(null);
		this.add(SignUp_View_jpl	, BorderLayout.CENTER);
		
		signUpView_Deptname_jbl = new JLabel("Department");
		signUpView_Deptname_jbl.setFont(new Font("Dialog", Font.BOLD, 14));
		signUpView_Deptname_jbl.setHorizontalAlignment(SwingConstants.CENTER);
		signUpView_Deptname_jbl.setBounds(32, 196, 130, 15);
		SignUp_View_jpl	.add(signUpView_Deptname_jbl);

		signUpView_MemberName_jbl = new JLabel("Name");
		signUpView_MemberName_jbl.setFont(new Font("Dialog", Font.BOLD, 14));
		signUpView_MemberName_jbl.setHorizontalAlignment(SwingConstants.CENTER);
		signUpView_MemberName_jbl.setBounds(32, 137, 130, 15);
		SignUp_View_jpl	.add(signUpView_MemberName_jbl);

		signUpView_MemeberNo_jlb = new JLabel("MemberNumber");
		signUpView_MemeberNo_jlb.setFont(new Font("Dialog", Font.BOLD, 14));
		signUpView_MemeberNo_jlb.setHorizontalAlignment(SwingConstants.CENTER);
		signUpView_MemeberNo_jlb.setBounds(32, 37, 130, 15);
		SignUp_View_jpl	.add(signUpView_MemeberNo_jlb);
	
		signUpView_Level_jbl = new JLabel("Level");
		signUpView_Level_jbl.setFont(new Font("Dialog", Font.BOLD, 14));
		signUpView_Level_jbl.setHorizontalAlignment(SwingConstants.CENTER);
		signUpView_Level_jbl.setBounds(32, 257, 130, 15);
		SignUp_View_jpl	.add(signUpView_Level_jbl);

		signUpView_MemeberNo_jtf = new JTextField();
		signUpView_MemeberNo_jtf.setBounds(199, 34, 106, 21);
		SignUp_View_jpl	.add(signUpView_MemeberNo_jtf);
		signUpView_MemeberNo_jtf.setColumns(10);

		signUpView_Pw_jtf = new JTextField();
		signUpView_Pw_jtf.setBounds(199, 82, 106, 21);
		SignUp_View_jpl	.add(signUpView_Pw_jtf);
		signUpView_Pw_jtf.setColumns(10);

		signUpView_MemberName_Name = new JTextField();
		signUpView_MemberName_Name.setBounds(199, 134, 106, 21);
		SignUp_View_jpl	.add(signUpView_MemberName_Name);
		signUpView_MemberName_Name.setColumns(10);

		signUpView_EmpLevelComboBox = new JComboBox();
		signUpView_EmpLevelComboBox.setBounds(199, 253, 106, 23);
		SignUp_View_jpl	.add(signUpView_EmpLevelComboBox);

		signUpView_DeptComboBox = new JComboBox();
		signUpView_DeptComboBox.setBounds(199, 192, 106, 23);
		SignUp_View_jpl	.add(signUpView_DeptComboBox);
////////////////////////////////////////////////////////////////////////
		signUp_Ctrl = new SignUp_Ctrl(this);
//////////////////////////////////////////////////		///////////////////
		signUpView_Submit_jbtn = new JButton("Submit");
		signUpView_Submit_jbtn.setFont(new Font("굴림", Font.BOLD, 14));
		signUpView_Submit_jbtn.setBounds(65, 333, 95, 23);
		signUpView_Submit_jbtn.setForeground(new Color(240, 255, 240));
		signUpView_Submit_jbtn.setOpaque(true);
		signUpView_Submit_jbtn.setBorderPainted(true);
		signUpView_Submit_jbtn.setContentAreaFilled(true);
		signUpView_Submit_jbtn.setBackground(new Color(30, 144, 255));
		SignUp_View_jpl	.add(signUpView_Submit_jbtn);
		signUpView_Submit_jbtn.addActionListener(signUp_Ctrl);

		
		signUpView_Cancel_jbtn = new JButton("Cancel");
		signUpView_Cancel_jbtn.setFont(new Font("굴림", Font.BOLD, 14));
		signUpView_Cancel_jbtn.setBounds(225, 333, 95, 23);
		signUpView_Cancel_jbtn.setForeground(new Color(240, 255, 240));
		signUpView_Cancel_jbtn.setOpaque(true);
		signUpView_Cancel_jbtn.setBorderPainted(true);
		signUpView_Cancel_jbtn.setContentAreaFilled(true);
		signUpView_Cancel_jbtn.setBackground(new Color(30, 144, 255));
		SignUp_View_jpl	.add(signUpView_Cancel_jbtn);
		signUpView_Cancel_jbtn.addActionListener(signUp_Ctrl);
/////////////////////		////////////////////////////////////////////////////////
		
		signUpView_Pw_jbl = new JLabel("PassWord");
		signUpView_Pw_jbl.setFont(new Font("Dialog", Font.BOLD, 14));
		signUpView_Pw_jbl.setHorizontalAlignment(SwingConstants.CENTER);
		signUpView_Pw_jbl.setBounds(32, 85, 130, 15);
		SignUp_View_jpl	.add(signUpView_Pw_jbl);

		new JDialog();

		this.setBounds(100, 100, 400, 420);
		this.setTitle("아라 상사 메신져 회원가입");
		this.setVisible(true);

	}
}// End of Method this Class// End of Method this Class// End of Method this Class// End of Method this Class// End of Method this Class
