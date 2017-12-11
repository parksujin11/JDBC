package test.main;

import dto.MemberDto;
import test.dao.MemberDao;

public class MainClass12 {
	public static void main(String[] args) {
		//1 번 회원 한명의 정보를 불러 오려면?
		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=dao.getData(1);
		
		if(dto!=null) {
			int num=dto.getNum();
			String name=dto.getName();
			String nickname=dto.getNickname();		
			System.out.println(num+"/"+name+"/"+nickname);
			
		}else{
			System.out.println("정보가 없음");
		}
	}
}
