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

public class BevShopTestStudent {

    @Test
    public void testAddOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "John", 22);
        assertEquals(1, shop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testIsValidTime() {
        BevShop shop = new BevShop();
        assertTrue(shop.isValidTime(10));
    }

    @Test
    public void testTotalMonthlySale() {
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "John", 22);
        shop.processCoffeeOrder("Coffee", Size.SMALL, false, false);
        assertEquals(2.0, shop.totalMonthlySale());
    }
}
