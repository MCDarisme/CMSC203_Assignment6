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
public class Alcohol extends Beverage {
    private boolean weekendOffer;
    private static final double WEEKEND_SURCHARGE = 0.60;

    public Alcohol(String bevName, Size size, boolean weekendOffer) {
        super(bevName, Type.ALCOHOL, size);
        this.weekendOffer = weekendOffer;
    }

    
    public double calcPrice() {
        double price = super.calcPrice();
        if (weekendOffer) {
            price += WEEKEND_SURCHARGE;
        }
        return price;
    }

    public boolean isWeekendOffer() {
        return weekendOffer;
    }

    public void setWeekendOffer(boolean weekendOffer) {
        this.weekendOffer = weekendOffer;
    }

    @Override
    public String toString() {
        return String.format("Alcohol{name=%s, size=%s, weekendOffer=%b, price=%.2f}",
                getBevName(), getSize(), weekendOffer, calcPrice());
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Alcohol alcohol = (Alcohol) anotherBev;
        return super.equals(alcohol) && weekendOffer == alcohol.weekendOffer;
    }
}

