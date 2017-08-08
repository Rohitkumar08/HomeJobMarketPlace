<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

	if(session.getAttribute("uname")==null)
		response.sendRedirect("error.jsp");



%>
<c:import url="header.jsp"></c:import>

<center>
<form action = "ShowAppServlet" method="POST">
<table border="2" style="background-color:salmon">

<tr><th colspan="2">LIST OF ALL JOBS</th></tr>

	<c:forEach items="${jobs}" var ="job">

		<tr>
		
			<td><c:out  value="${job.getJobTitle()}"></c:out></td>
			
			<td><input type="submit" name="inputed" value="Show Applicants" onclick="this.value += ' <c:out  value="${job.getJobTitle()}"/>'"></td>
		</tr>
	
	</c:forEach>
</table>

</form>
<br>
<a href="PerformSeeker.jsp">GO BACK</a>

</center>
</body>
</html>