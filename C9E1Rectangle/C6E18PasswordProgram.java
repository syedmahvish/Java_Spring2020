package DoneProgram.C9E1Rectangle;

import javax.swing.JOptionPane;

/***
 * This program allow user to enter password in JOption pane.
 * It also checks validation of password.
 */
public class C6E18PasswordProgram {

    final static int PASSWORD_MIN_LENGTH = 8;

    public static void main(String[] args) {

        //Creates JOptionPane with "Ok" and "Cancel" option.
        //It also provides text field to enter password.
        int option = JOptionPane.YES_OPTION;
        String message = "";

        while (option == JOptionPane.YES_OPTION) {
            try {

                //Minimum Password length is 8 and at least 2 digits.
                //Password must consist of letters and digits only.
                //Special characters or whitespace not allowed.
                String password = JOptionPane.showInputDialog(
                        "Enter a Password: Must be 8 or more" +
                                " letters or numerical digits 2" +
                                " of which must be digits");

                if (isValidPassword(password)) {
                    message = "Valid Password";
                } else {
                    message = "Invalid Password";
                }

                //Allows user to re-enter password.
                option = JOptionPane.showConfirmDialog(null,
                        message + "\nDo you want to continue");
            } catch (Exception ex) {
                String outputStr = " Invalid Password: " +
                        ex.getMessage() +
                        "\nDo you want to continue? ";
                option = JOptionPane.showConfirmDialog(null, outputStr);
            }
        }
    }

    /***
     * This methods checks password validation.
     * Password must have:
     * A password must have at least eight characters.
     * A password consists of only letters and digits.
     * A password must contain at least two digits.
     * @param str password whose validation to be done
     * @return boolean value true if valid password is entered, false if invalid.
     * @throws Exception
     */
    private static boolean isValidPassword(String str) throws Exception {
        if(str.length() < PASSWORD_MIN_LENGTH) return false;

        int numberOfDigits = 0;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                numberOfDigits++;
            } else if (!Character.isLetter(c)) {
                return false;
            }
        }

        if(numberOfDigits < 2) return false;

        return true;
    }


}
