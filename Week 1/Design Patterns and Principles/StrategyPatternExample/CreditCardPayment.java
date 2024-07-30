public class CreditCardPayment implements PaymentStrategy {

  private String cardNumber;
  private String cardHolder;
  private String cvv;

  public CreditCardPayment(String cardNumber, String cardHolder, String cvv) {
    this.cardNumber = cardNumber;
    this.cardHolder = cardHolder;
    this.cvv = cvv;
  }

  @Override
  public void pay(double amt) {
    System.out.println("Paid Rs " + amt + " using Credit Card.");
  }
}
