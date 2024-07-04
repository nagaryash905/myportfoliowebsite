<%@page import="com.portfolio.model.EducationPojo"%>
<%@page import="com.portfolio.model.CredentilasPojo"%>
<%@page import="java.util.ArrayList"%>
<%@include file="security.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-image: url('images/undraw/adminpanel.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.container {
	text-align: center;
	margin-top: 50px;
}

.button {
	background-color: #4a90e2;
	border: none;
	color: white;
	padding: 5px 10px; /* Adjusted padding */
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

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 145px; /* 160px */
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 4px 7px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

/* .button::after {
	content: " \25BC"; /* Unicode for down arrow */
	margin-left: 5px;
} */
</style>
</head>
<body>
	<div class="container">
		<h2>Admin Panel</h2>
<!-- 		<button class="button" onclick="window.location.href='index.jsp'">Your Website</button>&nbsp;&nbsp; -->
		<button class="button" onclick="window.location.href='addprofilepicture.jsp'">Upload Profile Picture</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='profiledetails.jsp'">Profile Details</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='ReadUpdateDeleteProfileServlet'">Read & Delete Profile Details</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='CredentialsDetailsServlet'">Credentials Details</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='uploadresume.jsp'">Upload Resume</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='addproject.jsp'">Upload Project</button>&nbsp;&nbsp;<br><br>
		<button class="button" onclick="window.location.href='ReadUpdateDeleteProjectServlet'">Read, Update & Delete Project</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='addexperience.jsp'">Add Experience</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='ReadDeleteUpdateServlet'">Read, Update & Delete Experience</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='ReadMessageServlet'">Read Message</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='education.jsp'">Add Education</button>&nbsp;&nbsp;
		<button class="button" onclick="window.location.href='ReadEducationServlet'">Read & Delete Education</button>&nbsp;&nbsp;
		<!-- <button class="button" onclick="window.location.href='adminpanel.jsp'">Refresh</button>&nbsp;&nbsp; -->
		<button class="button" onclick="window.location.href='LogoutServlet'">Logout</button>
		<hr>
		<br>
	</div>
	<div style="text-align: center; margin-top: 40px;">
		<!-- Adjust margin-top as needed -->
		<%@include file="message.jsp"%>
	</div>
</body>
</html>
