package com.pluralsight; // Declare the package name

public class Employee {
    // Backing variables
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    // Constructor to initialize employee data
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Derived getter for regular hours (up to 40 hours)
    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    // Derived getter for overtime hours (above 40 hours)
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // Derived getter for total pay including overtime
    public double getTotalPay() {
        return getRegularHours() * payRate + getOvertimeHours() * payRate * 1.5;
    }

    // toString method for displaying employee info
    @Override
    public String toString() {
        return "Employee " + name + " (ID: " + employeeId + ") in " + department +
                " worked " + hoursWorked + " hrs, Pay: $" + getTotalPay();
    }
}