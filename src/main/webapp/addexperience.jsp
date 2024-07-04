<%@include file="security.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Experience Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	padding: 20px;
}

h1 {
	text-align: center;
}

form {
	max-width: 500px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type="text"], textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

textarea {
	height: 100px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.button {
	background-color: #4a90e2;
	border: none;
	color: white;
	padding: 9px 12px; /* Adjusted padding */
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px; /* Adjusted font size */
	border-radius: 3px; /* Adjusted border radius */
	cursor: pointer;
}

.button:hover {
	background-color: #357ebd;
}
</style>
</head>
<body>
	<form action="AddExperienceServlet" method="post">
		<h1>Experience Details</h1>
		<div style="text-align: center; margin-top: 50px;">
			<!-- Adjust margin-top as needed -->
			<%@include file="message.jsp"%>
		</div>
		<label for="year">Year:</label> <input type="text" id="year"
			name="year" required> <label for="school">Job Title:</label>
		<input type="text" id="school" name="jobtitle" required> <label
			for="class">Company Name:</label> <input type="text" id="section"
			name="company" required> <label for="description">Description:</label>
		<textarea id="description" name="description" rows="4" required></textarea>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
