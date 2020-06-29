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

    /** this method extraxts lines from source file and returns them as an ArrayList  */
    public ArrayList<String> getRowsInArray () {
        fileRowsKeeper = new ArrayList<String>();//initialize ArrayList object
        String line;
        // below loop reads lines of text from the source file and put each row in ArrayList
        while (fileScanner.hasNextLine()) {
            line = fileScanner.nextLine();
            fileRowsKeeper.add(line);
        }
        return fileRowsKeeper;
    }

    /** this method closes Scanner resources  */
    public static void closeInputStream () {
        fileScanner.close();
    }
}
