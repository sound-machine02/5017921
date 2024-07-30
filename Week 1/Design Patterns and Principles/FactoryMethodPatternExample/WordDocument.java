public class WordDocument implements Document {

  @Override
  public void open() {
    System.out.println("Word Document is being opened...");
  }

  @Override
  public void edit() {
    System.out.println("Editing Word Document...");
  }

  @Override
  public void save() {
    System.out.println("Saving Word Document...");
  }

  @Override
  public void close() {
    System.out.println("Word Document being closed...");
  }
}