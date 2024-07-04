<%@page import="com.portfolio.model.CredentilasPojo"%>
<%@page import="java.util.ArrayList"%>
<%@include file="security.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credentials Panel</title>
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
		<h2>This is the Read Credentials Panel</h2>
 		<button class="button" onclick="window.location.href='adminpanel.jsp'">Admin Panel</button>&nbsp;&nbsp; 
		<hr>
		<br>
	</div>

	<div style="text-align: center; margin-top: 40px;">
		<!-- Adjust margin-top as needed -->
		<%@include file="message.jsp"%>
	</div>
	<%
	ArrayList<CredentilasPojo> arrayList = (ArrayList<CredentilasPojo>) session.getAttribute("contactdata");
	if (arrayList != null && !arrayList.isEmpty()) {
	%>
	<div>
		<table border="1" cellspacing="0" cellpadding="5"
			style="margin: auto;">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Actions</th>
				<!-- New column for delete button -->
			</tr>
			<%
			for (CredentilasPojo cp : arrayList) {
			%>
			<tr>
				<td><%=cp.getName()%></td>
				<td><%=cp.getEmail()%></td>
				<td><%=cp.getPassword()%></td>
				<td>
					<form action="DeleteCredentialsServlet" method="post">
						<input type="hidden" name="id" value="<%=cp.getSn()%>">
						<button type="submit" class="button">Delete</button>
					</form>
				</td>
			</tr>
			<%

			}
			%>
		</table>
	</div>
	<%
	}
	%>
</body>
</html>
