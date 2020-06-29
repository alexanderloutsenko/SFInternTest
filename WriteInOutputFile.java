import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

public class WriteInOutputFile  {
        File outputFile;
        PrintStream outputPrintStream;
        String outputFileName;
        boolean fileCreated;

    /** this method creates output file if necessary */
    boolean checkOutputFileReadiness (String fileName) throws FileNotFoundException, IOException {
        assert fileName != null : "You passed null as an Ouput file name to the WriteInOutputFile class";
        outputFileName = fileName;
        outputFile = new File(fileName);
        fileCreated = outputFile.createNewFile();
        return fileCreated;
    }

    /** this method creates Print Stream */
    void setOutputFilePrintStream () throws FileNotFoundException  {
        outputPrintStream = new PrintStream(outputFileName);
    }

    /** below method is implemented to check whether source file row's num corresponds to
    // a num included in Fibonacci Sequence, reverse corresponding strings and put them into
    // the output file  */
    void writeIntoFile (Fibonacci fibObj, int fibonacciLength, ReverseString reverseString, ReadSourceFile reader) {

        for (int i = 0; i < fibonacciLength; i++) {
		  if (fibObj.isFibonacciNumber(i+1)) {
		    // get original string from ArrayList, convert it to string and send it for reversing
		    reverseString.setString((reader.fileRowsKeeper.get(i)).toString());
		    // write reversed string to the output file
            outputPrintStream.print((i==0) ? reverseString.getString() : ("\n" + reverseString.getString()));
		  }
        }
    }

    /** this method closes Scanner resources  */
    void closePrintStream () {
        outputPrintStream.close();
    }
}
