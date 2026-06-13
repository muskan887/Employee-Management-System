package Employee.Management.System;

import java.sql.*;

public class conn {
    public Connection c;
    public Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ems",  // Make sure database name is "ems"
                    "root",
                    "root"                             // ✅ Replaced with correct password
            );
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // Show actual error if connection fails
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return s.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return s.executeUpdate(query);
    }

    public ResultSet executequrey(String s) {
        return null;
    }

}
