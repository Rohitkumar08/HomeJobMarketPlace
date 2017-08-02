package com.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.Jobs;
import com.dao.*;

public class JobServiceImp {

	public boolean newJob(int uid){
		JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
		System.out.println(uid);
		System.out.println(jd);
		boolean created = jd.createJob(uid);
			
		return created;
		
	}
public boolean deleteJob(int uid, String jobTitle) {
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	   
		if(jd.deleteThisJob(uid,jobTitle))
		return true;
		else
			return false;
	}

public List<Jobs> updateJob(int uid){
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	List<Jobs> jobs=jd.fetchSeekerJobs(uid);
		return jobs;
	
}
public Jobs getJobDetails(String jobTitle) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	Jobs jb=jd.findDetailsOfJob(jobTitle);
	return jb;
}
public boolean updateCurrentTitle(String newTitle, String curentJobTitle) {
	// TODO Auto-generated method stub
//	if(email=="jobTitle"){
//		jd.updateJobTitle(email);
//	}
//	if(email=="startDate"){
//		updateStartDate(job.getJobTitle());
//	}
//	if(email=="endDate"){
//		updateEndDate(job.getJobTitle());
//	}
//	if(email=="payPerHour"){
//		updatePayPerHour(job.getJobTitle());
//	}
//
//	Jobs jb = 
//	
//	if(.updateJobTitle(newTitle)){
//		System.out.println("success");
//		return true;
//	}
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	if(jd.updateJobTitle(curentJobTitle, newTitle))
		return true;
	
	return false;
	
	
	
}
public boolean appliedForThisJob(String jobTitle, int uid) {
	// TODO Auto-generated method stub
	JobsData jd =(JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	int jobId=jd.getJobId(jobTitle);
	if(jd.applyThisJobDao(jobTitle, uid, jobId))
		return true;
	else
		return false;
}




}
