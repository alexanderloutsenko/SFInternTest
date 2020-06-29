public class Fibonacci {
    public static long n1 = 1, n2 = 2; //initialize numbers for summing them
    long[] fibonacciKeeper; //initialize an array to store Fibonacci Sequance
    long maxFibonacci = 0;

        /** this method generates Fibonacci Sequance based on a size received as an argument */
        public void generateFibonacci(int count) {
            int i = 1;
            long sumOfN1andN2 = 0;
            fibonacciKeeper = new long[count];//setting a length for the array

            System.out.println("Fibonacci Sequance: ");
            while(i < fibonacciKeeper.length)
            {
                fibonacciKeeper[i-1] = n1;
                    System.out.print(fibonacciKeeper[i-1] + " ");// prints Fibonacci Sequance members
                sumOfN1andN2 = n1 + n2;
                n1 = n2;
                n2 = sumOfN1andN2;
                i++;
            }
            // set max Fibonacci value to a variable
            maxFibonacci = sumOfN1andN2;
        }

        /** below method checks whether a row number corresponds any
        // member within the Fibonacci Sequance and returns check result*/
        public boolean isFibonacciNumber(long numToCheck) {
            boolean checkResult = false; // boolean to return

            for (int i = 0; i < maxFibonacci && i <= fibonacciKeeper[i]; i++) {
                if (numToCheck == fibonacciKeeper[i]) {
                    checkResult = true;
                        //System.out.println("\n i = " + i);
                }
            }
            return checkResult;
        }
}
