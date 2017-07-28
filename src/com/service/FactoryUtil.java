package com.service;
import com.dao.*;
import com.bean.*;
import java.util.HashMap;

public class FactoryUtil {
	
	static String UserData;
	static String Member;
	static String Seeker;
	static String Sitter;
	static String Jobs;
	static String MemberServiceImp;
	public static HashMap<String, Object> mapClassInstance = new HashMap<>();
	
	public static void create(){
		
		 mapClassInstance.put(UserData, new UserData());
		 mapClassInstance.put(Member, new Member());
		 mapClassInstance.put(Seeker, new Seeker());
		 mapClassInstance.put(Sitter, new Sitter());
		 mapClassInstance.put(Jobs, new Jobs());
		 mapClassInstance.put(MemberServiceImp, new MemberServiceImp());
		
	}
	public static<T> T getInstance(String className){
		return (T) mapClassInstance.get(className);
		
	}
	
	
}
