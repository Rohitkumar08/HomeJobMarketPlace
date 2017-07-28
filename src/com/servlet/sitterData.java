package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Member;
import com.bean.Sitter;
import com.dao.UserData;

/**
 * Servlet implementation class sitter
 */
@WebServlet("/sitterData")
public class sitterData extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Sitter sitter= new Sitter(); 
      UserData ud = new UserData();
      Member mem= new Member();
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public sitterData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		sitter.setExpectedPay(Integer.parseInt(request.getParameter("expectedPay")));
		sitter.setYearsOfExperience(Integer.parseInt(request.getParameter("experience")));
		int uid = ud.getID(mem.getEmail());
		ud.registerSitter(uid, sitter);
		
		
		
		
		
		
		
		
	}

}
