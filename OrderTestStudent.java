import static org.junit.jupiter.api.Assertions.*;
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
import org.junit.jupiter.api.Test;

public class OrderTestStudent {

    @Test
    public void testCalcOrderTotal_SingleBeverage() {
        Order order = new Order(10, Day.MONDAY, new Customer("John", 22));
        order.addNewBeverage("Coffee", Size.SMALL, false, false);
        assertEquals(2.0, order.calcOrderTotal());
    }

    @Test
    public void testAddNewBeverage_MultipleTypes() {
        Order order = new Order(10, Day.MONDAY, new Customer("John", 22));
        order.addNewBeverage("Coffee", Size.SMALL, true, true);
        order.addNewBeverage("Smoothie", Size.MEDIUM, 2, true);
        assertEquals(8.0, order.calcOrderTotal());
    }

    @Test
    public void testIsWeekend() {
        Order order = new Order(10, Day.SATURDAY, new Customer("John", 22));
        assertTrue(order.isWeekend());
    }
}
