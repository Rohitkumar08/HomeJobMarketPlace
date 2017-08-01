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

<form action = "updateChoosenParameter" method="POST">
<table border="2" style="background-color:salmon">

<tr><th colspan="3">CHOOSE THE PARAMETER WHICH YOU WANT TO EDIT</th></tr>

		<tr>
		
			<td>JOB TITLE</td>
			<td><c:out  value="${jobs.getJobTitle()}"></c:out></td>
			
			<td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${jobs.getJobTitle()}"/>'"></td>
		</tr>
		<tr>
		
			<td>START DATE</td>
			<td><c:out  value="${jobs.getStartDate()}"></c:out></td>
			
			<td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${jobs.getStartDate()}"/>'"></td>
		</tr>
		<tr>
		
			<td>END DATE</td>
			<td><c:out  value="${jobs.getEndDate()}"></c:out></td>
			
			<td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${jobs.getEndDate()}"/>'"></td>
		</tr>
	
	
		<tr>
		
			<td>START TIME</td>
			<td><c:out  value="${jobs.getStartTime()}"></c:out></td>
			
			<td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${jobs.getStartTime()}"/>'"></td>
		</tr>
		
		<tr>
		
			<td>END TIME</td>
			<td><c:out  value="${jobs.getEndTime()}"></c:out></td>
			
			<td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${jobs.getEndTime()}"/>'"></td>
		</tr>
		
		<tr>
		
			<td>PAY PER HOUR</td>
			<td><c:out  value="${jobs.getPayPerHour()}"></c:out></td>
			
			<td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${jobs.getPayPerHour()}"/>'"></td>
		</tr>
	
</table>

</form>


</center>
</body>
</html>