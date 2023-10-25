package fr.gameblack.rcuhcv2.database;

import java.sql.SQLException;

public class DatabaseManager {

	@SuppressWarnings("unused")
	private DbConnection dbConnection;
	
	private DbConnection gradeConnection;
	
	public DatabaseManager() {
		
		this.gradeConnection = new DbConnection(new DbCredentials("mysql2.ouiheberg.com", "u3378_UULUfxdtew", "A6.PbnQe9REg0RgynoW+YD!v", "s3378_PVPTeam", 3306));
		
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
