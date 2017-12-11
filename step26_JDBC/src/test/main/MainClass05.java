package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainClass05 {
	public static void main(String[] args) {
		//Connetion ��ü�� ������ ������ 
		Connection conn=new DBConnect().getConn();
		
		//�ʿ��� ��ü�� ���� ���� �����
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//������ sql �� �غ�
			String sql="SELECT num, name, nickname, hobby FROM member";
			//PreparedStatement ��ü�� ������ ������
			//(sql ���� ��� �������� ��ü)
			pstmt=conn.prepareStatement(sql);
			//ResultSet ��ü�� ������ ������
			//(SELECT ���� ���� ��� ���� ������ �ִ� ��ü)
			rs=pstmt.executeQuery();
			//�ݺ��� ���鼭 cursor �� ��ĭ�� ������.
			while(rs.next()) {
				//���� cursor �� ��ġ�� ���� row ���� ���ϴ� Į���� �����͸� ����.
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
