public class Fibonacci {
    public static long n1 = 1, n2 = 2; //initialize numbers for summing them
    long[] fibonacciKeeper; //initialize an array to store Fibonacci Sequance

        /** this method generates Fibonacci Sequance based on a size received as an argument */
        public void generateFibonacci(int count) {
            int i = 1;
            long sumOfN1andN2;
            fibonacciKeeper = new long[count];//setting a length for the array

            while(i <= count)
            {
                fibonacciKeeper[i-1] = n1;
                    //System.out.print(fibonacciKeeper[i-1] + " ");// prints Fibonacci Sequance members
                sumOfN1andN2 = n1 + n2;
                n1 = n2;
                n2 = sumOfN1andN2;
                i++;
            }
        }

        /** below method checks whether a row number corresponds any
        // member within the Fibonacci Sequance and returns check result*/
        public boolean isFibonacciNumber(long numToCheck) {
            boolean checkResult = false; // boolean to return

            for (int i = 0; i < fibonacciKeeper.length && checkResult == false && i <= fibonacciKeeper[i]; i++) {
                if (numToCheck == fibonacciKeeper[i]) {
                    checkResult = true;
                        //System.out.println("\n i = " + i);
                }
            }
            return checkResult;
        }
}
