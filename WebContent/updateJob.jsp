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
<%-- <% 

	if(session.getAttribute("uname")==null)
		response.sendRedirect("error.jsp");



%> --%>
<c:import url="header.jsp"></c:import>

<center>
<form action = "updateJob" method="POST">
<table border="2" style="background-color:salmon">

<tr><th colspan="3">LIST OF ALL JOBS POSTED BY YOU</th></tr>
<tr><b><td>JOB TITLE</td><td>STATUS</td></b></tr>
	<c:forEach items="${jobs}" var ="job">

		<tr>
		
			<td><c:out  value="${job.getJobTitle()}"></c:out></td>
			<td><c:out  value="${job.getStatus()}"></c:out></td>
			<td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${job.getJobTitle()}"/>'"></td>
		</tr>
	
	</c:forEach>
</table>

</form>
<a href="PerformSeeker"><b>GO BACK.....</b></a>

</center>

</body>
</html>