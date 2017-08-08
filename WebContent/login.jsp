<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form action = "LoginServlet" method ="POST">
<table border="2" width="50%" style="background-color:salmon">
<tr><th colspan="2">LOG IN</th></tr>
<tr><td>Enter Email:</td> <td><input type="text" name="userEmail" placeholder="Enter email id" required></td></tr>
<tr><td>Password:</td> <td><input type="password" name="password" placeholder="password" required></td></tr>
<tr><td align="center" colspan="2"><input type="submit" name="submit"></td></tr>


</table>


</form>
OR
<br><a href="register.jsp">REGISTER HERE</a>

</center>
</body>
</html>