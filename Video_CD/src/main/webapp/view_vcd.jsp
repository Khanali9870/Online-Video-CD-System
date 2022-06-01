<%@page import="com.entity.VcdDetails"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.DataAcc.VcdDataImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="All_file/AllCss.jsp"%>
</head>
<body style="background-color: #ffffcc">
	<%@include file="All_file/navbar.jsp"%>

	<%
	int vid = Integer.parseInt(request.getParameter("vid"));
	VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
	VcdDetails v = data.getVcdById(vid);
	%>
	<div class="container p-3">
		<div class="row p-5">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img alt="" src="Movies/<%=v.getPhotoName()%>"
					style="height: 150px; width: 100px"><br>
				<h4 class="mt-3">
					VCD Name:<span class="text-success"><%=v.getVcdName()%></span>
				</h4>
				<h4>
					Actors Name: <span class="text-success"><%=v.getActors()%></span>
				</h4>
				<h4>
					Cetegory: <span class="text-success"><%=v.getVcdCategory()%></span>
				</h4>
			</div>

			<div class="col-md-6 text-center p-5 border bg-white">
				<h2><%=v.getVcdName()%></h2>

				<%
				if ("Old".equals(v.getVcdCategory())) {
				%>
				<h5 class="text-primary">Contact To Seller</h5>
				<h5 class="text-primary">
					<i class="fa-solid fa-envelope"></i> Email:
					<%=v.getEmail()%></h5>
				<%
				}
				%>
				<div class="row">
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fa-solid fa-money-bill-wave fa-2x"></i>
						<p>Cash On Delivery</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fa-solid fa-rotate-left fa-2x"></i>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fa-solid fa-truck fa-3x"></i>
						<p>Free Shipping</p>
					</div>
				</div>
				<%
				if ("Old".equals(v.getVcdCategory())) {
				%>
				<div class="text-center p-3">
					<a href="index.jsp" class="btn btn-success">Continue Shopping</a> <a href=""
						class="btn btn-danger"><%=v.getPrice()%><i
						class="fa-solid fa-indian-rupee-sign"></i></a>
				</div>

				<%
				} else {
				%>
				<div class="text-center p-3">
					<a href="" class="btn btn-primary"><i
						class="fa-solid fa-cart-plus"></i> Add Cart</a> <a href=""
						class="btn btn-danger"><%=v.getPrice() %><i
						class="fa-solid fa-indian-rupee-sign"></i></a>
				</div>
				<%
				}
				%>


			</div>

		</div>
	</div>
</body>
</html>