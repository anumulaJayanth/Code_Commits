<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:rgb(255,252,211)">
<br>
<a href=HomePage.jsp style="color:black;text-decoration:none;font-size:35px;font-weight:bold;">FlyAway</a>
<br><br>
<%
	List<String[]> flights=(List<String[]>)session.getAttribute("flights");
	if(flights!=null){
%>
<h1>Available Flights</h1>
<div style="border:5px solid red;width:50%;border-radius:20px;padding:20px">
<pre style="font-size:20px">
Name   Time   Price
</pre>

<%
	for(String[] flight:flights){
%>

<pre style="font-size:17px">
<%=flight[0]%>&nbsp;&nbsp;<%=flight[1]%>&nbsp;&nbsp;<%=flight[2]%>
<a href=BookFlight.jsp>Book Now</a>
</pre>
<%
	}
%>
</div>
<%
	}
	else{
%>
<h1>There are no available flights</h1>
<%
	}
%>
</body>
</html>