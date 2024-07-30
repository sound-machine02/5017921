public class TestStrategy {

  public static void main(String[] args) {
    PaymentContext context = new PaymentContext();

    PaymentStrategy creditCard = new CreditCardPayment("5596 0101 6878 7552", "John Doe", "425");
    context.setPaymentStrategy(creditCard);
    context.executePayment(1200.00);

    PaymentStrategy payPal = new PayPalPayment("doe.john@gmail.com", "pass@123");
    context.setPaymentStrategy(payPal);
    context.executePayment(2500.00);
  }
}