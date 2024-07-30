public class StudentController {

  private Student studentModel;
  private StudentView studentView;

  public StudentController(Student studentModel, StudentView studentView) {
    this.studentModel = studentModel;
    this.studentView = studentView;
  }

  public void setStudentName(String name) {
    studentModel.setName(name);
  }

  public String getStudentName() {
    return studentModel.getName();
  }

  public void setStudentId(String id) {
    studentModel.setId(id);
  }

  public String getStudentId() {
    return studentModel.getId();
  }

  public void setStudentGrade(String grade) {
    studentModel.setGrade(grade);
  }

  public String getStudentGrade() {
    return studentModel.getGrade();
  }

  public void updateView() {
    studentView.displayStudentDetails(studentModel.getName(), studentModel.getId(), studentModel.getGrade());
  }
}