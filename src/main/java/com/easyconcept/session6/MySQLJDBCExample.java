package com.easyconcept.session6;

import java.sql.*;

public class MySQLJDBCExample {

    // Step 1: Get connection
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb"; // Replace mydb with your DB name
        String user = "root"; // Replace with your DB username
        String password = "yourpassword"; // Replace with your DB password
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
        return DriverManager.getConnection(url, user, password);
    }

    // Step 2: Insert a subject
    public static void insertSubject(String name, int unit) {
        String sql = "INSERT INTO subjects (name, unit) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, unit);
            pstmt.executeUpdate();
            System.out.println("Subject inserted successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Please add it to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error inserting subject!");
            e.printStackTrace();
        }
    }

    // Step 3: Fetch all subjects
    public static void fetchSubjects() {
        String sql = "SELECT * FROM subjects";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " +
                        rs.getString("name") + " - " +
                        rs.getInt("unit") + " units");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error fetching subjects!");
            e.printStackTrace();
        }
    }

    // Step 4: Update a subject
    public static void updateSubject(int id, String name, int unit) {
        String sql = "UPDATE subjects SET name = ?, unit = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, unit);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Subject updated successfully.");
            } else {
                System.out.println("No subject found with ID: " + id);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error updating subject!");
            e.printStackTrace();
        }
    }

    // Step 5: Delete a subject
    public static void deleteSubject(int id) {
        String sql = "DELETE FROM subjects WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Subject deleted successfully.");
            } else {
                System.out.println("No subject found with ID: " + id);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error deleting subject!");
            e.printStackTrace();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        insertSubject("Mathematics", 3);
        insertSubject("Physics", 4);

        System.out.println("Subjects in DB:");
        fetchSubjects();

        updateSubject(1, "Advanced Mathematics", 5);
        deleteSubject(2);

        System.out.println("Subjects after update and delete:");
        fetchSubjects();
    }
}
