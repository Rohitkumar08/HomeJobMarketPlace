package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.FactoryUtil;
import com.service.JobServiceImp;

/**
 * Servlet implementation class updateJobTitle
 */
@WebServlet("/updateJobTitle")
public class updateJobTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateJobTitle() {
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
		HttpSession session = request.getSession();
		String newJobTitle=request.getParameter("newJobTitle");
		System.out.println(session.getAttribute("currentJobTitle"));
		String currentJobTitle=(String) session.getAttribute("currentJobTitle");
		
		if(jbs.updateCurrentTitle(newJobTitle,currentJobTitle))
		{
			RequestDispatcher rd = request.getRequestDispatcher("updatedJobTitle.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
