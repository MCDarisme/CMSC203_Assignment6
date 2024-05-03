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
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private static final double EXTRA_SHOT_PRICE = 0.50;
    private static final double EXTRA_SYRUP_PRICE = 0.50;

    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public double calcPrice() {
        double price = super.calcPrice();
        if (extraShot) {
            price += EXTRA_SHOT_PRICE;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_PRICE;
        }
        return price;
    }

    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    @Override
    public String toString() {
        return String.format("Coffee{name=%s, size=%s, extraShot=%b, extraSyrup=%b, price=%.2f}",
                getBevName(), getSize(), extraShot, extraSyrup, calcPrice());
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Coffee coffee = (Coffee) anotherBev;
        return super.equals(coffee) && extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }
}
