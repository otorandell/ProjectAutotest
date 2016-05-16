package core.CommonActions;

import core.ErrorManager.ErrorManager;
import core.TestDriver.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by otorandell on 12/02/2016.
 */
public class DataGenerator {
    /**
     * Method that generates a random alphanumeric sequence.
     * @param length length of the returned String
     * @param lettersNumbers tells if the returned String can include or not numbers into it
     * @return random alphanumeric value String
     */
    public static String getRandomAlphanumericSequence(int length, boolean lettersNumbers) {
        //how to call this method:
        // SwissKnife.getRandomAlphanumericSequence(3, true);
        try{Thread.sleep(1);}catch (Exception e){}
        String sequence = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < length) {
            char c = (char) r.nextInt(255);
            if (lettersNumbers) {
                if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                    sequence += c;
                    i++;
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    sequence += c;
                    i++;
                }
            }
        }
        return sequence;
    }

    /**
     * This method generates a random integer between the chosen range
     * @param min minimum value the result can adquire
     * @param max maximum value the result can adquire
     * @return random integer between min and max
     */
    public static int random(int min, int max) {
        try{Thread.sleep(1);}catch (Exception e){}
        int myrand= (int) (Math.floor((int) (Math.random() * (max - min) + 1))) + min;
        return myrand;

    }

    /**
     * This method generates and returns a String referent to the date of today
     * @param driver this class manages all the information referent to the current test.
     * @param format defines the date format of the result
     * @return String that represents the date of today
     */
    public static String getToday(TestDriver driver, String format){
        String today="";
        try{
            DateFormat myformat = new SimpleDateFormat(format);
            today = myformat.format(driver.getTestdate().getTime());
        }
        catch(Exception e){
            String ecode = "--ERROR:getToday(): Unable to convert " + format + " to DateFormat please check that is inserted correctly.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }

        return today;
    }

    /**
     * This method generates and returns a String referent to a relative date value
     * @param driver this class manages all the information referent to the current test.
     * @param originaldate the returned date value is relative to this parameter
     * @param format defines the date format of the result
     * @param incrmonth integer that defines the increment of month value
     * @param incrday integer that defines the increment of month day value
     * @param incryear integer value that defines the increment of the year value
     * @return String representing a date value
     */
    public static String getRelativeDate(TestDriver driver, String originaldate, String format, int incrmonth, int incrday, int incryear){
        //HOW TO CALL THIS METHOD
        /*SwissKnife.getRelativeDate(driver, "dataname", //dataname
                "01/01/1990", "dd/MM/yyyy",0, 0, 0);*/ // original date // dateformat // increments (month, day, year)
        String today="";
        try{
            Date fecha;
            Calendar cal = Calendar.getInstance();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            fecha = dateFormat.parse(originaldate);
            cal.setTime(fecha);
            cal.add(Calendar.DAY_OF_MONTH, incrday);
            cal.add(Calendar.YEAR, incryear);
            cal.add(Calendar.MONTH, incrmonth);
            today = dateFormat.format(cal.getTime());

        }
        catch(Exception e){
            String ecode = "--ERROR:getRelativeDate(): Unable to convert " + format + " to DateFormat please check that is inserted correctly.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }
        return today;
    }

    /**
     * This method generates and returns a String referent to the date of today
     * @param driver this class manages all the information referent to the current test.
     * @param format defines the date format of the result
     * @param incrmonth integer that defines the increment of month value
     * @param incrday integer that defines the increment of month day value
     * @param incryear integer value that defines the increment of the year value
     * @return String representing a date value
     */
    public static String getRelativeDateToday(TestDriver driver, String format, int incrmonth, int incrday, int incryear){
        String today="";
        try{
            Calendar fecha = Calendar.getInstance();
            DateFormat myformat = new SimpleDateFormat(format);
            myformat.format(fecha.getTime());
            fecha.add(Calendar.DAY_OF_MONTH, incrday);
            fecha.add(Calendar.YEAR, incryear);
            fecha.add(Calendar.MONTH, incrmonth);
            today = myformat.format(fecha.getTime());
        }
        catch(Exception e){
            String ecode = "--ERROR:getRelativeDateToday(): Unable to convert " + format + " to DateFormat please check that is inserted correctly.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }
        return today;
    }

    /**
     * This method generates and returns a String referent to the date of today
     * @param driver this class manages all the information referent to the current test.
     * @return String that represents the date of today
     */
    public static String getToday(TestDriver driver){
        String today="";
        try{
            DateFormat myformat = new SimpleDateFormat("dd/MM/yyyy");
            today = myformat.format(driver.getTestdate().getTime());
        }
        catch(Exception e){
            String ecode = "--ERROR:getToday(): An unexpected error has ocurred, please check.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }

        return today;
    }
}
