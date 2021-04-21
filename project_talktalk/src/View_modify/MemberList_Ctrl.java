package View_modify;

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
	MemberList_Panel memberList_Panel; //  멤버리스트 패널 선언 
	public MemberList_Ctrl(MemberList_Panel memberList_Panel){// 생성자
		this.memberList_Panel= memberList_Panel;  // 멤버리스트 패널 주소번지 동기화
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		선택된 로우 클릭 getSelectionRows API를 보면 int 타입인걸 알 수 있음. 사원번호를 떙기는거 어떰?
		Object aaa = memberList_Panel.memberListTree.getSelectionRows();   //선택된 로우들을 임의 변수로 지정 
		if (e.getClickCount()==1) {											// 한번 클릭하면 객체 클릭 되는지 확인
			System.out.println("선택된 로우 출력 : " + aaa);
		}  // End of 한번클릭 if 문
		///////////////////
		
		if (e.getClickCount()==2) {							
			System.out.println("더블클릭 선택된 로우 출력 : " + aaa);  // 더블클릭한 객체 클릭 된건지 확인
//		요 아래에 파라미터 값으로 선택된 사람을 받아오게끔 해줘야함.
//		해당 타입이 VO가 될지 뭐가 될진 정해야함.
			ChatDialog_View chatDialog_View = new ChatDialog_View(); // 채팅창 생성
			} // End of 더블클릭 감지 if문
		} //마우스 클릭 이벤트 끝///
		

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} //마우스 넣는 액션

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} //마우스 배는 액션

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}  // 좌우클릭 마우스클릭 누르기 액션

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}  // 몰라 

	@Override
	public void actionPerformed(ActionEvent ae) { // 액션 퍼폼드
			Object aobj = ae.getSource(); 
		if (memberList_Panel.search_jbtn==aobj) { //멤버 검색입력창
			String xxx = memberList_Panel.memeberListSearch_jtf_MemberListPanel.getText(); //입력창에 입력된 값 가져오기
		}  
		/// if문 마감
		
		
		else if (memberList_Panel.CreateChat_jbtn==aobj) {// 그룹채팅 생성버튼
			int ddd = memberList_Panel.memberListTree.getSelectionCount(); // 선택된 인간들의 갯수 감지
			
				if (ddd!=0) { // ddd 가 널이 아니면
					List<Object> ccc = new ArrayList<>(); 
					
					int[] bbb = memberList_Panel.memberListTree.getSelectionRows();  // 선퇙된 로우 값을 가져와야하는데 int 배열지원해;
					System.out.println(bbb);
					
					new ChatDialog_View(); // 채팅창  생성
				// view int [] 형태의 파라미터로 넣어줘야 될거 같아. 가능할까?
			}
		}
	}
	@Override
	public void valueChanged(TreeSelectionEvent te) { // Jtree 메소드
		DefaultMutableTreeNode selectedNode =  //선택된 패스의 가장 아래 컴포넌트가 잡히면 값이 뭘까요? 
			       (DefaultMutableTreeNode)memberList_Panel.memberListTree.getLastSelectedPathComponent(); 
		 		System.out.println(selectedNode);
		 		// 이걸로 가도 될가요 DB님 
	}



	
}
