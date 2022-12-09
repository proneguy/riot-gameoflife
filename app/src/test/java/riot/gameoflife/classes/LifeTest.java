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
        assertEquals("#Life 1.06" + System.lineSeparator() + "-123 456", life.toString());
    }

    @Test void lifeDuplicatedEntry() {
        Life life = new Life();
        life.addBit(-123L, 456L);
        life.addBit(-123L, 456L);
        assertEquals("#Life 1.06" + System.lineSeparator() + "-123 456", life.toString());
    }

    @Test void lifeTwoEntries() {
        Life life = new Life();
        life.addBit(-123L, 456L);
        life.addBit(-123L, 455L);
        assertEquals("#Life 1.06" + System.lineSeparator() + "-123 455" + System.lineSeparator() + "-123 456", life.toString());
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
        assertEquals("#Life 1.06" + System.lineSeparator() + "1 0" + System.lineSeparator() + "-1 0" + System.lineSeparator() + "0 0", life.toString());
    }

    @Test void lifeThreeInALineTwiceEvolvesToSameLine() {
        Life life = new Life();
        life.addBit(0L, -1L);
        life.addBit(0L, 0L);
        life.addBit(0L, 1L);
        life.evolve();
        life.evolve();
        assertEquals("#Life 1.06" + System.lineSeparator() + "0 -1" + System.lineSeparator() + "0 0" + System.lineSeparator() + "0 1", life.toString());
    }

    @Test void lifeThreeInAnLEvolvesToSquare() {
        Life life = new Life();
        life.addBit(0L, -1L);
        life.addBit(0L, 0L);
        life.addBit(1L, 0L);
        life.evolve();
        assertEquals("#Life 1.06" + System.lineSeparator() + "1 -1" + System.lineSeparator() + "1 0" + System.lineSeparator() + "0 -1" + System.lineSeparator() + "0 0", life.toString());
    }

    @Test void lifeSquareEvolvesUnchanged() {
        Life life = new Life();
        life.addBit(0L, -1L);
        life.addBit(0L, 0L);
        life.addBit(1L, 0L);
        life.addBit(1L, -1L);
        life.evolve();
        assertEquals("#Life 1.06" + System.lineSeparator() + "1 -1" + System.lineSeparator() + "1 0" + System.lineSeparator() + "0 -1" + System.lineSeparator() + "0 0", life.toString());
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
        assertEquals("#Life 1.06" + System.lineSeparator() + "0 0" + System.lineSeparator() + "1 1" + System.lineSeparator() + "-1 1" + System.lineSeparator() + "1 2" + System.lineSeparator() + "-1 2" + System.lineSeparator() + "0 3", life.toString());
    }

}
