import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiplicationSum {

    public static void main(String[] args) {
        // Make sure to provide the correct path to your text file
        File file = new File("input.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Initialize total sum of multiplications
            int total = 0;

            // Start with multiplications enabled
            boolean mulEnabled = true;

            // Regular expression to find mul(X, Y) pattern
            Pattern mulPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
            // Regular expression to find do() and don't() instructions
            Pattern doPattern = Pattern.compile("do\\(\\)");
            Pattern dontPattern = Pattern.compile("don't\\(\\)");

            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Check if the line contains "do()" or "don't()" instructions
                Matcher doMatcher = doPattern.matcher(line);
                Matcher dontMatcher = dontPattern.matcher(line);

                // Update mulEnabled based on the most recent do() or don't() instruction
                if (doMatcher.find()) {
                    mulEnabled = true; // Enable multiplications
                } else if (dontMatcher.find()) {
                    mulEnabled = false; // Disable multiplications
                }

                // Find all valid mul(X, Y) instructions in the current line
                Matcher mulMatcher = mulPattern.matcher(line);
                while (mulMatcher.find()) {
                    // If mul is enabled, process the multiplication
                    if (mulEnabled) {
                        int x = Integer.parseInt(mulMatcher.group(1));
                        int y = Integer.parseInt(mulMatcher.group(2));
                        total += x * y;
                    }
                }
            }

            // Output the final total sum
            System.out.println("Total sum of valid multiplications: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

