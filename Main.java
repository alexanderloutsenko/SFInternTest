import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {

		ReadSourceFile reader = new ReadSourceFile();
		WriteInOutputFile writer = new WriteInOutputFile();
		 // initialize Fibonacci object
		Fibonacci fibonacciObj = new Fibonacci();
		 // initialize an object for reversing the original strings
		ReverseString reverseString = new ReverseString();
         // limit Fibonacci Sequence to include 30 numbers on assumption
         // that text file will include not more than 1 mln lines
		int fibonacciLength = 30;
		String sourceFileName = "source.txt";
		String outputFileName = "output.txt";

		try {
		    reader.createInputStream(sourceFileName);
		    if(reader == null) throw new FileNotFoundException ("reader has not been created");
            // generate a Fibonacci Sequence for specific N elements
		    fibonacciObj.generateFibonacci(fibonacciLength);
		    // get only the rows which match Fibonacci numbers and put them into an array
            reader.getOnlyFibonacciMatches(fibonacciObj);
		    reader.closeInputStream();
		}
		catch (Exception e) {
            e.printStackTrace();
        }

		 System.out.println("\n--Fibonacci rows selected rows from source file are: \n" + reader.fileRowsKeeper);

        // open output stream, generate file content and write to the file
        try {
            writer.checkOutputFileReadiness(outputFileName);
            assert writer.fileCreated == true : "Output file hasn't been created.";
            writer.setOutputFilePrintStream();
            writer.writeIntoFile(reverseString, reader);
            writer.closePrintStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

	} // end of main method
} // end of class
