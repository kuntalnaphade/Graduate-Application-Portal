<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Application</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
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
						Details</a></li>
				<li><a href="editPersonalDeatails.html">Personal Details</a></li>
				<li><a href="editEdubackgroundDetails.html">Eductional
						Background Details</a></li>
				<li class="active"><a href="editEducationalDetails.html">Eductional
						Details<span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="../login.html">Log Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<form:form modelAttribute="application" enctype="multipart/form-data">
		<div class="container" style="width: 50%; margin-top: 150px;">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Educational Details</div>
				</div>
				<div class="panel-body  panel-body-sm">
					<table class="table table-bordered">
						<tr>
							<td>Gpa :</td>
							<td><form:input path="gpa" /></td>
						</tr>
						<tr>
							<td>Gre :</td>
							<td><form:input path="grescore" /></td>
						</tr>
						<tr>
							<td>Toefl :</td>
							<td><form:input path="toeflscore" /></td>
						</tr>

						<tr>
							<td>Transcript :</td>
							<td><a href="download.html">${application.transcript}</a> <input
								type="file" name="file"></td>
						</tr>
					</table>
					<br>
					<div>
						<input type="submit" class="btn btn-primary" value="Submit"
							name="action"> <input type="submit"
							class="btn btn-primary" value="Save" name="action">
					</div>
				</div>
			</div>
		</div>


	</form:form>


</body>
</html>