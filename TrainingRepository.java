import java.sql.*;

public class TrainingRepository {

    public void saveSession(TrainingSession session) {

        String sql =
                "INSERT INTO training_sessions " +
                "(athlete_name, date, time, location, performance, attended) " +
                "VALUES(?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, session.athleteName);
            stmt.setString(2, session.date);
            stmt.setString(3, session.time);
            stmt.setString(4, session.location);
            stmt.setString(5, session.performance);
            stmt.setBoolean(6, session.attended);

            stmt.executeUpdate();

            System.out.println("Training session saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePerformance(
            String athleteName,
            String performance,
            boolean attended
    ) {

        String sql =
                "UPDATE training_sessions " +
                "SET performance=?, attended=? " +
                "WHERE athlete_name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, performance);
            stmt.setBoolean(2, attended);
            stmt.setString(3, athleteName);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Performance updated!");
            } else {
                System.out.println("Session not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAttendance() {

        String sql =
                "SELECT athlete_name, attended FROM training_sessions";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        "Athlete: " +
                        rs.getString("athlete_name") +
                        " | Attended: " +
                        rs.getBoolean("attended")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateReport() {

        String sql = "SELECT * FROM training_sessions";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n===== TRAINING REPORT =====");

            while (rs.next()) {

                System.out.println(
                        "Athlete: " +
                        rs.getString("athlete_name") +
                        " | Date: " +
                        rs.getString("date") +
                        " | Performance: " +
                        rs.getString("performance") +
                        " | Attended: " +
                        rs.getBoolean("attended")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}