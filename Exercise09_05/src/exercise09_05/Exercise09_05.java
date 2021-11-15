package exercise09_05;
import java.util.GregorianCalendar;
/**
 *
 * @author jw0013826@otc.edu
 */
public class Exercise09_05 {
    
    public static void main(String[] args) {
        
	// Creates GregorianCalendar object
	GregorianCalendar calendar = new GregorianCalendar();

        // Displays current year, month, and day
	System.out.print("\nCurrent year, month, and day in format Mth/Day/Year: ");
	System.out.println(calendar.get(calendar.MONTH) + "/" +
	calendar.get(calendar.DAY_OF_MONTH) + "/" + calendar.get(calendar.YEAR));

	// Elapsed time since January 1, 1970 to 1234567898765L
	calendar.setTimeInMillis(1234567898765L);

	// Display year, month and day of 1234567898765L
	System.out.print("\nElapsed time since January 1, 1970 set to " +
		"1234567898765L in format Mth/Day/Year: ");
	System.out.println(calendar.get(calendar.MONTH) + "/" +
		calendar.get(calendar.DAY_OF_MONTH) + "/" + calendar.get(calendar.YEAR));
    }    
}