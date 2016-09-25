package sept16;

import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class Temperature 
{
    public static void main(String[] args)//args= argument
    {
        //Prompt the use for the temperature
        System.out.print("What is the temperature outside?");
        
        //get the temperature from the user
        Scanner keyboard = new Scanner(System.in);
        
        //Datatype     variable name
        double            temperature = keyboard.nextDouble();
        
        //display the temperature to the screen
        System.out.println("\nThe temperature is " + temperature + " Celcius.");
        
        //This will check if the temperature is both greater than or equal to 
        //20 AND less than 30
        if ((temperature >= 20) && (temperature < 30))
            System.out.printf("%nIt's a good day for shorts");
        
        if (temperature == 15)
            System.out.printf("%nGood day for sweater");
        
        
        
        
    }
}
