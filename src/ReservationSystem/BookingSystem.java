/* Class needs to be deleted at some point to integrate a main driver class */
package ReservationSystem;

import java.io.IOException;

/**
 * Class to run the booking system
 */
public class BookingSystem {
    public static void main(String[] args) throws IOException
    {
        BookingMenu menu = new BookingMenu();
        menu.run();
    }
}
