package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.dao.*;
import com.bean.*;

import com.service.FactoryUtil;

/**
 * Servlet implementation class listOfJobs
 */
@WebServlet("/listOfJobs")
public class listOfJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       JobsData jbd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
       Jobs jb= (Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listOfJobsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            List<Jobs> job = jbd.listAllJobs();
            System.out.println(job.get(0).getJobTitle());
            request.setAttribute("jobs", job); 
            System.out.println("skuvbwkuvchwouvwkuvhwifvgweifwkuvcwifbweufgewifebwu");
            request.getRequestDispatcher("listOfJobs.jsp").forward(request, response);
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
