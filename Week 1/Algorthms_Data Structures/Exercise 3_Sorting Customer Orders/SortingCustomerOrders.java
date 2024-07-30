public class SortingCustomerOrders {
  public static void main(String[] args) {
    Order o1 = new Order(101, "Ramesh", 600);
    Order o2 = new Order(102, "Suresh", 450);
    Order o3 = new Order(103, "Nitin", 800);
    Order o4 = new Order(104, "Pankaj", 1000);
    Order o5 = new Order(105, "Mohan", 500);

    Order[] orders = { o1, o2, o3, o4, o5 };

    // BubbleSort.bubbleSort(orders);
    QuickSort.quickSort(orders, 0, orders.length - 1);
    for (Order od : orders)
      System.out.println(od);
  }
}
