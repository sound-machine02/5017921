public class Logger {
  private static Logger _logger;

  private Logger() {
    System.out.println("Instance created");
  }

  public static Logger getInstance() {        // Double checked locking
    if (_logger == null) {
      synchronized (Logger.class) {
        if (_logger == null)
          _logger = new Logger();
      }
    }
    return _logger;
  }
}