package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RoomTest {

    private Room room;


    @Test
    void checkIn() {
//Arrange
// start each test with a clean, vacant room
        room  room1 = new Room(2, 100.0, false, false);

//Act
//
        room1.checkIn();
        boolean occupiedResult = room1.isOccupied();
        boolean dirtyResult = room1 isDirty();
//Assert
//


        }

    @Test
    void checkOut() {
    }

    @Test
    void cleanRoom() {
    }
}