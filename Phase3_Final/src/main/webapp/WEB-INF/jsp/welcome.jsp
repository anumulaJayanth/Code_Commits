<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html  xmlns:td="http://www.tdymeleaf.org">

<head>
<title>User List for SportyShoes</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<h3>Welcome ${name}!! Please select a task to perform.</h3>
		<table class="table table-striped">
			<tbody>
				<tr><td><h4><a href="/admin-pass">Change password</a></h4></td></tr>
				<tr><td><h4><a href="/list-users">List/Search Users</a></h4></td></tr>
				<tr><td><h4><a href="/list-shoes">List/Search/Categorize/Update Shoes</a></h4></td></tr>
				<tr><td><h4><a href="/list-users">List/Search Purchase Orders</a></h4></td></tr>
			</tbody>
		</table>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	    function clearSearch() {
	        window.location = "/list-users";
	    }
	</script>
</body>

</html>