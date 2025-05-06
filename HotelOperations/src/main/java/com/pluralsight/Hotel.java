package com.pluralsight;

public class Hotel {
    private String name; // Hotel name
    private int numberOfSuites; // Total king suites
    private int numberOfRooms; // Total basic double rooms
    private int bookedSuites; // Currently booked king suites
    private int bookedBasicRooms; // Currently booked double rooms

    // Constructor with default 0 bookings
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor with specified bookings
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Book rooms
    public boolean bookRoom(int numToBook, boolean isSuite) {
        if (isSuite) {
            if (getAvailableSuites() >= numToBook) {
                bookedSuites += numToBook;
                return true;
            }
        } else {
            if (getAvailableRooms() >= numToBook) {
                bookedBasicRooms += numToBook;
                return true;
            }
        }
        return false; // Not enough available
    }

    // Derived getter for available suites
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    // Derived getter for available basic rooms
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    // toString to show status
    @Override
    public String toString() {
        return name + " Hotel - Available Suites: " + getAvailableSuites() +
                ", Available Basic Rooms: " + getAvailableRooms();
    }
}