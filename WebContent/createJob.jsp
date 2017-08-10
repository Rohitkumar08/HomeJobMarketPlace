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

<c:import url="header.jsp"></c:import>
<center>
<form action="CreateJobServlet" method="POST">
<table border="2" width="50%" style="background-color:salmon">
<tr><th colspan="2">CREATE A NEW JOB</th></tr>

<tr><td>Job Title:</td><td> <input type = "text" name="jobTitle" placeholder="Enter Job-Title" required></td></tr>
<tr><td>Start Date: </td><td><input type = "date" name="startDate" required></td></tr>
<tr><td>End Date:</td><td><input type = "date" name="endDate" required></td></tr>
<tr><td>Start Time: </td><td><input type = "text" name="startTime" placeholder="hh:mm[24hour]" required></td></tr>
<tr><td>End Time:</td><td><input type = "text" name="endTime" placeholder="hh:mm[24hour]" required></td></tr>
<tr><td>Pay Per Hour:</td><td><input type = "number" name="payPerHour" placeholder="Enter pay per hour" required></td></tr>

<tr><td colspan="2" align="right" ><input type="submit" value="submit" style="font-size:7pt;"></td></tr>

</table>
</form>


</center>
</body>
</html>