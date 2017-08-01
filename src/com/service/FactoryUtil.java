package com.service;
import com.dao.*;
import com.bean.*;
import java.util.HashMap;

public class FactoryUtil {
	
	public final static String USERDATA="userData";
	public final static String MEMBER="member";
	public final static String SEEKER="seeker";
	public final static String 	SITTER="sitter";
	public final static String JOBS="jobs";
	public final static String MEMBERSERVICEIMP="memberServiceImp";
	public final static String JOBSERVICEIMP="jobServiceImp";
	public final static String JOBSDATA="jobsData";
	public static HashMap<String, Object> mapClassInstance = new HashMap<>();
	
	static {
		
		 mapClassInstance.put(USERDATA, new UserData());
		 mapClassInstance.put(MEMBER, new Member());
		 mapClassInstance.put(SEEKER, new Seeker());
		 mapClassInstance.put(SITTER, new Sitter());
		 mapClassInstance.put(JOBS, new Jobs());
		 mapClassInstance.put(MEMBERSERVICEIMP, new MemberServiceImp());
		 mapClassInstance.put(JOBSERVICEIMP, new JobServiceImp());
		 mapClassInstance.put(JOBSDATA, new JobsData());
	}
//	public static  <T> T getInstance(String className){
//		
//		System.out.println("*****************************");
//		return (T) mapClassInstance.get(className);
//		
//	}
//	
	
}
