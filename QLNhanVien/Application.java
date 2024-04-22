import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeManage employeeManage = new EmployeeManage();

    private static void displayEmployees() {
        System.out.print("List of Employee :\n");
        System.out.print(
                "ID             |Name              |Age               |Department            |Code              |Salary rate\n");
        for (Employee employee : employeeManage.getEmployees()) {
            System.out.print(employee.getId() + "            |" + employee.getName() + "           |"
                    + employee.getAge() + "             |" + employee.getDepartment() + "              |"
                    + employee.getCode() + "            |" + employee.getSalary() + "\n");
        }
        ;
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private static void createEmployee() {
        System.out.print("Please!Input the information of employee:\n");
        System.out.print("ID : ");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                // Kiểm tra xem id có là số không
                break;
            } catch (NumberFormatException e) {
                System.out.print("ID must be a number. Please enter a valid ID:");
            }
        }
        while (employeeManage.isIdExist(id)) {
            System.out.println("This ID already exists. Please enter a different ID:");
            id = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Name : ");
        String name = scanner.nextLine();
        System.out.print("Age : ");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                // Kiểm tra xem age có là số không
                break;
            } catch (NumberFormatException e) {
                System.out.print("Age must be a number. Please enter a valid age:");
            }
        }
        System.out.print("Deparment : ");
        String deparment = scanner.nextLine();
        System.out.print("Code : ");
        String code = scanner.nextLine();

        // Kiểm tra xem code có bị trùng không
        while (employeeManage.isCodeExist(code)) {
            System.out.print("This code already exists. Please enter a different code:");
            code = scanner.nextLine();
        }
        System.out.print("Salary rate: ");
        int salary;
        while (true) {
            try {
                salary = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Salary must be a number. Please enter a valid salary rate:");
            }
        }
        if (employeeManage.createEmployee(id, name, age, deparment, code, salary) == true)
            System.out.print("Employee added successfully!\n");
        else {
            System.out.print("Please,Check your input , it isn't correct!\n");
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private static void deleteEmployee() {
        System.out.print("Please!Input the information of employee to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (employeeManage.deleteEmployee(id) == true) {
            System.out.print("Deleted!\n");
        } else {
            System.out.print("Sorry, don't find employee!\n");
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        employeeManage.initializeEmployees();
        int exit = 0;
        int select;
        while (exit != 1) {
            System.out.print("Bonjour, my Sir!\n");
            System.out.print("1 :Create employee \n");
            System.out.print("2 :Delete employee \n");
            System.out.print("3 :View employee \n");
            System.out.print("4 :Exit \n");
            System.out.print("Please!Choose your select : ");
            select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    displayEmployees();
                    break;
                case 4:
                    System.out.print("Au revoir!");
                    exit = 1;
                default:
                    break;
            }
        }
    }
}
