package test.main;

import dto.MemberDto;
import test.dao.MemberDao;

public class MainClass10 {
	public static void main(String[] args) {
		//999�� ȸ���� ���� �Ϸ���?
		int num=999;
		
		MemberDao dao=MemberDao.getInstance();
		boolean isSuccess=dao.delete(num);
		if(isSuccess) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ���� ");
		}	
	}
}
	
