package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.buyer;

/**
 * Servlet implementation class BuyerAPI
 */
@WebServlet("/BuyerAPI")
public class BuyerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	buyer itemObj = new buyer(); 
    public BuyerAPI() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = itemObj.insertItem(
				request.getParameter("bid"), 
				request.getParameter("name"),
				request.getParameter("descri"), 
				request.getParameter("address"), 
				request.getParameter("email"),
				request.getParameter("pwd"),
				request.getParameter("tp"),
				request.getParameter("gender"));
				
				response.getWriter().write(output);
				
				String pro = itemObj.viewBuyerProfile(
						request.getParameter("bid"));
						
						response.getWriter().write(pro);
						
				String odr = itemObj.purchaseProducts(
						request.getParameter("bid"));
								
						response.getWriter().write(odr);
				
						
				String sld = itemObj.purchaseProducts(
						request.getParameter("status"));
										
						response.getWriter().write(sld);
		
	}
	
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 {
		 String[] p = param.split("=");
		 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map; 
	}
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map parse = getParasMap(request); 
		 String output = itemObj.updateItem(parse.get("hidItemIDSave").toString(), 
		 parse.get("name").toString(), 
		 parse.get("descri").toString(), 
		 parse.get("address").toString(), 
		 parse.get("email").toString(),
		 parse.get("pwd").toString(),
		 parse.get("tp").toString(),
		 parse.get("gender").toString());

		response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map parse = getParasMap(request); 
		 String output = itemObj.deleteItem(parse.get("bid").toString()); 
		response.getWriter().write(output); 
	}

}
