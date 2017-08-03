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

<form action = "updateChoosenParameter" method="POST"> 
<table border="2" style="background-color:salmon">

<tr><th colspan="2">CHOOSE THE PARAMETER WHICH YOU WANT TO EDIT</th></tr>

		<tr>
		
			<td>JOB TITLE <input type="hidden" name="oldJobTitle" value="${jobs.getJobTitle()}" ></td>
			<%-- <c:out  value="${jobs.getJobTitle()}"</c:out> --%>
			<td><input type="text" name="jobTitle" value="${jobs.getJobTitle()}"></td>
			
			<%-- <td><input type="submit" name="inputed" value="update" onclick=" this.value += ' <c:out  value="jobTitle"/>'"></td> --%>
		</tr>
		<tr>
		
			<td>START DATE</td>
			<%-- <c:out  value="${jobs.getStartDate()}"</c:out> --%>
			<td><input type="text" name="startDate" value="${jobs.getStartDate()}"></td>
			<%-- this.value += ' <c:out  value="startDate"/>' --%>
			<!-- <td><input type="submit" name="inputed" value="update" onclick="window.location='updateStartDate.jsp'"></td> -->
		</tr>
		<tr>
		
			<td>END DATE</td>
				<td><input type="text" name="endDate" value="${jobs.getEndDate()}"></td>
			<%-- <td><c:out  value="${jobs.getEndDate()}"></c:out></td>
			 onclick="this.value += ' <c:out  value="endDate"/>'"
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updateEndDate.jsp'"></td> --%>
		</tr>
	
	
		<tr>
		
			<td>START TIME</td>
			<td><input type="text" ReadOnly="true" name="endDate" value="${jobs.getStartTime()}"></td>
			
			<%-- <td><input type="submit" disabled="disabled" name="inputed" value="update" onclick="this.value += ' <c:out  value="startTime"/>'"></td> --%>
		</tr>
		
		<tr>
		
			<td>END TIME</td>
			<td><input type="text" ReadOnly ="true" name="endDate" value="${jobs.getEndTime()}"></td>
			
			<%-- <td><input type="submit"disabled="disabled"  name="inputed" value="update" onclick="this.value += ' <c:out  value="endTime"/>'"></td> --%>
		</tr>
		
		<tr>
		
			<td>PAY PER HOUR</td>
			<%-- <c:out  value="${jobs.getPayPerHour()}"</c:out> --%>
			 	<td><input type="text" name="payPerHour" value="${jobs.getPayPerHour()}"/></td>
		<%--	<td><c:out  value="${jobs.getPayPerHour()}"></c:out></td>
			this.value += ' <c:out  value="payPerHour"/>'
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updatePayPerHour.jsp'"></td> --%>
		</tr>
		<tr>
		
			<td>STATUS</td>
			<td><%-- <input type="text" name="status" value="<c:out  value="${jobs.getStatus()}"</c:out>"/ --%>
			
			<select name="status">
    
        		<option value="${jobs.getStatus()}"><c:out value="${jobs.getStatus()}" /></option>
        		<c:choose>
        			
        				<c:when test="${jobs.getStatus()=='INACTIVE'}">
        					<option value="ACTIVE">ACTIVE</option>
        				</c:when>
        				<c:otherwise>
        					<option value="INACTIVE">INACTIVE</option>
        				</c:otherwise>
        		
        		</c:choose>
        		
    
			</select>
			</td>
			<%-- <td><c:out  value="${jobs.getStatus()}"></c:out></td>
			this.value += ' <c:out  value="payPerHour"/>'
			<td><input type="submit" name="inputed" value="update" onclick=" this.value += ' <c:out  value="status"/>'"></td> --%>
		</tr>
		<tr>
		<td colspan="2" align="right">
		<input type="submit" name="update" value="update">
		</td>
		</tr>
	
</table>

</form> 


</center>
</body>
</html>