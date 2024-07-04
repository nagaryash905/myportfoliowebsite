<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Signup Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	background-image: url('images/undraw/signup.jpg');
	background-size: cover; /* Set background image to cover entire page */
}

.signup-container {
	width: 300px;
	margin: 100px auto;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.8);
	/* Add transparency for better visibility of form */
	border-radius: 5px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.signup-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.signup-container input[type="text"], .signup-container input[type="email"],
	.signup-container input[type="password"], .signup-container input[type="submit"]
	{
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box;
}

.signup-container input[type="submit"] {
	background-color: #4caf50;
	color: #fff;
	cursor: pointer;
}

.signup-container input[type="submit"]:hover {
	background-color: #45a049;
}

.signup-button {
	width: 100%;
	background-color: #4a90e2;
	color: #fff;
	border: none;
	border-radius: 3px;
	padding: 10px;
	cursor: pointer;
}

</style>
</head>
<body>
	<div class="signup-container">

		<div style="text-align: center; margin-top: 50px;">
			<!-- Adjust margin-top as needed -->
			<%@include file="message.jsp"%>
		</div>

		<h2>Signup Form</h2>
		<form action="SignupServlet" method="post">
			<input type="text" name="name" placeholder="Name" required> <input
				type="email" name="email" placeholder="Email" required> <input
				type="password" name="password" placeholder="Password" minlength="8"
				required> <input type="submit" value="Signup">
			<!-- Signup button -->
		</form>
		<button class="signup-button"
			onclick="window.location.href='admin.jsp'">Login</button>
	</div>
</body>
</html>
