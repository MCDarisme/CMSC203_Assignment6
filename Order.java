import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = cust;
        this.beverages = new ArrayList<>();
        this.orderNumber = generateOrder();
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }


    @Override
    public int compareTo(Order anotherOrder) {
        return Integer.compare(this.orderNumber, anotherOrder.orderNumber);
    }

    @Override
    public int findNumOfBeveType(Type type) {
        return (int) beverages.stream().filter(b -> b.getType() == type).count();
    }

    public int generateOrder() {
        return (int) (Math.random() * (90000 - 10000 + 1)) + 10000;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public int getOrderNo() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }
    
    public int getNumOfAlcoholDrink() {
        return (int) beverages.stream()
                              .filter(b -> b instanceof Alcohol)
                              .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{orderNumber=").append(orderNumber)
          .append(", orderTime=").append(orderTime)
          .append(", orderDay=").append(orderDay)
          .append(", customerName=").append(customer.getName())
          .append(", customerAge=").append(customer.getAge())
          .append(", beverages=").append(beverages)
          .append('}');
        return sb.toString();
    }
}
