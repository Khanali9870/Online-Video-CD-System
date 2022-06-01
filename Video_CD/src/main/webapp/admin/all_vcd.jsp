<%@page import="com.entity.VcdDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.DataAcc.VcdDataImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All VCD</title>
<%@include file="AllCss.jsp"%>

</head>
<body style="background-color: #ffffcc;">
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<h3 class="text-center">Hello Admin</h3>

	<c:if test="${not empty SucessMagssage }">
		<h5 class="text-center text-success">${SucessMagssage}</h5>
		<c:remove var="SucessMagssage" scope="session" />
	</c:if>

	<c:if test="${not empty FailedMassage }">
		<h5 class="text-center text-danger">${FailedMassage}</h5>
		<c:remove var="FailedMassage" scope="session" />
	</c:if>

	<table class="table table-striped ">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Image</th>
				<th scope="col">VCD Name</th>
				<th scope="col">Actors Name</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
			List<VcdDetails> list = data.getAllVcd();
			for (VcdDetails v : list) {
			%>
			<tr>
				<th><%=v.getVcdId()%></th>
				<td><img alt="" src="../Movies/<%=v.getPhotoName()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=v.getVcdName()%></td>
				<td><%=v.getActors()%></td>
				<td><%=v.getPrice()%></td>
				<td><%=v.getVcdCategory()%></td>
				<td><%=v.getStatus()%></td>
				<td><a href="edit_Vcd.jsp?id=<%=v.getVcdId()%>"
					class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i> Edit</a> 
					<a href="../delete?id=<%=v.getVcdId()%>"class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Delete</a></td>
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