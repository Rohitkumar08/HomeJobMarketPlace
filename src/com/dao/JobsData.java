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
	
	public List<Jobs> listAllJobs(int uid) {
		// TODO Auto-generated method stub
		
		String sql = "select * from Jobs where posted_by=? and status='ACTIVE'";
		List<Jobs>  jobs= new ArrayList<>();
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1,uid);
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
	public List<Jobs> listAllJobsForSeekers() {
		// TODO Auto-generated method stub
		
		String sql = "select * from Jobs where status='ACTIVE' ";
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

	public boolean updateJobTitle(String currentJobTitle, String newJobTitle) {
		// TODO Auto-generated method stub
		sql = "update Jobs set job_title =? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newJobTitle);
			ps.setString(2, currentJobTitle);
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
			
			sql = "update Jobs set status='INACTIVE' where job_title=?";
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
		sql = "select job_title,status from Jobs where posted_by= ? and status='ACTIVE'";
		List<Jobs> jobs= new ArrayList<>();
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Jobs jb=new Jobs();
				jb.setJobTitle(rs.getString("job_title"));
				jb.setStatus(rs.getString("status"));
				jobs.add(jb);
				System.out.println("inside dao"+jb.getJobTitle());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobs;
	}
	public List<Jobs> getAppliedJobs(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from Jobs where job_id IN (select jobId from Application where member_id=?) and status='ACTIVE'";
         List<Jobs>  jobApplied= new ArrayList<>();
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Jobs jb=new Jobs();
				jb.setJobTitle(rs.getString("job_title"));
				jb.setStartDate(rs.getString("start_date"));
				System.out.println("*************"+jb.getStartDate());
				jb.setEndDate(rs.getString("end_date"));
				jb.setStartTime(rs.getString("start_time"));
				jb.setEndTime(rs.getString("end_time"));
				jb.setPayPerHour(rs.getInt("pay_per_hour"));
				
				jobApplied.add(jb);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobApplied;
	
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
				jb.setStatus(rs.getString("status"));
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

	public boolean updateJobTitle(String newJobTitle) {
		// TODO Auto-generated method stub
		Jobs job = new Jobs();
		sql = "update Jobs set job_title =? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newJobTitle);
			System.out.println("****************"+ job.getJobTitle());
			ps.setString(2, job.getJobTitle());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}
	public int getExpectedPay(int user_id){
		String sql = "select expected_pay from sitter where sitter_id = ?";
		int expected_pay = 0;
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				expected_pay = rs.getInt("expected_pay");
			}
			return expected_pay;
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expected_pay;
	}
	
	
	public int getJobId(String jobTitle){
		String sql = "select job_id from jobs where job_title = ?";
		int jobId = 0;
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				jobId = rs.getInt("job_id");
			}
			
			return jobId;
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 1;
	}

	public boolean applyThisJobDao(String jobTitle, int uid, int jobId) {
		// TODO Auto-generated method stub
		int expected_pay=getExpectedPay(uid);
		String sql = "insert into Application(jobId, Expected_pay, member_id) values(?, ? , ?)";
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, jobId);
			ps.setInt(2, expected_pay);
			ps.setInt(3, uid);
			ps.executeUpdate();
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteThisAppDao(String jobTitle, int uid, int jobId) {
		// TODO Auto-generated method stub
		String sql = "delete from Application where jobId =(select job_id from Jobs where job_title=?) AND member_id=?";
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ps.setInt(2, uid);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;			
		}
		
		
		
	}

	public boolean updateTheseJobDetails(Jobs job, String oldJobTitle) {
		// TODO Auto-generated method stub
		
		sql = "update Jobs set job_title =?, start_date=?, end_date=?, pay_per_hour=?, status=? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, job.getJobTitle());
			ps.setString(2, job.getStartDate());
			ps.setString(3, job.getEndDate());
			ps.setInt(4, job.getPayPerHour());
			ps.setString(5, job.getStatus());
			System.out.println("****************"+ job.getJobTitle());
			ps.setString(6, oldJobTitle);
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	

}
