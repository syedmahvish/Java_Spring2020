package DoneProgram.C9E1Rectangle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class C7E9SearchAndSortProgram {

    final static int ARRAY_SIZE = 10;

    public static void main(String args[]){

        double[] doubleArray = new double[ARRAY_SIZE];
        double number;

        int repeatProgram = 1;

        Scanner scan = new Scanner(System.in);

        while(repeatProgram == 1) {
            //Finds smallest number from array of double number.
            readInputArray(doubleArray);
            number = min(doubleArray);
            System.out.println("The minimum number is: " + number);

            //Finds index of smallest number from array of double number.
            System.out.println("The index of smallest number is: " + indexOfSmallestElement(doubleArray , number));

            //Sort array of double number.
            System.out.println("The Sorted array is (separated by comma): " + Arrays.toString(sortArray(doubleArray)));

            System.out.println("\n" + "Program continue (enter 1 for yes, 0 to quit)? : ");
            repeatProgram = scan.nextInt();
        }
    }

    /***
     * This method accepts double array and read inputs of array from user.
     * @param array Array of double number with size ARRAY_SIZE= 10.
     */
    public static void readInputArray(double[] array){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ten numbers (number can be decimal. Separated by one space): ");
        for (int i = 0; i < 10 ; i++){
            array[i] = scan.nextDouble();
        }
    }

    /***
     * This method accepts double array as parameter and finds smallest number among them.
     * @param array Array of double number with size ARRAY_SIZE= 10.
     * @return smallest number of array.
     */
    public static double min(double[] array){
        double minNumber = array[0];

        for(int i = 0; i < array.length ; i++){
            if(array[i] < minNumber)
                minNumber = array[i];
        }
        return minNumber;
    }


    /***
     * This method accepts double array as parameter and finds index of smallest number among them.
     * If number of such elements is greater than 1, return the smallest index.
     * @param array Array of double number with size ARRAY_SIZE= 10.
     * @param smallestNumber whose index to be find.
     * @return index of smallest number (zero based index).
     */
    public static int indexOfSmallestElement(double[] array, double smallestNumber){
        for(int i = 0; i < array.length ; i++){
            if(smallestNumber == array[i])
                return i;
        }
        return -1;
    }

    /***
     * This method accepts double array as parameter and sort them using Selection sort.
     * But here it finds largest number and swapping it with the last
     * @param array Array of double number with size ARRAY_SIZE= 10.
     * @return sorted array with largest number from last to first.
     */
    public static double[] sortArray(double[] array){
        for(int i = array.length - 1 ; i >= 0 ;i--){
            for(int j = i ; j >= 0 ; j--){
                if(array[j] > array[i]) {
                    double temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }


}
