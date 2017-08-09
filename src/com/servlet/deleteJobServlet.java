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
 * Servlet implementation class deleteJobServlet
 */
@WebServlet("/deleteJobServlet")
public class deleteJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    JobsData jbd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
   JobServiceImp jbs=(JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteJobServlet() {
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
		int uid= (int) session.getAttribute("uid");
		try {
            List<Jobs> job = jbd.listAllJobs(uid);
            if(job.size()==0){
            	RequestDispatcher rd = request.getRequestDispatcher("noJobs.jsp");
    			rd.forward(request, response);
            }
            System.out.println(job.get(0).getJobTitle());
            request.setAttribute("jobs", job); 
            System.out.println("skuvbwkuvchwouvwkuvhwifvgweifwkuvcwifbweufgewifebwu");
            request.getRequestDispatcher("deleteJob.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Cannot obtain jobs from DB", e);
        }
		
		
		
		
	}

}
