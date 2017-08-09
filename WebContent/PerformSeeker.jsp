<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%

	if(session.getAttribute("uname")==null){
		out.print("dscdcewdccwdc");
		response.sendRedirect("login.jsp");
	}
	

%>   --%>


<c:import url="header.jsp"></c:import>

<center>
<table border="2" width="50%" style="background-color:salmon">

<tr><th align="center">WELCOME AS A SEEKER</th></tr>
<tr><td><a href="createJob">Create a new Job</a></td></tr>
<tr><td><a href="updateJobServlet">Update a Job</a></td></tr>
<tr><td><a href="deleteJobServlet">Delete a job</a></td></tr>
<tr><td><a href="ApplicantsJobServlet">View all jobs</a></td></tr>
</table>
</center>
</body>
</html>