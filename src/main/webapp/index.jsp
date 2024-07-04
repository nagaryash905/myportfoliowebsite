<!doctype html>
<%@page import="com.portfolio.model.ExperiencePojo"%>
<%@page import="com.portfolio.model.EducationPojo"%>
<%@page import="com.portfolio.model.ProjectPojo"%>
<%@page import="com.portfolio.model.ProfilePojo"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Marvel HTML Bootstrap 4 Template</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/unicons.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- MAIN STYLE -->
<link rel="stylesheet" href="css/tooplate-style.css">
</head>
<body>

<%-- 	<%@include file="message.jsp" %>  --%>

	<!-- MENU -->

	<!-- Profile Start Here -->
	
	<%
	String check = (String) session.getAttribute("check");
	if (check == null) {
	%>

	<form id="myform" action="IndexProfileServlet" method="post">
		<input id="submitbutton" style="display: none;" type="submit"
			value="submit">
	</form>

	<script type="text/javascript">
		window.onload = function() {
			document.getElementById('submitbutton').click();
		};
	</script>

	<%
	return;
	}
	session.removeAttribute("check");
	%>

	<%
	String messagepro = (String) session.getAttribute("msg");
	if (messagepro == null) {
		ArrayList<ProfilePojo> arrayList = (ArrayList<ProfilePojo>) session.getAttribute("profile");
		if (arrayList != null && !arrayList.isEmpty()) {
			for (ProfilePojo profile : arrayList) {
	%>

	<!-- Profile Start Here Stop -->

	<nav class="navbar navbar-expand-sm navbar-light">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"><i class='uil uil-user'></i>
				<%=profile.getName()%></a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span> <span
					class="navbar-toggler-icon"></span> <span
					class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mx-auto">
					<li class="nav-item"><a href="#about" class="nav-link"><span
							data-hover="About">About</span></a></li>
					<li class="nav-item"><a href="#project" class="nav-link"><span
							data-hover="Projects">Projects</span></a></li>
					<li class="nav-item"><a href="#resume" class="nav-link"><span
							data-hover="Experience & Education">Experience & Education</span></a></li>
					<li class="nav-item"><a href="#contact" class="nav-link"><span
							data-hover="Contact">Contact</span></a></li>
				</ul>

				<ul class="navbar-nav ml-lg-auto">
					<div class="ml-lg-4">
						<div
							class="color-mode d-lg-flex justify-content-center align-items-center">
							<i class="color-mode-icon"></i> Color mode
						</div>
					</div>
				</ul>
			</div>
		</div>
	</nav>

	<!-- ABOUT -->
	<section
		class="about full-screen d-lg-flex justify-content-center align-items-center"
		id="about">
		<div class="container">
			<div class="row">

				<div class="col-lg-7 col-md-12 col-12 d-flex align-items-center">
					<div class="about-text">
						<small class="small-text">Welcome to <span
							class="mobile-block"><%=profile.getName()%> portfolio
								website!</span></small>
						<h1 class="animated animated-text">
							<span class="mr-2">Hey folks, I'm</span>
							<div class="animated-info">
								<span class="animated-item"><%=profile.getName()%></span> <span
									class="animated-item"><%=profile.getDesignation()%></span>
							</div>
						</h1>

						<p><%=profile.getDescription()%></p>

						<div class="custom-btn-group mt-4">
							<a href="DownloadResumeServlet" class="btn mr-lg-2 custom-btn"><i
								class='uil uil-file-alt'></i> Download Resume</a> <a href="#contact"
								class="btn custom-btn custom-btn-bg custom-btn-link">Get a
								free quote</a>
						</div>
					</div>
				</div>

				<!-- Here in div I need to add the Image -->

				<div class="col-lg-5 col-md-12 col-12">
					<div class="about-image svg">
						<img src="profilepicture/profile.png"
							class="img-fluid" alt="svg image">
					</div>
				</div>

				<!-- Here in div I need to add the Image -->

			</div>
		</div>
	</section>


	<!-- END Point Here -->

	<%
	}
	}
	} else {
	%>
	<h3><%=messagepro%></h3>
	<%
	}
	session.removeAttribute("msg");
	%>

	<!-- Profile Start Here -->


	<!-- PROJECTS -->

	<section class="project py-5" id="project">
		<div class="container">
			<div class="row">
				<div class="col-lg-11 text-center mx-auto col-12">
					<div class="col-lg-8 mx-auto">
						<h2>Project I Have Worked</h2>
					</div>
					<!-- Project Start Here -->

					<%
					String checkproject = (String) session.getAttribute("checkproj");
					if (checkproject == null) {
					%>

					<form id="myform" action="IndexProjectServlet" method="post">
						<input id="submitbutton" style="display: none;" type="submit"
							value="submit">
					</form>

					<script type="text/javascript">
						window.onload = function() {
							document.getElementById('submitbutton').click();
						};
					</script>

					<%
					return;
					}
					session.removeAttribute("checkproj");
					%>

					<%
					String messageproject = (String) session.getAttribute("msg");
					if (messageproject == null) {
						ArrayList<ProjectPojo> arrayListproject = (ArrayList<ProjectPojo>) session.getAttribute("project");
						if (arrayListproject != null && !arrayListproject.isEmpty()) {
							for (ProjectPojo project : arrayListproject) {
					%>

					<!-- Project Start Here End -->

					<div class="item"
						style="border: 2px solid #ffc200; border-radius: 5px; padding: 50px; max-width: 800px; margin: 0 auto;">
						<div class="project-info">
							<h3><%=project.getProject()%></h3>
							<p><%=project.getDescription()%></p>
						</div>
					</div>
					<hr>

					<!-- Project Ends Here -->

					<%
					}
					}
					} else {
					%>
					<h3><%=messageproject%></h3>
					<%
					}
					session.removeAttribute("msg");
					%>

					<!-- Project Ends Here End -->
				</div>
			</div>
		</div>
	</section>



	<!-- FEATURES -->
	<section
		class="resume py-5 d-lg-flex justify-content-center align-items-center"
		id="resume">
		<div class="container">
			<div class="row">

				<div class="col-lg-6 col-12">
					<h2 class="mb-4">Experiences</h2>

					<!-- Experience First Start Here  -->

					<%
					String checkexper = (String) session.getAttribute("checkexper");
					if (checkexper == null) {
					%>

					<form id="myform" action="IndexExperienceServlet" method="post">
						<input id="submitbutton" style="display: none;" type="submit"
							value="submit">
					</form>

					<script type="text/javascript">
						window.onload = function() {
							document.getElementById('submitbutton').click();
						};
					</script>

					<%
					return;
					}
					session.removeAttribute("checkexper");
					%>

					<%
					String messageexper = (String) session.getAttribute("msg");
					if (messageexper == null) {
						ArrayList<ExperiencePojo> arrayListexper = (ArrayList<ExperiencePojo>) session.getAttribute("experience");
						if (arrayListexper != null && !arrayListexper.isEmpty()) {
							for (ExperiencePojo exper : arrayListexper) {
					%>

					<!-- Experience First Start End -->

					<div class="timeline">
						<div class="timeline-wrapper">
							<div class="timeline-yr">
								<span><%=exper.getYear()%></span>
							</div>
							<div class="timeline-info">
								<h3>
									<span><%=exper.getJobtitle()%></span><small><%=exper.getCompany()%></small>
								</h3>
								<p><%=exper.getDescription()%></p>
							</div>
						</div>
					</div>

					<!-- Experience First Start Here  -->

					<%
					}
					}
					} else {
					%>
					<h3><%=messageexper%></h3>
					<%
					}
					session.removeAttribute("msg");
					%>

					<!-- Experience First Start End -->

				</div>

				<div class="col-lg-6 col-12">
					<h2 class="mb-4 mobile-mt-2">Educations</h2>

					<!-- Education First Start Here  -->

					<%
					String checkeducat = (String) session.getAttribute("checkedu");
					if (checkeducat == null) {
					%>

					<form id="myform" action="IndexEducationServlet" method="post">
						<input id="submitbutton" style="display: none;" type="submit"
							value="submit">
					</form>

					<script type="text/javascript">
						window.onload = function() {
							document.getElementById('submitbutton').click();
						};
					</script>

					<%
					return;
					}
					session.removeAttribute("checkproj");
					%>

					<%
					String messageeducationt = (String) session.getAttribute("msg");
					if (messageeducationt == null) {
						ArrayList<EducationPojo> arrayListeducation = (ArrayList<EducationPojo>) session.getAttribute("education");
						if (arrayListeducation != null && !arrayListeducation.isEmpty()) {
							for (EducationPojo education : arrayListeducation) {
					%>

					<!-- Education First Start End -->

					<div class="timeline">
						<div class="timeline-wrapper">
							<div class="timeline-yr">
								<span><%=education.getYear()%></span>
							</div>
							<div class="timeline-info">
								<h3>
									<span><%=education.getSchool()%></span><small><%=education.getSection()%></small>
								</h3>
								<p><%=education.getDescription()%></p>
							</div>
						</div>
					</div>

					<!-- Education End Start Here  -->

					<%
					}
					}
					} else {
					%>
					<h3><%=messageeducationt%></h3>
					<%
					}
					session.removeAttribute("msg");
					%>

					<!-- Education End Start End -->

				</div>

			</div>
		</div>
	</section>

	<!-- CONTACT -->
	<section class="contact py-5" id="contact">
		<div class="container"
			style="display: flex; justify-content: center; align-items: center; width: 100vw; height: 100vh;">
			<div class="row"></div>

			<div class="col-lg-6 col-12">
				<div class="contact-form">
					<h2 class="mb-4">Interested to work together? Let's talk</h2>
					<form action="ContactServlet" method="post">
						<div class="row">
							<div class="col-lg-6 col-12">
								<input type="text" class="form-control" name="name"
									placeholder="Your Name" id="name">
							</div>

							<div class="col-lg-6 col-12">
								<input type="email" class="form-control" name="email"
									placeholder="Email" id="email">
							</div>

							<div class="col-12">
								<textarea name="message" rows="6" class="form-control"
									id="message" placeholder="Message"></textarea>
							</div>

							<input type="submit" class="form-control submit-btn"
								value="Send Button" style="display: block; margin: auto;">

							<!-- <footer class="footer py-5">
								<div class="container">
									<div class="row">
										<div class="col-lg-12 col-12" style="text-align: center;">
											<p class="copyright-text" style="display: inline-block; margin: 0 10px;">LinkedIn<a rel="nofollow" href=""></a></p>
											<p class="copyright-text" style="display: inline-block; margin: 0 10px;">HackerRank<a rel="nofollow" href=""></a></p>
											<p class="copyright-text" style="display: inline-block; margin: 0 10px;">HackerEarth<a rel="nofollow" href=></a></p>
										</div>
									</div>
								</div>
							</footer> -->
						</div>
					</div>
				</form>
			</div>
		</div>
		</div>
		</div>
	</section>


	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/Headroom.js"></script>
	<script src="js/jQuery.headroom.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/smoothscroll.js"></script>
	<script src="js/custom.js"></script>

</body>
</html>