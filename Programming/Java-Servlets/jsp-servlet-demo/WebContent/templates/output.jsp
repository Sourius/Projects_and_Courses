<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<c:out value="${fn:toLowerCase('Hello world')}"></c:out><br/>
		<c:out value="${fn:toUpperCase('Hello world')}"></c:out><br/>
		<c:out value="${fn:length('Hello world')}"></c:out><br/>
		
		<c:out value="${fn:contains('Hello world','Hello')}"></c:out><br/>	
		<c:out value="${fn:contains('Hello world','sghsa')}"></c:out><br/>
		
		<c:out value="${fn:indexOf('Hello world','world')}"></c:out><br/>
		<c:out value="${fn:indexOf('Hello world','xsdss')}"></c:out><br/>
	</body>
</html>