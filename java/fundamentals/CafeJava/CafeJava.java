public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 1.10;
        double lattePrice = 4.2;
        double cappuccinoPrice = 1.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.printf("Thank you for ordering the coffee, %s%s.\n", customer1, pendingMessage);
        if (isReadyOrder4) {
            System.out.printf("Hi, %s%s.\n", customer4, readyMessage);
        } else{
            System.out.printf("Hi, %s%s.\n",customer4, pendingMessage);
        }
        System.out.format("%s, %s%.2f.\n", customer2, displayTotalMessage, lattePrice*2);
        if (isReadyOrder2) {
            System.out.printf("%s%s.\n", customer2, readyMessage);
        }
        else{
            System.out.printf("%s%s.\n", customer2, pendingMessage);
        }

        System.out.printf("Aplogies for the mix-up, %s. You owe $%.2f more for the latte\n.", customer3, lattePrice - dripCoffeePrice);

    }
}
