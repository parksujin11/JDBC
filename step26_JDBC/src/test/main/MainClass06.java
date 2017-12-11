package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.MemberDto;
import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
	/*
	 * ��ȣ : 20
	 * �̸� : ������
	 * �ּ� : ���� 
	 * 
	 * ���� ������ MemberDto ��ü�� ���� ���� MemberDto ��ü�� ��� ������ �����ؼ� �ش������� DB�� �����غ�����.
	 * 
	 */
	MemberDto dto=new MemberDto(20, "������", "����");
	
//	dto.setNum(20);
//	dto.setName("������");
//	dto.setNickname("����");
	
	//Connection ��ü�� ������ ������
	Connection conn=new DBConnect().getConn();
	//�ʿ��� ��ü�� ���� ���� �����
			PreparedStatement pstmt=null;
			
			try {
				//������ SQL ���� ���� �����ϱ� 
				String sql="INSERT INTO member (num,name,nickname)"+"VALUES(?,?,?)";
				// PreparedStatement ��ü�� ������ ������ (sql ���� ��� ������ �� ��ü)
		         pstmt= conn.prepareStatement(sql);
		         
		         pstmt.setInt(1, dto.getNum());
		         pstmt.setString(2, dto.getName());
		         pstmt.setString(3, dto.getNickname());
		         
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

