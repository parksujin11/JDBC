package test.main;

import dto.MemberDto;
import test.dao.MemberDao;

public class MainClass09 {
	public static void main(String[] args) {
		//������ ȸ������
		int num=999;
		String name="������";
		String addr="����";
		
		MemberDto dto=new MemberDto(num, name, addr);
		MemberDao dao=MemberDao.getInstance();
		boolean isSuccess=dao.update(dto);
		
		if(isSuccess) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
}
