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
}
