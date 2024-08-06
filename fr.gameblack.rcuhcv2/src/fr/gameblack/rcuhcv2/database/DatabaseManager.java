package fr.gameblack.rcuhcv2.database;

import java.sql.SQLException;

public class DatabaseManager {

	@SuppressWarnings("unused")
	private DbConnection dbConnection;
	
	private DbConnection gradeConnection;
	
	public DatabaseManager() {
		
		this.gradeConnection = new DbConnection(new DbCredentials("mysql2.ouiheberg.com", "u3377_qloEkUwDHj", "S!20+zL@fS9.ye81CnUZauP@", "s3377_rubiscraft", 3306));
		
	}
	
	public DbConnection getGradeConnection() {
		
		return gradeConnection;
		
	}
	
	public void close() {
		
		try {
			
			this.gradeConnection.close();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
