package dk.bringlarsen.tdd.marsrover;

public record Coordinates(int x, int y) {

    public Coordinates moveUp() {
        return new Coordinates(x, y+1);
    }

    public Coordinates moveRight() {
        return new Coordinates(x+1, y);
    }

    public Coordinates moveDown() {
        return new Coordinates(x-1, y);
    }

    public Coordinates moveLeft() {
        return new Coordinates(x, y-1);
    }
}
