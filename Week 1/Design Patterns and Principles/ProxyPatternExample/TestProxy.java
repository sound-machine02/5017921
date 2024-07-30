public class TestProxy {

  public static void main(String[] args) {
    Image img1 = new ProxyImage("example.com/img1.jpg");
    Image img2 = new ProxyImage("example.com/img2.png");

    img1.display();
    System.out.println();
    img2.display();

  } 
}