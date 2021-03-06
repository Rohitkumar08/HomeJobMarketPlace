package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Member;
import com.bean.Seeker;
import com.bean.Sitter;
import com.dao.UserData;
import com.service.MemberServiceImp;
import com.validations.*;
/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	validation val=new validation();
	public static final String SALT = "my-salt-text";
    
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		
		MemberServiceImp svc= (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
	     Seeker seeker =(Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER);  
	    Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
	     //Member mem = new Member();
	     Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		 System.out.println(ud);
		 System.out.println("********** "+request.getParameter("memberType"));
		 
		mem.setFirstName(request.getParameter("name"));
		mem.setPhone(request.getParameter("mobile"));
		mem.setEmail(request.getParameter("email"));
		
		String password=request.getParameter("password");
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);
		System.out.println("*******"+hashedPassword);
		mem.setPassword(hashedPassword);
		
		mem.setAdd(request.getParameter("address"));
		mem.setMemberType(request.getParameter("memberType"));
		System.out.println(mem.getMemberType());

		if(!val.validateName())
		{
			request.setAttribute("errorParameter", "name");
			RequestDispatcher rd= request.getRequestDispatcher("errorName.jsp");
			rd.forward(request, response);
		}
		System.out.println(mem.getFirstName());
		if(!val.validatePhone())
		{
			request.setAttribute("errorParameter", "Phone No");
			RequestDispatcher rd= request.getRequestDispatcher("errorName.jsp");
			rd.forward(request, response);
		}
		
		if(!val.validateEmail())
		{
			request.setAttribute("errorParameter", "Email");
			RequestDispatcher rd= request.getRequestDispatcher("errorName.jsp");
			rd.forward(request, response);
		}
		
		String email = mem.getEmail();
		if(ud.emailExist(email)){
			ud.setPipeline(email);
		}
		boolean registered=svc.doRegister(mem);
		if(registered){
			String uType = mem.getMemberType();
			int uid = ud.getID(mem.getEmail());
			HttpSession session = request.getSession();
			session.setAttribute("uname", mem.getFirstName());
			session.setAttribute("utype", uType);
	        session.setAttribute("uid",uid);  
			if(uType.equals("Sitter")){
				sitter.setExpectedPay(Integer.parseInt(request.getParameter("expectedPay")));
				sitter.setYearsOfExperience(Integer.parseInt(request.getParameter("yoe")));
				svc.doRegisterSitter(uid,sitter);
				
				RequestDispatcher rd= request.getRequestDispatcher("PerformSitter");
				rd.forward(request, response);
				
					//TODO sitter operations
//				fillSitterDetails(uid,sc);
//				performSitterTask(uid,sc);
			}
			else{
				seeker.setNoOfChilds(Integer.parseInt(request.getParameter("noOfChilds")));
				seeker.setSpouseName(request.getParameter("spouseName"));
					svc.doRegisterSeeker(uid,seeker);
					RequestDispatcher rd= request.getRequestDispatcher("PerformSeeker");
					rd.forward(request, response);
//				fillSeekerDetails(uid,sc);
//				performSeekerTask(uid,sc);
			
			}
		
	}
		else{
			RequestDispatcher rd= request.getRequestDispatcher("errorLogin.jsp");
			rd.forward(request, response);
			System.out.println("****EMAIL ID ALREADY EXISTS****");
		}
		
		
	}
    public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
