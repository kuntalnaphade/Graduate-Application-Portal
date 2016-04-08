<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Application</title>
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
				<li><a href="editapplication.html?id=${application.applicationId}">Application Details</a></li>
				<li><a href="editPersonalDeatails.html">Personal Details</a></li>
				<li class="active"><a href="editEdubackgroundDetails.html">Eductional Background Details<span class="sr-only">(current)</span></a></li>
				<li><a href="editEducationalDetails.html">Eductional Details</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="../login.html">Log Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	
		<div class="container" style="width: 50%">
		<c:if test="${not empty lstedu}">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Educational Background Details</div>
				</div>
				<div class="panel-body  panel-body-sm">
					<table class="table table-bordered">
						<tr>
							<th>College</th>
							<th>Degree</th>
							<th>Duration</th>
							<th>Major</th>
							<th>Action(s)</th>
						</tr>
						<c:forEach items="${lstedu}" var="edub">
							<tr>
								<td>${edub.college}</td>
								<td>${edub.degree}</td>
								<td>${edub.duration}</td>
								<td>${edub.major}</td>
								<td><a href="editEduBg.html?id=${edub.eduId}"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="deleteEduBg.html?id=${edub.eduId}"><span class="glyphicon glyphicon-trash" ></span></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			</c:if>
		</div>
		
	<div>
		<form:form modelAttribute="edu" action="editEdubackgroundDetails.html?id=${edu.eduId}"
			method="Post">
			<div class="container" style="width: 50%">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">Add Educational Details</div>
					</div>
					<div class="panel-body  panel-body-sm">
						<table class="table table-bordered">
							<tr>
								<td>College:</td>
								<td><form:input path="college" /></td>
							</tr>
							<tr>
								<td>Degree :</td>
								<td><form:input path="degree" /></td>
							</tr>
							<tr>
								<td>Duration :</td>
								<td><form:input path="duration" /></td>
							</tr>
							<tr>
								<td>Major:</td>
								<td><form:input path="major" /></td>
							</tr>
						</table>
						<br>
						<div>
							<input type="submit" class="btn btn-primary" value="Save">
							<a class="btn btn-primary" href="editEducationalDetails.html">Next</a>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>