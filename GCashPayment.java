public class GCashPayment extends PaymentFramework {

    @Override
    protected boolean validatePayment(double amount) {

        return amount > 0;
    }

    @Override
    protected double getDiscountRate(double subtotal) {

        return 0.08;
    }

    @Override
    protected boolean chargePayment(double finalAmount) {

        System.out.println(
                "Charging through GCash..."
        );

        return true;
    }

    @Override
    protected String getInvoiceHeader() {

        return "GCASH PAYMENT";
    }
}