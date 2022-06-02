<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
<title>Add/Update shoes</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container">
		<form:form method="post" modelAttribute="shoes">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="shoetype">ShoeType</form:label>
				<form:input path="shoetype" type="text" class="form-control"
					required="required" />
				<form:errors path="shoetype" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="gender">Gender (Male/Female/Boy/Girl)</form:label>
				<form:input path="gender" type="text" class="form-control"
					required="required" />
				<form:errors path="gender" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="size">Size</form:label>
				<form:input path="size" type="text" class="form-control"
					required="required" />
				<form:errors path="size" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="color">Color</form:label>
				<form:input path="color" type="text" class="form-control"
					required="required" />
				<form:errors path="color" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="price">Price</form:label>
				<form:input path="price" type="text" class="form-control"
					required="required" />
				<form:errors path="price" cssClass="text-warning" />
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