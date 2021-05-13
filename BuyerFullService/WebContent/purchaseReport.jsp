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
				<h1>Purchased Report</h1>


				<br>
				<div id="divItemsGrid2">
					
					
					<%
					
					String val7 = "sold";
					
					buyer itemObj = new buyer();
					out.print(itemObj.viewBuyiedProductReport(val7));
					%>
					
				</div>
			</div>
		</div>
	</div>
	
<div align="right"><a href = "buyerAdmin.jsp"><input id="btn1" name="btnSave" type="button" value="Back" class="btn btn-primary"></a></div>
				

</body>
</html>