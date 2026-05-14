public class CashPayment extends PaymentFramework {

    @Override
    protected boolean validatePayment(double amount) {

        return amount > 0;
    }

    @Override
    protected double getDiscountRate(double subtotal) {

        if (subtotal >= 5000) {
            return 0.10;
        }

        return 0.05;
    }

    @Override
    protected boolean chargePayment(double finalAmount) {

        System.out.println(
                "Processing cash payment..."
        );

        return true;
    }

    @Override
    protected String getInvoiceHeader() {

        return "CASH PAYMENT";
    }
}