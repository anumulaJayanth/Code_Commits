<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html  xmlns:th="http://www.thymeleaf.org">

<head>
<title>User List for SportyShoes</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<br/>
		<a href="/admin-pass">Change password</a>&nbsp;&nbsp;
		<a href="/list-users">List/Search Users</a>&nbsp;&nbsp;
		<a href="/list-shoes">List/Search/Categorize/Update Shoes</a>&nbsp;&nbsp;
		<a href="/list-purchaseOrders">List Purchase Orders</a>&nbsp;&nbsp;
		<a href="/search-purchaseOrders">Search Purchase Orders</a>&nbsp;&nbsp;
		<br/>
		<form th:action="@{/list-users}">
		    Search User ( Enter any Username/FirstName/LastName/Address/Email): <input type="text" name="keyword" id="keyword" size="50" th:value="${keyword}" required />
		    &nbsp;
		    <input type="submit" value="Search" />
		    &nbsp;
		    <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
		</form>
		<table class="table table-striped">
			<caption>Users:</caption>
			<thead>
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Email</th>
					<th>Purchase Order IDs</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.firstname}</td>
						<td>${user.lastname}</td>
						<td>${user.address}</td>
						<td>${user.email}</td>
						<td>
							<c:forEach var="po" items="${user.purchaseOrders}">
								${po.id},
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
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