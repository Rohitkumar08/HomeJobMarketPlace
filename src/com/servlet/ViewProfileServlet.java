package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Jobs;
import com.bean.Seeker;
import com.service.FactoryUtil;
import com.service.JobServiceImp;
import com.service.MemberServiceImp;

/**
 * Servlet implementation class ViewProfileServlet
 */
@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 MemberServiceImp mbs= (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileServlet() {
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
		if(session.getAttribute("uname")==null || !(session.getAttribute("utype").equals("Seeker"))){
			System.out.println("***************************************8");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		int uid=(int) session.getAttribute("uid");
		
		
		Seeker seeker= mbs.fetchSeekerUserDetails(uid);
		request.setAttribute("seeker", seeker);
		  request.getRequestDispatcher("profileUpdateDetail.jsp").forward(request, response);
		
	}

}
