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

public class AlcoholTestStudent {

    @Test
    public void testCalcPrice_Normal() {
        Alcohol alcohol = new Alcohol("Vodka", Size.MEDIUM, false);
        assertEquals(2.5, alcohol.calcPrice());
    }

    @Test
    public void testCalcPrice_WeekendSurcharge() {
        Alcohol alcohol = new Alcohol("Vodka", Size.MEDIUM, true);
        assertEquals(3.1, alcohol.calcPrice());
    }

    @Test
    public void testIsWeekendOffer() {
        Alcohol alcohol = new Alcohol("Vodka", Size.MEDIUM, true);
        assertTrue(alcohol.isWeekendOffer());
    }
}
