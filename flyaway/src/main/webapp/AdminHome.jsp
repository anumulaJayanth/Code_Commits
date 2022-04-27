<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body style="background-color:rgb(255,252,211)">
<br>
<a href=HomePage.jsp style="color:black;font-size:35px;font-weight:bold;">Go To FlyAway Home page </a>
<br><br>

<h1>Insert New Flight Details</h1>

<div style="border:3px solid pink;width:25%;border-radius:20px;padding:20px">
<form action=InsertFlight method=post>
	<label for=name>Name :-</label> <input type="text" name=name id=name /><br><br>
	<label for=source>Source :-</label> <input type="text" name=source id=source /><br><br>
	<label for=destination>Destination :-</label> <input type="text" name=destination id=destination /><br><br>
	<label for=date>Departure :-</label> <input type="date" name=date id=date /><br><br>
	<label for=time>Time :-</label> <input type="time" name=time id=time /><br><br>
	<label for=price>Price :-</label> <input type="text" name=price id=price /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>
</div>
<%
	String message=(String)session.getAttribute("message");
	if(message!=null){
%>
<p style="color:silver;"><%=message %></p>
<%
		session.setAttribute("message", null);
	}
%>
</body>
</html>