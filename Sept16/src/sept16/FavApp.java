
package sept16;

import java.util.Scanner;


public class FavApp {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        

        //Prompt the user to enter first app
        System.out.print("What is your favourite app ?");
        String app1 = keyboard.nextLine ();
    
        //Prompt the user to enter second app
        System.out.print("What is your favourite app ?");
        String app2 = keyboard.nextLine();
        
        //Prompt the user to enter third app
        System.out.print("What is your favourite app ?");
        String app3 = keyboard.nextLine();
        
        //Prompt the user to enter fourth app
        System.out.print("What is your favourite app ?");
        String app4 = keyboard.nextLine();
        
        //Prompt the user to enter fifth app
        System.out.print("What is your favourite app ?");
        String app5 = keyboard.nextLine();
        
        
        
        //print a line that says "Your favourite apps are: ", then list each of the apps seperated by a comma
        System.out.printf("Your favourite apps are: %s, %s, %s, %s, %s ! Have a good day!", app1,app2,app3,app4,app5);
    }
    
}
