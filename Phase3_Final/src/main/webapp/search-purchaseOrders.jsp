<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>Purchase Order Details</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
		<a href="/admin-pass">Change password</a>&nbsp;&nbsp;
		<a href="/list-users">List/Search Users</a>&nbsp;&nbsp;
		<a href="/list-shoes">List/Search/Categorize/Update Shoes</a>&nbsp;&nbsp;
		<a href="/list-purchaseOrders">List Purchase Orders</a>&nbsp;&nbsp;
		<a href="/search-purchaseOrders">Search Purchase Orders</a>&nbsp;&nbsp;
		<div class="container">
		<br/>
		<br/>
		<form th:action="@{/search-purchaseOrders}">
		    Search by date (dd/MM/yyyy): <input type="text" name="date" id="date" size="50" th:value="${date}" required />
		    &nbsp;
		    <input type="submit" value="Search" />
		    &nbsp;
		    <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
		</form>
		<form th:action="@{/search-purchaseOrders}">
		    Search by Shoe Type: <input type="text" name="shoetype" id="shoetype" size="50" th:value="${shoetype}" required />
		    &nbsp;
		    <input type="submit" value="Search" />
		    &nbsp;
		    <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
		</form>

		<table class="table table-striped">
			<caption>Purchase Orders</caption>
			<thead>
				<tr>
					<th>User</th>
					<th>Purchase Date</th>
					<th>Billed Amount</th>
					<th>Purchased Shoes Types</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="purchaseOrder" items="${purchaseOrderlist}">
					<tr>
						<td>${purchaseOrder.user.username}</td>
						<td><fmt:formatDate value="${purchaseOrder.purchaseDate}"
								pattern="dd/MM/yyyy" /></td>
						<td>${purchaseOrder.billedAmount}</td>
						<td><c:forEach var="shoe" items="${purchaseOrder.shoes}">
								${shoe.shoetype} (ID: ${shoe.id}), 
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/list-purchaseOrders">List all Purchase Orders</a>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	    function clearSearch() {
	        window.location = "/search-purchaseOrders";
	    }
	</script>
</body>

</html>