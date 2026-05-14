import java.sql.Connection;
import java.sql.PreparedStatement;

public class AthleteRepository {

    public void addAthlete(Athlete athlete) {

        String sql =
                "INSERT INTO athletes(name, age, sport) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, athlete.getName());
            stmt.setInt(2, athlete.getAge());
            stmt.setString(3, athlete.getSport());

            stmt.executeUpdate();

            System.out.println("Athlete added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAthlete(String oldName, Athlete athlete) {

        String sql =
                "UPDATE athletes SET name=?, age=?, sport=? WHERE name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, athlete.getName());
            stmt.setInt(2, athlete.getAge());
            stmt.setString(3, athlete.getSport());
            stmt.setString(4, oldName);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Athlete updated!");
            } else {
                System.out.println("Athlete not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAthlete(String name) {

        String sql = "DELETE FROM athletes WHERE name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);

            stmt.executeUpdate();

            System.out.println("Athlete deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}