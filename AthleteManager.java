import java.util.Scanner;

public class AthleteManager {

    AthleteRepository repository = new AthleteRepository();

    public void addAthlete(Scanner scanner) {

        System.out.print("Enter athlete name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter sport: ");
        String sport = scanner.nextLine();

        Athlete athlete = new Athlete(name, age, sport);

        repository.addAthlete(athlete);
    }

    public void updateAthlete(Scanner scanner) {

        System.out.print("Enter athlete name to update: ");
        String oldName = scanner.nextLine();

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new age: ");
        int newAge = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new sport: ");
        String newSport = scanner.nextLine();

        Athlete athlete = new Athlete(newName, newAge, newSport);

        repository.updateAthlete(oldName, athlete);
    }

    public void deleteAthlete(Scanner scanner) {

        System.out.print("Enter athlete name to delete: ");
        String name = scanner.nextLine();

        repository.deleteAthlete(name);
    }
}