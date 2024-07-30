public class RazorPayAdapter implements PaymentProcessor {
  private RazorPay razorPay;

  public RazorPayAdapter(RazorPay razorPay) {
    this.razorPay = razorPay;
  }

  @Override
  public void processPayment(double amt) {
    razorPay.doPayment(amt);
  }
}