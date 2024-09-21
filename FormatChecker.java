import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The FormatChecker class is responsible for checking the format of files
 * that are expected to contain numerical data in a specific structure.
 *
 * This class reads the specified file, verifies that it starts with two
 * integers
 * representing the number of rows and columns, and checks that the file
 * contains
 * the correct number of numerical values. It can handle both integers and
 * doubles.
 * 
 * Usage:
 * java FormatChecker file1 [file2 ... fileN]
 * 
 * @author Ben Lammers
 * @version 1.0 CS221 Fall 2024
 */
public class FormatChecker {
    /**
     * The entry point of the FormatChecker application.
     *
     * This method takes file names as command-line arguments, creates a
     * FormatChecker instance for each file, and checks if the file format
     * is valid. It prints "VALID" or "INVALID" for each file based on
     * the result of the format check.
     *
     * @param args command-line arguments representing the file names to be checked.
     * @throws FileNotFoundException if any of the specified files do not exist.
     */
    public static void main(String[] args) throws FileNotFoundException {
        int size = args.length;
        for (int i = 0; i < size; i++) {
            String fileName = args[i];
            boolean val;

            FormatChecker format = new FormatChecker(fileName);
            val = format.Filechecker();

            if (val == true) {
                System.out.println(fileName);
                System.out.println("VALID");
                System.out.println();
            } else {
                // System.out.println("$ java FormatChecker file1 [file2 ... fileN]");
                System.out.println(fileName);
                System.out.println("INVALID");
                System.out.println();
            }
        }

    }

    /**
     * The name of the file to be checked for formatting.
     */
    private String fileName;

    /**
     * Constructs a FormatChecker instance with the specified file name.
     *
     * @param fileName the name of the file to be checked for formatting.
     */
    public FormatChecker(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Checks the format of the specified file to ensure it has the correct number
     * of rows and columns.
     *
     * The method reads the first two integers from the file to determine the
     * expected number of rows and columns,
     *  then checks if the file contains the appropriate number of double values. If the format
     * is incorrect or the file cannot be found, it prints an error message to the
     * console.
     *
     * @return true if the file format is valid; false otherwise.
     * @throws FileNotFoundException if the file does not exist.
     */
    public boolean Filechecker() throws FileNotFoundException {
        boolean verdict = true;
        // this.fileName = fileName;
        Scanner flsc;
        try {
            File file = new File(this.fileName);
            flsc = new Scanner(file);

            int rows = flsc.nextInt();
            int cols = flsc.nextInt();

            Double[] numbs = new Double[cols * rows];
            for (int i = 0; i < rows * cols; i++) {
                numbs[i] = flsc.nextDouble();
            }
            if (flsc.hasNextDouble() == true) {
                verdict = false;
                System.out.println("check if your file has the correct number of rows and columns");
            } else if (flsc.hasNextInt() == true) {
                verdict = false;
                System.out.println("check if your file has the correct number of rows and columns");
            }
            if (numbs[(rows * cols) - 1].equals(null)) {
                verdict = false;
                System.out.println("");
            }

        } catch (InputMismatchException e) {
            verdict = false;
            System.out.println("Check that your files top row is only Itegers and the grid has only Itegers or Doubles");

        } catch (FileNotFoundException e) {
            verdict = false;
            System.out.println("java FormatChecker file1 [file2 ... fileN]");
        }

        return verdict;
    }

}