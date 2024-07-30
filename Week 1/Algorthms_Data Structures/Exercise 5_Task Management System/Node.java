public class Node {

  Task task;
  Node next;

  public Node(Task task) {
    this.task = task;
  }

  public Node(Task task, Node next) {
    this.task = task;
    this.next = next;
  }

}