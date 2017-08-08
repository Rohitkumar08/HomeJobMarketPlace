package com.servlet;

import java.io.IOException;
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

import com.bean.*;
import com.dao.UserData;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SALT = "my-salt-text";
	
	
      MemberServiceImp mbs= (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP); 
      Member mem = (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
      UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    			response.setContentType("text/html");
    			String email = request.getParameter("userEmail");
    			System.out.println(email);
    			String pwd = request.getParameter("password");
    			
    			String saltedPassword = SALT + pwd;
    			String hashedPassword = generateHash(saltedPassword);
    			mem.setEmail(email);
    			System.out.println(mem.getEmail());
    			if(mbs.validateUser(email, hashedPassword)){
    				
    				HttpSession session=request.getSession();  
    		        session.setAttribute("uid",ud.getID(email));  
    		        ud.getUserDetails(email);
    		        session.setAttribute("uname",mem.getFirstName()); 
    		        session.setAttribute("uid", ud.getID(email));
    		        System.out.println(session.getAttribute("uid"));
    				String uType=mem.getMemberType();
    				session.setAttribute("utype", uType);
    				if(uType.equals("Seeker")){
    					RequestDispatcher rd = request.getRequestDispatcher("PerformSeeker.jsp");
    					rd.forward(request, response);
    				}
    				else{
    					RequestDispatcher rd = request.getRequestDispatcher("PerformSitter.jsp");
    					rd.forward(request, response);
    				}
    				
    			}
    			else{
    				
    				RequestDispatcher rd = request.getRequestDispatcher("invalidCredentialsForLogin.jsp");
					rd.forward(request, response);
    				
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
