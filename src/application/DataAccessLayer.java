package application;

import java.io.IOException;

public class DataAccessLayer {

	
	
	private String connectionURL;

	public DataAccessLayer() throws IOException {

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
	}

}
