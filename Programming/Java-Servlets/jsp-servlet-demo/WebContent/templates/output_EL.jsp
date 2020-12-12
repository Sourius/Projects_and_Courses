<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<p>I am writing EL expression ${2+2}</p>
		<p>${6 ge 8 ? "Welcome" : "Good Bye"}</p>
		
		<h1>Hello ${name}</h1>
		<p>Student's name is ${student.name}, he is ${student.age} and he is from ${student.country}</p>
	</body>
</html>