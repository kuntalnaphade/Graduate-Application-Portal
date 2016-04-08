<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Details</title>
</head>
<body background="./img/intro-bg.jpg">
	<ul class="breadcrumb">
		<li><a href="home.html">Home</a></li>
		<li><a href="login.html">Login</a></li>
		<li><a href="admin.html">Admin</a></li>
		<li class="active">Department Details</li>
	</ul>
	<div align="right"><a href="login.html" class="btn btn-info" role="button">Log Out</a></div>
	<div class="container" style="width: 50%">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Department Details</div>
			</div>
			<div>
				<table class="table table-bordered">
					<tr>
						<td>Department Name :</td>
						<td>${dept.department}</td>
						<c:choose>
							<c:when test="${depteditflag > 0}">
								<td><a style="color: gray;"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
							</c:when>
							<c:otherwise>
								<td><a href="editdepartment.html?id=${dept.deptId}"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
			</div>
			<c:if test="${depteditflag >0}">
				<div>
					<form:form action="editdepartment.html?id=${dept.deptId}"
						method="post" modelAttribute="editdept">
						<table style="width: auto !important;"
							class="table table-bordered">
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
								<td colspan="2"><input type="submit"
									class="btn btn-primary" name="save" value="Save">&nbsp
									&nbsp <a href="viewdepartment.html?id=${dept.deptId}"
									class="btn btn-primary">Cancel</a></td>
							</tr>
						</table>
					</form:form>
				</div>
			</c:if>
		</div>
	</div>
	<br />
	<div class="container" style="width: 50%">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Programs</div>
			</div>
			<div>
				<table class="table table-bordered">
					<tr>
						<th>Program Name</th>
						<th>Action(s)</th>
					</tr>
					<c:forEach items="${dept.lstPrograms}" var="prog">
						<tr>
							<td>${prog.program}</td>
							<c:choose>
								<c:when
									test="${(prgeditflag > 0) && (editprg.programId==prog.programId)}">
									<td><a style="color: gray;"><span
											class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>&nbsp
										<a
										href="deleteprogram.html?id=${prog.programId}&deptid=${dept.deptId}"><span
											class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
								</c:when>
								<c:otherwise>
									<td><a
										href="editprogram.html?id=${prog.programId}&deptid=${dept.deptId}"><span
											class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>&nbsp
										<a
										href="deleteprogram.html?id=${prog.programId}&deptid=${dept.deptId}"><span
											class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
			</div>
			<c:choose>
				<c:when test="${prgeditflag > 0}">
					<div>
						<form:form
							action="editprogram.html?id=${editprg.programId}&deptid=${dept.deptId}"
							method="post" modelAttribute="editprg">
							<table style="width: auto !important;"
								class="table table-bordered">
								<tr>
									<td>Program Name :</td>
									<td><form:input path="program" /></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" name="save"
										class="btn btn-primary" value="Save">&nbsp &nbsp <a
										href="viewdepartment.html?id=${dept.deptId}"
										class="btn btn-primary">Cancel</a></td>
								</tr>
							</table>
						</form:form>
					</div>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${prgflag > 0}">
					<div>
						<form:form action="addprogram.html?id=${dept.deptId}"
							method="post" modelAttribute="prog">
							<table style="width: auto !important;"
								class="table table-bordered">
								<tr>
									<td>Program Name :</td>
									<td><form:input path="program" /></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" name="save" class="btn btn-primary"
										value="Save">&nbsp &nbsp <a
										href="viewdepartment.html?id=${dept.deptId}"
										class="btn btn-primary">Cancel</a></td>
								</tr>
							</table>
						</form:form>
					</div>
				</c:when>
				<c:otherwise>
					<a href="addprogram.html?id=${dept.deptId}" class="btn btn-primary">Add
						New Program</a>
				</c:otherwise>
			</c:choose>

		</div>
	</div>

	<div class="container" style="width: 50%">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Additional Requirements</div>
			</div>
			<div>
				<table class="table table-bordered">
					<tr>
						<th>Additional field(s)</th>
						<th>Action(s)</th>
					</tr>
					<c:forEach items="${dept.lstAdditionalFields}" var="field">
						<tr>
							<td>${field.name}</td>
							<c:choose>
								<c:when
									test="${(fldeditflag > 0) && (editfld.fieldId==field.fieldId)}">
									<td><a style="color: gray;"><span
											class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>&nbsp
										<a
										href="deletefield.html?id=${field.fieldId}&deptid=${dept.deptId}"><span
											class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>

								</c:when>
								<c:otherwise>
									<td><a
										href="editfield.html?id=${field.fieldId}&deptid=${dept.deptId}"><span
											class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>&nbsp
										<a
										href="deletefield.html?id=${field.fieldId}&deptid=${dept.deptId}"><span
											class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
			</div>
			<c:choose>
				<c:when test="${fldflag > 0}">
					<div>
						<form:form action="addfields.html?id=${dept.deptId}" method="post"
							modelAttribute="field">
							<table style="width: auto !important;"
								class="table table-bordered">
								<tr>
									<td>Field Name :</td>
									<td><form:input path="name" /></td>
								</tr>
								<tr>
									<td>Field Type:</td>
									<td><form:select id="fldtype" path="fieldtype">
											<form:option value="Integer">Integer</form:option>
											<form:option value="String">String</form:option>
											<form:option value="File">File</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>Required</td>
									<td>Yes <form:radiobutton path="required" value="true"></form:radiobutton>
										No <form:radiobutton path="required" value="false"></form:radiobutton>
								</tr>

								<tr>
									<td colspan="2"><input type="submit" name="save"
										class="btn btn-primary" value="Save"> &nbsp &nbsp <a
										href="viewdepartment.html?id=${dept.deptId}"
										class="btn btn-primary">Cancel</a></td>
								</tr>
							</table>
						</form:form>
					</div>
				</c:when>
				<c:otherwise>
					<a href="addfields.html?id=${dept.deptId}" class="btn btn-primary">Add
						New Field</a>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${fldeditflag > 0}">
					<div>
						<form:form
							action="editfield.html?id=${editfld.fieldId}&deptid=${dept.deptId}"
							method="post" modelAttribute="editfld">
							<table style="width: auto !important;"
								class="table table-bordered">
								<tr>
									<td>Field Name :</td>
									<td><form:input path="name" /></td>
								</tr>
								<tr>
									<td>Field Type:</td>
									<td><form:select id="fldtype" path="fieldtype">
											<form:option value="Integer">Integer</form:option>
											<form:option value="String">String</form:option>
											<form:option value="File">File</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>Required</td>
									<td>Yes <form:radiobutton path="required" value="true"></form:radiobutton>
										No <form:radiobutton path="required" value="false"></form:radiobutton>
								</tr>

								<tr>
									<td colspan="2"><input type="submit" name="save"
										value="Save" class="btn btn-primary">&nbsp &nbsp <a
										href="viewdepartment.html?id=${dept.deptId}"
										class="btn btn-primary">Cancel</a></td>
								</tr>
							</table>
						</form:form>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>