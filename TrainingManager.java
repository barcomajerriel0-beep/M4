import java.util.Scanner;

public class TrainingManager {

    private TrainingRepository repository =
            new TrainingRepository();

    public void scheduleSession(Scanner scanner) {

        System.out.print("Athlete Name: ");
        String athlete = scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Time: ");
        String time = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        TrainingSession session =
                new TrainingSession(
                        athlete,
                        date,
                        time,
                        location
                );

        repository.saveSession(session);

        System.out.println("Training session scheduled!");
    }

    public void recordPerformance(Scanner scanner) {

        System.out.print("Athlete Name: ");
        String athlete = scanner.nextLine();

        System.out.print("Performance result: ");
        String performance = scanner.nextLine();

        System.out.print("Attended? (true/false): ");
        boolean attended =
                Boolean.parseBoolean(scanner.nextLine());

        repository.updatePerformance(
                athlete,
                performance,
                attended
        );
    }

    public void monitorAttendance() {

        repository.showAttendance();
    }

    public void generateReport() {

        repository.generateReport();
    }
}