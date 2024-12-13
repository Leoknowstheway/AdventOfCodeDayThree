import java.io.*;
import java.util.regex.*;

public class MulInstructionScanner {

    /**
     * Reads a text file, scans for valid 'mul(X,Y)' instructions, and calculates the total sum of their results,
     * considering the effects of 'do()' and 'don't()' instructions.
     *
     * @param filePath The path to the text file containing the corrupted memory.
     * @return The total sum of the results of valid 'mul(X,Y)' instructions, or -1 if an error occurs.
     */
    public static int scanAndCalculate(String filePath) {
        try {
            // Read the file content
            StringBuilder data = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    data.append(line).append("\n");
                }
            }

            // Define regex patterns
            Pattern mulPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
            Pattern doPattern = Pattern.compile("do\\(\\)");
            Pattern dontPattern = Pattern.compile("don't\\(\\)");

            Matcher mulMatcher = mulPattern.matcher(data.toString());

            // Initialize state
            boolean isEnabled = true; // 'mul' instructions are enabled by default
            int totalSum = 0;

            // Process the data
            Matcher doMatcher = doPattern.matcher(data.toString());
            Matcher dontMatcher = dontPattern.matcher(data.toString());

            int currentIndex = 0;
            while (mulMatcher.find(currentIndex)) {
                // Update the state based on 'do()' or 'don't()' instructions before the current 'mul'
                while (doMatcher.find(currentIndex) && doMatcher.start() < mulMatcher.start()) {
                    isEnabled = true;
                    currentIndex = doMatcher.end();
                }
                while (dontMatcher.find(currentIndex) && dontMatcher.start() < mulMatcher.start()) {
                    isEnabled = false;
                    currentIndex = dontMatcher.end();
                }

                // If enabled, process the current 'mul' instruction
                if (isEnabled) {
                    int x = Integer.parseInt(mulMatcher.group(1));
                    int y = Integer.parseInt(mulMatcher.group(2));
                    totalSum += x * y;
                }

                currentIndex = mulMatcher.end();
            }

            return totalSum;

        } catch (FileNotFoundException e) {
            System.err.println("Error: The file at " + filePath + " was not found.");
            return -1;
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            return -1;
        }
    }

    // Example usage
    public static void main(String[] args) {
        String filePath = "input.txt"; // Replace with your file path
        int result = scanAndCalculate(filePath);
        if (result != -1) {
            System.out.println("The total sum of valid 'mul' instructions is: " + result);
        }
    }
}

