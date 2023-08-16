package dk.bringlarsen.tdd.marsrover;

public class Plateau {
    private final Coordinates upperBound;
    public final Coordinates lowerBound = new Coordinates(0, 0);

    public Plateau(int x, int y) {
        upperBound = new Coordinates(x, y);
    }

    public boolean isLegalMove(Coordinates position) {
        return (upperBound.x() >= position.x() && upperBound.y() >= position.y()) &&
                (lowerBound.x() <= position.x() && lowerBound.y() <= position.y());
    }
}
