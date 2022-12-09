package riot.gameoflife.classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    
    @Test void positionGetX() {
        Position position = new Position(1234L, 5678L);
        assertEquals(1234L, position.getX());
    }
    
    @Test void positionGetY() {
        Position position = new Position(1234L, 5678L);
        assertEquals(position.getY(), 5678L);
    }
    
    @Test void positionHashCode() {
        Position position = new Position(1234L, 5678L);
        assertNotNull(position.hashCode());
    }
    
    @Test void positionToString() {
        Position position = new Position(1234L, 5678L);
        assertEquals("1234 5678", position.toString());
    }

    @Test void positionNegativeToString() {
        Position position = new Position(-1234L, -5678L);
        assertEquals("-1234 -5678", position.toString());
    }

    @Test void positionEqualsNull() {
        Position position = new Position(1234L, 5678L);
        assertFalse(position.equals(null));
    }
    
    @Test void positionNotEqualsOtherObject() {
        Position position = new Position(1234L, 5678L);
        String string = new String("1234 5678");
        assertFalse(position.equals(string));
    }

    @Test void positionEqualsSelf() {
        Position position = new Position(1234L, 5678L);
        assertTrue(position.equals(position));
    }

    @Test void positionEqualsDuplicate() {
        Position position1 = new Position(1234L, 5678L);
        Position position2 = new Position(1234L, 5678L);
        assertTrue(position1.equals(position2));
    }
    


}
