import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
  private List<Observer> obsList;
  private double stockPrice;

  public StockMarket() {
    obsList = new ArrayList<>();
  }

  

  @Override
  public void register(Observer obs) {
    obsList.add(obs);
  }

  @Override
  public void deregister(Observer obs) {
    obsList.remove(obs);
  }

  @Override
  public void notifyObserver() {
    for (Observer observer : obsList)
      observer.update(stockPrice);
  }


  public void setStockPrice(double stockPrice) {
    this.stockPrice = stockPrice;
    // notifyObserver();
  }
}