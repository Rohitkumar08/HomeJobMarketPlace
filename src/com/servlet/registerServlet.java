package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Member;
import com.dao.UserData;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserData ud = new UserData();
       
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
		Member mem=new Member();
		
		mem.setFirstName(request.getParameter("name"));;
		mem.setPhone(request.getParameter("mobile"));
		mem.setEmail(request.getParameter("email"));
		mem.setAdd(request.getParameter("address"));
		mem.setMemberType(request.getParameter("memberType"));
		
		boolean registered=ud.putUserData(mem);
		if(registered){
			String uType = mem.getMemberType();
			int uid = ud.getID(mem.getEmail());
			if(uType.equals("sitter")){
					//TODO sitter operations
				fillSitterDetails(uid,sc);
				performSitterTask(uid,sc);
			}
			else{
				
				fillSeekerDetails(uid,sc);
				performSeekerTask(uid,sc);
			
			}
		
	}
		else{
			System.out.println("****EMAIL ID ALREADY EXISTS****");
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
