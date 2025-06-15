/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane; // Pastikan ini diimpor jika Anda menggunakannya di GUI

/**
 *
 * @author RIZKY KUSUMA (dan modifikasi untuk testability oleh Gemini)
 */
public class UserClass implements UserInterface {
    private String username;
    private String password; // Password tidak perlu disimpan sebagai field jika hanya untuk checkLogin
    private String role;     // Role ini akan diisi setelah login berhasil

    // Constructor untuk UserClass
    // Biasanya digunakan untuk menginisialisasi objek UserClass
    public UserClass(String username, String password, String role) {
        this.username = username;
        this.password = password; // Dalam praktik nyata, jangan simpan password di field seperti ini
        this.role = role;
    }
    
    // Constructor default jika diperlukan (tidak disarankan jika UserClass selalu butuh detail)
    public UserClass() {
        // Anda bisa menginisialisasi dengan nilai default atau membiarkannya kosong
    }

    public String getUsername() {
        return username;
    }

    // Metode ini akan mengembalikan role yang berhasil didapatkan setelah login
    public String getRole() {
        return role;
    }

    /**
     * Metode utama untuk memeriksa login, menerima objek Connection.
     * Metode ini cocok untuk pengujian unit karena Connection bisa di-mock.
     * @param conn Objek Connection untuk interaksi database.
     * @param username Nama pengguna untuk login.
     * @param password Kata sandi untuk login.
     * @return true jika login berhasil, false jika tidak.
     * @throws SQLException Jika terjadi kesalahan database.
     */
    public boolean checkLogin(Connection conn, String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    this.role = rs.getString("role"); // Simpan peran pengguna yang berhasil login
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * Metode overload untuk checkLogin, digunakan di lingkungan GUI.
     * Metode ini mendapatkan Connection dari ConnectionProvider secara otomatis
     * dan menangani SQLException dengan JOptionPane.
     * @param username Nama pengguna untuk login.
     * @param password Kata sandi untuk login.
     * @return true jika login berhasil, false jika tidak atau terjadi error database.
     */
    public boolean checkLogin(String username, String password) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            return checkLogin(conn, username, password); // Panggil metode utama
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metode utama untuk mendaftarkan pengguna baru, menerima objek Connection.
     * Metode ini cocok untuk pengujian unit karena Connection bisa di-mock.
     * @param conn Objek Connection untuk interaksi database.
     * @param username Nama pengguna baru.
     * @param password Kata sandi pengguna baru.
     * @param role Peran pengguna baru (misalnya "Admin", "Regular User").
     * @return true jika pendaftaran berhasil, false jika tidak.
     * @throws SQLException Jika terjadi kesalahan database.
     */
    public boolean registerUser(Connection conn, String username, String password, String role) throws SQLException {
        String sql = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Berhasil jika minimal 1 baris terpengaruh
        }
    }

    /**
     * Metode overload untuk registerUser, digunakan di lingkungan GUI.
     * Metode ini mendapatkan Connection dari ConnectionProvider secara otomatis
     * dan menangani SQLException dengan JOptionPane.
     * @param username Nama pengguna baru.
     * @param password Kata sandi pengguna baru.
     * @param role Peran pengguna baru.
     * @return true abjika pendaftaran berhasil, false jika tidak atau terjadi error database.
     */
    public boolean registerUser(String username, String password, String role) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            return registerUser(conn, username, password, role); // Panggil metode utama
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
}