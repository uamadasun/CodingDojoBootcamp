import java.util.ArrayList;
import java.util.Arrays;

class TestCafe {
    public static void main(String[] args) {
        CafeUtil newInstance = new CafeUtil();

        //#1
        // System.out.println(newInstance.getStreakGoal());

        //#2
        double[] orderItems = {3.5, 1.5, 4.0, 4.5};
        // System.out.println(newInstance.getOrderTotal(orderItems));

        //#3
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");
        // newInstance.displayMenu(menuItems);

        //#4 
        ArrayList<String> allCustomers = new ArrayList<String>();
        // newInstance.addCustomer(allCustomers);
        // newInstance.addCustomer(allCustomers);
        // newInstance.addCustomer(allCustomers);

        //Senpai Bonus #1
        newInstance.printPriceChart("Columbian Coffee Grounds", 2.0, 4);

    }

}