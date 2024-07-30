public class JusPayAdapter implements PaymentProcessor {
  private JusPay jusPay;

  public JusPayAdapter(JusPay jusPay) {
    this.jusPay = jusPay;
  }

  @Override
  public void processPayment(double amt) {
    jusPay.transferAmount(amt);
  }
}