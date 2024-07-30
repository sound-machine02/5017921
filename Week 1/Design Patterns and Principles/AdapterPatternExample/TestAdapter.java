public class TestAdapter {
  public static void main(String[] args) {
    PaymentProcessor razorPayProcessor = new RazorPayAdapter(new RazorPay());
    razorPayProcessor.processPayment(500.00);

    PaymentProcessor phonePeProcessor = new PhonePeAdapter(new PhonePe());
    phonePeProcessor.processPayment(1000.00);

    PaymentProcessor jusPayProcessor = new JusPayAdapter(new JusPay());
    jusPayProcessor.processPayment(2500.00);

    PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
    payPalProcessor.processPayment(5000.00);

  }
}