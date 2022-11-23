/* Temp class to test if CSV / CLI systems work for Menu creation */

package RestaurantSystem;

import java.io.IOException;

public class RestaurantTester {
    public static void main(String[] args) throws IOException
    {
        MenuInterface menuInterface = new MenuInterface();
        menuInterface.run();
    }
}
