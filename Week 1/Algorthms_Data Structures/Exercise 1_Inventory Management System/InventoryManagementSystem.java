import java.util.HashMap;

public class InventoryManagementSystem {
  private HashMap<String, Product> productMap = new HashMap<>();

  public void addProduct(Product prod) {
    productMap.put(prod.getProductId(), prod);
  }

  public void updateProduct(Product prod) {
    productMap.put(prod.getProductId(), prod);
  }

  public void deleteProduct(Product prod) {
    productMap.remove(prod.getProductId());

  }

  public void listProducts() {
    for (Product p : productMap.values()) {
      System.out.println(p);
      // System.out.println();
    }
  }

  public static void main(String[] args) {
    InventoryManagementSystem ims = new InventoryManagementSystem();

    Product p1 = new Product("#01", "Grocery", 10, 40);
    Product p2 = new Product("#02", "Cereals", 20, 60);
    Product p3 = new Product("#03", "Vegetables", 15, 80);
    Product p4 = new Product("#04", "Snacks", 25, 100);

    ims.addProduct(p1);     
    ims.addProduct(p2);
    ims.addProduct(p3);
    ims.addProduct(p4);

    ims.listProducts();

    ims.deleteProduct(p4);
    ims.listProducts();

    // System.out.println(p1.toString());

  }
}