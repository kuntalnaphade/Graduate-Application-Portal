<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<title>Gapp Login</title>
</head>
<body background="./img/intro-bg.jpg">
<ul class="breadcrumb">
  <li><a href="home.html">Home</a></li>
  <li class="active">Login</li>
</ul>
<c:choose>
			<c:when test="${loginV > 0}">
				<div class="alert alert-danger" role="alert" style="margin-top: 10px">Email Id or password is incorrect</div>
			</c:when>
			<c:otherwise>
			<div class="alert alert-danger" role="alert" style="display: none;">Email Id or password is incorrect</div>
			</c:otherwise>
		</c:choose>

	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form:form id="loginform" cssClass="form-horizontal"
						modelAttribute="user">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input id="login-username" path="email_id"
								cssClass="form-control" />
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span>
							<form:password id="login-password" path="password"
								cssClass="form-control" name="password" />
						</div>

						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<input type="submit" class="btn btn-success" name="login"
									id="btn-login" value="Login" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									Don't have an account! <a href="registration.html"> Sign Up
										Here </a>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>