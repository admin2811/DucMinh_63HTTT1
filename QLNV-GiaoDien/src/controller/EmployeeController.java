package controller;

import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class EmployeeController {
    private List<Employee> employeeList;

    public EmployeeController() {

        employeeList = new ArrayList<>();
        initializeEmployees();
    }

    private void initializeEmployees() {
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee(i, "Employee " + i, 25 + i, "Department " + (i % 3), "E" + i,
                    1000 + i * 100);
            employeeList.add(employee);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void deleteEmployee(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getId() == employeeId) {
                employeeList.remove(employee);
                return;
            }
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
