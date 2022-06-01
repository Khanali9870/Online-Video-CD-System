<%@page import="com.entity.VcdDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DataAcc.VcdDataImp"%>
<%@page import="com.db.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All New VCD</title>
<%@include file="All_file/AllCss.jsp"%>
<style type="text/css">
h2 {
	color: #ffff00;
}

.crd-ho:hover {
	background-color: #66ff99;
}
</style>
</head>
<body style="background-color: #ffffcc">
	<%@include file="All_file/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
			List<VcdDetails> list = data.getAllOldtVcd();
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
							<a href="view_vcd.jsp?vid=<%=v.getVcdId()%>" class="btn btn-success btn-sm ml-5">View Detail</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><%=v.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign"></i> </a>
						</div>
					</div>

				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>
</body>
</html>