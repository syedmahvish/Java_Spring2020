package DoneProgram.C9E1Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class C5E16FactorAndPrimeNumberProgram {
    final static int NUMBERS_PER_LINE = 8;
    public static int[] primeNumberArray = new int[170];


    public static void main(String args[]){

        int inputNumber;
        int repeatProgram = 1;

        Scanner scan = new Scanner(System.in);

        while(repeatProgram == 1) {

            //Stores prime number between 2 and 1,000 inclusive in array and display first 50.
            storePrimeNumber(2,1000);
            System.out.println("\nFollowing are the prime number between 2 and 50 inclusive (eight number are display in one line separated by one space) : ");
            displayPrimeNumber(2,50);

            int repeatInput = 1;

            while(repeatInput == 1) {

                //Finds if a number is prime or not.
                System.out.println("\nEnter a number to find its prime or not (number should be less than 10,000) :");
                inputNumber = scan.nextInt();

                //Checks if number is valid positive number and less than 1,000.
                if (inputNumber < 0 || inputNumber > 1000)
                    System.out.println("This is invalid input. Please enter valid number between 0-10000.");

                //Display result whether entered number is prime or not.
                //If so, display number is prime else display it's factor.
                if (findPrime(inputNumber)) {
                    System.out.println("The number " + inputNumber + " is a Prime number");
                } else {
                    System.out.println("The number " + inputNumber + " is not a Prime number");
                    System.out.println("Samllest factors of " + inputNumber + " is (separated by one space) : " + factorOfNumber(inputNumber));
                }

                System.out.println("\nWant to check another number and continue (enter 1 for yes, 0 to quit)? : ");
                repeatInput = scan.nextInt();
            }

            System.out.println("\nProgram continue (enter 1 for yes, 0 to quit)? : ");
            repeatProgram = scan.nextInt();
        }

    }


    /***
     * This method stores prime number between 2 and 1000 inclusive.
     */
    public static void storePrimeNumber(int startIndex, int endIndex) {

        int i = startIndex , j = 0;

        while (i <= endIndex){
            //calls isPrime() method to check if number is prime or not. If so stores prime number in array.
            if(isPrime(i)){
                primeNumberArray[j++] = i;
            }
            i++;
        }
    }

    /***
     * This method takes an integer and displays
     * all its smallest factors in increasing order.
     * @param number is an integer to find list of smallest factor.
     * @return  string of smallest factors in increasing order.
     */
    public static String factorOfNumber(int number){
        String result = "";
        int i = 2;

        //Checks validity of number.
        if(number < 0){
            System.out.println("This is invalid input. Please enter valid positive number.");
        }

        //if entered number is 0 or 2, return number itself because it has no lowest factor.
        if(number >= 0 && number <= 2){
            return  result = result + number;
        }

        //Checks if divisor is prime and divisible by number. If so append it to result String.
        //Else check for next divisor.
       while(i <= number){
           if(isPrime(i) && number % i == 0){
               result = result + i + " ";
               number = number / i;
           }else{
               i++;
           }
       }
       return result;
    }



    /***
     * This method stores all the prime numbers between 2 and 1,000, inclusive.
     * It displays prime numbeer between 2 and 50 inclusive.
     * @param startNumber start range for displaying prime number.
     * @param endNumber end range for displaying prime number.
     */
    public static void displayPrimeNumber(int startNumber , int endNumber){
        int i = startNumber;
        int maxNumberPerLine = 0;

        //loop until last given number.
        while (i <= endNumber){
            //calls isPrime() method to check if number is prime or not.
            if(isPrime(i)){
                System.out.print(i + " ");
                maxNumberPerLine++;
            }
            //Checks if maxNumberPerLine reaches limit. If so reset and print number in next line.
            if(maxNumberPerLine == NUMBERS_PER_LINE) {
                maxNumberPerLine = 0;
                System.out.println();
            }
            i++;
        }

    }

    /***
     * This method checks if number is Prime or not.
     * @param number is an integer which need to verify as prime or not.
     * @return boolean value. If number is prime, true is retun else false.
     */
    public static boolean isPrime(int number){
        int k = 2;

        if(number < 0){
            System.out.println("This is invalid number. Please enter valid positive number.");
            return false;
        }

        while(k <= number/2){
            if(number % k == 0 && number > 1){
                 return false;
            }
            k++;
        }
        return true;
    }

    /***
     * This method checks if given number is prime or not by searching in primeNumber Array.
     * If so return true else false.
     * @param number to check whether its prime or not.
     * @return boolean value, true if found, else false.
     */
    public static boolean findPrime(int number){
        for(int i = 0 ; i < primeNumberArray.length ; i++){
            if(primeNumberArray[i] == number){
                return true;
            }
        }

        return false;
    }
}
