package org.example;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Victor Romanov", 1, 50000);
        Employee employee2 = new Employee("Dmitriy Nogin", 2, 60000);
        Employee employee3 = new Employee("Alexey Rybkin", 1, 55000);

        Employee.addEmployee(employee1);
        Employee.addEmployee(employee2);
        Employee.addEmployee(employee3);

        System.out.println("All Employees:");
        Employee.printAllEmployees();

        System.out.println("Total Salary: " + Employee.calculateTotalSalary());
        System.out.println("Min Salary Employee: " + Employee.findMinSalaryEmployee());
        System.out.println("Max Salary Employee: " + Employee.findMaxSalaryEmployee());
        System.out.println("Average Salary: " + Employee.calculateAverageSalary());
        System.out.println("All Full Names: " + String.join(", ", Employee.getAllFullNames()));
    }
}