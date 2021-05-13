/**
 * 
 */

$(document).ready(function()
{ 
	if ($("#alertSuccess").text().trim() == "") 
 	{ 
 	$("#alertSuccess").hide(); 
 	} 
 	$("#alertError").hide(); 
});

 // SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
	// Clear alerts---------------------
 	$("#alertSuccess").text(""); 
 	$("#alertSuccess").hide(); 
 	$("#alertError").text(""); 
 	$("#alertError").hide(); 
	// Form validation-------------------
	var status = validateItemForm(); 
	if (status != true) 
 	{ 
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
 		return;
	} 
	

	 
	// If valid------------------------
 		var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
 		 $('input[name="gender"]:checked').val(), 

 		$.ajax( 
 	{ 
 		url : "BuyerAPI", 
	 	type : type, 
 		data : $("#formItem").serialize(),
 		dataType : "text", 
 		complete : function(response, status) 
 	{ 
 			onItemSaveComplete(response.responseText, status); 
 	} 
 	});
});





// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 	$("#hidItemIDSave").val($(this).data("bid")); 
 	$("#name").val($(this).closest("tr").find('td:eq(0)').text()); 
	$("#descri").val($(this).closest("tr").find('td:eq(1)').text()); 
 	$("#address").val($(this).closest("tr").find('td:eq(2)').text()); 
 	$("#email").val($(this).closest("tr").find('td:eq(3)').text()); 
 	$("#pwd").val($(this).closest("tr").find('td:eq(4)').text());
 	$("#tp").val($(this).closest("tr").find('td:eq(5)').text());
    $("INPUT[name=gender]").val([$(this).closest("tr").find('td:eq(6)').text()]);
 

});





// DELETE=====================================================
$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "BuyerAPI", 
 type : "DELETE", 
 data : "bid=" + $(this).data("bid"), 
 dataType : "text", 
 complete : function(response, status) 
 { 
	 onItemDeleteComplete(response.responseText, status); 
 } 
 }); 
});




// CLIENT-MODEL================================================================
function validateItemForm() 
{ 
	// CODE
	if ($("#name").val().trim() == "") 
 	{ 
 		return "Insert Name."; 
 	} 
	// NAME
	if ($("#descri").val().trim() == "") 
 	{ 
 		return "Insert Description."; 
 	}
 	// PRICE-------------------------------
	if ($("#address").val().trim() == "") 
 	{ 
 		return "Insert Address."; 
 	} 
	
	// E-mail-------------------------------
	if ($("#email").val().trim() == "") 
 	{ 
 		return "Insert E-mail."; 
 	}
	
	// Password-------------------------------
	if ($("#pwd").val().trim() == "") 
 	{ 
 		return "Insert Password."; 
 	}
	
	// TP-------------------------------
	if ($("#tp").val().trim() == "") 
 	{ 
 		return "Insert Telephone Number."; 
 	}
	

	return true; 
}

// Function on items==========
function onItemSaveComplete(response, status)
{ 
	if (status == "success") 
 	{ 
 		var resultSet = JSON.parse(response); 
 		if (resultSet.status.trim() == "success") 
 		{ 
 			$("#alertSuccess").text("Inserted successfully."); 
 			$("#alertSuccess").show(); 
 			$("#divItemsGrid").html(resultSet.data); 
 		} else if (resultSet.status.trim() == "error") 
 		{ 
 			$("#alertError").text(resultSet.data); 
 			$("#alertError").show(); 
 		} 
 	}else if (status == "error") 
 	{ 
 			$("#alertError").text("Error while inserting the Buyer Details."); 
 			$("#alertError").show(); 
 		} else
 		{ 
 			$("#alertError").text("Unknown error while saving.."); 
 			$("#alertError").show(); 
 		}
 		
 		
 		$("#hidItemIDSave").val(""); 
 		$("#formItem")[0].reset(); 
}


// function items Delete====================

function onItemDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
	 var resultSet = JSON.parse(response); 
	 if (resultSet.status.trim() == "success") 
	 { 
			 $("#alertSuccess").text("Buyer Details Deleted successfully."); 
			 $("#alertSuccess").show(); 
			 $("#divItemsGrid").html(resultSet.data); 
	 }
	 else if (resultSet.status.trim() == "error") 
	 { 
			 $("#alertError").text(resultSet.data); 
			 $("#alertError").show(); 
	 } 
	 } 
	 else if (status == "error") 
	 { 
		 $("#alertError").text("Error while deleting the Buyer details."); 
		 $("#alertError").show(); 
	 } else
	 { 
		 $("#alertError").text("Unknown error while deleting."); 
		 $("#alertError").show(); 
	 } 
}






