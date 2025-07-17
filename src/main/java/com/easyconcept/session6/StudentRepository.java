package com.easyconcept.session6;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

// create an interface for the repository first

public class StudentRepository {
    public Optional<Student> save(Student student) {
        // SQL Insert statement
        String sql = "INSERT INTO student (id, name, age, gender, password) VALUES (?, ?, ?, ?, ?)";
        try (
                // do not have to manually close connection
                // 2. Connect to database
                Connection conn = getConnection();

                // 3. Create PreparedStatement
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 4. Set parameters
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getGender().name());
            pstmt.setString(5, student.getPassword());

            // 5. Execute insert
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Student record inserted successfully!");
            } else {
                System.out.println("⚠️ Failed to insert student record.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
            return Optional.empty();
        }
        return Optional.ofNullable(student);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                ) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender"))
                );
                students.add(student);

            }
            return students;

        } catch (SQLException e) {
            System.out.println("❌ Error fetching students: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Optional<Student> findById(String id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

                ){
            pstmt.setString(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                Student student = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender"))
                );
                return Optional.of(student);
            }

        } catch(SQLException e) {
            System.out.println("❌ Error fetching student: " + e.getMessage());
        }
        return Optional.empty();
    }

    public boolean update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ?, gender = ?, password = ? WHERE id = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getGender().name());
            pstmt.setString(4, student.getPassword());
            pstmt.setString(5, student.getId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error updating student: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteById(String id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error deleting student: " + e.getMessage());
        }
        return false;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                StudentDBConfig.getInstance().getUrl(),
                StudentDBConfig.getInstance().getUsername(),
                StudentDBConfig.getInstance().getPassword()
        );
    }
}
