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

import com.bean.Sitter;
import com.service.FactoryUtil;
import com.service.JobServiceImp;

/**
 * Servlet implementation class ShowAppServlet
 */
@WebServlet("/ShowAppServlet")
public class ShowAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 JobServiceImp jbs=(JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAppServlet() {
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
//		String job= request.getParameter("jobToBeDeleted");
//		System.out.println(job);
		HttpSession session = request.getSession(); 
		int uid=(int) session.getAttribute("uid");
		
		String selected[]= request.getParameterValues("inputed");
		String jobTitle=selected[0].substring(16);
			System.out.println(selected[0].substring(16));
			
			List<Sitter> applicants =jbs.showApplicants(uid,jobTitle);
			if(applicants.size()!=0){
				
				System.out.println("*****************"+applicants.get(0).getFirstName());
				
				request.setAttribute("sitter", applicants);
				request.getRequestDispatcher("allApplicants.jsp").forward(request, response);
			}
			else{
				
				request.getRequestDispatcher("noApplicants.jsp").forward(request, response);
			}
			
			
//		if(jbs.showApp(uid,jobTitle)){
//			RequestDispatcher rd = request.getRequestDispatcher("successDeletionOfJob.jsp");
//			rd.forward(request, response);
//		}
//		else{
//			RequestDispatcher rd = request.getRequestDispatcher("errorInDeletionOfJob.jsp");
//			rd.forward(request, response);
//		}
		
	}

}
