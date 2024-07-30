public class EmployeeManagementSystem {
  private Employee[] emps;
  int cnt;

  public EmployeeManagementSystem(int n) {
    emps = new Employee[n];
    cnt = 0;
  }

  public void add(Employee employee) {
    if (cnt < emps.length) {
      emps[cnt] = employee;
      cnt++;
    } else {
      System.out.println("Array is full!");
    }
  }

  public Employee search(String eID) {
    for (int i = 0; i < cnt; i++) {
      if (emps[i].getEmployeeId().equals(eID))
        return emps[i];
    }
    return null;
  }

  public void traverse() {
    for (int i = 0; i < cnt; i++) {
      System.out.println(emps[i]);
    }
  }

  public void delete(String eID) {
    for (int i = 0; i < cnt; i++) {
      if (emps[i].getEmployeeId().equals(eID)) {
        for (int j = i; j < cnt - 1; j++) {
          emps[j] = emps[j + 1];
        }
        emps[cnt - 1] = null;
        cnt--;
        return;
      }
    }
  }

  public static void main(String[] args) {
    EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

    ems.add(new Employee("ID01", "Rahul", "HR", 80000));
    ems.add(new Employee("ID02", "Manish", "IT", 50000));
    ems.add(new Employee("ID03", "Kumar", "Finance", 40000));
    ems.add(new Employee("ID04", "Navnit", "IT", 60000));
    ems.add(new Employee("ID05", "Bhushan", "Marketing", 45000));

    ems.traverse();

    ems.delete("ID03");
    ems.traverse();
  }
}