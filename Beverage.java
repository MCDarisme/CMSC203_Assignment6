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
public abstract class Beverage {
    private String bevName;
    private Type type;
    private Size size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_PRICE = 0.5;

    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public Type getType() {
        return type;
    }

    public String getBevName() {
        return bevName;
    }

    public Size getSize() {
        return size;
    }

    public double addSizePrice() {
        return size == Size.SMALL ? 0 : SIZE_PRICE * (size.ordinal() - Size.SMALL.ordinal());
    }
    


    @Override
    public String toString() {
        return bevName + ", " + size;
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Beverage beverage = (Beverage) anotherBev;
        return bevName.equals(beverage.bevName) &&
               type == beverage.type &&
               size == beverage.size;
    }

    public double calcPrice() {
        return getBasePrice() + addSizePrice();
    }
}