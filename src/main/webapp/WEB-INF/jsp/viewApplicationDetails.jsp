<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Application</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
</head>
<body background="./img/intro-bg.jpg">
	<ul class="breadcrumb">
		<li><a href="home.html">Home</a></li>
		<li><a href="login.html">Login</a></li>
		<li><a href="student.html">Applications</a></li>
		<li class="active">View Application</li>
	</ul>

	<div class="container" style="width: 50%">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Application Details</div>
			</div>
			<div class="panel-body  panel-body-sm">
				<div align="left">
					<b>Application Info</b>
				</div>
				<table class="table table-bordered">
					<tr>
						<td>Department:</td>
						<td>${application.dept.department}</td>
					</tr>
					<tr>
						<td>Program :</td>
						<td>${application.program.program}</td>
					</tr>
					<tr>
						<td>Status:</td>
						<td>${application.status.value}</td>
					</tr>
					<tr>
						<td>Last Modified Date:</td>
						<td>${application.modifiedtime}</td>
					</tr>
				</table>
				<c:if test="${fn:length(application.lstfieldvalues) gt 0}">
					<div align="left">
						<b>Additional Fields</b>
					</div>
					<table class="table table-bordered">
						<c:forEach items="${application.lstfieldvalues}" var="field">
							<tr>
							<td>${field.field.name}</td>
							<c:choose>
									<c:when test="${field.field.fieldtype=='File'}">
										<td><a href="download.html?name=${field.value}">${field.value}</a></td>
									</c:when>
									<c:otherwise>
										<td>${field.value}</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</table>
				</c:if>



				<div align="left">
					<b>Personal Info</b>
				</div>
				<table class="table table-bordered">
					<tr>
						<td>First Name:</td>
						<td>${application.firstname}</td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td>${application.lastname}</td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td>${application.emailid}</td>
					</tr>
					<tr>
						<td>CIN:</td>
						<td>${application.cin}</td>
					</tr>
					<tr>
						<td>Date Of Birth</td>
						<td>${application.dob}</td>
					</tr>
					<tr>
						<td>Citizenship</td>
						<td>${application.citizenship}</td>
					</tr>
					<tr>
						<td>Gender</td>
						<td>${application.gender}</td>
					</tr>
					<tr>
						<td>Phone Number</td>
						<td>${application.phoneNumber}</td>
					</tr>
				</table>
				<div align="left">
					<b>Educational Background Details</b>
				</div>
				<table class="table table-bordered">
					<tr>
						<th>College</th>
						<th>Degree</th>
						<th>Duration</th>
						<th>Major</th>
					</tr>
					<c:forEach items="${application.lsteEducationalBackgrounds}"
						var="edub">
						<tr>
							<td>${edub.college}</td>
							<td>${edub.degree}</td>
							<td>${edub.duration}</td>
							<td>${edub.major}</td>
						</tr>
					</c:forEach>
				</table>
				<div align="left">
					<b>Education Info</b>
				</div>
				<table class="table table-bordered">
					<tr>
						<td>Gre :</td>
						<td>${application.grescore}</td>
					</tr>
					<tr>
						<td>Toefl :</td>
						<td>${application.toeflscore}</td>
					</tr>
					<tr>
						<td>Gpa :</td>
						<td>${application.gpa}</td>
					</tr>
					<tr>
						<td>Transcript</td>
						<td><a href="download.html">${application.transcript}</a></td>
					</tr>
				</table>
				<br>
				<div>
					<a class="btn btn-primary" href="student.html">Done</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>