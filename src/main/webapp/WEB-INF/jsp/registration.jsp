<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/register.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<title>Registration</title>
</head>
<body background="./img/intro-bg.jpg">
<ul class="breadcrumb">
  <li><a href="home.html">Home</a></li>
  <li><a href="login.html">Login</a></li>
  <li class="active">Register</li>
</ul>

	<div class="container">
		<c:choose>
			<c:when test="${ErrorduplicateEmail > 0}">
				<div class="alert alert-danger" role="alert" style="margin-top: 50px">Email id already exist</div>
			</c:when>
			<c:otherwise>
			<div class="alert alert-danger" role="alert" style="display: none;">Email id already exist</div>
			</c:otherwise>
		</c:choose>
		<div id="signupbox" style="margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign Up</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="login.html">Sign In</a>
					</div>
				</div>
				<div class="panel-body">
					<form:form id="register-form" cssClass="form-horizontal"
						modelAttribute="newuser" action="registration.html">

						<div id="signupalert" style="display: none"
							class="alert alert-danger">
							<p>Error:</p>
							<span></span>
						</div>

						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">First
								Name</label>
							<div class="col-md-9">
								<form:input path="first_name" cssClass="form-control"
									id="first_name" />
									<c:if test="${fnameerror>0}">
									<span><font color="red"><i>This field is required</i></font></span></c:if>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">Last
								Name</label>
							<div class="col-md-9">
								<form:input path="last_name" cssClass="form-control"
									id="last_name" />
									<c:if test="${lnameerror>0}">
									<span><font color="red"><i>This field is required</i></font></span></c:if>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<form:input cssClass="form-control" path="email_id" 
									id="email_id" />
									<c:if test="${emailerror>0}">
									<span><font color="red"><i>This field is required</i></font></span></c:if>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<form:password path="password" cssClass="form-control"
									id="password" />
									<c:if test="${pwderror>0}">
									<span><font color="red"><i>This field is required</i></font></span></c:if>
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<input type="submit" id="btn-signup" class="btn btn-info"
									name="create" value="Create Account" />
							</div>
						</div>

					</form:form>
				</div>
			</div>

		</div>
	</div>

</body>
</html>