package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass04 {
	public static void main(String[] args) {
		//�ʿ��� ��ü�� ���� ���� �����
		Connection conn=null;
		try{
			//����Ŭ ����̹� �ε��ϱ�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//������ oracle DB url ����
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//Connection ��ü�� ������ ������
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB ���� ����!");
		}catch(Exception e){
			e.printStackTrace();
		}
		//1�� ȸ���� ������ ������ ������
		int num=3;
		
		//�ʿ��� ��ü�� ���� ���� �����
		PreparedStatement pstmt=null;
		
		try {
			//������ SQL ���� ���� �����ϱ� 
			String sql="DELETE FROM member WHERE num=?";
			// PreparedStatement ��ü�� ������ ������ (sql ���� ��� ������ �� ��ü)
	         pstmt= conn.prepareStatement(sql);
	         
	         pstmt.setInt(1, num);
	         
	         pstmt.executeUpdate();
	         
	         System.out.println("ȸ�� ������ �����߽��ϴ�.");
			
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
