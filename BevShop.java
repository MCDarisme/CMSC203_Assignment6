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
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BevShop implements BevShopInterface {
    private List<Order> orders = new ArrayList<>();

    public BevShop() {
        orders = new ArrayList<>();
    }

    @Override
    public boolean isEligibleForMore() {
        Order currentOrder = getCurrentOrder();
        return currentOrder != null && currentOrder.getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        Order currentOrder = getCurrentOrder();
        return currentOrder != null ? currentOrder.getNumOfAlcoholDrink() : 0;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Order newOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(newOrder);
    }


    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null;
    }

    @Override
    public double totalMonthlySale() {
        return orders.stream().mapToDouble(Order::calcOrderTotal).sum();
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        getCurrentOrder().addNewBeverage(bevName, size);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }
    
    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }
    
    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }


    @Override
    public String toString() {
        return "BevShop{" +
               "orders=" + orders +
               '}';
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }


	@Override
	public int getMinAgeForAlcohol() {
	    return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public int getMaxOrderForAlcohol() {
	    return MAX_ORDER_FOR_ALCOHOL;
	}


	@Override
	public int findOrder(int orderNo) {
	    for (int i = 0; i < orders.size(); i++) {
	        if (orders.get(i).getOrderNo() == orderNo) {
	            return i;
	        }
	    }
	    return -1; 
	}

	@Override
	public double totalOrderPrice(int orderNo) {
	    int index = findOrder(orderNo);
	    if (index != -1) {
	        return orders.get(index).calcOrderTotal();
	    }
	    return 0; 
	}

	@Override
	public void sortOrders() {
	    Collections.sort(orders); 
	}
}
