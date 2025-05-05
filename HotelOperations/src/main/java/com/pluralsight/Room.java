package com.pluralsight; // Declare the package name

public class Room { // Define the Room class
    // Private backing variables
    private int numberOfBeds; // Number of beds in the room
    private double price; // Price of the room
    private boolean occupied; // Whether the room is currently occupied
    private boolean dirty; // Whether the room is currently dirty

    // Constructor to initialize room variables
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds; // Set number of beds
        this.price = price; // Set price
        this.occupied = occupied; // Set occupied status
        this.dirty = dirty; // Set dirty status
    }

    // Getter for number of beds
    public int getNumberOfBeds() {
        return numberOfBeds; // Return number of beds
    }

    // Getter for price
    public double getPrice() {
        return price; // Return price
    }

    // Getter to check if room is occupied
    public boolean isOccupied() {
        return occupied; // Return occupied status
    }

    // Getter to check if room is dirty
    public boolean isDirty() {
        return dirty; // Return dirty status
    }

    // Derived getter to check if room is available (not occupied and clean)
    public boolean isAvailable() {
        return !occupied && !dirty; // Return true if room is available
    }

    // Method to check a guest into the room
    public void checkIn() {
        if (isAvailable()) { // Check if room is available
            occupied = true; // Set as occupied
            dirty = true; // Set as dirty
            System.out.println("Guest has checked in."); // Print status
        } else {
            System.out.println("Room is not available for check-in."); // Print error
        }
    }

    // Method to check a guest out of the room
    public void checkOut() {
        if (occupied) { // If room is currently occupied
            occupied = false; // Set as unoccupied
            System.out.println("Guest has checked out. Room needs cleaning."); // Print status
        } else {
            System.out.println("Room is already vacant."); // Print error
        }
    }

    // Method to clean the room
    public void cleanRoom() {
        if (dirty) { // If room is dirty
            dirty = false; // Set as clean
            System.out.println("Room has been cleaned."); // Print status
        } else {
            System.out.println("Room is already clean."); // Print info
        }
    }

    // toString method to return a description of the room
    @Override
    public String toString() {
        return "Room with " + numberOfBeds + " beds, $" + price + ", " + // Return room details
                (occupied ? "Occupied" : "Available") + ", " + // Check occupancy status
                (dirty ? "Dirty" : "Clean"); // Check cleanliness status
    }
}