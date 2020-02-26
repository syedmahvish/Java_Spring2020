package DoneProgram.C9E1Rectangle;

import java.util.Scanner;

/**
 * This program accepts exchange rate and convert currency according to user's choice.
 * If user enters 0 : converts dollar to RMB and 1 vice versa.
 */

public class C3E31ExchangeRateProgram {
    public static void main(String[] args){

        double exchangeRate;
        double input;
        double result;
        int userChoice;

        int repeatProgram = 1;

        Scanner readInput = new Scanner(System.in);

        //loop program
        while(repeatProgram == 1) {

            //Accepts exchangeRate from user.
            System.out.println("Enter the exchange rate from dollars to RMB = ");
            exchangeRate = readInput.nextDouble();

            //Get user's choice.
            System.out.println("Enter 0 to convert dollars to RMB and 1 vice versa = ");
            userChoice = readInput.nextInt();

            if(userChoice == 0){
                //Accepts dollar and convert it to RMB.
                System.out.println("Enter the dollar amount = ");
                input = readInput.nextDouble();

                result = input * exchangeRate;

                System.out.println("$" + input + " is " + result + " yuan");

            }else{
                //Accepts RMB and convert it to dollars.
                System.out.println("Enter the RMB amount = ");
                input = readInput.nextDouble();

                result = input / exchangeRate;

                System.out.println(input + " yuan is $" + result);
            }

            System.out.println("Program continue (enter 1 for yes, 0 to quit)? : ");
            repeatProgram = readInput.nextInt();
        }

    }
}
