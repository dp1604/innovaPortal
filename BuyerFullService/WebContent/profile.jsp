<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.buyer"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-1.9.1.min.js"></script>
<script src="Components/buyers.js"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Buyer Profile</h1>

				
				
				
				<form id="formItem" name="testForm" action="profile.jsp">
				Enter Buyer ID Here: <input  name="testParam" type="text" class="form-control form-control-sm"> <br>
				

		           <input type="submit" id="btnSave2" name="btnSaveProf" value="Search" class="btn btn-primary">
		        </form>
				
				
				
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemsGrid2">
					
					
					<%
					
					String val3 = request.getParameter("testParam");
					
					buyer itemObj = new buyer();
					out.print(itemObj.viewBuyerProfile(val3));
					%>
					
				</div>
			</div>
		</div>
	</div>
	
	
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
					
				</form>
		
				<br>
				
<div align="right"><a href = "buyerAdmin.jsp"><input id="btn1" name="btnSave" type="button" value="Back" class="btn btn-primary"></a></div>
</body>
</html>