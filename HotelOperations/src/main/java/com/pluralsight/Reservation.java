package com.pluralsight; // Declare the package name

public class Reservation {
    // Backing variables
    private String roomType; // Can be "king" or "double"
    private int numberOfNights;
    private boolean isWeekend;

    // Constructor to set initial values
    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType.toLowerCase(); // Normalize input
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }

    // Setter for room type
    public void setRoomType(String roomType) {
        this.roomType = roomType.toLowerCase();
    }

    // Getter for number of nights
    public int getNumberOfNights() {
        return numberOfNights;
    }

    // Setter for number of nights
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    // Getter for isWeekend
    public boolean isWeekend() {
        return isWeekend;
    }

    // Setter for isWeekend
    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    // Derived getter for price per night
    public double getPrice() {
        double basePrice = roomType.equals("king") ? 139.00 : 124.00; // Base price by room type
        if (isWeekend) {
            basePrice *= 1.10; // 10% increase on weekends
        }
        return basePrice;
    }

    // Derived getter for total reservation cost
    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }

    // toString method for displaying reservation info
    @Override
    public String toString() {
        return "Reservation for a " + roomType + " room, " +
                numberOfNights + " night(s), " +
                (isWeekend ? "Weekend rate applied" : "Weekday rate") +
                ", Total: $" + getReservationTotal();
    }
}