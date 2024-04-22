import java.util.ArrayList;
import java.util.List;

public class EmployeeManage {
    private List<Employee> employees;

    public EmployeeManage() {
        employees = new ArrayList<Employee>();
    }

    public Employee[] getEmployees() {
        return employees.toArray(new Employee[0]);
    }

    public boolean createEmployee(int id, String name, int age, String department, String code, double salaryRate) {
        Employee employee = new Employee(id, name, age, department, code, salaryRate);
        return employees.add(employee);
    }

    public boolean deleteEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employees.remove(employee);
            }
        }
        return false;
    }

    public void initializeEmployees() {
        // Khởi tạo 10 nhân viên
        for (int i = 0; i <= 10; i++) {
            createEmployee(i, "Employee " + i, 20 + i, "Department " + i, "Code " + i, 1000 + i);

        }
    }

    public boolean isIdExist(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isCodeExist(String code) {
        for (Employee employee : employees) {
            if (employee.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

}
