package com.service;

import com.bean.Member;
import com.bean.Seeker;
import com.bean.Sitter;
import com.dao.UserData;

public class MemberServiceImp {

	UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
	
	public boolean doRegister(Member mem) {
		// TODO Auto-generated method stub
		
		boolean register=ud.putUserData(mem);
		
		
		return register;
	}

	public void doRegisterSitter(int uid, Sitter sitter) {
		// TODO Auto-generated method stub
		ud.registerSitter(uid, sitter);
	}

	public void doRegisterSeeker(int uid, Seeker seeker) {
		// TODO Auto-generated method stub
		ud.registerSeeker(uid, seeker);
	}
	
	public boolean validateUser(String email, String pwd){
		String originalPwd = ud.getPassword(email);
		
		if(pwd.equals(originalPwd)){
			ud.getUserDetails(email);
			return true;
		}
	
		return false;
	}
	
	
}
