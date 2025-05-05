package com.pluralsight; // Declare the package name

public class Main {
    public static void main(String[] args) {
        // Create a Room object with 2 beds, $150, not occupied, and clean
        Room room = new Room(2, 150.0, false, false);
        // Print Room information
        System.out.println("Room Test:\n" + room);

        // Create a Reservation for a king room, 3 nights, over the weekend
        Reservation res = new Reservation("king", 3, true);
        // Print Reservation details
        System.out.println("\nReservation Test:\n" + res);

        // Create an Employee who worked 45 hours
        Employee emp = new Employee(101, "Alice Smith", "Front Desk", 20.0, 45);
        // Print Employee payroll details
        System.out.println("\nEmployee Test:\n" + emp);
    }
}
