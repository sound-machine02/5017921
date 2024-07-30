public class TestObserver {

  public static void main(String[] args) {
    StockMarket stockMarket = new StockMarket();

    Observer mobileApp = new MobileApp("Binomo");
    Observer webApp = new WebApp("Groww");

    stockMarket.register(mobileApp);
    stockMarket.register(webApp);

    stockMarket.setStockPrice(5000.00);

    stockMarket.notifyObserver();

    stockMarket.deregister(mobileApp);

    stockMarket.setStockPrice(2500.00);
    stockMarket.notifyObserver();

  } 
}