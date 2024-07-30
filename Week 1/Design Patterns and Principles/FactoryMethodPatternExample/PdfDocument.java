public class PdfDocument implements Document {
  @Override
  public void open() {
    System.out.println("PDF Document is being opened...");
  }

  @Override
  public void edit() {
    System.out.println("Editing PDF Document...");
  }

  @Override
  public void save() {
    System.out.println("Saving PDF Document...");
  }

  @Override
  public void close() {
    System.out.println("PDF Document being closed...");
  }

}
