package com.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.*;
import com.service.FactoryUtil;

public class validation {
	Member mem = (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
	Jobs job = (Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
	public boolean validateName(){
//		char[] arr = firstName.toCharArray();
		mem.getFirstName(); 	
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(mem.getFirstName());
		boolean b = m.find();
		//System.out.println(b);
		if(b){
			System.out.println("***Enter valid name*****");
			return false;
		}
		
		else
			return true;
	}
	
	
	//VAlidation for Phone no
	public boolean validatePhone(){
		
//		Pattern p = Pattern.compile("\\d{3}");
//		Matcher m = p.matcher(phone);
	
//		if(b){
//			System.out.println("***Enter valid Mobile no with 10 digits*****");
//			return false;
//		}
//		
//		else
//			return true;
		
		if (mem.getPhone().matches("\\d{10}")) 
			return true;
		
	      else
	      {
	    	  System.out.println("Phone Number must be in the form XXX-XXXXXXX");
	    	  return false;
	      }
		
	}
	
	//validation for Email
	
	public boolean validateEmail(){
		final String EMAIL_REGEX="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})";
	    //static Pattern object, since pattern is fixed
	    Pattern pattern;
	    //non-static Matcher object because it's created from the input String
	    Matcher matcher;
	    pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	    matcher = pattern.matcher(mem.getEmail());
	    if(matcher.matches()){
	    	return true;
	    }
	    else{
	    	System.out.println("*******PLEASE ENTER VALID EMAIL ADD******");
	    	return false;
	    }
		
	}



	public boolean validateEndDate() throws ParseException {
		// TODO Auto-generated method stub
		String date1 = job.getStartDate();
		String date2 = job.getEndDate();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date startDate = format.parse(date1);
		Date endDate = format.parse(date2);

		if (startDate.compareTo(endDate) <0) {
		    System.out.println("earlier");
		    System.out.println("");
		    return true;
		}
		else if(startDate.compareTo(endDate)==0){
			
			 String startTime = job.getStartTime();
			    String endTime = job.getEndTime();
			    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			    Date d1 = sdf.parse(startTime);
			    Date d2 = sdf.parse(endTime);
			    long elapsed = d2.getTime() - d1.getTime(); 
			    System.out.println(elapsed);

			if (elapsed<0) {
			    System.out.println("earlier");
			    System.out.println("");
			    return false;
			}
		    else{
		    	
		    return true;	
		    }
			
			
		}
	    else{
	    	
	    return false;	
	    }
		
	}
//	public boolean validateEndTime() throws ParseException {
//		// TODO Auto-generated method stub
//		 String startTime = job.getStartTime();
//		    String endTime = job.getEndTime();
//		    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//		    Date d1 = sdf.parse(startTime);
//		    Date d2 = sdf.parse(endTime);
//		    long elapsed = d2.getTime() - d1.getTime(); 
//		    System.out.println(elapsed);
//
//		if (elapsed<0) {
//		    System.out.println("earlier");
//		    System.out.println("");
//		    return true;
//		}
//	    else{
//	    	
//	    return false;	
//	    }
//		
//	}


	public boolean validatePayPerHour() {
		// TODO Auto-generated method stub
		int checkHour=job.getPayPerHour();
		if(checkHour<=0)
			return true;
		else
		return false;
	}

	

}
