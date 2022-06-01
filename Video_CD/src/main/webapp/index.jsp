<%@page import="com.entity.User"%>
<%@page import="com.entity.VcdDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DataAcc.VcdDataImp"%>
<%@page import="com.db.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VCD System</title>
<%@include file="All_file/AllCss.jsp"%>
<style type="text/css">
.back-Image {
	background: url("Image/VCD.jpg");
	height: 50vh;
	width: 100%;
	backgroung-repeat: no-repeat;
	backgroung-size: cover;
}

h2 {
	color: #ffff00;
}

.crd-ho:hover {
	background-color: #66ff99;
}
</style>
</head>
<body style="background-color: #ffffcc">

	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="All_file/navbar.jsp"%>
	<div class="container-fluid back-Image">
		<h2 class="text-center">Online VCD System</h2>
	</div>

	<!-- Start Recent Video_CD -->
	<div class="container">
		<h3 class="text-center">Recent Video_CD</h3>
		<div class="row">
			<%
			VcdDataImp data2 = new VcdDataImp(DbConnect.getConnection());
			List<VcdDetails> list1 = data2.getRecentVcd();
			for (VcdDetails v : list1) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="Movies/<%=v.getPhotoName()%>"
							style="width: 150px; height: 200px;" class="Image-thumblin">
						<p><%=v.getVcdName()%></p>
						<p><%=v.getActors()%></p>

						<%
						if (v.getVcdCategory().equals("Old")) {
						%>
						<p>
							Categories:
							<%=v.getVcdCategory()%></p>
						<div class="row">

							<a href="view_vcd.jsp?vid=<%=v.getVcdId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=v.getPrice()%> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
						<%
						} else {
						%>
						<p>
							Categories:
							<%=v.getVcdCategory()%></p>
						<div class="row">


							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-plus"></i>Add Cart
							</a>
							<%
							} else {
							%>
							<a href="cart?vid=<%=v.getVcdId()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-plus"></i>Add Cart
							</a>

							<%
							}
							%>
							<a href="view_vcd.jsp?vid=<%=v.getVcdId()%>"
								class="btn btn-success btn-sm ml-1">View Detail</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=v.getPrice()%> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
						<%
						}
						%>

					</div>

				</div>
			</div>
			<%
			}
			%>

		</div>
		<div class="text-center mt-1">
			<a href="all_recent_vcd.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>

	<!-- End Recent Video_CD -->
	<hr>

	<!-- Start New Video_CD -->
	<div class="container">
		<h3 class="text-center">New Video_CD</h3>
		<div class="row">

			<%
			VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
			List<VcdDetails> list = data.getNewVcd();
			for (VcdDetails v : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="Movies/<%=v.getPhotoName()%>"
							style="width: 150px; height: 200px;" class="Image-thumblin">
						<p><%=v.getVcdName()%></p>
						<p><%=v.getActors()%></p>
						<p>
							Categories:
							<%=v.getVcdCategory()%></p>
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-plus"></i> Add Cart
							</a>
							<%
							} else {
							%>
							<a href="cart?vid=<%=v.getVcdId()%>&&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-plus"></i> Add Cart
							</a>

							<%
							}
							%>

							<a href="view_vcd.jsp?vid=<%=v.getVcdId()%>"
								class="btn btn-success btn-sm ml-1">View Detail</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=v.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign"></i> </a>
						</div>
					</div>

				</div>
			</div>
			<%
			}
			%>


		</div>
		<div class="text-center mt-1">
			<a href="all_new_vcd.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>

	<!-- End New Video_CD -->
	<hr>
	<!-- Start Old Video_CD -->
	<div class="container">
		<h3 class="text-center">Old Video_CD</h3>
		<div class="row">
			<%
			VcdDataImp data3 = new VcdDataImp(DbConnect.getConnection());
			List<VcdDetails> list3 = data3.getOldVcd();
			for (VcdDetails v : list3) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="Movies/<%=v.getPhotoName()%>"
							style="width: 150px; height: 200px;" class="Image-thumblin">
						<p><%=v.getVcdName()%></p>
						<p><%=v.getActors()%></p>
						<p>
							Categories:
							<%=v.getVcdCategory()%></p>
						<div class="row">
							<a href="view_vcd.jsp?vid=<%=v.getVcdId()%>"
								class="btn btn-success btn-sm ml-5">View Detail</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=v.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign"></i> </a>
						</div>

					</div>

				</div>
			</div>
			<%
			}
			%>
		</div>
		<div class="text-center mt-1">
			<a href="all_old_vcd.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>

	<!-- End Old Video_CD -->
	<%@include file="All_file/footer.jsp"%>
</body>
</html>