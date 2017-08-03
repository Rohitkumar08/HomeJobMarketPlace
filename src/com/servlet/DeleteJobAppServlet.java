package com.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class DeleteJobAppServlet
 */
@WebServlet("/DeleteJobAppServlet")
public class DeleteJobAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 JobServiceImp jbs= (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP); 
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJobAppServlet() {
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
			
			int uid =(int) session.getAttribute("uid");
			

			try {
	            List<Jobs> job = jbs.deletejobApp(uid);
	            if(job.size()!=0){
	            	
	            	
	            	 System.out.println(job.get(0).getJobTitle());
	 	            request.setAttribute("jobs", job); 
	 	            System.out.println("skuvbwkuvchwouvwkuvhwifvgweifwkuvcwifbweufgewifebwu");
	 	            request.getRequestDispatcher("listOfAppliedJob.jsp").forward(request, response);
	            }
	            else
	            {
	            	 request.getRequestDispatcher("errorListOfApp.jsp").forward(request, response);
	            }
	           
	        } catch (Exception e) {
	            throw new ServletException("Cannot obtain jobs from DB", e);
	        }
			
			
		 
		 
	}

}
