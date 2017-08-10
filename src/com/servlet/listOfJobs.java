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

import com.bean.Jobs;
import com.dao.JobsData;
import com.service.FactoryUtil;

/**
 * Servlet implementation class listOfJobs
 */
@WebServlet("/listOfJobs")
public class listOfJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
    JobsData jbd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listOfJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("uname")==null || !(session.getAttribute("utype").equals("Sitter"))){
			System.out.println("***************************************8");
			RequestDispatcher rd = request.getRequestDispatcher("PerformSitter.jsp");
			rd.forward(request, response);
		}
		int uid = (int) session.getAttribute("uid");
		try {
            List<Jobs> job = jbd.listAllJobsForSeekers();
          if(job.size()==0){
        	  RequestDispatcher rd = request.getRequestDispatcher("noJobsAvail.jsp");
              rd.forward(request, response);
          }
            request.setAttribute("jobs", job);            
            RequestDispatcher rd = request.getRequestDispatcher("listOfAllJobs.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Cannot obtain jobs from DB", e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
