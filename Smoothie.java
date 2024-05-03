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
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private static final double PROTEIN_PRICE = 1.50;
    private static final double FRUIT_PRICE = 0.50;

    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    public double calcPrice() {
        double price = super.calcPrice();
        price += numOfFruits * FRUIT_PRICE;
        if (addProtein) {
            price += PROTEIN_PRICE;
        }
        return price;
    }
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public boolean getAddProtein() {
        return addProtein;
    }

    @Override
    public String toString() {
        return String.format("Smoothie{name=%s, size=%s, numOfFruits=%d, addProtein=%b, price=%.2f}",
                getBevName(), getSize(), numOfFruits, addProtein, calcPrice());
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Smoothie smoothie = (Smoothie) anotherBev;
        return super.equals(smoothie) && numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein;
    }
}
