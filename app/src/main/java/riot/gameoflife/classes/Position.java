package riot.gameoflife.classes;

import java.util.Objects;

public class Position {

    // Coordinates for cell position
    private final long x;
    private final long y;

    // hashCode for use in HashSet
    private int hashCode;

    // Constructor
    public Position(long x, long y) {
        this.x = x;
        this.y = y;
        this.hashCode = Objects.hash(x, y);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    // Return Position object in Life 1.06 format
    public String toString() {
        return new String(String.valueOf(x) + " " + String.valueOf(y));
    }

    // Our solution will be using a HashSet of Position for live cells
    // To accomplish this, Position must override equals and hashCode for 
    //   HashSet to be able to use it properly
    @Override
    public boolean equals (Object o) {

        // Object reference to self
        if (this == o) {
            return true;
        }

        // Object is null or different class
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position pos = (Position) o;

        // Position values are identical
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
