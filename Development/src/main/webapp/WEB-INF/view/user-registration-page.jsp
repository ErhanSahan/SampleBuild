<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegPage</title>


<style type="text/css">
.error{
	color:red;
	position:fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

</head>
<body>


	<h1 align="center">Register here</h1>
<form:form action="registration-success" modelAttribute="regInfoDTO">
	<div align="center">
		<label>Name :</label>
		<form:input path="name"/>
		<form:errors path="name" cssClass="error"/>
		
		<br/>
		
		<label>User name : </label>
		<form:input path="userName"/>
		<form:errors path="userName" cssClass="error"/>
		
		<br/>
		
		<label>Password : </label>
		<form:password path="password"/>
		
		<br/>
		<form:select path="countryName">
			<form:option value="TR" Label="Turkey"></form:option>
			<form:option value="ENG" Label="ENGLAND"></form:option>
			<form:option value="USA" Label="United States"></form:option>
		</form:select>
		<br/>
		
		<label>Hobbies : </label>
		Football : <form:checkbox path="hobbies" value="Football"/>
		Basketball : <form:checkbox path="hobbies" value="Basketball"/>
		
		<br/>
		<label>Gender : </label>
		Male  <form:radiobutton path="gender"/>
		Female <form:radiobutton path="gender"/>
		<br/>
		
		<label>Age : </label>
		<form:input path="age"/>
		<form:errors path="age" cssClass="error"></form:errors>
		
			
	</div>
		<div align="center"> 
			<h3>Communication</h3>
			<label>Email</label>
			<form:input path="CommunicationDTO.email"/>
			<form:errors path="CommunicationDTO.email" cssClass="error" ></form:errors>
			<br/>
			<label>Phone</label>
			<form:input path="CommunicationDTO.phone"/>
		</div>
	
		
	<div align="center"><input type="submit" value = "register"></div>
		
</form:form>



</body>
</html>