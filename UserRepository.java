import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {

    public void saveUser(User user) {

        String sql =
                "INSERT INTO users(username, password, role) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());

            stmt.executeUpdate();

            System.out.println("User registered!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(String username, String password) {

        String sql =
                "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}