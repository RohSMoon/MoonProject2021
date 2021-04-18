package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuList_Ctrl implements ActionListener {
	MenuList_View menuList_View;
	
	MenuList_Ctrl(MenuList_View menuList_View){
		this.menuList_View = menuList_View;
	}
	private void Remover() {
		menuList_View.basementPanel.removeAll();
		menuList_View.basementPanel.revalidate();
		menuList_View.basementPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if (menuList_View.memberList_jbtn_MenuPanel==obj) {
			Remover();
			menuList_View.basementPanel.add(menuList_View.memberListPanel);
		}
		else if (menuList_View.search_jbtn==obj) {
			String xxx = menuList_View.memeberListSearch_jtf_MemberListPanel.getText();
			
		}
		else if (menuList_View.CreateChat_jbtn==obj) {
			new ChatDialog_View();
		}
		
		else if (menuList_View.chatList_jbtn_MenuPanel==obj) {
			Remover();
			menuList_View.basementPanel.add(new ChatRoomListView());
		}
		
		else if (menuList_View.groupChatList_jbtn_MenuPanel==obj) {
			Remover();
			menuList_View.basementPanel.add(new GroupChatRoomListView());
		}
		
		else if (menuList_View.config_jbtn_MenuPanel==obj) {
			Remover();
			menuList_View.basementPanel.add(new Config_Main_Panel(menuList_View));
		}
		
	}
}
