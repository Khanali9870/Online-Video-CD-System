<%@page import="com.entity.Vcd_order"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.DataAcc.VcdOrderImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Order</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<h3 class="text_center">Hello Admin</h3>
	<table class="table table-striped ">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No</th>
				<th scope="col">VCD Name</th>
				<th scope="col">Actors</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>

			</tr>
		</thead>
		<tbody>

			<%
			VcdOrderImp data = new VcdOrderImp(DbConnect.getConnection());
			List<Vcd_order> list = data.getAllVcd();
			for (Vcd_order v : list) {
			%>
			<tr>
				<th scope="row"><%=v.getOrderId()%></th>
				<td><%=v.getUserName()%></td>
				<td><%=v.getEmail()%></td>
				<td><%=v.getFullAdd()%></td>
				<td><%=v.getPhoneno()%></td>
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
	<div style="margin-top: 280px">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>