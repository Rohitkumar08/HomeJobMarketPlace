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

<c:import url="headerSitter.jsp"></c:import>
<center>

<form action = "UpdateChoosenParameterSitter" method="POST"> 
<table border="2" style="background-color:salmon">

<tr><th colspan="2">CHOOSE THE PARAMETER WHICH YOU WANT TO EDIT</th></tr>

		<tr>
		
			<td>FirstName <input type="hidden" name="oldFirstName" value="${sitter.getFirstName()}" ></td>
			<%-- <c:out  value="${jobs.getJobTitle()}"</c:out> --%>
			<td><input type="text" name="firstName" value="${sitter.getFirstName()}"></td>
			
			<%-- <td><input type="submit" name="inputed" value="update" onclick=" this.value += ' <c:out  value="jobTitle"/>'"></td> --%>
		</tr>
		<tr>
		
			<td>Phone No</td>
			<%-- <c:out  value="${jobs.getStartDate()}"</c:out> --%>
			<td><input type="text" name="phoneNo" value="${sitter.getPhone()}"></td>
			<%-- this.value += ' <c:out  value="startDate"/>' --%>
			<!-- <td><input type="submit" name="inputed" value="update" onclick="window.location='updateStartDate.jsp'"></td> -->
		</tr>
		<tr>
		
			<td>Email</td>
				<td><input type="text" name="email" value="${sitter.getEmail()}"></td>
			<%-- <td><c:out  value="${jobs.getEndDate()}"></c:out></td>
			 onclick="this.value += ' <c:out  value="endDate"/>'"
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updateEndDate.jsp'"></td> --%>
		</tr>
	
	
		<tr>
		
			<td>Password</td>
			<td><input type="text" ReadOnly="true" name="password" value="${sitter.getPassword()}"></td>
			
			<%-- <td><input type="submit" disabled="disabled" name="inputed" value="update" onclick="this.value += ' <c:out  value="startTime"/>'"></td> --%>
		</tr>
		<%-- 	<tr>
		
			<td>Address</td>
			<td><input type="text" ReadOnly="true" name="password" value="${seeker.getAdd()}"></td>
			
			<td><input type="submit" disabled="disabled" name="inputed" value="update" onclick="this.value += ' <c:out  value="startTime"/>'"></td>
		</tr> --%>
		
		
		<tr>
		
			<td>YEars of experience</td>
			<td><input type="text" name="yearsOfExp" value="${sitter.getYearsOfExperience()}"></td>
			
			<%-- <td><input type="submit"disabled="disabled"  name="inputed" value="update" onclick="this.value += ' <c:out  value="endTime"/>'"></td> --%>
		</tr>
		
		<tr>
		
			<td>Expected pay</td>
			<%-- <c:out  value="${jobs.getPayPerHour()}"</c:out> --%>
			 	<td><input type="text" name="expectedPay" value="${sitter.getExpectedPay()}"/></td>
		<%--	<td><c:out  value="${jobs.getPayPerHour()}"></c:out></td>
			this.value += ' <c:out  value="payPerHour"/>'
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updatePayPerHour.jsp'"></td> --%>
		</tr>
		
		<tr>
		<td colspan="2" align="right">
		<input type="submit" name="edit" value="update">
		</td>
		</tr>
	
</table>

</form> 


</center>
</body>
</html>