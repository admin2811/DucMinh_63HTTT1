// package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class Employee {

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

public class QuanLyNhanVien extends JFrame {
    private JTextField idField, nameField, ageField, departmentField, codeField, salaryRateField;
    private JButton addButton, deleteButton;
    private DefaultTableModel tableModel;
    private JTable table;

    public QuanLyNhanVien() {
        setTitle("Employee Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel departmentLabel = new JLabel("Department:");
        departmentField = new JTextField();
        JLabel codeLabel = new JLabel("Code:");
        codeField = new JTextField();
        JLabel salaryRateLabel = new JLabel("Salary Rate:");
        salaryRateField = new JTextField();

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);
        inputPanel.add(codeLabel);
        inputPanel.add(codeField);
        inputPanel.add(salaryRateLabel);
        inputPanel.add(salaryRateField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(inputPanel);
        mainPanel.add(tablePanel);

        add(mainPanel);
        addTestDataToTable();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });
    }

    private void addTestDataToTable() {
        Object[][] data = {
                { 1, "John", 30, "HR", "J001", 5000.0 },
                { 2, "Alice", 28, "Finance", "A002", 5500.0 },
                { 3, "Bob", 35, "IT", "B003", 6000.0 },
                { 4, "Emily", 32, "Marketing", "E004", 5200.0 },
                { 5, "David", 40, "Sales", "D005", 5800.0 },
                { 6, "Sara", 27, "HR", "S006", 5100.0 },
                { 7, "Michael", 33, "IT", "M007", 5900.0 },
                { 8, "Jessica", 29, "Finance", "J008", 5400.0 },
                { 9, "Ryan", 38, "Marketing", "R009", 5300.0 },
                { 10, "Emma", 31, "Sales", "E010", 5700.0 }
        };

        String[] columnNames = { "ID", "Name", "Age", "Department", "Code", "Salary Rate" };

        tableModel.setDataVector(data, columnNames);
    }

    private void addEmployee() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String department = departmentField.getText();
        String code = codeField.getText();
        double salaryRate = Double.parseDouble(salaryRateField.getText());

        boolean idExists = false;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((int) tableModel.getValueAt(i, 0) == id) {
                idExists = true;
                break;
            }
        }

        if (idExists) {
            JOptionPane.showMessageDialog(this, "Employee ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            Object[] rowData = { id, name, age, department, code, salaryRate };
            tableModel.addRow(rowData);
        }
    }

    private void deleteEmployee() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            tableModel.removeRow(selectedRow);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
                quanLyNhanVien.setVisible(true);
            }
        });
    }
}
