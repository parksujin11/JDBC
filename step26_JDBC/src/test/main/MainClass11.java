package test.main;

import java.util.List;

import dto.MemberDto;
import test.dao.MemberDao;

public class MainClass11 {
	public static void main(String[] args) {
		//ȸ�� ����� �ҷ�������?
		MemberDao dao=MemberDao.getInstance();
		List<MemberDto> list=dao.getList();
		
		//�ֿܼ� ���
		for(MemberDto tmp:list) {
			int num=tmp.getNum();
			String name=tmp.getName();
			String addr=tmp.getNickname();
			System.out.println("num:"+num+"name:"+name+"addr:"+addr);
		}
	}
}
