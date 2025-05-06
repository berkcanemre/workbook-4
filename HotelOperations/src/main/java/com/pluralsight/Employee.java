package com.pluralsight; // Declare the package name

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int employeeId;                  // Unique ID for the employee
    private String name;                     // Employee's name
    private String department;               // Department the employee works in
    private double payRate;                  // Pay rate per hour
    private double hoursWorked;              // Total hours worked
    private Double startTime = null;         // Start time of current shift (null if not clocked in)

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Formatter for output

    // Constructor to initialize employee object
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Punch time using manual input (in decimal hours, e.g. 10.5)
    public void punchTimeCard(double time) {
        if (startTime == null) {
            startTime = time;
            System.out.println(name + " punched in at " + time);
        } else {
            double workedHours = time - startTime;
            if (workedHours < 0) {
                System.out.println("Invalid punch-out time.");
            } else {
                hoursWorked += workedHours;
                System.out.println(name + " punched out at " + time + ", worked " + String.format("%.2f", workedHours) + " hours.");
            }
            startTime = null;
        }
    }

    // Punch time using current system time (with hour, minute, and second precision)
    public void punchTimeCard() {
        LocalDateTime now = LocalDateTime.now(); // Get current system time
        double time = now.getHour() + now.getMinute() / 60.0 + now.getSecond() / 3600.0; // Convert to decimal hour

        if (startTime == null) {
            startTime = time;
            System.out.println(name + " punched in at " + now.format(formatter)); // Print formatted timestamp
        } else {
            double workedHours = time - startTime;
            if (workedHours < 0) {
                System.out.println("Invalid punch-out time.");
            } else {
                hoursWorked += workedHours;
                System.out.println(name + " punched out at " + now.format(formatter)
                        + ", worked " + String.format("%.2f", workedHours) + " hours.");
            }
            startTime = null;
        }
    }

    // Get regular hours (up to 40)
    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    // Get overtime hours (above 40)
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // Calculate total pay
    public double getTotalPay() {
        return getRegularHours() * payRate + getOvertimeHours() * payRate * 1.5;
    }

    // Override toString to display employee summary
    @Override
    public String toString() {
        return "Employee " + name + " (ID: " + employeeId + ") in " + department +
                " worked " + String.format("%.2f", hoursWorked) + " hrs, Pay: $" +
                String.format("%.2f", getTotalPay());
    }
}