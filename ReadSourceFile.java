import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadSourceFile {
    static Scanner fileScanner; //declare Scanner
    ArrayList<String> fileRowsKeeper; //declare ArrayList<String> as number of file lines is unknown

    /** this method creates and returns Scanner object */
    public Scanner createInputStream (String fileName) throws FileNotFoundException {
        assert fileName != null : "You passed null as a Source file name to the Scanner";
        fileScanner = new Scanner(new FileInputStream(fileName));
        return fileScanner;
    }

    /** this method extracts lines from source file and returns them as an ArrayList  */
    public ArrayList<String> getOnlyFibonacciMatches (Fibonacci fibonacciObj) {
        fileRowsKeeper = new ArrayList<String>();//initialize ArrayList object
        String lineFromFile;

        // below loop reads lines of text from the source file and put in ArrayList
        // only the rows which row number corresponds to a number included in Fibonacci Sequence
        for (int i = 0; i < fibonacciObj.maxFibonacci && fileScanner.hasNextLine(); i++) {
            lineFromFile = fileScanner.nextLine();
		    if (fibonacciObj.isFibonacciNumber(i+1)) {
                fileRowsKeeper.add(lineFromFile);
		    }
        }
        assert fileRowsKeeper != null : "fileRowsKeeper array has no elements inside";
        return fileRowsKeeper;
    }

    /** this method closes Scanner resources  */
    public static void closeInputStream () {
        fileScanner.close();
    }
}
