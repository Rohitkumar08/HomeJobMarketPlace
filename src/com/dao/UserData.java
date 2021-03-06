package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Jobs;
import com.bean.Member;
import com.bean.Sitter;
import com.service.FactoryUtil;
import com.bean.Seeker;




public class UserData {
	
	Member mem = (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
	Seeker seeker = (Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER);
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
		String sql = "select uid from users where uemail= ? and ustatus='ACTIVE'";
		
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
	public String getPassword(String email){
		
		String sql = "select upassword from users where uemail = ? and ustatus='ACTIVE'";
		String pwd="";
		try{
			
			 ps = connect.prepareStatement(sql);
			 ps.setString(1, email);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 pwd = rs.getString("upassword");
				 System.out.println(pwd);
				
			 }
			
		}catch(SQLException e){
			System.out.println("password error");
			return null;
		}
		return pwd;
		
		
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

	public void getUserDetails(String email) {
		// TODO Auto-generated method stub
		
		
			String uType=null;
			String sql = "select * from users where uemail= ? and ustatus='ACTIVE'";
			
			try {
				ps= connect.prepareStatement(sql);
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Member mem = (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
					System.out.println(rs.getString("utype"));
					mem.setMemberType(rs.getString("utype"));
					mem.setEmail(rs.getString("uemail"));
					mem.setFirstName(rs.getString("uname"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	public List<Sitter> fetchApplicants(int uid, String jobTitle) {
		// TODO Auto-generated method stub
		
		String sql= "select u.uname,s.years_of_exp,s.expected_pay from application a,jobs j,users u,sitter s where j.job_title= ? and j.job_Id=a.jobId and a.member_id=u.uid and u.uid=s.sitter_id and u.ustatus='ACTIVE'";

		List<Sitter>  sitters= new ArrayList<>();
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				//Jobs jb= (Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
			
				Sitter sitter = new Sitter();
				sitter.setFirstName(rs.getString("uname"));
				sitter.setExpectedPay(rs.getInt("expected_pay"));
				sitter.setYearsOfExperience(rs.getInt("years_of_exp"));
				sitters.add(sitter);
//				jobs.add(jb);
//				System.out.println("inside dao"+jb.getJobTitle());
//				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sitters;
	}

	public Seeker fetchSeekerMemberData(int uid) {
		// TODO Auto-generated method stub
		Seeker seeker = (Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER);
		String uType=null;
		String sql = "select * from users where uid= ? and ustatus='ACTIVE'";
		String sql1 = "select * from seeker where seeker_id = ?";
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				System.out.println(rs.getString("utype"));
				seeker.setMemberType(rs.getString("utype"));
				seeker.setEmail(rs.getString("uemail"));
				seeker.setFirstName(rs.getString("uname"));
				seeker.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps= connect.prepareStatement(sql1);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				
//				System.out.println(rs.getString("utype"));
				seeker.setNoOfChilds(rs.getInt("no_of_child"));
				seeker.setSpouseName(rs.getString("spouse_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seeker;
	}

	public boolean updateSeekerDetailsDao(int uid,Seeker seeker) {
		// TODO Auto-generated method stub
		
		
		String sql = "update users set uname =?, phone=?, uemail=?, upassword=?, where uid = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, seeker.getFirstName());
			ps.setString(2, seeker.getPhone());
			ps.setString(3, seeker.getEmail());
			ps.setString(4, seeker.getPassword());
			ps.setInt(5, uid);
			ps.executeUpdate();
			System.out.println(seeker.getFirstName()+ "****"+ seeker.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 sql = "update seeker set no_of_child =?, spouse_name=? where seeker_id=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, seeker.getNoOfChilds());
			ps.setString(2, seeker.getSpouseName());
			ps.setInt(3, uid);
			ps.executeUpdate();
			
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	public Sitter fetchSitterMemberData(int uid) {
		// TODO Auto-generated method stub
		Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		String uType=null;
		String sql = "select * from users where uid= ?";
		String sql1 = "select * from sitter where sitter_id = ?";
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				System.out.println(rs.getString("utype"));
				sitter.setMemberType(rs.getString("utype"));
				sitter.setEmail(rs.getString("uemail"));
				sitter.setFirstName(rs.getString("uname"));
				sitter.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps= connect.prepareStatement(sql1);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				
//				System.out.println(rs.getString("utype"));
				sitter.setYearsOfExperience(Integer.parseInt(rs.getString("years_of_exp")));
				sitter.setExpectedPay(Integer.parseInt(rs.getString("expected_pay")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sitter;
	}

	public boolean updateSitterDetailsDao(int uid, Sitter sitter) {
		// TODO Auto-generated method stub
		String sql = "update users set uname =?, phone=?, uemail=?, upassword=?, where uid = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, sitter.getFirstName());
			ps.setString(2, sitter.getPhone());
			ps.setString(3, sitter.getEmail());
			ps.setString(4, sitter.getPassword());
			ps.setInt(5, uid);
			ps.executeUpdate();
			System.out.println(sitter.getFirstName()+ "****"+ sitter.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 sql = "update sitter set years_of_exp =?, expected_pay=? where sitter_id=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, sitter.getYearsOfExperience());
			ps.setInt(2, sitter.getExpectedPay());
			ps.setInt(3, uid);
			ps.executeUpdate();
			
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<String> getSearchedEmails(String keyWord) {
		// TODO Auto-generated method stub
		String sql = "select uemail from users where (uemail LIKE ? and utype='Seeker' and ustatus='ACTIVE')";
		List<String> fetchedData = new ArrayList<>();
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
//				System.out.println(rs.getString("utype"));
				fetchedData.add(rs.getString("uemail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fetchedData;
	}

	public boolean deleteSeeker(int uid) {
		// TODO Auto-generated method stub
		
		String sql = "update users set ustatus='INACTIVE' where uid=?";
			try {
				ps = connect.prepareStatement(sql);
				ps.setInt(1, uid);
				ps.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			
			}
			sql = "update jobs set status='INACTIVE' where posted_by=?";
			try {
				ps = connect.prepareStatement(sql);
				ps.setInt(1, uid);
				ps.executeUpdate();
			return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				return false;
			}
	}

	public boolean deleteSitter(int uid) {
		// TODO Auto-generated method stub
		String sql = "update users set ustatus='INACTIVE' where uid=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
		}
		sql = "update Application set appstatus='INACTIVE' where member_id=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();
		return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return false;
		}
	}

	public List<Member> fetchAdminData(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		List<Member> members = new ArrayList<>();
		try {
			ps= connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Member mem = new Member();
				mem.setFirstName(rs.getString("uname"));
				mem.setEmail(rs.getString("uemail"));
				mem.setMemberType(rs.getString("utype"));
				mem.setPhone(rs.getString("phone"));
				mem.setStatus(rs.getString("ustatus"));
				members.add(mem);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return members;
		
	}

	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from users where uemail=? and ustatus='INACTIVE'";
		int count=0;
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count++;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			return true;
		}
		
		return false;
	}

	public void setPipeline(String email) {
		// TODO Auto-generated method stub
		String sql="update users set uemail=? where uemail=?";
		String flagEmail = email;
		flagEmail=flagEmail.concat("|");
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, flagEmail);
			ps.setString(2,email);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
