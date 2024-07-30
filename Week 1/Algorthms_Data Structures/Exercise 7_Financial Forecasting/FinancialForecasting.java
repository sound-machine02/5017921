public class FinancialForecasting {

  public static void main(String[] args) {
    double initialValue = 500.00;
    double rate = 0.06;
    int timePeriod = 5;

    System.out.println("Future Value = Rs " + calcFutureValue(initialValue, rate, timePeriod));
  }

  static double calcFutureValue(double initialValue, double rate, int timePeriod) {
    if (timePeriod == 0)
      return initialValue;

    return (1 + rate) * calcFutureValue(initialValue, rate, timePeriod - 1);
  }
}