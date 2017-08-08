package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Sitter;
import com.service.FactoryUtil;
import com.service.MemberServiceImp;

/**
 * Servlet implementation class UpdateChoosenParameterSitter
 */
@WebServlet("/UpdateChoosenParameterSitter")
public class UpdateChoosenParameterSitter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberServiceImp mbs = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
    Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChoosenParameterSitter() {
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
		HttpSession session = request.getSession();
		int uid= (int) session.getAttribute("uid");
		sitter.setFirstName(request.getParameter("firstName"));
		sitter.setPhone(request.getParameter("phoneNo"));
		sitter.setEmail(request.getParameter("email"));
		sitter.setPassword(request.getParameter("password"));
		sitter.setYearsOfExperience(Integer.parseInt(request.getParameter("yearsOfExp")));
        sitter.setExpectedPay(Integer.parseInt(request.getParameter("expectedPay")));
        
		if(mbs.updateSitterDetails(uid,sitter)){
			
			RequestDispatcher rd= request.getRequestDispatcher("profileUpdatedSitter.jsp");
			rd.forward(request, response);
			
			
		}
		else{
			RequestDispatcher rd= request.getRequestDispatcher("errorProfileUpdatedSitter.jsp");
			rd.forward(request, response);
		}
		
	}

}
