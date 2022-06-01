<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell VCD</title>
<%@include file="All_file/AllCss.jsp"%>
</head>
<body style="background-color: #ffffcc">
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="All_file/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center text-primary p-1">Sell Old VCD</h5>

						<c:if test="${not empty SucessMagssage }">
							<p class="text-center text-success">${SucessMagssage}</p>
							<c:remove var="SucessMagssage" scope="session" />
						</c:if>

						<c:if test="${not empty FailedMassage }">
							<p class="text-center text-danger">${FailedMassage}</p>
							<c:remove var="FailedMassage" scope="session" />
						</c:if>

						<form action="add_old_vcd" method="post"
							enctype="multipart/form-data">



							<input type="hidden" value="${userobj.email}" name="user">
							<div class="form-group">
								<label for="exampleInputEmail1">VCD Name</label> <input
									name="vname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describrdby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Actors Name</label> <input
									name="actors" type="text" class="form-control"
									id="exampleInputEmail1" aria-describrdby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputEmail1">
							</div>



							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									name="vimg" type="file" class="form-control-file"
									id="exampleFormControlFile1">
							</div>
							<button type="submit" class="btn btn-primary">Sell</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>