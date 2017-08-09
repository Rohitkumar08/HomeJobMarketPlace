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
 * Servlet implementation class updateChoosenParameter
 */
@WebServlet("/updateChoosenParameter")
public class updateChoosenParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
    Jobs job=(Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateChoosenParameter() {
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
//		String selected[]= request.getParameterValues("inputed");
//		String param=selected[0].substring(7);
//		System.out.println(param);
		HttpSession session = request.getSession();

		if(session.getAttribute("utype")==null){
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		if(!(session.getAttribute("utype").equals("Seeker"))){
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		job.setJobTitle(request.getParameter("jobTitle"));
		job.setStartDate(request.getParameter("endDate"));
		job.setEndDate(request.getParameter("startTime"));
		job.setStartTime(request.getParameter("startTime"));
		job.setEndTime(request.getParameter("endTime"));
		job.setPayPerHour(Integer.parseInt(request.getParameter("payPerHour")));
		job.setStatus(request.getParameter("status"));
		
		String oldJobTitle=request.getParameter("oldJobTitle");
		System.out.println(request.getParameter("oldJobTitle"));
		
		
		
		session.setAttribute("oldJobTitle", oldJobTitle);
		
		
	
//		Jobs job = jbs.getJobDetails(currentJobTitle);
		
		
		
		//jbs.updateCurrentData(email);
		if(jbs.updateJobDetails(job,oldJobTitle)){
			//jd.updateJobTitle(email);
			System.out.println(request.getParameter("currentJobTitle"));
			RequestDispatcher rd = request.getRequestDispatcher("updatedJobDetails.jsp");
			rd.forward(request, response);
		
		}
	}

}
