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
 * Servlet implementation class deletedJob
 */
@WebServlet("/deletedJob")
public class deletedJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
      JobServiceImp jbs= (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletedJob() {
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
//		String job= request.getParameter("jobToBeDeleted");
//		System.out.println(job);
		HttpSession session = request.getSession(); 

		if(session.getAttribute("utype")==null){
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		if(!(session.getAttribute("utype").equals("Seeker"))){
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		int uid=(int) session.getAttribute("uid");
		
		String selected[]= request.getParameterValues("inputed");
		String email=selected[0].substring(7);
			System.out.println(selected[0].substring(7));
			
		if(jbs.deleteJob(uid,email)){
			RequestDispatcher rd = request.getRequestDispatcher("successDeletionOfJob.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("errorInDeletionOfJob.jsp");
			rd.forward(request, response);
		}
		
	}

}
