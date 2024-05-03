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

public class CustomerTestStudent {

    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("John", 25);
        Customer copy = new Customer(original);
        assertEquals("John", copy.getName());
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer("John", 25);
        customer.setName("Jane");
        assertEquals("Jane", customer.getName());
    }

    @Test
    public void testSetAge() {
        Customer customer = new Customer("John", 25);
        customer.setAge(26);
        assertEquals(26, customer.getAge());
    }
}
