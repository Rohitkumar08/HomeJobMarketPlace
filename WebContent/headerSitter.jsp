<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<center>
<%-- <% if(!session.getAttribute("utype").equals("Sitter"))
	response.sendRedirect("error.jsp");
	%> --%>
<span style="float:left">
<a href="PerformSitter"><img src="images/images.jpeg" width="30%" height="50%"/></a>
<form action="SearchServlet">
<input type = "text" placeholder="Enter Seeker's email" name="searchEmail">
<input type="submit" value="search" name="searchButton">
</form>
</span>

<span style="float:right">
<a href="ViewProfileServletSitter"><button type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-user"></span> <c:out value="${sessionScope.uname}"/> 
        </button></a>
<a href="logout">Logout</a></b>

</span>
</center>
</body>
</html>