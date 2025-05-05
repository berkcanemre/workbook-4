package com.pluralsight; // Declare the package name

public class Main { // Start of the Main class
    public static void main(String[] args) { // Main method, entry point of the application

        // Create a new employee instance
        Employee employee1 = new Employee(101, "Alice Johnson", "Housekeeping", 20.0, 0.0); // Create employee with ID, name, department, pay rate, and initial hours

        // Simulate punch in at 9:00 AM
        employee1.punchTimeCard(9.0); // First call acts as punch in

        // Simulate punch out at 5:00 PM
        employee1.punchTimeCard(17.0); // Second call acts as punch out and logs hours

        // Output the employee details and total pay
        System.out.println(employee1); // Print employee summary (calls toString())

        // Optional: Simulate another shift
        employee1.punchTimeCard(8.0); // Punch in at 8:00 AM
        employee1.punchTimeCard(12.5); // Punch out at 12:30 PM

        // Output updated employee details
        System.out.println(employee1); // Print updated summary
    }
}
