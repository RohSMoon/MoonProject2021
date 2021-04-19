package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

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
		
		
		//////////////////////////////////////////////
		if (menuList_View.memberList_jbtn_MenuPanel==obj) { //멤버리스트 버튼
			Remover();
			menuList_View.basementPanel.add(menuList_View.memberListPanel);
		}
		
		else if (menuList_View.chatList_jbtn_MenuPanel==obj) {// 채팅리스트 버튼
			Remover();
			menuList_View.basementPanel.add(new ChatRoomListView());
		}
		
		else if (menuList_View.groupChatList_jbtn_MenuPanel==obj) {//그룹채팅 리스트 버튼
			Remover();
			menuList_View.basementPanel.add(new GroupChatRoomListView());
		}
		
		else if (menuList_View.config_jbtn_MenuPanel==obj) {//설정 메뉴 버튼
			Remover();
			menuList_View.basementPanel.add(new Config_Main_Panel(menuList_View));
		}
	//////////////// 메뉴 버튼 	
	}
	

	
}
