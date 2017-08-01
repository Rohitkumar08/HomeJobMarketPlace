package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.*;
import com.bean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.*;
/**
 * Servlet implementation class createJobServlet
 */
@WebServlet("/CreateJobServlet")
public class CreateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
       UserData ud  = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
       Member mem = (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
       Jobs job = (Jobs)FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public CreateJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		job.setJobTitle(request.getParameter("jobTitle"));
		job.setStartDate(request.getParameter("endDate"));
		job.setEndDate(request.getParameter("startTime"));
		job.setStartTime(request.getParameter("startTime"));
		job.setEndTime(request.getParameter("endTime"));
		job.setPayPerHour(Integer.parseInt(request.getParameter("payPerHour")));
		HttpSession session = request.getSession();
		
		String email = mem.getEmail();
		int uid = (int) session.getAttribute("uid");
		boolean done = jbs.newJob(uid);
		
		if(done){
			RequestDispatcher rd = request.getRequestDispatcher("successJob.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("someError.jsp");
			rd.forward(request, response);
		}
    	
    	
    	
    	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
