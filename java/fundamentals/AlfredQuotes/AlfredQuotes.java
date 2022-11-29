import java.util.Date;
import java.text.SimpleDateFormat; 


public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s. Lovely to see you.", name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE  
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");  
        String strDate = dateFormat.format(date); 
        return String.format("It is currently %s.", strDate);
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        String alexis = "Alexis";
        String alfred = "Alfred";

        if(conversation.indexOf(alexis) >= 0) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if(conversation.indexOf(alfred) >= 0) {
            return "At your service. As you wish, naturally.";
        }
        return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

