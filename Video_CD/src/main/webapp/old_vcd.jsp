<%@page import="com.entity.VcdDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
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
<title>User: Old VCD</title>
<%@include file="All_file/AllCss.jsp"%>
</head>
<body style="background-color: #ffffcc">
	<%@include file="All_file/navbar.jsp"%>

	<c:if test="${not empty SucessMagssage}">
		<p class="text-center text-success">${SucessMagssage}</p>
		<c:remove var="SucessMagssage" scope="session" />
	</c:if>

	<div class="container p-5">
		<table class="table table-striped">
			<thead class="bg-primary text-white">
				<tr>

					<th scope="col">Vcd Name</th>
					<th scope="col">Actors</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<%
				User u = (User) session.getAttribute("userobj");
				String email = u.getEmail();
				VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
				List<VcdDetails> list = data.getVcdbyOld(email, "Old");
				for (VcdDetails v : list) {%>
				<tr>
					<td><%=v.getVcdName()%></td>
					<td><%=v.getActors()%></td>
					<td><%=v.getPrice()%></td>
					<td><%=v.getVcdCategory()%></td>
					<td><a href="delete_old_vcd?em=<%=email%>&&id=<%=v.getVcdId()%>"
						class="btn btn-sm btn-danger"> Delete</a></td>
				</tr>
				<%}
				%>

			</tbody>
		</table>
	</div>

</body>
</html>