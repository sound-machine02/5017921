import java.util.Scanner;

public class SinglyLinkedList {

  private Node head;

  public SinglyLinkedList() {
    this.head = null;
  }

  public static void main(String[] args) {
    SinglyLinkedList taskList = new SinglyLinkedList();
    Scanner sc = new Scanner(System.in);

    taskList.addTask(new Task("#141", "XYZ", "Pending"));
    taskList.addTask(new Task("#142", "ABC", "Completed"));
    taskList.addTask(new Task("#143", "PQR", "In Progress"));

    System.out.println("------ Task List ------");
    taskList.traverseTask();

    System.out.print("Enter ID of the task to search: ");
    String searchID = sc.next();

    Task taskToFind = taskList.searchTask(searchID);

    if (taskToFind != null)
      System.out.println("Task found. Giving details ->\n" + taskToFind);
    else
      System.out.println("Task not found.");

    System.out.print("Enter ID of the task to delete: ");
    String deleteID = sc.next();

    System.out.println("Deleting task: " + deleteID + "\n");
    taskList.deleteTask(deleteID);

    sc.close();
  }

  public void addTask(Task task) {
    Node newNode = new Node(task);

    if (head == null)
      head = newNode;
    else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = newNode;
    }
  }

  public Task searchTask(String taskId) {
    Node tmp = head;

    while (tmp != null) {
      if (tmp.task.getTaskId().equals(taskId))
        return tmp.task;

      tmp = tmp.next;
    }
    return null;
  }

  public void traverseTask() {
    Node curr = head;

    while (curr != null) {
      System.out.println(curr.task);
      curr = curr.next;
    }

  }

  public void deleteTask(String taskId) {
    Node curr = head;
    if (head == null)
      return;

    if (head.task.getTaskId().equals(taskId)) {
      head = head.next;
      traverseTask();
      return;
    }

    while (curr.next != null) {
      if (curr.next.task.getTaskId().equals(taskId)) {
        curr.next = curr.next.next;
        System.out.println("Task List after deletion: ");
        traverseTask();
        return;
      }
      curr = curr.next;
    }
    System.out.println("Given ID could not be found");
  }
}