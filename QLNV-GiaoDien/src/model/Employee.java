package model;

// - Tạo lớp Employee với các thuộc tính: 
// 	+ id
//  	+ name
// 	+ age
// 	+ department
// 	+ code
// 	+ salary rate
public class Employee {

    private String name;
    private int id;
    private String department;
    private int age;
    private String code;
    private double salaryRate;

    // constructor
    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    public double getSalary() {
        return salaryRate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Employee() {
    }
}
