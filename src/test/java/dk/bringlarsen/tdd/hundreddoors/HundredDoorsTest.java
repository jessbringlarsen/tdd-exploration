package dk.bringlarsen.tdd.hundreddoors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HundredDoorsTest {

    @Test
    void givenNoDoorsExpectNoResult() {
        HundredDoors doors = new HundredDoors(0);

        assertEquals(0, doors.getOpenDoors());
        assertEquals(0, doors.getClosedDoors());
    }

    @Test
    void givenHundredClosedDoorsExpectAllClosedAsResult() {
        HundredDoors doors = new HundredDoors(100);

        assertEquals(0, doors.getOpenDoors());
        assertEquals(100, doors.getClosedDoors());
    }

    @Test
    void givenHundredPassesExpectTenOpen() {
        HundredDoors doors = new HundredDoors(100);

        doors.visit();

        assertEquals(10, doors.getOpenDoors());
        assertEquals(90, doors.getClosedDoors());
    }
}