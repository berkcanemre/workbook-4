package com.pluralsight; // Declare the package name

public class Main {
    public static void main(String[] args) {
        //BONUS DEMO/Punch Time Test
        Employee e = new Employee(100, "Sophie Tran", "Housekeeping", 20.0, 30.0);

        // Use system time to punch in
        e.punchTimeCard();

        try {
            Thread.sleep(1500); // Simulate time passing (1.5 seconds)
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // Use system time to punch out
        e.punchTimeCard();

        // Display employee details
        System.out.println(e);

        // HOTEL DEMO/Availability Check
        Hotel h = new Hotel("Lakeside Resort", 4, 6);
        h.bookRoom(2, true);
        h.bookRoom(1, false);
        System.out.println(h);
    }
}