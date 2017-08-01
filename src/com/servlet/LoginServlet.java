package com.servlet;

import java.io.IOException;
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
    			mem.setEmail(email);
    			System.out.println(mem.getEmail());
    			if(mbs.validateUser(email, pwd)){
    				
    				HttpSession session=request.getSession();  
    		        session.setAttribute("uid",ud.getID(email));  
    		        ud.getUserDetails(email);
    		        session.setAttribute("uname",mem.getFirstName()); 
    		        
    				String uType=mem.getMemberType();
    				if(uType.equals("Seeker")){
    					RequestDispatcher rd = request.getRequestDispatcher("PerformSeeker.jsp");
    					rd.forward(request, response);
    				}
    				else{
    					RequestDispatcher rd = request.getRequestDispatcher("PerformSitter.jsp");
    					rd.forward(request, response);
    				}
    				
    			}
    	
    	
    	
    	
	}
    
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}