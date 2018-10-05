import org.junit.jupiter.api.Test;
import java.util.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    Date test = new Date(1998);
    Date test1 = new Date(1999);
    Date test2 = new Date(2001);
    Date test3 = new Date(2002);
    Date test4 = new Date(2003);
    Date test5 = new Date(2004);
    Date test6 = new Date(2005);
    Date test7 = new Date(2006);
    Date test8 = new Date(2007);
    Date test9 = new Date(2008);
    Date test10 = new Date(2009);
    Date test11= new Date(2010);
    Date test12 = new Date(2011);
    Date test13 = new Date(2012);
    Date test14 = new Date(2013);
    Date test15 = new Date(2014);
    Date test16 = new Date(2015);
    Date test17 = new Date(2016);
    Date test18 = new Date(2017);
    Date test19 = new Date(2018);

/*https://en.wikipedia.org/wiki/List_of_dates_for_Easter*/
/*Used Western list to the right*/

    @Test
    void calculateGregorianDate() {
        test.calculateGregorianDate();
        test1.calculateGregorianDate();
        test2.calculateGregorianDate();
        test3.calculateGregorianDate();
        test4.calculateGregorianDate();
        test5.calculateGregorianDate();
        test6.calculateGregorianDate();
        test7.calculateGregorianDate();
        test8.calculateGregorianDate();
        test9.calculateGregorianDate();
        test10.calculateGregorianDate();
        test11.calculateGregorianDate();
        test12.calculateGregorianDate();
        test13.calculateGregorianDate();
        test14.calculateGregorianDate();
        test15.calculateGregorianDate();
        test16.calculateGregorianDate();
        test17.calculateGregorianDate();
        test18.calculateGregorianDate();
        test19.calculateGregorianDate();

        assertEquals("4/12", test.getMonthDay());
        assertEquals("4/4", test1.getMonthDay());
        assertEquals("4/15", test2.getMonthDay());
        assertEquals("3/31", test3.getMonthDay());
        assertEquals("4/20", test4.getMonthDay());
        assertEquals("4/11", test5.getMonthDay());
        assertEquals("3/27", test6.getMonthDay());
        assertEquals("4/16", test7.getMonthDay());
        assertEquals("4/8", test8.getMonthDay());
        assertEquals("3/23", test9.getMonthDay());
        assertEquals("4/12", test10.getMonthDay());
        assertEquals("4/4", test11.getMonthDay());
        assertEquals("4/24", test12.getMonthDay());
        assertEquals("4/8", test13.getMonthDay());
        assertEquals("3/31", test14.getMonthDay());
        assertEquals("4/20", test15.getMonthDay());
        assertEquals("4/5", test16.getMonthDay());
        assertEquals("3/27", test17.getMonthDay());
        assertEquals("4/16", test18.getMonthDay());
        assertEquals("4/1", test19.getMonthDay());

    }
}