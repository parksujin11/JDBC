package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.MemberDto;
import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
	/*
	 * 번호 : 20
	 * 이름 : 누구게
	 * 주소 : 어디게 
	 * 
	 * 위의 정보를 MemberDto 객체에 담은 다음 MemberDto 객체가 담긴 변수를 참조해서 해당정보를 DB에 저장해보세요.
	 * 
	 */
	MemberDto dto=new MemberDto(20, "누구게", "어디게");
	
//	dto.setNum(20);
//	dto.setName("누구게");
//	dto.setNickname("어디게");
	
	//Connection 객체의 참조값 얻어오기
	Connection conn=new DBConnect().getConn();
	//필요한 객체를 담을 변수 만들기
			PreparedStatement pstmt=null;
			
			try {
				//실행할 SQL 문의 뼈대 구성하기 
				String sql="INSERT INTO member (num,name,nickname)"+"VALUES(?,?,?)";
				// PreparedStatement 객체의 참조값 얻어오기 (sql 문을 대신 수행해 줄 객체)
		         pstmt= conn.prepareStatement(sql);
		         
		         pstmt.setInt(1, dto.getNum());
		         pstmt.setString(2, dto.getName());
		         pstmt.setString(3, dto.getNickname());
		         
		         pstmt.executeUpdate();
		         
		         System.out.println("회원 정보를 저장했습니다.");
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				}catch(Exception e) {
					
				}//try
			}
		}
	}

