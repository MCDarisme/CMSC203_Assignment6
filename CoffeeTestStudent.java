/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Guerlain Darisme
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoffeeTestStudent {

    @Test
    public void testCalcPrice_WithExtras() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, true);
        assertEquals(3.0, coffee.calcPrice());
    }

    @Test
    public void testCalcPrice_NoExtras() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, false, false);
        assertEquals(2.0, coffee.calcPrice());
    }

    @Test
    public void testGetExtraShot() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        assertTrue(coffee.getExtraShot());
    }
}
