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
<span style="float:left">
<a href="PerformSeeker.jsp"><img src="images/images.jpeg" width="30%" height="50%"/></a>
</span>
<span style="float:right">
<b> Hi, <c:out value="${sessionScope.uname}"/>| <a href="logout">Logout</a></b>

</span>

</body>
</html>