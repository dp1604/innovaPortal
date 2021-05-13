<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.buyer"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Overall Buyer Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-1.9.1.min.js"></script>
<script src="Components/buyers.js"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Buyer Profile</h1>
				<form id="formItem" name="formItem">
					
					Name: <input id="name" name="name" type="text" class="form-control form-control-sm"> <br> 
					Description:<input id="descri" name="descri" type="text" class="form-control form-control-sm"> <br> 
					Address:<input id="address" name="address" type="text" class="form-control form-control-sm"> <br>
					Email:<input id="email" name="email" type="text" class="form-control form-control-sm"> <br>
					Password:<input id="pwd" name="pwd" type="text" class="form-control form-control-sm"> <br>
					Telephone:<input id="tp" name="tp" type="text" class="form-control form-control-sm"> <br>
					 
<!-- GENDER -->
 <div class="input-group input-group-sm mb-3">
 <div class="input-group-prepend">
 <span class="input-group-text" id="lblName">Gender: </span>
 </div>
 &nbsp;&nbsp;Male
<input type="radio" id="rdoGenderMale" name="gender" value="Male">
 &nbsp;&nbsp;Female
<input type="radio" id="rdoGenderFemale" name="gender" value="Female">
 </div>
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary"> <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemsGrid">
					<%
					buyer itemObj = new buyer();
					out.print(itemObj.readItems());
					%>
				</div>
			</div>
		</div>
	</div>
<div align="right"><a href = "buyerAdmin.jsp"><input id="btn1" name="btnSave" type="button" value="Back" class="btn btn-primary"></a></div>

</body>
</html>