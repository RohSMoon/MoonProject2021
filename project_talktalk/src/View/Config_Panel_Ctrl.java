package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Config_Panel_Ctrl implements ActionListener {
	MenuList_View menuList_View;
	Config_Main_Panel config_Main_Panel;
	
	Config_Panel_Ctrl(Config_Main_Panel config_Main_Panel, MenuList_View menuList_View){
		this.config_Main_Panel = config_Main_Panel;
		this.menuList_View = menuList_View;
	}
	private void Remover() {
		menuList_View.basementPanel.removeAll();
		menuList_View.basementPanel.revalidate();
		menuList_View.basementPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent cae) {
		Object obj = cae.getSource();
		if (config_Main_Panel.userInfo_jbtn==obj) {
			System.out.println("aaaa");
			Remover();
			menuList_View.basementPanel.add(new Config_UserInfo_Panel());
		}
		if (config_Main_Panel.changeStatus_jbtn==obj) {
			Remover();
			menuList_View.basementPanel.add(new Config_Status_Change_Panel());
		}
		if (config_Main_Panel.LogOut_jbtn==obj) {
			System.exit(0);
		}
	}
}
