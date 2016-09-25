
package f16spet23;

import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class Greeting {
    public static void main(String[] args)
    {
        String user = getUserName();
        sendGreeting(user);
    }
    
    /**
     * The getUserName method will prompt the user for their name and
     * return it to the calling function
     * @return 
     */
    
    public static String getUserName()
    {
        System.out.printf("What's your name?");
        Scanner keyboard = new Scanner(System.in);
        String getUserName = keyboard.nextLine();
        return getUserName;
    }

   
    
    
    /**
     * The sendGreeting method accepts a String representing the users name
     * and prints "hello" and the users name to the screen
     */
    public static void sendGreeting(String user) 
    {
        System.out.printf("Hello %s", user); 
    }
    
    
}
