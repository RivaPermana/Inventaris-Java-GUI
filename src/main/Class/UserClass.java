/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RIZKY KUSUMA
 */
public class UserClass {
    
    public abstract class User implements UserInterface{
        public String username;
        public String role;
        
        public User(String username, String role) {
            this.username = username;
            this.role = role;
        }
        
        public void login() {
            System.out.println("User " + username + " is logging in.");
        }
        
        public boolean checkLogin(String username, String password) {
            
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(query)) {
               pstmt.setString(1, username);
               pstmt.setString(2, password);
               ResultSet rs = pstmt.executeQuery();
               return rs.next();
           } catch (SQLException e) {
               e.printStackTrace();
               return false;
           }
        }
    }

    public class AdminUser extends User {

        public AdminUser(String username, String role) {
            super(username, role);
        }

        @Override
        public void login() {
            System.out.println("Admin user " + username + " is logging in with admin privileges.");
        }
        
        
    }

    public class RegularUser extends User {

        public RegularUser(String username, String role) {
            super(username, role);
        }

        @Override
        public void login() {
            System.out.println("Regular user " + username + " is logging in.");
        }
    }
    
    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String USER = "root";
    private static final String PASS = "Qa04091518";
    
}
