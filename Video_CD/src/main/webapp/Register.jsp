<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VCD Register</title>
<%@include file="All_file/AllCss.jsp"%>
</head>
<body style="background-color: #ffffcc;">
	<%@include file="All_file/navbar.jsp"%>
	<div class="Container">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Registration Page</h4>
						<c:if test="${not empty SucessMagssage}">
							<p class="text-center text-success">${SucessMagssage}</p>
							<c:remove var="SucessMagssage" scope="session"/>
						</c:if>
						<c:if test="${not empty FailedMassage }">
							<p class="text-center text-danger">${FailedMassage}</p>
							<c:remove var="FailedMassage" scope="session"/>
						</c:if>
						<form action="Register" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Phone Number</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phoneno">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input" name="check"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Agree term & Condition</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="All_file/footer.jsp"%>
</body>
</html>