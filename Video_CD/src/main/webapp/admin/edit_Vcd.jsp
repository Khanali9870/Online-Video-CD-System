<%@page import="com.entity.VcdDetails"%>
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
<title>Admin Add VCD</title>
<%@include file="AllCss.jsp"%>
</head>
<body style="background-color: #ffffcc;">
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit VCD</h4>


						<%
						int id = Integer.parseInt(request.getParameter("id"));
						VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
						VcdDetails v = data.getVcdById(id);
						%>
						<form action="../editvcd" method="post">
							<input type="hidden" name="id" value="<%=v.getVcdId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">VCD Name</label> <input
									name="vname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describrdby="emailHelp"
									value="<%=v.getVcdName()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Actors Name</label> <input
									name="actors" type="text" class="form-control"
									id="exampleInputEmail1" aria-describrdby="emailHelp"
									value="<%=v.getActors()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputEmail1" value="<%=v.getPrice()%>">
							</div>


							<div class="form-group">
								<label for="inputState">VCD Status</label> <select
									id="inputState" name="status" class="form-control">
									<%
									if ("Active".equals(v.getStatus())) {
									%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>

									<%
									} else {
									%>
									<option value="Inactive">Inactive</option>

									<%
									}
									%>


								</select>
							</div>
							<button type="submit" class="btn btn-primary">Update</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 57px">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>