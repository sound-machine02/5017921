public class TestDecorator {
  public static void main(String[] args) {
    Notifier emailNotifier = new EmailNotifier();

    System.out.println("Notifying via Email and SMS -");
    Notifier emailAndSMSNotifier = new SMSNotifierDecorator(emailNotifier);
    emailAndSMSNotifier.send("This is a test message.");

    System.out.println("\nNotifying via Email SMS and Slack -");
    Notifier emailSMSandSlackNotifier = new SlackNotifierDecorator(emailAndSMSNotifier);
    emailSMSandSlackNotifier.send("This is a test message.");

  }
}