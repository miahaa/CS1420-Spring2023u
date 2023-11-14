package assignment01;
/**
 * This class implements this cool idea: converted my Uid into hours, minutes
 * and seconds
 *
 * @author  Thu Ha
 * @version January 12, 2023
 */
public class TimeCalculation {
    public static void main(String[] args) {
        int Uid = 1429766;
        int Seconds = Uid % 60;
        int Hours = Uid / 60;
        int Minutes = Hours % 60;
        Hours = Hours / 60;
        System.out.print("My uID number is u");
        System.out.print(Uid);
        System.out.println(".");
        System.out.println(Uid + " seconds is " + Hours + " hour(s), " +
                Minutes + " minute(s)," + " and " + Seconds + " second(s)"
                + ".");
    }

}

