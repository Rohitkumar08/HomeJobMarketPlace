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


<% 

	if(session.getAttribute("uname")==null)
		response.sendRedirect("error.jsp");

%>
<c:import url="headerSitter.jsp"></c:import>

<center>

<table border="2" style="background-color:salmon">

<tr><th colspan="2">LIST OF ALL EMAILS</th></tr>


	<c:forEach items="${emails}" var ="email">

		<tr>
			<td><c:out  value="${email}"></c:out></td>
		</tr>
	
	</c:forEach>
</table>
<br>
<a href="PerformSitter.jsp">GO BACK..</a>
</center>
</body>
</html>