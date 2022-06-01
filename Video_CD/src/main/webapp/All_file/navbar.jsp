<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div class="container-fluid"
	style="height: 10px, backgroung-color:danger"></div>
<div class="container-fluid p-3">
	<div class="row">
		<div class="col-md-3 text-success">
			<h3>
				<i class="fa-solid fa-compact-disc"></i> VCD
			</h3>
		</div>
		<div class="col-md-6">
			<form class="form-inline my-2 my-lg-0" action="search.jsp" method="post">
				<input class="form-control mr-sm-2" type="search" name="ch"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>

		<c:if test="${not empty userobj}">
			<div class="col-md-3">
			<a href="checkout.jsp"><i class="fa-solid fa-cart-plus fa-2x"></i></a>
				<a href="login.jsp" class="btn btn-success">
				<i class="fa-solid fa-users"></i>${userobj.name}</a> 
				<a href="logout" class="btn btn-primary"> <i class="fa-solid fa-right-to-bracket"></i> Logout
				</a>
			</div>
		</c:if>

		<c:if test="${empty userobj}">
			<div class="col-md-3">
				<a href="login.jsp" class="btn btn-success"> <i
					class="fa-solid fa-right-to-bracket"></i> Login
				</a> <a href="Register.jsp" class="btn btn-primary"> <i
					class="fa-solid fa-users"></i> Register
				</a>
			</div>
		</c:if>

	</div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
	<a class="navbar-brand" href="#"><i class="fa-solid fa-house-user"></i></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">
					Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="all_recent_vcd.jsp"><i class="fa-solid fa-compact-disc"></i>
					Recent Video-CD</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="all_new_vcd.jsp"><i class="fa-solid fa-compact-disc"></i>
					New Video-CD</a></li>
			<li class="nav-item active"><a class="nav-link disabled"
				href="all_old_vcd.jsp"><i class="fa-solid fa-compact-disc"></i>
					Old Video-CD</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<a href="setting.jsp"class="btn btn-light my-2 my-sm-0" type="submit">
				<i class="fa-solid fa-gear"></i> Setting
			</a>
			<button class="btn btn-light my-2 my-sm-0 ml-1" type="submit">
				<i class="fa-solid fa-phone-volume"></i> Contact Us
			</button>
		</form>
	</div>
</nav>