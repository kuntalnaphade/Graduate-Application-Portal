<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body background="./img/intro-bg.jpg">
	<ul class="breadcrumb">
		<li><a href="home.html">Home</a></li>
		<li><a href="login.html">Login</a></li>
		<li class="active">Applications</li>
	</ul>
	<div align="right">
		<a href="login.html" class="btn btn-info" role="button">Log Out</a>
	</div>
	<div class="container" style="width: 60%">
	<div class="panel  panel-info" style="margin-top: 50px;">
	<div class="panel-heading">
				<h3 class="panel-title">Applications</h3>
			</div>
			<div class="panel-body  panel-body-sm">
		<table class="table table-bordered">
			<tr>
				<th>Application Id</th>
				<th>Department</th>
				<th>Program</th>
				<th>Term</th>
				<th>Status of application</th>
				<th>Action(s)</th>
			</tr>
			<c:forEach items="${lstapplications}" var="application">
				<tr>
					<td><a href="viewApplicationDetails.html?id=${application.applicationId}">${application.applicationId}</a></td>
					<td>${application.dept.department}</td>
					<td>${application.program.program}</td>
					<td>${application.term.termname}</td>
					<td>${application.status.value}</td>
					<td><a  href="EditApplication/editapplication.html?id=${application.applicationId}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="newapplication.html" class="btn btn-primary">Start New Application</a>
		</div>
		</div>
	</div>
</body>
</html>