import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {

		ReadSourceFile reader = new ReadSourceFile();
		WriteInOutputFile writer = new WriteInOutputFile();
		int fibonacciLength;
		String sourceFileName = "source.txt";
		String outputFileName = "output.txt";

        // open input stream and get source file content into an array
		try {
		    reader.createInputStream(sourceFileName);
		    reader.getRowsInArray();
		    reader.closeInputStream();
		}
		catch (Exception e) {
            System.out.println("Specified file is not found. Try to provide correct file name instead of " + e.getMessage());
        }

		            //System.out.println("Data from file is: \n" + reader.fileRowsKeeper);
		// put length of the input file into a variable
		fibonacciLength = reader.fileRowsKeeper.size();

		// initialize Fibonacci object and generate a Fibonacci Sequence for specific N elements
		Fibonacci fibonacciObj = new Fibonacci();
		fibonacciObj.generateFibonacci(fibonacciLength);

		// initialize an object for reversing the original strings
		ReverseString reverseString = new ReverseString();

        // open output stream, generate file content and write to the file
        try {
            writer.checkOutputFileReadiness(outputFileName);
            assert writer.fileCreated == true : "Output file hasn't been created.";
            writer.setOutputFilePrintStream();
            writer.writeIntoFile(fibonacciObj, fibonacciLength, reverseString, reader);
            writer.closePrintStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

	} // end of main method
} // end of class
