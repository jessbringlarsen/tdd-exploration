package dk.bringlarsen.tdd.hundreddoors;

import java.util.Arrays;
public class HundredDoors {

    private final Boolean[] doors;

    public HundredDoors(int noOfDoors) {
        doors = new Boolean[noOfDoors];
        Arrays.fill(doors, false);
    }

    public void visit() {
        for (int door = 1; door <= doors.length; door++) {
            for (int visit = door; visit <= doors.length; visit = visit + door) {
                toggleDoor(visit - 1);
            }
        }
    }

    private void toggleDoor(int door) {
        doors[door] = !doors[door];
    }

    public int getOpenDoors() {
        return Arrays.stream(doors)
                .filter(doorOpen -> doorOpen)
                .toList()
                .size();
    }

    public int getClosedDoors() {
        return Arrays.stream(doors)
                .filter(doorOpen -> !doorOpen)
                .toList()
                .size();
    }
}