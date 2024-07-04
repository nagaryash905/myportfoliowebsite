<%@include file="security.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Resume</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	padding: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 30px;
}

form {
	max-width: 400px;
	margin: 0 auto;
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

input[type="file"] {
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 10px;
	width: 100%;
	box-sizing: border-box;
}

button {
	display: block;
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s;
}

button:hover {
	background-color: #45a049;
}

button.back-button {
	background-color: #4a90e2;
	margin-top: 10px;
}

button.back-button:hover {
	background-color: #357ebd;
}
</style>
</head>
<body>
	<h1>Add Resume</h1>
	<form action="AddResumeServlet" method="post"
		enctype="multipart/form-data">
		<div style="text-align: center; margin-top: 50px;">
			<!-- Adjust margin-top as needed -->
			<%@include file="message.jsp"%>
		</div>
		<input type="file" name="myresume">
		<button>Upload Resume</button>
	</form>
</body>
</html>
