
package sept16;

import java.util.Scanner;


public class TipCalculator 
{
    public static void main(String[] args)
    {
        //Prompt the user for the meal amount
        System.out.print("Meal amount = ");
        
        //Read and store the user's input in a double
        Scanner keyboard = new Scanner(System.in);
        double mealAmount = keyboard.nextDouble();
        
        //Prompt the user for the tip %
        System.out.print("TipPercentage = ");
        
        //Read and store the tip percentage
        double tipPercent = keyboard.nextDouble();
        
        //convert the tip % to a decimal number
        tipPercent = tipPercent/100;
        
        //calculate the tip in $
        double tipTotal = mealAmount * tipPercent;
        
        //display the tip amount
        System.out.printf("Tip = %.0f%n", tipTotal);
        
    }
            
    
}
