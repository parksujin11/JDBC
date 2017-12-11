package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass01 {
	public static void main(String[] args) {
		//필요한 객체를 담을 변수 만들기
		Connection conn=null;
		try{
			//오라클 드라이버 로딩하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 oracle DB url 정보
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB 접속 성공!");
		}catch(Exception e){
			e.printStackTrace();
		}
		//필요한 객체를 담을 변수 만들기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//실행할 sql 문 준비
			String sql="SELECT num, name, nickname, hobby FROM member";
			//SELECT 하면 
			//PreparedStatement 객체의 참조값 얻어오기
			//(sql 문을 대신 수행해줄 객체)
			pstmt=conn.prepareStatement(sql);
			//prepareStatement에서 insert update delete 를 할 수 있다. 
			//ResultSet 객체의 참조값 얻어오기
			//(SELECT 문의 수행 결과 값을 가지고 있는 객체)
			rs=pstmt.executeQuery();
			//데이터 불러올때는 executeQuery 
			//반복문 돌면서 cursor 를 한칸씩 내린다.
			while(rs.next()) {//커서 바로 밑에 데이터가 있으면 true 를 전달해주는 rs.next 메소드
				// 커서 밑에 데이터가 없으면 false 를 전달
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
