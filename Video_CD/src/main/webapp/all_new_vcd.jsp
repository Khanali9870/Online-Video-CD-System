<%@page import="com.entity.User"%>
<%@page import="com.entity.VcdDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DataAcc.VcdDataImp"%>
<%@page import="com.db.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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

#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body style="background-color: #ffffcc">
	<%
	User u = (User) session.getAttribute("userobj");
	%>

	<c:if test="${not empty addCart }">
		<div id="toast">${addCart}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>

		<c:remove var="addCart" scope="session" />
	</c:if>

	<%@include file="All_file/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
			List<VcdDetails> list = data.getAllNewVcd();
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
							<a href="cart?vid=<%=v.getVcdId()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-plus"></i>Add Cart
							</a>

							<%
							}
							%>
							<a href="view_vcd.jsp?vid=<%=v.getVcdId()%>" class="btn btn-success btn-sm ml-1">View Detail</a> <a
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