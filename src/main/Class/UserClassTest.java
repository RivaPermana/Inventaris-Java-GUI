// --- KODE UNTUK UserClassTest.java ---
package Class; // Sesuaikan dengan package UserClass Anda

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserClassTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private UserClass userClass; // Objek nyata dari UserClass

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this); // Menginisialisasi semua @Mock
        userClass = new UserClass("dummy", "dummy", "dummy"); // UserClass butuh constructor
    }

    @Test
    void testCheckLogin_Success() throws SQLException {
        // Atur perilaku mockResultSet: ada 1 baris, dan role adalah "Admin"
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("role")).thenReturn("Admin");

        // Atur perilaku mockPreparedStatement: saat executeQuery() dipanggil, kembalikan mockResultSet
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Atur perilaku mockConnection: saat prepareStatement() dipanggil, kembalikan mockPreparedStatement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Panggil metode yang diuji dengan mockConnection
        boolean result = userClass.checkLogin(mockConnection, "validUser", "validPass");

        assertTrue(result, "Login seharusnya berhasil untuk kredensial yang valid.");
        verify(mockPreparedStatement).setString(1, "validUser"); // Pastikan parameter di-set
        verify(mockPreparedStatement).setString(2, "validPass"); // Pastikan parameter di-set
        verify(mockPreparedStatement).executeQuery(); // Pastikan query dieksekusi
        verify(mockResultSet).getString("role"); // Pastikan role diambil
    }

    @Test
    void testCheckLogin_Failure_WrongCredentials() throws SQLException {
        // Atur perilaku mockResultSet: tidak ada hasil
        when(mockResultSet.next()).thenReturn(false);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        boolean result = userClass.checkLogin(mockConnection, "wrongUser", "wrongPass");

        assertFalse(result, "Login seharusnya gagal untuk kredensial yang salah.");
        verify(mockPreparedStatement).executeQuery();
        verify(mockResultSet, never()).getString(anyString()); // Role tidak perlu diambil
    }

    @Test
    void testCheckLogin_SQLException() throws SQLException {
        // Atur mockConnection untuk melempar SQLException saat prepareStatement
        when(mockConnection.prepareStatement(anyString())).thenThrow(new SQLException("Simulated DB Error during login"));

        // Verifikasi bahwa SQLException dilempar
        SQLException thrown = assertThrows(SQLException.class, () -> {
            userClass.checkLogin(mockConnection, "user", "pass");
        });
        assertEquals("Simulated DB Error during login", thrown.getMessage());
    }

    @Test
    void testRegisterUser_Success() throws SQLException {
        // Atur perilaku mockPreparedStatement: 1 baris terpengaruh (berhasil insert)
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        boolean result = userClass.registerUser(mockConnection, "newUser", "newPass", "User");

        assertTrue(result, "Registrasi seharusnya berhasil.");
        verify(mockPreparedStatement).setString(1, "newUser");
        verify(mockPreparedStatement).setString(2, "newPass");
        verify(mockPreparedStatement).setString(3, "User");
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void testRegisterUser_Failure_NoRowsAffected() throws SQLException {
        // Atur perilaku mockPreparedStatement: 0 baris terpengaruh (gagal insert)
        when(mockPreparedStatement.executeUpdate()).thenReturn(0);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        boolean result = userClass.registerUser(mockConnection, "existUser", "existPass", "User");

        assertFalse(result, "Registrasi seharusnya gagal jika 0 baris terpengaruh.");
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void testRegisterUser_SQLException() throws SQLException {
        // Atur mockConnection untuk melempar SQLException saat prepareStatement
        when(mockConnection.prepareStatement(anyString())).thenThrow(new SQLException("Simulated DB Error during registration"));

        SQLException thrown = assertThrows(SQLException.class, () -> {
            userClass.registerUser(mockConnection, "errorUser", "errorPass", "User");
        });
        assertEquals("Simulated DB Error during registration", thrown.getMessage());
    }
}