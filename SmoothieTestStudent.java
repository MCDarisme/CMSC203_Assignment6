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

public class SmoothieTestStudent {

    @Test
    public void testCalcPrice_WithProtein() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        assertEquals(6.0, smoothie.calcPrice());
    }

    @Test
    public void testCalcPrice_NoProtein() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, false);
        assertEquals(4.5, smoothie.calcPrice());
    }

    @Test
    public void testGetNumOfFruits() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, false);
        assertEquals(3, smoothie.getNumOfFruits());
    }
}
