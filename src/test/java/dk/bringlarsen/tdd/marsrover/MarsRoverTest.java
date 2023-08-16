package dk.bringlarsen.tdd.marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @Test
    void shouldReportItsPosition() {
        MarsRover marsRover = new MarsRover(new Plateau(5, 5), new Coordinates(1, 2), Direction.NORTH);

        assertEquals(Direction.NORTH, marsRover.getDirection());
        assertEquals(new Coordinates(1,2), marsRover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
        "NORTH,EAST","EAST,SOUTH","SOUTH,WEST","WEST,NORTH"
    })
    void givenMoveRightCommandExpectRoverToChangeDirection(Direction initialDirection, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(new Plateau(5, 5), new Coordinates(1, 2), initialDirection);

        marsRover.moveRight();

        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @ParameterizedTest
    @CsvSource({
            "NORTH,WEST","WEST,SOUTH","SOUTH,EAST","EAST,NORTH"
    })
    void givenMoveLeftCommandExpectRoverToChangeDirection(Direction initialDirection, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(new Plateau(5, 5), new Coordinates(1, 2), initialDirection);

        marsRover.moveLeft();

        assertEquals(expectedDirection, marsRover.getDirection());
    }

    @ParameterizedTest
    @CsvSource({
            "NORTH,2,3",
            "EAST,3,2",
            "SOUTH,1,2",
            "WEST,2,1"
    })
    void givenMoveForwardCommandExpectRoverToChangePosition(Direction direction, int x, int y) {
        MarsRover marsRover = new MarsRover(new Plateau(5, 5), new Coordinates(2, 2), direction);

        marsRover.moveForward();

        assertEquals(new Coordinates(x, y), marsRover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
            "NORTH", "EAST"
    })
    void givenMoveOutOfPlateauUpperBoundExpectNoOperation(Direction direction) {
        MarsRover marsRover = new MarsRover(new Plateau(1, 1), new Coordinates(1, 1), direction);

        marsRover.moveForward();

        assertEquals(new Coordinates(1,1), marsRover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
            "SOUTH", "WEST"
    })
    void givenMoveOutOfPlateauLowerBoundExpectNoOperation(Direction direction) {
        MarsRover marsRover = new MarsRover(new Plateau(1, 1), new Coordinates(0, 0), direction);

        marsRover.moveForward();

        assertEquals(new Coordinates(0,0), marsRover.getPosition());
    }
}