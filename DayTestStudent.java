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

public class DayTestStudent {

    @Test
    public void testDayEnumValues() {
        Day[] days = Day.values();
        assertArrayEquals(new Day[]{Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY}, days);
    }
}