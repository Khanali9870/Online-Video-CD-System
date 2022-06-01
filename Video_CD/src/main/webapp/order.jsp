<%@page import="com.entity.Vcd_order"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.DataAcc.VcdOrderImp"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
<%@include file="All_file/AllCss.jsp"%>
</head>
<body style="background-color: #ffffcc;">
	<%@include file="All_file/navbar.jsp"%>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container p-1">
		<h3 class="text-center text-primary">Your Order</h3>
		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Vcd Name</th>
					<th scope="col">Actors</th>
					<th scope="col">Price</th>
					<th scope="col">Payment type</th>
				</tr>
			</thead>
			<tbody>

				<%
				User u = (User) session.getAttribute("userobj");
				VcdOrderImp data = new VcdOrderImp(DbConnect.getConnection());
				List<Vcd_order> list = data.getVcd(u.getEmail());

				for (Vcd_order v : list) {
				%>
				<tr>
					<th scope="row"><%=v.getOrderId()%></th>
					<td><%=v.getUserName()%></td>
					<td><%=v.getVcdName()%></td>
					<td><%=v.getActors()%></td>
					<td><%=v.getPrice()%></td>
					<td><%=v.getPaymentType()%></td>
				</tr>

				<%
				}
				%>

			</tbody>
		</table>
	</div>

</body>
</html>