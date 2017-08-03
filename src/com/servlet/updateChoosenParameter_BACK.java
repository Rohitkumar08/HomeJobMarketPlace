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
@WebServlet("/updateChoosenParameter_BACK")
public class updateChoosenParameter_BACK extends HttpServlet {
	private static final long serialVersionUID = 1L;
     JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
     Jobs job=(Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateChoosenParameter_BACK() {
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
		String selected[]= request.getParameterValues("inputed");
		String param=selected[0].substring(7);
		System.out.println(param);
		
		String currentJobTitle=request.getParameter("currentJobTitle");
		System.out.println(request.getParameter("currentJobTitle"));
		
		Jobs job = jbs.getJobDetails(currentJobTitle);
		HttpSession session = request.getSession();
		
		session.setAttribute("currentJobTitle", job.getJobTitle());
		//jbs.updateCurrentData(email);
		if(param.equals("jobTitle")){
			//jd.updateJobTitle(email);
			System.out.println(request.getParameter("currentJobTitle"));
			RequestDispatcher rd = request.getRequestDispatcher("updateJobTitle.jsp");
			rd.forward(request, response);
		
		}
//		if(email=="startDate"){
//			updateStartDate(job.getJobTitle());
//		}
//		if(email=="endDate"){
//			updateEndDate(job.getJobTitle());
//		}
//		if(email=="payPerHour"){
//			updatePayPerHour(job.getJobTitle());
//		}
		
		
	}

}
