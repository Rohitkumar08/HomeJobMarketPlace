package com.dao;
import java.text.ParseException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.bean.*;


import com.service.FactoryUtil;

public class JobsData {
	DBConnection con=new DBConnection();
	Connection connect= con.getconnection(); 
	PreparedStatement ps;
	String sql;
	
	Jobs job = (Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
	public boolean createJob(int uid) {
		
		System.out.println("*****jhdbcjcecbucj");
		sql = "insert into Jobs(job_title, posted_by, start_date, end_date, start_time, end_time, pay_per_hour) values(?,?,?,?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, job.getJobTitle());
			ps.setInt(2, uid);
			ps.setString(3, job.getStartDate());
			ps.setString(4, job.getEndDate());
			ps.setString(5, job.getStartTime());
			ps.setString(6,job.getEndTime());
			ps.setInt(7, job.getPayPerHour());
			
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}

	public void updateJob(String job_title, String updateParameter) {
		// TODO Auto-generated method stub
//		sql = "update "
		
		
		
		
	}
	
	public List<Jobs> listAllJobs() {
		// TODO Auto-generated method stub
		
		String sql = "select * from Jobs";
		List<Jobs>  jobs= new ArrayList<>();
		
		try {
			ps= connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				//Jobs jb= (Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
				Jobs jb=new Jobs();
				jb.setJobTitle(rs.getString("job_title"));
				jb.setStartDate(rs.getString("start_date"));
				jb.setEndDate(rs.getString("end_date"));
				jb.setStartTime(rs.getString("start_time"));
				jb.setEndTime(rs.getString("end_time"));
				jb.setPayPerHour(rs.getInt("pay_per_hour"));
				jobs.add(jb);
				System.out.println("inside dao"+jb.getJobTitle());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;
		
	}
	

	public boolean deleteJob(String job_title, int uid) {
		
		// TODO Auto-generated method stub
		int posted_By=0;
		sql = "select posted_by from Jobs where job_title= ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, job_title);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				posted_By = rs.getInt("posted_by");
				System.out.println("Posted by:    "+posted_By);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(posted_By == uid){
			
			sql = "delete from Jobs where job_title= ?";
			try {
				ps = connect.prepareStatement(sql);
				ps.setString(1, job_title);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else
			return false;
		
		return true;
		
	
	}

	public boolean updateJobTitle(String job_title, String newJobTitle) {
		// TODO Auto-generated method stub
		sql = "update Jobs set job_title =? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newJobTitle);
			ps.setString(2, job_title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public boolean updateJobStart(String job_title, String newStartDate) {
		// TODO Auto-generated method stub
		sql = "update Jobs set start_date = ? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newStartDate);
			ps.setString(2, job_title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateJobEnds(String job_title, String newEndDate) {
		// TODO Auto-generated method stub
		sql = "update Jobs set end_date = ? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newEndDate);
			ps.setString(2, job_title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteThisJob(int uid, String jobTitle) {
		// TODO Auto-generated method stub
		int posted_By=0;
		sql = "select posted_by from Jobs where job_title= ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				posted_By = rs.getInt("posted_by");
				System.out.println("Posted by:    "+posted_By);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(posted_By == uid){
			
			sql = "delete from Jobs where job_title= ?";
			try {
				ps = connect.prepareStatement(sql);
				ps.setString(1, jobTitle);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else
			return false;
		
		
		return true;
	}

	public List<Jobs> fetchSeekerJobs(int uid) {
		// TODO Auto-generated method stub
		int posted_By=0;
		sql = "select job_title from Jobs where posted_by= ?";
		List<Jobs> jobs= new ArrayList<>();
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Jobs jb=new Jobs();
				jb.setJobTitle(rs.getString("job_title"));
				jobs.add(jb);
				System.out.println("inside dao"+jb.getJobTitle());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobs;
	}

	public Jobs findDetailsOfJob(String jobTitle) {
		// TODO Auto-generated method stub
		sql = "select * from Jobs where job_title= ?";
		
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ResultSet rs = ps.executeQuery();
			Jobs job;
			while(rs.next()){
				
				Jobs jb=new Jobs();
				jb.setJobTitle(rs.getString("job_title"));
				jb.setStartDate(rs.getString("start_date"));
				jb.setEndDate(rs.getString("end_date"));
				jb.setStartTime(rs.getString("start_time"));
				jb.setEndTime(rs.getString("end_time"));
				jb.setPayPerHour(rs.getInt("pay_per_hour"));
				//jobs.add(jb);
				
				System.out.println("inside dao"+jb.getJobTitle());
				return jb;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
		
	}

}