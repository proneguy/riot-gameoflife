package riot.gameoflife.classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LifeTest {
    
    @Test void lifeEmpty() {
        Life life = new Life();
        assertEquals("#Life 1.06", life.toString());
    }
    
    @Test void lifeSingleEntry() {
        Life life = new Life();
        life.addBit(-123L, 456L);
        assertEquals("#Life 1.06\n-123 456", life.toString());
    }

    @Test void lifeDuplicatedEntry() {
        Life life = new Life();
        life.addBit(-123L, 456L);
        life.addBit(-123L, 456L);
        assertEquals("#Life 1.06\n-123 456", life.toString());
    }

    @Test void lifeTwoEntries() {
        Life life = new Life();
        life.addBit(-123L, 456L);
        life.addBit(-123L, 455L);
        assertEquals("#Life 1.06\n-123 455\n-123 456", life.toString());
    }

    @Test void lifeEmptyEvolvesToEmpty() {
        Life life = new Life();
        life.evolve();
        assertEquals("#Life 1.06", life.toString());
    }

    @Test void lifeSingleEvolvesToEmpty() {
        Life life = new Life();
        life.addBit(0L, 0L);
        life.evolve();
        assertEquals("#Life 1.06", life.toString());
    }

    @Test void lifeTwoInALineEvolvesToEmpty() {
        Life life = new Life();
        life.addBit(0L, 0L);
        life.addBit(0L, 1L);
        life.evolve();
        assertEquals("#Life 1.06", life.toString());
    }

    @Test void lifeThreeInALineEvolvesToRotatedLine() {
        Life life = new Life();
        life.addBit(0L, -1L);
        life.addBit(0L, 0L);
        life.addBit(0L, 1L);
        life.evolve();
        assertEquals("#Life 1.06\n1 0\n-1 0\n0 0", life.toString());
    }

    @Test void lifeThreeInALineTwiceEvolvesToSameLine() {
        Life life = new Life();
        life.addBit(0L, -1L);
        life.addBit(0L, 0L);
        life.addBit(0L, 1L);
        life.evolve();
        life.evolve();
        assertEquals("#Life 1.06\n0 -1\n0 0\n0 1", life.toString());
    }

    @Test void lifeThreeInAnLEvolvesToSquare() {
        Life life = new Life();
        life.addBit(0L, -1L);
        life.addBit(0L, 0L);
        life.addBit(1L, 0L);
        life.evolve();
        assertEquals("#Life 1.06\n1 -1\n1 0\n0 -1\n0 0", life.toString());
    }

    @Test void lifeSquareEvolvesUnchanged() {
        Life life = new Life();
        life.addBit(0L, -1L);
        life.addBit(0L, 0L);
        life.addBit(1L, 0L);
        life.addBit(1L, -1L);
        life.evolve();
        assertEquals("#Life 1.06\n1 -1\n1 0\n0 -1\n0 0", life.toString());
    }

    @Test void lifeSixAliveOvalEvolvesUnchanged() {
        Life life = new Life();
        life.addBit(0L, 0L);
        life.addBit(1L, 1L);
        life.addBit(-1L, 1L);
        life.addBit(-1L, 2L);
        life.addBit(1L, 2L);
        life.addBit(0L, 3L);
        life.evolve();
        assertEquals("#Life 1.06\n0 0\n1 1\n-1 1\n1 2\n-1 2\n0 3", life.toString());
    }

}
