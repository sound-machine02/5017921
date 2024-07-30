import java.util.Arrays;

public class ECommerceSearch {
  public static void main(String[] args) {
    Product prod1 = new Product("#001", "Printer", "Electronics");
    Product prod2 = new Product("#002", "Laptop", "Electronics");
    Product prod3 = new Product("#003", "Mouse", "Accessories");
    Product prod4 = new Product("#004", "Mobile", "Electronics");
    Product prod5 = new Product("#005", "Headphone", "Accessories");

    Product[] products = new Product[5];
    products[0] = prod1;
    products[1] = prod2;
    products[2] = prod3;
    products[3] = prod4;
    products[4] = prod5;

    String productToSearch = "Printer";
    Product foundProductLS = linearSearch(products, productToSearch);
    Product foundProductBS = binarySearch(products, productToSearch);

    if (foundProductLS != null) {
    System.out.println("Product found. Details are:\n" + foundProductLS);
    } else
    System.out.println("The searched product could not be found");

    if (foundProductBS != null) {
      System.out.println("Product found. Details are:\n" + foundProductBS);
    } else
      System.out.println("The searched product could not be found");

  }

  public static Product linearSearch(Product[] products, String name) {
    for (Product prod : products) {
      if (prod.getProductName().equals(name))
        return prod;
    }
    return null;
  }

  public static Product binarySearch(Product[] products, String name) {
    Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));
    int l = 0, r = products.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      int cmp = products[mid].getProductName().compareTo(name);

      if (cmp == 0)
        return products[mid];
      else if (cmp > 0)
        r = mid - 1;
      else if (cmp < 0)
        l = mid + 1;
    }
    return null;
  }
}