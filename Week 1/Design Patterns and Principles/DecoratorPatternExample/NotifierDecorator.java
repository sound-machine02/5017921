public class NotifierDecorator implements Notifier {
  private Notifier notifier;

  public NotifierDecorator(Notifier notifier) {
    this.notifier = notifier;
  }

  @Override
  public void send(String msg) {
    notifier.send(msg);
  }
}