/**
 * 
 */
package demo;

import java.util.Date;

/**
 * @author chenguangjian
 *
 */
public class DateDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date d1 = new Date("2015/7/15");
        Date d2 = new Date("2015/7/15");
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
        System.out.println(d1.getTime() == d2.getTime());
    }
}
