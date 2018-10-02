import java.util.*;
import java.io.*;

/**
 * Date is used to calculate the date Easter occurs on a single given year.
 * Additionally, a function is included to get the total count at each possible date Easter occurs over
 * an entire cycle, in which the order reoccurs once every 5,700,000 years
 * @author Marc Shepherd
 * @version 1.0, 9/29/2018
 * @since SDK 1.8
 */
public class Date {
    private int a, b, c, d, e, f, g, h, i, k, l, m;
    private int year, month, day;
    private String monthDay;
    private List<Date> easterArray = new ArrayList<>();
    private Map<String, Integer> easterCountMap = new HashMap<>();
    private final String [] possibleEasterDates= {"3/22", "3/23", "3/24", "3/25", "3/26","3/27", "3/28", "3/29", "3/30",
                                                  "3/31", "4/1", "4/2", "4/3", "4/4", "4/5", "4/6", "4/7", "4/8", "4/9",
                                                  "4/10", "4/11", "4/12", "4/13", "4/14", "4/15", "4/16", "4/17", "4/18",
                                                  "4/19", "4/20", "4/21", "4/22", "4/23", "4/24", "4/25"};

    /**
     * Constructor to instantiate important variables for every object
     * @param year      User input used to calculate date corresponding to given year
     */
    public Date(int year) {
        this.year = year;
        this.monthDay = "";
        this.month = -1;
        this.day = -1;
    }

    /**
     * Calculates <code>month and day</code> based on Meeus/Jones/Butcher algorithm and processes them into a combination
     * string for later testing of equality with <code>possibleEasterDates</code> string array
     * @return void
     */
    public void calculateGregorianDate() {
        a = year % 19;
        b = year / 100;
        c = year % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = (19 * a + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        l = (32 + 2 * e + 2 * i - h - k) % 7;
        m = (a + 11 * h + 22 * l) / 451;
        month = (h + l - 7 * m + 114) / 31;
        day = ((h + l - 7 * m + 114) % 31) + 1;
        monthDay = Integer.toString(month) + "/" + Integer.toString(day);
    }

    //Prints out the calculated date of Easter
    public void printGregorianDate() {
        System.out.println("Calculated date of Easter: " +
                month + "/" + day + "/" + year);
    }

    /**
     * Calculates the number of times easter occurs on a certain date over an entire cycle (5,700,000 years).
     * Array list appends new date object for each new year in the cycle --> proceeds to calculate month and day.
     * Nested for loop to increase count based on key (hashmap holds all possible dates of easter)
     * @return void
     */
    public void calculateCycleCount() {
        initializeEasterMap();
        for (int i = 0; i < 5700000; i++) {
            easterArray.add((new Date(year + i)));
            easterArray.get(i).calculateGregorianDate();

            for (int j = 0; j < possibleEasterDates.length; j++) {
                if (easterArray.get(i).monthDay.equals(possibleEasterDates[j])) {
                    easterCountMap.put(possibleEasterDates[j], easterCountMap.get(possibleEasterDates[j]) + 1);
                }
            }
        }
    }

    /**
     * Initializes easter map with keys of every possible easter date and value of 0
     * @return void
     * @access private - used solely to initialize map within class
     */
    private void initializeEasterMap() {
        for (String possibleEasterDate : possibleEasterDates) {
            easterCountMap.put(possibleEasterDate, 0);
        }
    }

    //Prints count corresponding to each date
    public void printCycleCount() {
        easterCountMap.forEach((key, value) -> System.out.println("Date: " + key + " | Count: " + easterCountMap.get(key)));
    }
}
