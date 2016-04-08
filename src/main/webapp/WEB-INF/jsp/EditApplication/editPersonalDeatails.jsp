<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Application</title>
</head>
<body background="../img/intro-bg.jpg">
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../student.html">Gapp</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a
					href="editapplication.html?id=${application.applicationId}">Application
						Details<span class="sr-only">(current)</span>
				</a></li>
				<li class="active"><a href="editPersonalDeatails.html">Personal
						Details<span class="sr-only">(current)</span>
				</a></li>
				<li><a href="editEdubackgroundDetails.html">Eductional
						Background Details</a></li>
				<li><a href="editEducationalDetails.html">Eductional
						Details</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="../login.html">Log Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<form:form modelAttribute="application">
		<div class="container" style="width: 50%; margin-top: 150px;">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Application Details</div>
				</div>
				<div class="panel-body  panel-body-sm">
					<table class="table table-bordered">
						<tr>
							<td>First Name:</td>
							<td><form:input path="firstname" /></td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td><form:input path="lastname" /></td>
						</tr>
						<tr>
							<td>Email Id:</td>
							<td><form:input path="emailid" /></td>
						</tr>
						<tr>
							<td>CIN :</td>
							<td><form:input path="cin" /></td>
						</tr>
						<tr>
							<td>Date of Birth :</td>
							<td><form:input type="date" path="dob" /></td>
						</tr>

						<tr>
							<td>Citizenship:</td>
							<td><form:select path="citizenship">
									<form:option value="-1" label="Select Citizenship"></form:option>
									<form:option value="Indian" label="Indian"></form:option>
									<form:option value="American" label="American"></form:option>
									<form:option value="Chinese" label="Chinese"></form:option>
								</form:select></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><form:radiobutton path="gender" value="Male"
									label="Male" /> <form:radiobutton path="gender" value="Female"
									label="Female" /></td>
						</tr>
						<tr>
							<td>Phone No:</td>
							<td><form:input path="phoneNumber" /></td>
						</tr>

					</table>
					<br>
					<div>
						<input type="submit" class="btn btn-primary" value="Save and Next">
					</div>
				</div>
			</div>
		</div>


	</form:form>



</body>
</html>