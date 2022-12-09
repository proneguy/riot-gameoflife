package riot.gameoflife;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AppTest {
    
    @Test
    public void appEmptyInput() {
        String input = String.format("");
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        String expected = "#Life 1.06" + System.lineSeparator();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null);

        String actual = baos.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void appValidSingleLine() {
        String input = String.format("(0,0)");
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        String expected = "#Life 1.06" + System.lineSeparator();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null);

        String actual = baos.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void appValidSingleLineWhitespaceNegative() {
        String input = String.format(" ( -987432 , -478324 ) ");
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        String expected = "#Life 1.06" + System.lineSeparator();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null);

        String actual = baos.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void appValidEvolution() {
        String input = String.format("(0, 0)" + System.lineSeparator() +
        "(0, -1)" + System.lineSeparator() +
        "(0, 1)");
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        String expected = "#Life 1.06" + System.lineSeparator() +
        "0 -1" + System.lineSeparator() +
        "0 0" + System.lineSeparator() +
        "0 1" + System.lineSeparator();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null);

        String actual = baos.toString();

        assertEquals(expected, actual);
    }

    // TODO: main calls System.Exit(1) on invalid input; need to research testing that
}
