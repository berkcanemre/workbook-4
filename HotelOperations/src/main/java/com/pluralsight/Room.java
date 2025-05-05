package com.pluralsight; // Declare the package name

public class Room {
    // Backing variables
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    // Constructor to set initial values
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    // Getter for number of beds
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Getter to check if room is occupied
    public boolean isOccupied() {
        return occupied;
    }

    // Getter to check if room is dirty
    public boolean isDirty() {
        return dirty;
    }

    // Derived getter to check if room is available (clean and not occupied)
    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // toString method for displaying room info
    @Override
    public String toString() {
        return "Room with " + numberOfBeds + " beds, $" + price + ", " +
                (occupied ? "Occupied" : "Available") + ", " +
                (dirty ? "Dirty" : "Clean");
    }
}
