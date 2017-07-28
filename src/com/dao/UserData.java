package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Member;
import com.bean.Sitter;
import com.bean.Seeker;




public class UserData {
	
	
	private DBConnection con=new DBConnection();
	private Connection connect= con.getconnection(); 
	PreparedStatement ps;
	
	public boolean putUserData(Member mem){
		 
		String sql = "insert into users(uname, phone,uemail,utype,upassword) values(?,?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, mem.getFirstName());
			ps.setString(2, mem.getPhone());
			ps.setString(3, mem.getEmail());
			ps.setString(4, mem.getMemberType());
			ps.setString(5, mem.getPassword());
			
			ps.executeUpdate();
			System.out.println("******successfully registered*********");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		
		
		
	}

	public int getID(String email) {
		// TODO Auto-generated method stub
		int uid;
		String sql = "select uid from users where uemail= ?";
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				uid = rs.getInt("uid");
				
				System.out.println("inside get method"+uid);
				return uid;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}

	public void registerSitter(int uid, Sitter sitter) {
		// TODO Auto-generated method stub
		String sql = "insert into sitter(sitter_id, years_of_exp, expected_pay) values(?, ?, ?)";
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, sitter.getYearsOfExperience());
			ps.setInt(3, sitter.getExpectedPay());
			
			ps.executeUpdate();
			System.out.println("*****Sitters details inserted******");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void registerSeeker(int uid, Seeker seeker) {
		// TODO Auto-generated method stub
		String sql = "insert into seeker values(?, ?, ?)";
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, seeker.getNoOfChilds());
			ps.setString(3, seeker.getSpouseName());
			
			ps.executeUpdate();
			System.out.println("*****Seekers details inserted******");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
