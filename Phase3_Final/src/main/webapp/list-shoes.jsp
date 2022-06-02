<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>

<head>
<title>Shoes List for SportyShoes</title>
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
		<form th:action="@{/list-shoes}">
		    Search Shoes(Enter any ShoeType/Gender/Size/Color/Price):
			<input type="text" name="keyword" id="keyword" size="50" th:value="${keyword}" />
		    &nbsp;
		    <input type="submit" value="Search" />
		    &nbsp;
		    <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
		</form>
		<h3>Categorize: </h3>
		<h5><a href="/list-shoes">Show All</a></h5>
		<h5>
		Shoetype:&nbsp;
		<a href="/list-shoes/Basketball">Basketball</a>&nbsp;&nbsp;
		<a href="/list-shoes/Football">Football</a>&nbsp;&nbsp;
		<a href="/list-shoes/Sneakers">Sneakers</a>&nbsp;&nbsp;
		<a href="/list-shoes/Formal">Formal</a>&nbsp;&nbsp;
		<a href="/list-shoes/Casual">Casual</a>&nbsp;&nbsp;
		<a href="/list-shoes/Leather">Leather</a>
		</h5>
		<h5>
		Gender:&nbsp;
		<a href="/list-shoes/Male">Male</a>&nbsp;&nbsp;
		<a href="/list-shoes/Female">Female</a>&nbsp;&nbsp;
		<a href="/list-shoes/Boy">Boy</a>&nbsp;&nbsp;
		<a href="/list-shoes/Girl">Girl</a>&nbsp;&nbsp;
		</h5>
		<h5>
		Size:&nbsp;
		<a href="/list-shoes/5.0">5.0</a>&nbsp;&nbsp;
		<a href="/list-shoes/5.5">5.5</a>&nbsp;&nbsp;
		<a href="/list-shoes/6.0">6.0</a>&nbsp;&nbsp;
		<a href="/list-shoes/6.5">6.5</a>&nbsp;&nbsp;
		<a href="/list-shoes/7.0">7.0</a>&nbsp;&nbsp;
		<a href="/list-shoes/7.5">7.5</a>&nbsp;&nbsp;
		<a href="/list-shoes/8.0">8.0</a>&nbsp;&nbsp;
		<a href="/list-shoes/8.5">8.5</a>&nbsp;&nbsp;
		<a href="/list-shoes/9.0">9.0</a>&nbsp;&nbsp;
		<a href="/list-shoes/9.5">9.5</a>&nbsp;&nbsp;
		<a href="/list-shoes/10.0">10.0</a>&nbsp;&nbsp;
		<a href="/list-shoes/10.5">10.5</a>&nbsp;&nbsp;
		</h5>
		<table class="table table-striped">
			<caption>Shoes:</caption>
			<thead>
				<tr>
				    <th>Item ID</th>
					<th>Shoetype</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Color</th>
					<th>Price</th>
					<th></th>
				</tr>				
			</thead>
			<tbody>
				<c:forEach items="${shoeslist}" var="shoes">
					<tr>
						<td>${shoes.id}</td>
						<td>${shoes.shoetype}</td>
						<td>${shoes.gender}</td>
						<td>${shoes.size}</td>
						<td>${shoes.color}</td>
						<td>${shoes.price}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-shoes?id=${shoes.id}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-shoes">Add New Shoes</a>
		</div>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	    function clearSearch() {
	        window.location = "/list-shoes";
	    }
	</script>
</body>

</html>