package DoneProgram.C9E1Rectangle;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * This program allows user to enter string and count occurrence of particular character in string.
 */

public class C6E23StringProgram {

    private String inputString;

    /**
     * Default constructor.
     */
    C6E23StringProgram(){}

    /***
     * Parameterised constructor accepts string and checks its validation.
     * @param inputString accepts and set string.
     */
    C6E23StringProgram(String inputString){
        setInputString(inputString);
    }

    /***
     * This method checks validation of input string.
     * If input string is invalid, it allows user to re-enter.
     * Else returns valid string.
     * Also handles exception.
     * @param str whose validation need to be done.
     */
    public void setInputString(String str) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                if (isValidString(str)) {
                    this.inputString = str;
                    return;
                } else {
                    System.out.println("Enter String (should be consist of letters and whitespaces only) :");
                    str = scan.nextLine();
                }
            } catch (InputMismatchException e) {
                scan.nextLine(); // clears buffer.
                System.out.println("Invalid string format :" + e.getMessage());
            }
        }

    }

    /***
     * To get string from outside the program.
     * @return input string variable value.
     */
    public String getInputString() {
        return inputString;
    }

    /***
     * Checks if entered string is valid or not.
     * It checks if string is null, if so returns true else false.
     * @param str  whose validation need to be done.
     * @return boolean value true if string is valid, else false.
     * @throws InputMismatchException if garbage value is entered.
     */
    public boolean isValidString(String str) throws InputMismatchException {
        if(str.length() == 0) return false;

        for(char c : str.toCharArray()){
            if(Character.isLetter(c) || Character.isWhitespace(c)){}
            else return false;
        }
        return true;
    }

    /***
     * This method calculates occurence of given character in input string.
     * @param character whose occurence need to be count in given string.
     * @return total count of character.
     */
    public int occurrenceOfChar(char character){
        int count = 0;

        for(char c : inputString.toCharArray()) {
            if(c == character){
                count++;
            }
        }
        return count;
    }

}
