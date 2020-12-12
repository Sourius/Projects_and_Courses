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
		<c:if test="${2 > 1}">
			<c:out value="2 is greater than 1"></c:out>
		</c:if>
		
		<c:set var="score" value="75"></c:set>
		
		<c:choose>
			<c:when test="${score > 50}">
				<p>Score is greater than 50</p>
			</c:when>
			
			<c:otherwise>
				<p>Score is less than 50</p>
			</c:otherwise>
		</c:choose>
	</body>
</html>