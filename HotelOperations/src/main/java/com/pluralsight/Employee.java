package com.pluralsight; // Declare the package name

public class Employee { // Define the Employee class

    // Backing variables
    private int employeeId; // Unique employee ID
    private String name; // Name of the employee
    private String department; // Department the employee works in
    private double payRate; // Hourly pay rate
    private double hoursWorked; // Total hours worked by employee
    private Double startTime = null; // Start time when punched in (null if not punched in)

    // Constructor to initialize all variables
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId; // Assign employee ID
        this.name = name; // Assign name
        this.department = department; // Assign department
        this.payRate = payRate; // Assign hourly rate
        this.hoursWorked = hoursWorked; // Initialize total hours worked
    }

    // Derived getter to return regular hours (up to 40)
    public double getRegularHours() {
        return Math.min(40, hoursWorked); // Return min of 40 or actual hours
    }

    // Derived getter to return overtime hours (over 40)
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40); // Return any hours beyond 40
    }

    // Derived getter to calculate total pay (regular + 1.5x overtime)
    public double getTotalPay() {
        return getRegularHours() * payRate + getOvertimeHours() * payRate * 1.5; // Calculate total pay
    }

    // Bonus: Unified method for both punch in and punch out
    public void punchTimeCard(double time) {
        if (startTime == null) { // If not punched in yet
            startTime = time; // Set start time
            System.out.println(name + " punched in at " + time); // Confirm punch in
        } else { // Already punched in; this is a punch out
            double hours = time - startTime; // Calculate hours worked in this session
            if (hours < 0) { // Invalid input check
                System.out.println("Error: punch-out time is earlier than punch-in time."); // Print error
            } else {
                hoursWorked += hours; // Add session hours to total worked hours
                System.out.println(name + " punched out at " + time + " and worked " + hours + " hour(s)."); // Confirm punch out
            }
            startTime = null; // Reset for next punch cycle
        }
    }

    // toString method for displaying employee summary
    @Override
    public String toString() {
        return "Employee " + name + " (ID: " + employeeId + ") in " + department + // Print name, ID, department
                " worked " + hoursWorked + " hrs, Pay: $" + getTotalPay(); // Print total hours and total pay
    }
}