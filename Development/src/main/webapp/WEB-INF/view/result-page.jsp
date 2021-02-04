<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1	align = "center">Love Calculator</h1>
	<hr>
	 
	<p>User name is : ${userInfoDTO.userName} </p>
	<p>Friend name is : ${userInfoDTO.friendName}</p>
	<br/>
	FRIEND
		
	<br/>
	<a href="/mysecond-mvc-project/sendEmail">Send Result to Your E mail</a>
</body>
</html>