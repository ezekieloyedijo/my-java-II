package com.easyconcept.session6;

import java.sql.*;

public class MySQLJDBCExample  {
    // Step 1: Get connection
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "yourpassword";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public static void insertUser(String name, String email) throws Exception {
        try (Connection conn = getConnection();
             // prepared statement good when you want to pass a parameter and security
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
                pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("User inserted successfully.");
        }
    }

    // Step 3: Read data
    public static void fetchUsers() throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name") + " - " + rs.getString("email"));
            }
        }
    }


}
