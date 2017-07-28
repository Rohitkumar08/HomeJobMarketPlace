package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Member;
import com.bean.Seeker;
import com.bean.Sitter;
import com.dao.UserData;
import com.service.MemberServiceImp;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String UserData;
	String MemberServiceImp;
	String Seeker;
	String Member;
	String Sitter;
	UserData ud = FactoryUtil.getInstance(UserData);
	MemberServiceImp svc= FactoryUtil.getInstance(MemberServiceImp);
     Seeker seeker = FactoryUtil.getInstance(Seeker);  
     Member mem= FactoryUtil.getInstance(Member);
     Sitter sitter = FactoryUtil.getInstance(Sitter);
     
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
		
		
		mem.setFirstName(request.getParameter("name"));;
		mem.setPhone(request.getParameter("mobile"));
		mem.setEmail(request.getParameter("email"));
		mem.setPassword(request.getParameter("password"));
		mem.setAdd(request.getParameter("address"));
		mem.setMemberType(request.getParameter("memberType"));
		System.out.println(mem.getMemberType());
		
		boolean registered=svc.doRegister(mem);
		if(registered){
			String uType = mem.getMemberType();
			int uid = ud.getID(mem.getEmail());
			if(uType.equals("Sitter")){
				sitter.setExpectedPay(Integer.parseInt(request.getParameter("expectedPay")));
				sitter.setYearsOfExperience(Integer.parseInt(request.getParameter("yoe")));
				svc.doRegisterSitter(uid,sitter);
				
				RequestDispatcher rd= request.getRequestDispatcher("PerformSitter.jsp");
				rd.forward(request, response);
				
					//TODO sitter operations
//				fillSitterDetails(uid,sc);
//				performSitterTask(uid,sc);
			}
			else{
				seeker.setNoOfChilds(Integer.parseInt(request.getParameter("noOfChilds")));
				seeker.setSpouseName(request.getParameter("spouseName"));
					svc.doRegisterSeeker(uid,seeker);
					RequestDispatcher rd= request.getRequestDispatcher("PerformSeeker.jsp");
					rd.forward(request, response);
//				fillSeekerDetails(uid,sc);
//				performSeekerTask(uid,sc);
			
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
