package dk.bringlarsen.tdd.marsrover;

public class MarsRover {
    private final Plateau plateau;
    private Coordinates position;
    private Direction direction;

    public MarsRover(Plateau plateau, Coordinates position, Direction direction) {
        this.plateau = plateau;
        this.position = position;
        this.direction = direction;
    }

    public Coordinates getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveForward() {
        Coordinates newPosition = position;
        switch (direction) {
            case NORTH -> newPosition = position.moveUp();
            case EAST -> newPosition = position.moveRight();
            case SOUTH -> newPosition = position.moveDown();
            case WEST -> newPosition = position.moveLeft();
        }
        if (plateau.isLegalMove(newPosition)) {
            position = newPosition;
        }
    }

    public void moveRight() {
        if (direction.equals(Direction.NORTH)) {
            direction = Direction.EAST;
        } else {
            direction = Direction.values()[direction.ordinal() - 1];
        }
    }

    public void moveLeft() {
        if (direction.equals(Direction.EAST)) {
            direction = Direction.NORTH;
        } else {
            direction = Direction.values()[direction.ordinal() + 1];
        }
    }
}
