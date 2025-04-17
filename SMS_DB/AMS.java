package myproject.tijada_oop.SMS_DB;

import java.sql.*;
import javax.swing.*;
import java.security.*;
import java.util.Base64;

public class AMS {
    public boolean SignUp(String username, String password) {
        // Hash the password before storing it
        String hashedPassword = hashPassword(password);

        if (UsernameExist(username)) {
            JOptionPane.showMessageDialog(null, "Account with the username already exists!");
            return false; // Exit if username exists
        }

        try (Connection connect = Connect_DB.connect()) {
            String query = "INSERT INTO student_accounts (username, password) VALUES (?, ?)";

            try (PreparedStatement pstmt = connect.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, hashedPassword);

                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Account created successfully!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add the account");
                }
            } catch (SQLException e) {
                System.out.println("Error inserting account: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return false;
    }

    private boolean verifyAcc(String user, String pass) {
        String query = "SELECT password FROM student_accounts WHERE username = ?";
        boolean isAuthenticated = false;

        try (Connection connect = Connect_DB.connect();
             PreparedStatement stmt = connect.prepareStatement(query)) {

            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");

                // Hash the entered password and compare with the stored hash
                if (verifyPassword(pass, storedHashedPassword)) {
                    isAuthenticated = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    // Checks if username exists
    private boolean UsernameExist(String username) {
        String query = "SELECT COUNT(*) FROM student_accounts WHERE username = ?";
        boolean exists = false;

        try (Connection connect = Connect_DB.connect();
             PreparedStatement pstmt = connect.prepareStatement(query)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                exists = true; // If count > 0, then username exists
            }
        } catch (SQLException e) {
            System.out.println("Error checking username existence: " + e.getMessage());
        }
        return exists;
    }

    // Hash the password using SHA-256
    private String hashPassword(String password) {
        try {
            // Generate a random key (randKey)
            byte[] randKey = new byte[16];
            SecureRandom sr = new SecureRandom();
            sr.nextBytes(randKey);

            // Combine the password with the randKey
            String passwordWithRandKey = password + Base64.getEncoder().encodeToString(randKey);

            // Get the MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the hash function to the password and randKey, then get the byte array
            byte[] hashedBytes = digest.digest(passwordWithRandKey.getBytes());

            // Convert the byte array into a hex string and return it
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b)); // Convert each byte to its hexadecimal representation
            }

            // Include the randKey with the hash (to store it in the DB)
            return hexString.toString() + ":" + Base64.getEncoder().encodeToString(randKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    // Verifies the password entered by the user against the stored hashed password
    private boolean verifyPassword(String enteredPassword, String hashedPass) {
        try {
            // Split the stored value into hash and randKey
            String[] parts = hashedPass.split(":");
            if (parts.length != 2) {
                return false;
            }

            String storedHashedPassword = parts[0];
            byte[] storedRandKey = Base64.getDecoder().decode(parts[1]);

            // Combine the entered password with the stored randKey
            String enteredPasswordWithRandKey = enteredPassword + Base64.getEncoder().encodeToString(storedRandKey);

            // Hash the entered password with randKey
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(enteredPasswordWithRandKey.getBytes());

            // Convert the byte array into a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Compare the entered hashed password with the stored one
            return storedHashedPassword.equals(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error verifying password", e);
        }
    }

    // LogIn method
   public boolean LogIn(String username, String password) {
        try (Connection connect = Connect_DB.connect()) {
            // Verifying user credentials
            if (verifyAcc(username, password)) {
                JOptionPane.showMessageDialog(null, "Logged in successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Try again.");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage());
            return false;
        }
    }
}