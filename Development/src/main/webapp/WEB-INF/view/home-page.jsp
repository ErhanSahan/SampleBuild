<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style type="text/css">
.error{
	color:red;
	position:fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

<script type="text/javascript">

function validateUserName(){
	var userName = document.getElementById("yn").value;
	if(userName.length<2){
		alert("your name should at least 2 characters");
		return false;
	}
	else
		{
		true;
		}
	
}
	
</script>
</head>
<body>

	<h1 align="center">Love Calculator</h1>
<hr>
	
<form:form action="process-homepage" method="get" modelAttribute="userInfoDTO" onsubmit="return validateUserName()">
	<div align="center">
		<p>	
			<Label for="yn">Your Name:</Label>
			<form:input type ="text" id="yn" path="userName" />
			<form:errors path="userName" cssClass="error"></form:errors>
		</p>
		
		<p>	
			<Label for="fn">Friends Name:</Label>
			<form:input type ="text" id="fn" path="friendName"/>
		</p>
		
		<p>
			<form:checkbox path="termAndCondition" id="check"/>
			<label>I am agree that this is for fun.</label>
			<form:errors path="termAndCondition" cssClass="error"></form:errors>
		</p>
		
	</div>
	
	<div align="center"><input type="submit" value="calculate"></div>
	
</form:form>

</body>
</html>