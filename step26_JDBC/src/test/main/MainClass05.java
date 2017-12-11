package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainClass05 {
	public static void main(String[] args) {
		//Connetion 객체의 참조값 얻어오기 
		Connection conn=new DBConnect().getConn();
		
		//필요한 객체를 담을 변수 만들기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//실행할 sql 문 준비
			String sql="SELECT num, name, nickname, hobby FROM member";
			//PreparedStatement 객체의 참조값 얻어오기
			//(sql 문을 대신 수행해줄 객체)
			pstmt=conn.prepareStatement(sql);
			//ResultSet 객체의 참조값 얻어오기
			//(SELECT 문의 수행 결과 값을 가지고 있는 객체)
			rs=pstmt.executeQuery();
			//반복문 돌면서 cursor 를 한칸씩 내린다.
			while(rs.next()) {
				//현재 cursor 가 위치한 곳의 row 에서 원하는 칼럼의 데이터를 얻어본다.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String nickname=rs.getString("nickname");
				String hobby=rs.getString("hobby");
				System.out.println(num+":"+name+"/"+nickname+"/"+hobby);
				
			};
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
			}//try
		}
	}
}
