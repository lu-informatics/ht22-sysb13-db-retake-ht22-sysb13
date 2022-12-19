package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessLayer {

	
	private String connectionURL;

	public DataAccessLayer()  {

		try {
			String databaseServerName = System.getenv("MARVIX_SERVER_NAME");
			String databaseServerPort = System.getenv("MARVIX_SERVER_PORT");
			String databaseName = System.getenv("MARVIX_NAME");
			String databaseUserName = System.getenv("MARVIX_USER_NAME");
			String databaseUserPassword = System.getenv("MARVIX_USER_PASSWORD");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connectionURL = "jdbc:sqlserver://" + databaseServerName + ":" + databaseServerPort + ";" + "database="
					+ databaseName + ";" + "user=" + databaseUserName + ";" + "password=" + databaseUserPassword + ";"
					+ "encrypt=true;" + "trustServerCertificate=true";
		} catch (Exception e) {

		}
		
		/* 
    -Create a Java Connection to the MySQL database
   - Define the SELECT statement
   - Execute the SELECT query, getting a Java ResultSet from that query
   - Iterate over the ResultSet, getting the database fields (columns) from each row of data that is returned
   - Close the Java database connection
   - Catch any SQL exceptions that may come up during the process

		 */
		
		
		
	}

	//Orders
	
	//Create order
	public void CreateOrder(int OrderID, int OrderDate, int CustomerID, int ProductID)
			throws SQLException {
					
					String query = "INSERT INTO PRODUCT VALUES (?,?,?, ?) SET NOCOUNT ON";
					Connection connection = DriverManager.getConnection(connectionURL);
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setInt(1, OrderID);
					ps.setInt(2, OrderDate);
					ps.setInt(3,  CustomerID);
					ps.setInt(4, ProductID);
					ps.executeUpdate();
				
			

			}
	//Viewing all orders 
	
	public ResultSet viewAllOrders (int orderID) throws SQLException{
		
		String query = "SELECT * FROM ORDERS WHERE orderID = ?";
		Connection connection = DriverManager.getConnection(connectionURL);
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setInt(1, orderID);
		pS.executeUpdate();
		ResultSet rS = pS.executeQuery();
		
		rS.close();
		pS.close();
		connection.close();
		
		return rS;
	}
	
	
	//Customer
	
	//Creating customer
	public void CreateCustomer(int CustomerID, String Name, String Address, String LoyaltyLevel)
			throws SQLException {
					
					String query = "INSERT INTO PRODUCT VALUES (?,?,?,?) SET NOCOUNT ON";
					Connection connection = DriverManager.getConnection(connectionURL);
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setInt(1, CustomerID);
					ps.setString(2, Name);
					ps.setString(3, Address);
					ps.setString(4,  LoyaltyLevel);
					 ps.executeUpdate();
				
				
			}
	
	//Finding customer by customer ID
public ResultSet findCustomerByCustomerId( int customerID) throws SQLException{
		
		String query = "SELECT * FROM CUSTOMER WHERE customerID = ?";
		Connection connection = DriverManager.getConnection(connectionURL);
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setInt(1, customerID);
		pS.executeUpdate();
		ResultSet rS = pS.executeQuery();
		
		rS.close();
		pS.close();
		connection.close();
		
		return rS;		
}

//Finding all orders for a certain customer

public ResultSet findOrdersForCertainCustomer( int customerID) throws SQLException{	
	
	String query = "SELECT c.CustomerID, o.OrderID, o.OrderDate"
			+ " FROM CUSTOMER c "
			+ "JOIN ORDERS o"
			+ "ON c.CustomerID = o.CustomerID"
			+ "WHERE c.CustomerID = ?";
	Connection connection = DriverManager.getConnection(connectionURL);
	PreparedStatement pS = connection.prepareStatement(query);
	pS.setInt(1, customerID);
	pS.executeUpdate();
	ResultSet rS = pS.executeQuery();
	
	rS.close();
	pS.close();
	connection.close();
	
	return rS;		
}



//finding the latest order for a certain customer


//Product

// Creating Products
public void createProduct(int ProductID, String ProductName, int Price)
throws SQLException {
		String query = "INSERT INTO PRODUCT VALUES (?,?,?) SET NOCOUNT ON";
		Connection connection = DriverManager.getConnection(connectionURL);
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, ProductID);
		ps.setString(2, ProductName);
		ps.setInt(3,  Price);
		ps.executeUpdate();
	
}

				
		

//Finding a product by productID
public ResultSet findProductByProductId( int productID) throws SQLException{
	
	String query = "SELECT * FROM PRODUCT WHERE ProductID = ?";
	Connection connection = DriverManager.getConnection(connectionURL);
	PreparedStatement pS = connection.prepareStatement(query);
	pS.setInt(1, productID);
	pS.executeUpdate();
	ResultSet rS = pS.executeQuery();
	
	rS.close();
	pS.close();
	connection.close();
	
	return rS;		
}


}


//COMBOBOXES

// 
