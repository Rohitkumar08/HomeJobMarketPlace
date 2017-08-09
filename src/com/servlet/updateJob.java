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
import com.service.FactoryUtil;
import com.service.JobServiceImp;

/**
 * Servlet implementation class updateJob
 */
@WebServlet("/updateJob")
public class updateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 JobServiceImp jbs= (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateJob() {
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
		String jobTitle=selected[0].substring(7);  //job title choosen for edit purpose
			System.out.println(selected[0].substring(7));
			
			Jobs job = jbs.getJobDetails(jobTitle);
			System.out.println(job.getJobTitle());
			System.out.println(job.getStartDate());
			  request.setAttribute("jobs", job); 
			  System.out.println("skuvbwkuvchwouvwkuvhwifvgweifwkuvcwifbweufgewifebwu");
	            request.getRequestDispatcher("jobUpdateDetail.jsp").forward(request, response);
		
	
	}

}
