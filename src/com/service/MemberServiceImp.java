package com.service;

import com.bean.Member;
import com.bean.Seeker;
import com.bean.Sitter;
import com.dao.UserData;

public class MemberServiceImp {

	UserData ud = new UserData();
	
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
	
	

}
