import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserManager userManager =
                new UserManager();

        AthleteManager athleteManager =
                new AthleteManager();

        TrainingManager trainingManager =
                new TrainingManager();

        PaymentManager paymentManager =
                new PaymentManager();

        System.out.println("=================================");
        System.out.println(" SPORTS TRAINING ACADEMY SYSTEM ");
        System.out.println("=================================");

        while (true) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    userManager.registerUser(scanner);
                    break;

                case 2:

                    User user =
                            userManager.loginUser(scanner);

                    if (user != null) {

                        userMenu(
                                scanner,
                                user,
                                athleteManager,
                                trainingManager,
                                paymentManager
                        );
                    }

                    break;

                case 3:

                    System.out.println("Goodbye!");
                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }
        }
    }

    public static void userMenu(
            Scanner scanner,
            User user,
            AthleteManager athleteManager,
            TrainingManager trainingManager,
            PaymentManager paymentManager
    ) {

        while (true) {

            System.out.println("\n===== USER MENU =====");

            System.out.println(
                    "Logged in as: " +
                    user.getUsername()
            );

            System.out.println(
                    "Role: " +
                    user.getRole()
            );

            System.out.println("1. Add Athlete");
            System.out.println("2. Update Athlete");
            System.out.println("3. Delete Athlete");
            System.out.println("4. Schedule Training");
            System.out.println("5. Record Performance");
            System.out.println("6. Monitor Attendance");
            System.out.println("7. Generate Report");
            System.out.println("8. Process Payment");
            System.out.println("9. Logout");

            System.out.print("Choose option: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    if (user.getRole().equalsIgnoreCase(
                            "Administrator"
                    )) {

                        athleteManager.addAthlete(scanner);

                    } else {

                        System.out.println(
                                "Permission denied!"
                        );
                    }

                    break;

                case 2:

                    if (user.getRole().equalsIgnoreCase(
                            "Administrator"
                    )) {

                        athleteManager.updateAthlete(scanner);

                    } else {

                        System.out.println(
                                "Permission denied!"
                        );
                    }

                    break;

                case 3:

                    if (user.getRole().equalsIgnoreCase(
                            "Administrator"
                    )) {

                        athleteManager.deleteAthlete(scanner);

                    } else {

                        System.out.println(
                                "Permission denied!"
                        );
                    }

                    break;

                case 4:

                    trainingManager.scheduleSession(scanner);
                    break;

                case 5:

                    trainingManager.recordPerformance(scanner);
                    break;

                case 6:

                    trainingManager.monitorAttendance();
                    break;

                case 7:

                    trainingManager.generateReport();
                    break;

                case 8:

                    paymentManager.processPayment(scanner);
                    break;

                case 9:

                    return;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }
        }
    }
}
