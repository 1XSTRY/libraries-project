package org.example;

import org.apache.commons.lang3.StringUtils;
public class Employee {
    private static int idCounter = 1;

    private int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public void setFullName(String fullName) {
        if (StringUtils.isAnyBlank(fullName)) {
            throw new IllegalArgumentException("Имя сотрудника не может быть пустым или состоять из пробелов");
        }
        this.fullName = fullName;

        String[] nameParts = fullName.split(" ");
        StringBuilder formattedName = new StringBuilder();

        for (String part : nameParts) {
            formattedName.append(StringUtils.capitalize(part)).append(" ");
        }

        this.fullName = formattedName.toString().trim();
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String toString() {
        return "Employee #" + id + ": " + fullName + ", Department: " + department + ", Salary: " + salary;
    }

    public static Employee[] employees = new Employee[10];
    public static int employeeCount = 0;

    public static void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = employee;
        }
    }

    public static void printAllEmployees() {
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    public static double calculateTotalSalary() {
        double totalSalary = 0;
        for (int i = 0; i < employeeCount; i++) {
            totalSalary += employees[i].getSalary();
        }
        return totalSalary;
    }

    public static Employee findMinSalaryEmployee() {
        if (employeeCount == 0) {
            return null;
        }

        Employee minSalaryEmployee = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findMaxSalaryEmployee() {
        if (employeeCount == 0) {
            return null;
        }

        Employee maxSalaryEmployee = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateAverageSalary() {
        if (employeeCount == 0) {
            return 0;
        }

        double totalSalary = calculateTotalSalary();
        return totalSalary / employeeCount;
    }

    public static String[] getAllFullNames() {
        String[] fullNames = new String[employeeCount];
        for (int i = 0; i < employeeCount; i++) {
            fullNames[i] = employees[i].getFullName();
        }
        return fullNames;
    }
}