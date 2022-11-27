import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class CafeUtil {
    
    public int getStreakGoal() {
        int numWeeks = 10;
        int sum = 0;
        for (int i = 1; i<numWeeks+1;i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for(double price:prices) {
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i<menuItems.size(); i++) {
            System.out.format("%d %s\n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %d people in front of you.\n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        double discount = 0.5;
        for (int i = 1; i<maxQuantity + 1; i++) {
            if(i>1) {
                String sentence = String.format("%d - $%.2f\n", i, (i*price)-discount);
                discount += 0.5;
                System.out.print(sentence);
            }
            else {
                String sentence = String.format("%d - $%.2f\n", i, i*price);
                System.out.print(sentence);
            }
        }
    }



}