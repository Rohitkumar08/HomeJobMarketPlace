package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Member;
import com.service.FactoryUtil;
import com.service.MemberServiceImp;

/**
 * Servlet implementation class AdminLoggedIn
 */
@WebServlet("/AdminLoggedIn")
public class AdminLoggedIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
     MemberServiceImp mbs = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoggedIn() {
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
		
		List<Member> admin=mbs.getAllData(uid);
		request.setAttribute("users", admin);
		RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
		rd.forward(request, response);
	}

}
