package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDto;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 *  member 테이블에 있는 모든 내용을 
		 *  List<MemberDto> 형태로 담아 보세요.
		 */
		//Connection 객체의 참조값 얻어오기 
		Connection conn=new DBConnect().getConn();
		//필요한 객체를 담을 변수 만들기 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//MemberDto 객체를 담을 ArrayList 객체생성
		List<MemberDto> list=new ArrayList<>();
		try{
			//실행할 sql 문 준비 
			String sql="SELECT num, name, addr FROM member";
			//PreparedStatement 객체의 참조값 얻어오기
			//(sql 문을 대신 수행해줄 객체)
			pstmt=conn.prepareStatement(sql);
			//ResultSet 객체의 참조값 얻어오기 
			//(SELECT 문의 수행 결과 값을 가지고 있는 객체)
			rs=pstmt.executeQuery();
			//반복문 돌면서 cursor 를 한칸씩 내린다. 
			while(rs.next()){
				//현재 cursor 가 위치한 곳의 
				//row 에서 원하는 칼럼의 데이터를 얻어온다.
				int  num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				//MemberDto 객체에 회원정보 담기
				MemberDto dto=new MemberDto(num, name, addr);
				//ArrayList 객체에 MemberDto 담기 
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}//try
		
		System.out.println("메인 메소드가 종료 됩니다.");
	}
}

