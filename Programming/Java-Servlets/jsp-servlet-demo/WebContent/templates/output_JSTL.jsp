<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<c:out value="JSTL is working"></c:out>
		<p>
			<c:set var = "i" value = "10"></c:set>
			Before :<c:out value="${i}"></c:out>
			<c:remove var="i"/>
			After: <c:out value="${i}"></c:out>
		</p>
		
		<a href='<c:url value="/index.html"></c:url>' >Go to home page</a>
		
		<div>
			<h2>Students</h2>
			<ul>
				<c:forEach items="${students}" var="student" >
					<p>
						<li>Name: ${student.name}</li>
						<li>Age: ${student.age}</li>
						<li>Country: ${student.country}</li>
						<hr>
					</p>
				</c:forEach>
			</ul>
		</div>
		
		<div>
			<h2>Students</h2>
			<table>
				<thead>
					<th>Name</th>
					<th>Age</th>
					<th>Country</th>
				<thead>
				
				<tbody>
					<c:forEach items="${students}" var="student" >
						<tr>
						<td>${student.name}</td>
							<td>${student.age}</td>
							<td>${student.country}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>