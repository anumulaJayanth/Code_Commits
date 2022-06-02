<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
<title>First Web Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<div class="container">

		<form:form method="post" modelAttribute="user">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="username">Username</form:label>
				<form:input path="username" type="text" class="form-control"
					required="required" />
				<form:errors path="username" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" type="text" class="form-control"
					required="required" />
				<form:errors path="password" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="firstname">First Name</form:label>
				<form:input path="firstname" type="text" class="form-control"
					required="required" />
				<form:errors path="firstname" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="lastname">Last Name</form:label>
				<form:input path="lastname" type="text" class="form-control"
					required="required" />
				<form:errors path="lastname" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="address">Address</form:label>
				<form:input path="address" type="text" class="form-control"
					required="required" />
				<form:errors path="address" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="text" class="form-control"
					required="required" />
				<form:errors path="email" cssClass="text-warning" />
			</fieldset>

			<button type="submit" class="btn btn-danger">Add</button>
		</form:form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- 
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
 -->

</body>
</html>