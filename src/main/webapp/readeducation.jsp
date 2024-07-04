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

.container {
	text-align: center;
	margin-top: 50px;
}

/* .button::after {
	content: " \25BC"; /* Unicode for down arrow */
margin-left
:
 
5px
;


}
*
/
</style>
</head>
<body>

	<div class="container">
		<h2>This is the Read & Delete And Update Panel</h2>
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
	ArrayList<EducationPojo> arrayList = (ArrayList<EducationPojo>) session.getAttribute("readEducation");
	if (arrayList != null && !arrayList.isEmpty()) 
	{
		int index=0;
	%>
	<div>
		<table border="1" cellspacing="1" cellpadding="5"
			style="margin: auto;">
			<tr>
				<th>Year</th>
				<th>School</th>
				<th>Class</th>
				<th>Description</th>
				<th>Action</th>
				<!-- New column for delete button -->
			</tr>
			<%
			for (EducationPojo ed : arrayList) {
			%>
			<tr>
				<td><%=ed.getYear()%></td>
				<td><%=ed.getSchool()%></td>
				<td><%=ed.getSection()%></td>
				<td><%=ed.getDescription()%>
				<td>
					<form action="DeleteEducationServlet" method="post">
						<input type="hidden" name="id" value="<%=ed.getSn()%>">
						<button type="submit" class="button">Delete</button>
					</form><hr>
					<button class="button" onclick="window.location.href='updateeducation.jsp?index=<%=index%>'">Update</button>
				</td>
			</tr>
			<%
			index++;
			}
			%>
		</table>
	</div>
	<%
	}
	%>

	<!-- Here We read The Education Start -->


</body>
</html>
