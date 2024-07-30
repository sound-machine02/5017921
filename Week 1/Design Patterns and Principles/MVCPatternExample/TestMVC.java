public class TestMVC {

  public static void main(String[] args) {
    Student model = new Student("001", "Rahul Paul", "9.05");

    StudentView view = new StudentView();

    StudentController controller = new StudentController(model, view);

    controller.updateView();

    controller.setStudentGrade("9.20");

    System.out.println("\nDetails after update ->");
    controller.updateView();
  }
}