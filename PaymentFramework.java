
public abstract class PaymentFramework {

    protected static final double VAT_RATE = 0.12;

    protected abstract boolean validatePayment(double amount);

    protected abstract double getDiscountRate(double subtotal);

    protected abstract boolean chargePayment(double finalAmount);

    protected abstract String getInvoiceHeader();

    public final double applyTax(double subtotal) {
        return subtotal * VAT_RATE;
    }

    public final double applyDiscount(double subtotal) {
        return subtotal * getDiscountRate(subtotal);
    }

    public void finalizeTransaction(
            double originalAmount,
            double discountAmount,
            double taxAmount,
            double finalAmount
    ) {

        System.out.println("------------------------------------");
        System.out.printf("  Subtotal    : P%.2f%n", originalAmount);
        System.out.printf("  Discount    : -P%.2f%n", discountAmount);
        System.out.printf("  VAT (12%%)   : +P%.2f%n", taxAmount);
        System.out.printf("  TOTAL DUE   : P%.2f%n", finalAmount);
        System.out.printf("  Status      : PAYMENT SUCCESSFUL%n");
        System.out.println("------------------------------------");
    }

    public void processInvoice(double subtotal) {

        System.out.println("\n--- INVOICE: " + getInvoiceHeader() + " ---");

        if (!validatePayment(subtotal)) {

            System.out.println(
                    "  [ERROR] Payment validation failed."
            );

            return;
        }

        double discountAmount
                = applyDiscount(subtotal);

        double afterDiscount
                = subtotal - discountAmount;

        double taxAmount
                = applyTax(afterDiscount);

        double finalTotal
                = afterDiscount + taxAmount;

        boolean charged
                = chargePayment(finalTotal);

        if (!charged) {

            System.out.println(
                    "  [ERROR] Charge failed."
            );

            return;
        }

        finalizeTransaction(
                subtotal,
                discountAmount,
                taxAmount,
                finalTotal
        );
    }
}
