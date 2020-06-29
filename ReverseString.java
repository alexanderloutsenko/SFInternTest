public class ReverseString {
    char[] normalStringInChars; // char array to store the string's chars in original order
    char[] reversedStringInChars; // char array to store the string's chars in reversed order
    int strLength; // a var to store the string length
    String resultString; // a string to store the reversed string

    /** this method receives original string as an argument,
    // converts the string into an array of the chars and produces another char array
    // storing the string chars in reversed order */
    public void setString (String str) throws NullPointerException, ArrayIndexOutOfBoundsException {
        //initialize char array storing original string in normal order but as a separate chars
        normalStringInChars = str.toCharArray();
        //put a char array length in integer variable
        strLength = normalStringInChars.length;
        //set the length for the char array which will store the string in reversed order
        reversedStringInChars = new char[strLength];
        // put the original string's chars into the char array in the reversed order
        for (int i = 0; i < normalStringInChars.length; i++) {
            reversedStringInChars[strLength-1] = normalStringInChars[i];
            strLength--;
        }
    }

    /** this method returns the reversed string */
    public String getString() {
        // convert reversed char array into String type
        resultString = new String(reversedStringInChars);
        return resultString;
    }
}
