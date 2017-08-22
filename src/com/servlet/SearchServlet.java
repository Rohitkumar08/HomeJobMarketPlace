package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.FactoryUtil;
import com.service.MemberServiceImp;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      MemberServiceImp mbs= (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd;
		String keyWord=request.getParameter("searchEmail");
		if(keyWord.length()!=0){
			
				List<String> emails=mbs.getSearchData(keyWord);
				request.setAttribute("emails", emails);
				if(emails.size()!=0){
					
					rd = request.getRequestDispatcher("emailResults.jsp");
					rd.forward(request, response);
					
				}
				else{
					rd = request.getRequestDispatcher("notFoundEmail.jsp");
					rd.forward(request, response);
				}
		}
		else{
			rd = request.getRequestDispatcher("invalidSearch.jsp");
			rd.forward(request, response);
			
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
