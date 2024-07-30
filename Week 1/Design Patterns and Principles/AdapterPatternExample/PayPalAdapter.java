public class PayPalAdapter implements PaymentProcessor {
  PayPal payPal;

  public PayPalAdapter(PayPal payPal) {
    this.payPal = payPal;
  }

  @Override
  public void processPayment(double amt) {
    payPal.makePayment(amt);
  }
}