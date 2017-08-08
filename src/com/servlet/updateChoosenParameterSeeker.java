package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Seeker;
import com.service.FactoryUtil;
import com.service.MemberServiceImp;

/**
 * Servlet implementation class updateChoosenParameterSeeker
 */
@WebServlet("/updateChoosenParameterSeeker")
public class updateChoosenParameterSeeker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Seeker seeker = (Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER);
       MemberServiceImp mbs = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateChoosenParameterSeeker() {
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
		seeker.setFirstName(request.getParameter("firstName"));
		seeker.setPhone(request.getParameter("phoneNo"));
		seeker.setEmail(request.getParameter("email"));
		seeker.setPassword(request.getParameter("password"));
		seeker.setNoOfChilds(Integer.parseInt(request.getParameter("no_of_child")));
        seeker.setSpouseName(request.getParameter("spouseName"));
        
		if(mbs.updateSeekerDetails(uid,seeker)){
			
			RequestDispatcher rd= request.getRequestDispatcher("profileUpdatedSeeker.jsp");
			rd.forward(request, response);
			
			
		}
		else{
			RequestDispatcher rd= request.getRequestDispatcher("errorProfileUpdatedSeeker.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
