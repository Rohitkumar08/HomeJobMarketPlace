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
<c:import url="header.jsp"></c:import>
<center>

<form action = "updateJobTitle" method="POST">
<table border="2" style="background-color:salmon">
<tr><th colspan="2">UPADTE DATA</th></tr>
<tr><td>Enter New title</td><td><input type="text" placeholder="enter new job title" name= "newJobTitle"></td></tr>
<tr><td colspan="2" align="right"><input type="submit" value="submit"></td></tr> 
</table>

</form>
</center>
</body>
</html>