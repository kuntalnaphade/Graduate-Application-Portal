<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body background="./img/intro-bg.jpg">
<ul class="breadcrumb">
  <li><a href="home.html">Home</a></li>
  <li><a href="login.html">Login</a></li>
  <li class="active">Admin</li>
</ul>
<div align="right"><a href="login.html" class="btn btn-info" role="button">Log Out</a></div>
	<div class="container" style="width: 60%">
		<div class="panel  panel-info" style="margin-top: 50px;">
			<div class="panel-heading">
				<h3 class="panel-title">Departments</h3>
			</div>
			<div class="panel-body  panel-body-sm">
				<table class="table table-bordered">
					<tr>
						<th>Department Name</th>
						<th>Programs</th>

					</tr>
					<c:forEach items="${lstdepartment}" var="dept">
						<tr>
							<td><a href="viewdepartment.html?id=${dept.deptId}">${dept.department}</a></td>
							<td><ul>
									<c:forEach items="${dept.lstPrograms}" var="prog">
										<li>${prog.program}</li>
									</c:forEach>
								</ul></td>
						</tr>
					</c:forEach>
				</table>
				<br />
				<c:choose>
					<c:when test="${addflag > 0}">
						<div>
							<form:form action="adddepartment.html" method="post"
								modelAttribute="dept">
								<table class="table table-bordered" width="400">
									<tr>
										<td>Department Name :</td>
										<td><form:input path="department" /></td>
									</tr>
									<tr>
										<td>Gre Required</td>
										<td>Yes <form:radiobutton path="grerequired" value="true"></form:radiobutton>
											No <form:radiobutton path="grerequired" value="false"></form:radiobutton>
									</tr>
									<tr>
										<td colspan="2"><input type="submit" name="save"
											class="btn btn-primary" value="Save"> &nbsp &nbsp <a
											href="admin.html" class="btn btn-primary">Cancel</a></td>
									</tr>
								</table>
							</form:form>
						</div>
					</c:when>
					<c:otherwise>
						<a href="adddepartment.html" class="btn btn-primary">Add New
							Department</a>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
</body>
</html>