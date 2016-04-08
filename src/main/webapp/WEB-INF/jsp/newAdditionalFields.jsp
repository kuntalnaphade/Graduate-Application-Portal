<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Application</title>
</head>
<body background="./img/intro-bg.jpg">
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
			<a class="navbar-brand" href="student.html">Gapp</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="newapplication.html">Application Details </a></li>
				<li class="active"><a>Additional Fields<span
						class="sr-only">(current)</span></a></li>
				<li><a>Personal Details</a></li>
				<li><a>Eductional Background Details</a></li>
				<li><a>Eductional Details</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.html">Log Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<form action="newAdditionalFields.html" method="post"
		enctype="multipart/form-data">
		<div class="container" style="width: 50%; margin-top: 150px;">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Addtional Details</div>
				</div>
				<c:set var="count" value="0" scope="page" />
				
				<div class="panel-body  panel-body-sm">
					<table class="table table-bordered">
						<c:forEach items="${lstaddfields}" var="field">
							<tr>
								<td>${field.name}</td>
								<c:choose>
									<c:when test="${field.fieldtype=='File'}">
										<td><input type="file" <%-- id="${field.name}" --%>
										name="file"	<%-- name="${field.name}" --%>></td>
										<c:set var="count" value="${count + 1}" scope="page"/>
									</c:when>
									<c:otherwise>
										<td><input type="text" id="${field.name}"
											name="${field.name}"></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</table>
					<br>
					<div>
						<input type="submit" class="btn btn-primary" value="Save and Next"
							name="save">
					</div>
				</div>
			</div>
		</div>


	</form>



</body>
</html>