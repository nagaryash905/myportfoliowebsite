<%@page import="com.portfolio.model.ContactPojo"%>
<%@page import="java.util.ArrayList"%>
<%@include file="security.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Details</title>
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
</style>
</head>
<body>

	<div class="container">
		<h2>Contact Read Panel</h2>
		<button class="button" onclick="window.location.href='adminpanel.jsp'">Admin
			Panel</button>
		<div style="text-align: center; margin-top: 40px;">
			<!-- Adjust margin-top as needed -->
			<%@include file="message.jsp"%>
		</div>
		<hr>
		<br>
	</div>
	<%
	ArrayList<ContactPojo> arrayList = (ArrayList<ContactPojo>) session.getAttribute("readcontact");
	if (arrayList != null && !arrayList.isEmpty())
	%>
	<div>
		<table border="1" cellspacing="0" cellpadding="5"
			style="margin: auto;">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>DateTime</th>
				<th>Actions</th>
				<!-- New column for delete button -->
			</tr>
			<%
			for (ContactPojo cpm : arrayList) {
			%>
			<tr>
				<td><%=cpm.getName()%></td>
				<td><%=cpm.getEmail()%></td>
				<td><%=cpm.getMessage()%></td>
				<td><%=cpm.getDatetime()%></td>
				<td>
					<form action="ContactDeleteServlet" method="post">
						<input type="hidden" name="id" value="<%=cpm.getSn()%>">
						<button type="submit" class="button">Delete</button>
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>