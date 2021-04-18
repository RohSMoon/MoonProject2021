package View;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LogView_Panel extends JPanel {  // This Class for set image to LoginView
	///Declare
	String imgPath = "src/imgs/";   //Imgpath
	ImageIcon ig 		= new ImageIcon(imgPath+"login.png");
	///End of Delcare
	public void paintComponent(Graphics g) {
		g.drawImage(ig.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	///End of Method paintComponent	///End of Method paintComponent	///End of Method paintComponent	///End of Method paintComponent
	
}/// End of This Class/// End of This Class/// End of This Class/// End of This Class/// End of This Class
