package riot.gameoflife;

import java.util.regex.Pattern;
import java.util.Scanner;
import riot.gameoflife.classes.Life;

public class App {

    public static void main(String[] args) {

        Life life = new Life();

        String line;
        Scanner in = new Scanner(System.in);

        // Regex for permissive formatting in coordinates
        Pattern pat = Pattern.compile("^\s*\\(\s*-?[0-9]+\s*,\s*-?[0-9]+\s*\\)\s*$");

        // Read stdin
        while (in.hasNextLine()) {
            line = in.nextLine();
            
            // Skip blank lines (in particular helpful for trailing line in input file)
            if (line.trim().length()==0)
                continue;

            // Exit application if invalid input is detected
            if (!pat.matcher(line).matches()) {
                System.out.println("Invalid input");
                System.exit(1);
            }

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
