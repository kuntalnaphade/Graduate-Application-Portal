<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li class="active"><a>Additional Fields<span
						class="sr-only">(current)</span></a></li>
				<li><a href="editPersonalDeatails.html">Personal Details</a></li>
				<li><a href="editEdubackgroundDetails.html">Eductional
						Background Details</a></li>
				<li><a href="editEducationalDetails.html">Eductional
						Details</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.html">Log Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<form action="editAdditionalFields.html?id=${application.applicationId} " method="post"
		enctype="multipart/form-data">
		<div class="container" style="width: 50%; margin-top: 150px;">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Addtional Details</div>
				</div>


				<div class="panel-body  panel-body-sm">
					<table class="table table-bordered">
						<c:forEach items="${lstaddfieldvalues}" var="field">
							<tr>
								<td>${field.field.name}</td>
								<c:choose>
									<c:when test="${field.field.fieldtype=='File'}">
										<td>
												<a href="download.html">${field.value}</a> 
												<input type="file" name="file" value="${field.value}"> 
										</td>
									</c:when>
									<c:otherwise>
										<td><input type="text" id="${field.field.name}"
											name="${field.field.name}" value="${field.value}"></td>
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
	<script>
		$(document).ready(function() {
			$("#btnedit").click(function() {
				$("#fileshow").hide();
				$("#filehide").show();
			});
			$("#btncancel").click(function() {
				$("#filehide").hide();
				$("#fileshow").show();
			});
		});
	</script>


</body>
</html>