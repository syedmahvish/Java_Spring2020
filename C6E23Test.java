package DoneProgram.C9E1Rectangle;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * This program perform testing for string and count occurence of particular character in string.
 */
public class C6E23Test {
    public static void main(String args[]){

        int loopOuterProgram = 1;
        int loopInnerProgram = 1;

        C6E23StringProgram stringObject;
        String input;
        Character inputChar;

        //to handle exception if continue loop program entered invalid value.
        try {

          // Allows user to re-enter string and character to be find in string.
            while (loopOuterProgram == 1) {
                Scanner scan = new Scanner(System.in);

                System.out.println("Enter string and enter character whose occurence you want to find (separated by newLine): ");
                input = scan.nextLine();
                inputChar = scan.next().charAt(0);
                stringObject = new C6E23StringProgram(input);

                System.out.println("Occurence of " + inputChar + " in " + stringObject.getInputString() + " is : " + stringObject.occurrenceOfChar(inputChar));

                // Allows user to re-enter character to be find in given string.
                while (loopInnerProgram == 1) {
                    if(inputChar == null) {
                        System.out.println("Enter character whose occurence you want to find in " + input + " : ");
                        inputChar = scan.next().charAt(0);
                        System.out.println("Occurrence of " + inputChar + " in " + stringObject.getInputString() + " is : " + stringObject.occurrenceOfChar(inputChar));
                    }

                    inputChar = null;
                    System.out.println("Want to find occurrence of character (enter 1 for yes, 0 to quit)? : ");
                    loopInnerProgram = scan.nextInt();

                }

                input = null;
                System.out.println("Want to enter String (enter 1 for yes, 0 to quit)? : ");
                loopOuterProgram = scan.nextInt();
                loopInnerProgram = 1;
            }

        } catch (InputMismatchException e){
            System.out.println("Entered invalid choice: " + e.getMessage());
        }

    }
}
