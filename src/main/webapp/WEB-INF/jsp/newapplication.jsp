<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<li class="active"><a
					href="newapplication.html">Application
						Details<span class="sr-only">(current)</span>
				</a></li>
				<li><a>Personal Details</a></li>
				<li><a>Eductional
						Background Details</a></li>
				<li><a>Eductional
						Details</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.html">Log Out</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<form:form modelAttribute="application">
		<div class="container" style="width: 50%; margin-top: 150px;">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Application Details</div>
				</div>
				<div class="panel-body  panel-body-sm">
					<table class="table table-bordered">
						<tr>
							<td>Department:<span style="color:red">*</span> </td>
							<td><form:select path="dept.deptId" id="dep">
									<form:option value="-1" label="Select Department"></form:option>
									<form:options items="${lstdepartment}" itemLabel="department"
										itemValue="deptId" />
								</form:select></td>
						</tr>
						<tr>
							<td>Program<span style="color:red">*</span></td>
							<td><form:select path="program.programId" id="programs">
									<form:option value="-1" label="Select Programs"></form:option>
								</form:select></td>
						</tr>
						<tr>
							<td>Term : <span style="color:red">*</span></td>
							<td><form:select path="term.termId">
									<form:option value="-1" label="Select Term"></form:option>
									<form:options items="${lstterms}" itemLabel="termname"
										itemValue="termId" />
								</form:select></td>
						</tr>
					</table>
					<br>
					<div>
						<input type="submit" class="btn btn-primary" value="Save and Next">
					</div>
				</div>
			</div>
		</div>


	</form:form>



	<script type="text/javascript">
		$(function() {
			$("#dep")
					.change(
							function() {
								$
										.ajax({
											url : "/gapp/getprograms.html",
											data : {
												"deptid" : $("#dep").val(),
											},
											dataType : 'json',
											success : function(data) {
												console.log();
												var html = '<option value="">Select Program</option>';
												for (var i = 0; i < data.length; i++) {
													html += '<option value="'+data[i].programId+'">'
															+ data[i].program
															+ '</option>';
												}

												$("#programs").html(html);

											},
											error : function(err) {
												console.log(err)
											}
										});
							});
		});
	</script>


</body>
</html>