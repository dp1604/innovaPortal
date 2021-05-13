package model;

import java.sql.*;

import com.mysql.cj.ParseInfo;

public class buyer {
	
	public static void main(String[] args) {
		buyer itemconn = new buyer();
		
	}

	//A common method to connect to the DB
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/group_04?useTimezone=true&serverTimezone=UTC", "root", ""); 
	 } 

	 catch (Exception e) 
	 {
		 e.printStackTrace();
	 } 
	 	return con; 
	 } 
	//inserting data
	public String insertItem(String bid,String name1, String descri1,String address1,String email1,String pwd1,String tp1,String gender1) 
	 { 
	 String output = ""; 
	 try
	 { 
		 Connection con = connect(); 
	 if (con == null) 
	 {
		 return "Error while connecting to the database for inserting.";
	 } 
	 
	 // create a prepared statement
	 String query = " insert into buyer(`bid`,`name`,`descri`,`address`,`email`,`pwd`,`tp`,`gender`)"+ " values (?, ?, ?, ?, ?, ?, ?,?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, name1); 
	 preparedStmt.setString(3, descri1);
	 preparedStmt.setString(4, address1); 
	 preparedStmt.setString(5, email1); 
	 preparedStmt.setString(6, pwd1); 
	 preparedStmt.setString(7, tp1);
	 preparedStmt.setString(8, gender1);
	 
	 
	// execute the statement
	 
	 preparedStmt.execute(); 
	 con.close(); 
	 
		String newItems = readItems(); 
		output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}"; 
	 
	 } 
	 catch (Exception e) 
	 { 

		 output = "{\"status\":\"error\", \"data\": \"Error while inserting the Buyer Details.\"}"; 
		 System.err.println(e.getMessage());
	 } 
	 	return output; 
	 } 
	//reading data
	public String readItems() 
	 { 
		 String output = ""; 
		 try
		 { 
			 Connection con = connect(); 
		 if (con == null) 
		 {
			 return "Error while connecting to the database for reading."; 
		 } 
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>Buyer Name</th><th>Description</th><th>Address</th><th>E-mail</th><th>Password</th><th>Telephone</th><th>Gender</th>" +
		 "<th>Update</th><th>Remove</th></tr>"; 
		 
		 String query = "select * from buyer"; 
		 Statement stmt = con.createStatement(); 
		 ResultSet rs = stmt.executeQuery(query); 
		 // iterate through the rows in the result set
		 while (rs.next()) 
		 { 
			 String bid1 = Integer.toString(rs.getInt("bid")); 
			 String name1 = rs.getString("name"); 
			 String descri1 = rs.getString("descri");
			 String address1 = rs.getString("address"); 
			 String email1 = rs.getString("email"); 
			 String pwd1 = rs.getString("pwd"); 
			 String tp1 = rs.getString("tp"); 
			 String gender1 = rs.getString("gender"); 
			 
			 // Add into the html table
			 output += "<tr><td>" + name1 + "</td>"; 
			 output += "<td>" + descri1 + "</td>";
			 output += "<td>" + address1 + "</td>";
			 output += "<td>" + email1 + "</td>";
			 output += "<td>" + pwd1 + "</td>";
			 output += "<td>" + tp1 + "</td>";
			 output += "<td>" + gender1 + "</td>";
			 
			 // buttons 
				output += "<td><input name='btnUpdate' "
						+ " type='button' value='Update' class='btnUpdate btn btn-secondary' data-bid='" + bid1 + "'></td>"
						+ "<td>"
						+ "<input name='btnRemove' "
						+ " type='button' value='Remove' class='btnRemove btn btn-danger' data-bid='" + bid1 + "'>"
						+ "</td></tr>";
						 
		 } 
			 con.close(); 
			 // Complete the html table
			 output += "</table>"; 
		 } 
		 catch (Exception e) 
		 { 
			 output = "Error while reading the Buyer Details."; 
			 System.err.println(e.getMessage()); 
		 } 
		 return output; 
	 } 
	//updating data
	public String updateItem(String bid1, String name1, String descri1, String address1, String email1, String pwd1, String tp1, String gender1)
	{ 
		 String output = ""; 
		 try
		 { 
			 Connection con = connect(); 
		 if (con == null) 
		 {
			 return "Error while connecting to the database for updating."; 
		 } 
		 
		 // create a prepared statement
		 String query = "UPDATE buyer SET name=?,descri=?,address=?,email=?,pwd=?,tp=?,gender=? WHERE bid=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		 // binding values
		 preparedStmt.setString(1, name1); 
		 preparedStmt.setString(2, descri1);
		 preparedStmt.setString(3, address1); 
		 preparedStmt.setString(4, email1); 
		 preparedStmt.setString(5, pwd1); 
		 preparedStmt.setString(6, tp1); 
		 preparedStmt.setString(7, gender1); 
		 preparedStmt.setInt(8, Integer.parseInt(bid1)); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close();
		 
		 String newItems = readItems(); 
		 output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}"; 
		 //output = "Updated successfully"; 
		 } 
		 catch (Exception e) 
		 { 
				output = "{\"status\":\"error\", \"data\": \"Error while Updating the Buyer Details.\"}";
				System.err.println(e.getMessage());
		 } 
		 	return output; 
		 } 
	//deleting data
		public String deleteItem(String bid1) 
		 { 
			 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for deleting."; 
				 } 
				 // create a prepared statement
				 String query = "delete from buyer where bid=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(bid1)); 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 //output = "";
				 String newItems = readItems(); 
				 output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}"; 
			 } 
			 catch (Exception e) 
			 {  
				 output = "{\"status\":\"error\", \"data\": \"Error while deleting the Buyer details.\"}"; 
				 System.err.println(e.getMessage());
			 } 
			 	return output; 
		 }
		public String viewBuyerProfile(String buyerId) {
			// TODO Auto-generated method stub
			String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for reading."; 
			 } 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Buyer Name</th><th>Description</th><th>Address</th><th>E-mail</th><th>Password</th><th>Telephone</th><th>Gender</th>" +
			 "<th>Clear View</th></tr>"; 
			 
			 String query = "select * from buyer where bid=?"; 
			 
			 PreparedStatement stmt = con.prepareStatement(query);

			 stmt.setInt(1,Integer.parseInt(buyerId));
			 ResultSet rs = stmt.executeQuery();
			 
			 
	
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 String bid = Integer.toString(rs.getInt("bid")); 
				 String name = rs.getString("name"); 
				 String descri = rs.getString("descri");
				 String address = rs.getString("address"); 
				 String email = rs.getString("email"); 
				 String pwd = rs.getString("pwd"); 
				 String tp = rs.getString("tp"); 
				 String gender = rs.getString("gender"); 
				 // Add into the html table
				 output += "<tr><td>" + name + "</td>"; 
				 output += "<td>" + descri + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + email + "</td>";
				 output += "<td>" + pwd + "</td>";
				 output += "<td>" + tp + "</td>";
				 output += "<td>" + gender + "</td>";
				 
				 // buttons --change here
				 output += "<td><input name='btnUpdatePro' "
							+ " type='button' value='View' class='btnUpdate btn btn-secondary' data-bid='" + bid + "'></td>"
							+ "<td></tr>"; 
			 } 
				 con.close(); 
				 // Complete the html table
				 output += "</table>"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "No any data for reading."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output;
		}
		public String purchaseProducts(String buyerId) {
			// TODO Auto-generated method stub
			 String status1="sold";
			 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for updating."; 
			 } 
			 
			 // create a prepared statement
			 String query = "UPDATE buyerproduct SET status=? WHERE bid=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setString(1, status1); 
			 preparedStmt.setInt(2, Integer.parseInt(buyerId)); 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Updated successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = ""; 
				 System.err.println(e.getMessage()); 
			 } 
			 	return output; 
			 
		}
		public String viewBuyiedProductReport(String status1) {
			// TODO Auto-generated method stub

			String output = "";
			//String state = "sold"; 
			 try
			 { 
				 Connection con = connect(); 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for reading."; 
			 } 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Resercher ID</th><th>Product Name</th><th>Price</th><th>Description</th>" +
			 "</tr>"; 
			 
			 String query = "select * from product RIGHT JOIN buyerproduct ON product.proCode = buyerproduct.proCode having buyerproduct.status =?";
			 
			 PreparedStatement stmt = con.prepareStatement(query);

			 stmt.setString(1,status1);
			 ResultSet rs = stmt.executeQuery();
			 
			 
	
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 String proCode = Integer.toString(rs.getInt("proCode")); 
				 String rid = rs.getString("rid"); 
				 String pname = rs.getString("pname");
				 String price = rs.getString("price"); 
				 String descri = rs.getString("descri"); 
				 
				 // Add into the html table
				 output += "<tr><td>" + rid + "</td>"; 
				 output += "<td>" + pname + "</td>";
				 output += "<td>" + price + "</td>";
				 output += "<td>" + descri + "</td>";
				 
				 // buttons
				  
			 } 
				 con.close(); 
				 // Complete the html table
				 output += "</table>"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while reading the Sold Product Details."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output;
		}
	
	
}
