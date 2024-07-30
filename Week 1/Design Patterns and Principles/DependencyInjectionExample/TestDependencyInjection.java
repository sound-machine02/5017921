public class TestDependencyInjection {

  public static void main(String[] args) {

    // Injecting repository into service
    CustomerService customerService = new CustomerService(new CustomerRepositoryImpl());

    String customerName = customerService.getCustomerById("102");
    System.out.println(customerName);

  }
}