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
				<h1>Purchasing Page</h1>

				
				
				
				<form id="formItem" name="testForm" action="purchaseReport.jsp">
				Enter Buyer ID Here (Purchased Person ID): <input  name="testParam2"  type="text" class="form-control form-control-sm"> <br>
				

		           <input type="submit" id="btnSave3" name="btnSavePurchase" value="Purchase" class="btn btn-primary">
		        </form>
				
				
				
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemsGrid2">
					
					
					<%
					
					String val6 = request.getParameter("testParam2");
					
					buyer itemObj = new buyer();
					out.print(itemObj.purchaseProducts(val6));
					%>
					
				</div>
			</div>
		</div>
	</div>
	
<div align="right"><a href = "buyerAdmin.jsp"><input id="btn1" name="btnSave" type="button" value="Back" class="btn btn-primary"></a></div>
				

</body>
</html>