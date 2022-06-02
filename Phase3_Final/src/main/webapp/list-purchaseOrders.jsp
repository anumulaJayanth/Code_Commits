<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Purchase Order Details</title>
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
		<table class="table table-striped">
			<caption>Purchase Orders</caption>
			<thead>
				<tr>
					<th>User</th>
					<th>Purchase Date</th>
					<th>Billed Amount</th>
					<th>Purchased Shoes Types</th>
					<th></th>
					<th></th>
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
								${shoe.shoetype} (${shoe.id}), 
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/search-purchaseOrders">Search Purchase Orders</a>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- 
	<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	 -->
</body>

</html>