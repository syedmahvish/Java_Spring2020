package DoneProgram.C9E1Rectangle;

import java.util.GregorianCalendar;

/***
 * @author Syed Mahvish
 * This class displays date in year-month-day format.
 */
class DateExample {

    private GregorianCalendar date;

    /***
     * default constructor to initialize date object.
     */
    DateExample(){
      date = new GregorianCalendar();
    }

    /***
     * This method uses DAY_OF_MONTH function to get current day of month.
      * @return int value of day of month.
     */
    public int getDay(){
        return date.get(GregorianCalendar.DAY_OF_MONTH);
     }

    /***
     * This method uses MONTH function to get current month of year.
     * @return int value of month of year.
     */
     public int getMonth(){
        return date.get(GregorianCalendar.MONTH) + 1;

    }

    /***
     * This method uses YEAR function to get current year.
     * @return int value of year.
     */
    public int getYear(){
        return date.get(GregorianCalendar.YEAR);
    }

    /**
     * This method uses setTimeinmillis() function to calculate elapsed date.
     * @param millis value in millis whose elapsed date is calculated since since January 1, 1970.
     */
    public void setTimeInMillis(long millis){
        date.setTimeInMillis(millis);
    }

    /***
     * Overrides string method to display date in string format.
     * @return string format of date in year-month-date format.
     */
    @Override
    public String toString(){
        return getYear() + "-" + getMonth() + "-" + getDay();
    }

}

public class C9E5DateProgram {
    public static void main(String[] args){

        DateExample d1 = new DateExample();
        //display current date.
        System.out.println("The current date is (yyyy-mm-dd): " + d1.toString());
        //display elapsed date.
        d1.setTimeInMillis(1234567898765L);
        System.out.println("The elapsed date since Jan 1, 1970 for 1234567898765 millis is (yyyy-mm-dd): " + d1.toString());

    }
}
