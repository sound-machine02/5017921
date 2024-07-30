public class ProxyImage implements Image {

  private RealImage realImage;
  private String imageURL;

  public ProxyImage(String imageURL) {
    this.imageURL = imageURL;
  }

  @Override
  public void display() {
    if (realImage == null)
      realImage = new RealImage(imageURL);
    realImage.display();
  }
}