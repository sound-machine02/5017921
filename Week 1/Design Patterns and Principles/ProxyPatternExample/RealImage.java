public class RealImage implements Image {
  private String imageURL;

  public RealImage(String imageURL) {
    this.imageURL = imageURL;
    loadImageFromServer();
  }

  // Loading an image from remote server
  private void loadImageFromServer() {
    System.out.println("Loading image from " + imageURL);
  }

  @Override
  public void display() {
    System.out.println("Displaying image from " + imageURL);
  }
}