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
		 *  member ���̺� �ִ� ��� ������ 
		 *  List<MemberDto> ���·� ��� ������.
		 */
		//Connection ��ü�� ������ ������ 
		Connection conn=new DBConnect().getConn();
		//�ʿ��� ��ü�� ���� ���� ����� 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//MemberDto ��ü�� ���� ArrayList ��ü����
		List<MemberDto> list=new ArrayList<>();
		try{
			//������ sql �� �غ� 
			String sql="SELECT num, name, addr FROM member";
			//PreparedStatement ��ü�� ������ ������
			//(sql ���� ��� �������� ��ü)
			pstmt=conn.prepareStatement(sql);
			//ResultSet ��ü�� ������ ������ 
			//(SELECT ���� ���� ��� ���� ������ �ִ� ��ü)
			rs=pstmt.executeQuery();
			//�ݺ��� ���鼭 cursor �� ��ĭ�� ������. 
			while(rs.next()){
				//���� cursor �� ��ġ�� ���� 
				//row ���� ���ϴ� Į���� �����͸� ���´�.
				int  num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				//MemberDto ��ü�� ȸ������ ���
				MemberDto dto=new MemberDto(num, name, addr);
				//ArrayList ��ü�� MemberDto ��� 
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
		
		System.out.println("���� �޼ҵ尡 ���� �˴ϴ�.");
	}
}

