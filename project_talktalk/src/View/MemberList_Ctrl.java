package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class MemberList_Ctrl implements MouseListener, ActionListener, TreeSelectionListener {
	MenuList_View menuList_View;
	public MemberList_Ctrl(MenuList_View menuList_View){
		this.menuList_View = menuList_View;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		선택된 로우 클릭 getSelectionRows API를 보면 int 타입인걸 알 수 있음. 사원번호를 떙기는거 어떰?
		if (e.getClickCount()==2) {
			Object aaa = menuList_View.memberListTree.getSelectionRows();
			System.out.println("선택된 로우 출력 : " + aaa);
//		요 아래에 파라미터 값으로 선택된 사람을 받아오게끔 해줘야함.
//		해당 타입이 VO가 될지 뭐가 될진 정해야함.
			ChatDialog_View chatDialog_View = new ChatDialog_View();
			if (aaa==null) {
				JOptionPane.showMessageDialog(menuList_View, "선택된 대상이 없습니당.♡");
			}
			
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
			Object aobj = ae.getSource();
		if (menuList_View.search_jbtn==aobj) { //멤버 검색버튼
			String xxx = menuList_View.memeberListSearch_jtf_MemberListPanel.getText();
			
		}
		else if (menuList_View.CreateChat_jbtn==aobj) {// 그룹채팅 생성버튼
			int ddd = menuList_View.memberListTree.getSelectionCount();
				if (ddd!=0) {
					List<Object> ccc = new ArrayList<>();
					
					int[] bbb = menuList_View.memberListTree.getSelectionRows();
					
					new ChatDialog_View();
				// view int [] 형태의 파라미터로 넣어줘야 될거 같아. 가능할까?
			}
		}
	}
	@Override
	public void valueChanged(TreeSelectionEvent te) {
		DefaultMutableTreeNode selectedNode = 
			       (DefaultMutableTreeNode)menuList_View.memberListTree.getLastSelectedPathComponent(); 
		 		System.out.println(selectedNode);
		 		// 이걸로 가도 될가요 DB님 
	}



	
}
