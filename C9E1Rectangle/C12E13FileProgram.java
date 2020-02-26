package DoneProgram.C9E1Rectangle;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;


/***
 * This program uses JFileChooser to open a text file.
 * It counts number of characters, words and lines in text file.
 */
public class C12E13FileProgram {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        //Creates JfileChooser with open and cancel option
        //Allows to select text file from main directory.
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text file", "txt");
        chooser.setFileFilter(filter);
        Frame frame = new Frame();

        int confirmControl = JOptionPane.YES_OPTION;

        while (confirmControl == JOptionPane.YES_OPTION) {

            //Opens file dialog.
            int returnVal = chooser.showOpenDialog(frame);
            System.out.println(returnVal);

            //Check if user selected a file.
            if (returnVal == JFileChooser.APPROVE_OPTION) {

                File selectedFile = chooser.getSelectedFile();
                try {
                    performfileOperations(selectedFile);
                    confirmControl = JOptionPane.NO_OPTION;
                } catch (FileNotFoundException e) {
                    String outputStr =  "\n File not found." + e.getMessage() + "\n Do you want to select another file?";
                    confirmControl = JOptionPane.showConfirmDialog(frame, outputStr);
                } catch (IOException e) {
                    String outputStr =  "\n I/O exception occurred." + e.getMessage() + "\n Do you want to select another file?";
                    confirmControl = JOptionPane.showConfirmDialog(frame, outputStr);
                }
            } else {
                System.out.println("You chose to close this file: ");
                String outputStr = "Do you want to select another file?";
                confirmControl = JOptionPane.showConfirmDialog(frame, outputStr);
            }
        }
    }

    /***
     * Counts the characters, words and lines in the file.
     * @param filename
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void performfileOperations(File filename) throws IOException, FileNotFoundException{

        FileReader fileRead = new FileReader(filename);
        System.out.println("You chose to open this file: " + filename.getName());

        int i;
        int totalCharacters = 0;
        int totalLines = 0;
        int totalWords = 0;

        while ((i = fileRead.read()) != -1) {
            char temp = (char) i;
            if (temp == '\n') {
                totalLines++;
            }
            if (Character.isWhitespace(temp)) {
                totalWords++;
            }
            totalCharacters++;
        }


        System.out.println("\nTotal character in this file: " + (totalCharacters - totalLines));
        System.out.println("\nTotal words in this file: " + (totalWords + 1));
        System.out.println("\nTotal lines in this file: " + (totalLines + 1));
    }
}
