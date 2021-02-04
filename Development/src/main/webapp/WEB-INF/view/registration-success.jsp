<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Registration is successful</h1>
<h2>The details entered by you are </h2>
Name 	 : ${regInfoDTO.name}
<br/>
User name: ${regInfoDTO.userName}
<br/>
Password : ${regInfoDTO.password}
<br/>
Country  : ${regInfoDTO.countryName}
<br/>
Hobbies  : 
<c:forEach var="temp" items="${regInfoDTO.hobbies }">${temp}</c:forEach>
<br/>
Gender   : ${regInfoDTO.gender }
<br/>
email    : ${regInfoDTO.communicationDTO.email }
<br/>
phone    : ${regInfoDTO.communicationDTO.phone}

</body>
</html>