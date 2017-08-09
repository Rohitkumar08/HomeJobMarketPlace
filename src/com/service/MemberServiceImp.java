package com.service;

import java.util.List;

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

	public Seeker fetchSeekerUserDetails(int uid) {
		// TODO Auto-generated method stub
		Seeker seeker=ud.fetchSeekerMemberData(uid);
		return seeker;
	}

	public boolean updateSeekerDetails(int uid,Seeker seeker) {
		// TODO Auto-generated method stub
		if(ud.updateSeekerDetailsDao(uid,seeker)){
			return true;
		}
		else
		return false;
	}

	public Sitter fetchSitterUserDetails(int uid) {
		// TODO Auto-generated method stub
		Sitter sitter=ud.fetchSitterMemberData(uid);
		return sitter;
	}

	public boolean updateSitterDetails(int uid, Sitter sitter) {
		// TODO Auto-generated method stub
		if(ud.updateSitterDetailsDao(uid,sitter)){
			return true;
		}
		else
		return false;
	}

	public List<String> getSearchData(String keyWord) {
		
		List<String> emails= ud.getSearchedEmails(keyWord);
		
		
		
		return emails;
		// TODO Auto-generated method stub
		
	}

	public boolean deleteSeekerDetails(int uid) {
		// TODO Auto-generated method stub
		if(ud.deleteSeeker(uid)){
			return true;
			
		}
		return false;
	}

	public boolean deleteSitterDetails(int uid) {
		// TODO Auto-generated method stub
		if(ud.deleteSitter(uid)){
			return true;
			
		}
		return false;
	}

	public List<Member> getAllData(int uid) {
		// TODO Auto-generated method stub
		
	List<Member> allData= ud.fetchAdminData(uid);
	return allData;
	}
	
	
}
