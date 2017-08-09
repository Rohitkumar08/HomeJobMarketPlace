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
import com.service.JobServiceImp;

/**
 * Servlet implementation class ApplicantsJobServlet
 */
@WebServlet("/ApplicantsJobServlet")
public class ApplicantsJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    JobsData jbd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
    JobServiceImp jbs=(JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantsJobServlet() {
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

		if(session.getAttribute("utype")==null){
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		if(!(session.getAttribute("utype").equals("Seeker"))){
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		int uid =(int) session.getAttribute("uid");
		

		try {
            List<Jobs> job = jbs.updateJob(uid);		//gives all jobs created by him only
            if(job.size()!=0){
            	
            	  System.out.println(job.get(0).getJobTitle());
                  request.setAttribute("jobs", job); 
                  System.out.println("skuvbwkuvchwouvwkuvhwifvgweifwkuvcwifbweufgewifebwu");
                  request.getRequestDispatcher("chooseJobForApp.jsp").forward(request, response);
            }
            else{
            	request.getRequestDispatcher("errorUpdateJob.jsp").forward(request, response);
            }
          
        } catch (Exception e) {
            throw new ServletException("Cannot obtain jobs from DB", e);
        }
	}

}
