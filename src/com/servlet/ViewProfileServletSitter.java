package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Seeker;
import com.bean.Sitter;
import com.service.FactoryUtil;
import com.service.MemberServiceImp;

/**
 * Servlet implementation class ViewProfileServletSItter
 */
@WebServlet("/ViewProfileServletSitter")
public class ViewProfileServletSitter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 MemberServiceImp mbs= (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileServletSitter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int uid=(int) session.getAttribute("uid");
		
		
		Sitter sitter= mbs.fetchSitterUserDetails(uid);
		request.setAttribute("sitter", sitter);
		  request.getRequestDispatcher("profileUpdateDetailSitter.jsp").forward(request, response);
		
	}

}