package org.example.javafxdb_sql_shellcode.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SecondaryController {

    private static final String DB_URL = "jdbc:sqlserver://<your_server_name>.database.windows.net:1433;database=<your_database_name>";
    private static final String USERNAME = "<your_username>";
    private static final String PASSWORD = "<your_password>";

    // Method to update user details in the database
    public void updateUser(int id, String name, String email, String phone, String address, String password) {
        String sql = "UPDATE users SET name = ?, email = ?, phone = ?, address = ?, password = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            // Set parameters for the SQL update query
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, password);
            preparedStatement.setInt(6, id);

            // Execute update and check if it was successful
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Error updating user with ID: " + id);
            e.printStackTrace();
        }
    }
}
