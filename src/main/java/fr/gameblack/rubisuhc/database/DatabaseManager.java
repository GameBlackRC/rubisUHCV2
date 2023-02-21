package fr.gameblack.rubisuhc.database;

import java.sql.SQLException;

public class DatabaseManager {

    @SuppressWarnings("unused")
    private DbConnection dbConnection;

    private DbConnection gradeConnection;

    public DatabaseManager() {

        this.gradeConnection = new DbConnection(new DbCredentials("45.140.165.82", "u20579_Hn8vM4482g", "V=@1o@VZU4GVt8rTC!XNHVWm", "s20579_rubisbot", 3306));

    }

    public DbConnection getGradeConnection() {

        return gradeConnection;

    }

    public void close() {

        try {

            this.gradeConnection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
