import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PaymentManager {

    public void processPayment(Scanner scanner) {

        System.out.println("\n===== PAYMENT MENU =====");
        System.out.println("1. Cash");
        System.out.println("2. GCash");

        System.out.print("Choose payment method: ");

        int choice =
                Integer.parseInt(scanner.nextLine());

        System.out.print("Enter amount: ");

        double subtotal =
                Double.parseDouble(scanner.nextLine());

        PaymentFramework payment = null;

        String paymentMethod = "";

        switch (choice) {

            case 1:

                payment = new CashPayment();
                paymentMethod = "Cash";
                break;

            case 2:

                payment = new GCashPayment();
                paymentMethod = "GCash";
                break;

            default:

                System.out.println(
                        "Invalid payment method!"
                );

                return;
        }

        if (!payment.validatePayment(subtotal)) {

            System.out.println("Invalid payment!");
            return;
        }

        double discount =
                payment.applyDiscount(subtotal);

        double afterDiscount =
                subtotal - discount;

        double tax =
                payment.applyTax(afterDiscount);

        double total =
                afterDiscount + tax;

        boolean charged =
                payment.chargePayment(total);

        if (!charged) {

            System.out.println("Payment failed!");
            return;
        }

        payment.finalizeTransaction(
                subtotal,
                discount,
                tax,
                total
        );

        savePayment(
                paymentMethod,
                subtotal,
                discount,
                tax,
                total
        );
    }

    private void savePayment(
            String method,
            double subtotal,
            double discount,
            double tax,
            double total
    ) {

        String sql =
                "INSERT INTO payments " +
                "(payment_method, subtotal, discount, tax, total) " +
                "VALUES(?,?,?,?,?)";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, method);
            stmt.setDouble(2, subtotal);
            stmt.setDouble(3, discount);
            stmt.setDouble(4, tax);
            stmt.setDouble(5, total);

            stmt.executeUpdate();

            System.out.println(
                    "Payment saved to database!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}