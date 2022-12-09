package riot.gameoflife.classes;

import java.util.HashSet;

public class Life {
    
    // set is a HashSet of alive cells
    // if set contains a position, the cell is alive
    // if set does not contain a position, the cell is dead
    HashSet<Position> set;

    // Constructor
    public Life() {
        set = new HashSet<Position>();
    }

    // For initial construction
    public void addBit(long x, long y) {
        set.add(new Position(x, y));
    }

    // Retrieves integer value of a given cell
    // Alive is 1, dead is 0
    private int positionToValue(long x, long y) {
        return set.contains(new Position(x,y)) ? 1 : 0;
    }

    // Iterate through neighbouring cells to see how many alive 
    //   neighbours a cell possesses
    //
    // Return: true (alive) if currently alive with 2 or 3 alive 
    //           neighbours or dead with 3 alive neighbours
    //         false (dead) if currently alive with <2 or >3 alive
    //           neighbours or dead with !3 alive neighbours
    private Boolean evaluatePosition(long x, long y) {
        Boolean current = set.contains(new Position(x,y));

        int neighbourCount = 0;

        // It might be more legible to write out all 8 positions, but this makes
        // for easier bounds checking
        for (int offsetX=(x==Long.MIN_VALUE ? 0 : -1); offsetX<=(x==Long.MAX_VALUE ? 0 : 1); offsetX++) {
            for (int offsetY=(y==Long.MIN_VALUE ? 0 : -1); offsetY<=(y==Long.MAX_VALUE ? 0 : 1); offsetY++) {
                if (!(offsetX==0 && offsetY==0)) {
                    neighbourCount += positionToValue(x+offsetX, y+offsetY);
                }
            }
        }

        // Explicitly listing rules; we could consolidate, but this more legible
        if (current && (neighbourCount < 2 || neighbourCount > 3)) {
            return false;
        } else if (current) {
            return true;
        } else if (neighbourCount == 3) {
            return true;
        } else {
            return false;
        }
    }

    // Execute the Game of Life logic against our cells
    public void evolve() {

        // We cannot alter our set in place, we need to construct a new set
        HashSet<Position> evolved = new HashSet<Position>();

        for (Position position: set) {
                        
            long x = position.getX();
            long y = position.getY();

            // Check 3x3 grid around (x,y); this ensures that we're looking at any dead cells around
            // (x,y) that need to be evaluated
            // This will almost certainly lead to wasted checks with neighbours being checked multiple times
            // Two alternatives would be to store a set of checked cells, or check exhaustively once
            // Exhaustive search would be very (very) wasteful
            for (int offsetX=(x==Long.MIN_VALUE ? 0 : -1); offsetX<=(x==Long.MAX_VALUE ? 0 : 1); offsetX++) {
                for (int offsetY=(y==Long.MIN_VALUE ? 0 : -1); offsetY<=(y==Long.MAX_VALUE ? 0 : 1); offsetY++) {
                    if (evaluatePosition(x+offsetX, y+offsetY)) {
                        evolved.add(new Position(x+offsetX, y+offsetY));
                    }
                }
            }
        }

        // Replace set with new evolved version
        set = evolved;
    }

    // Return Life object in Life 1.06 format
    // Note: Recommended to use with smaller data sets
    public String toString() {

        String string = new String("#Life 1.06");

        for (Position position: set) {
            string = string.concat("\n" + position.toString());
        }

        return string;
    }

    // Output Life object to stdout in Life 1.06 format
    public void output() {

        System.out.println("#Life 1.06");
        for (Position position: set) {
            System.out.println(position.toString());
        }
    }
}
