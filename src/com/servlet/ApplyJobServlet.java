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
 * Servlet implementation class ApplyJobServlet
 */
@WebServlet("/ApplyJobServlet")
public class ApplyJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      JobServiceImp jbs= (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyJobServlet() {
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
		int uid=(int) session.getAttribute("uid");
		
		String selected[]= request.getParameterValues("inputed");
		String jobTitle=selected[0].substring(7);
			System.out.println(selected[0].substring(6));
			if(jbs.appliedForThisJob(jobTitle,uid)){
				
				RequestDispatcher rd = request.getRequestDispatcher("successApp.jsp");
				rd.forward(request, response);
			}
			
			
	}

}
