<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	background-image: url('images/undraw/loginpage.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed; /* Fix the background image */
}

.login-container {
	width: 300px;
	margin: 100px auto;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.8);
	/* Add transparency for better visibility of form */
	border-radius: 5px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.login-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.login-container input[type="text"], .login-container input[type="password"],
	.login-container input[type="email"], /* Styling for email input */
	.login-container input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box;
	background-color: rgba(255, 255, 255, 0.5); /* Adjust transparency */
	color: #333; /* Adjust text color */
	font-size: 16px; /* Adjust font size */
}

.login-container input[type="submit"] {
	background-color: #4caf50;
	color: #fff;
	cursor: pointer;
}

.login-container input[type="submit"]:hover {
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

.signup-button:hover {
	background-color: #357ebd;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>Login Form</h2>
		<form action="LoginServlet" method="post">
			<input type="email" name="email" placeholder="Email" required>
			<input type="password" name="password" placeholder="Password" required> 
			<input type="submit" value="Login">
		</form>
		<button class="signup-button"
			onclick="window.location.href='signup.jsp'">Signup</button>
		<!-- Signup button -->
	</div>
</body>
</html>
