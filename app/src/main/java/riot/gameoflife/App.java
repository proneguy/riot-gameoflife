package riot.gameoflife;

import java.util.Scanner;
import riot.gameoflife.classes.Life;

public class App {

    public static void main(String[] args) throws Exception {

        Life life = new Life();

        String line;
        Scanner in = new Scanner(System.in);

        // Read stdin
        while (in.hasNextLine()) {
            line = in.nextLine();
            
            // TODO: We should detect & reject input if it it doesn't match (-?\d+, -?\d+) format

            String[] xy = line.split(",");

            long x = Long.valueOf(xy[0].trim().substring(1).trim());
            long y = Long.valueOf(xy[1].trim().substring(0, xy[1].trim().length()-1).trim());
            life.addBit(x, y);
        }

        in.close();

        // Evolve 10 times
        for (int i=0; i<10; i++)
            life.evolve();

        life.output();

    }
}
