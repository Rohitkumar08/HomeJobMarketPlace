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

	if(session.getAttribute("uname")==null)
		response.sendRedirect("error.jsp");



%> --%>
<c:import url="header.jsp"></c:import>

<center>
<table border="2" style="background-color:salmon">

<tr><th colspan="3">LIST OF SITTERS FOR THIS JOB</th></tr>
<tr><td style="color:blue">Applicants Name</td><td style="color:blue">Expected Pay</td><td style="color:blue">Years Of Experience</td></tr>

	<c:forEach items="${sitter}" var ="sitter">

		<tr>
			
			<td><c:out  value="${sitter.getFirstName()}"></c:out></td>
			<td><c:out  value="${sitter.getExpectedPay()}"></c:out></td>
			<td><c:out  value="${sitter.getYearsOfExperience()}"></c:out></td>
		
		</tr>
	
	</c:forEach>
</table>
<a href="ApplicantsJobServlet">GO BACK..</a>
</center>
</body>
</html>