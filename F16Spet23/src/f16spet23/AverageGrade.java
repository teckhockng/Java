
package f16spet23;

import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class AverageGrade 
{
    public static void main(String[] args)
    {
        //ask the user to enter grade
        System.out.printf("Please enter course grade: ");
        Scanner keyboard = new Scanner(System.in);
        double grade1 = keyboard.nextDouble();
        System.out.printf("Please enter course grade: ");
        double grade2 = keyboard.nextDouble();
        System.out.printf("Please enter course grade: ");
        double grade3 = keyboard.nextDouble();
        System.out.printf("Please enter course grade: ");
        double grade4 = keyboard.nextDouble();
        System.out.printf("Please enter course grade: ");
        double grade5 = keyboard.nextDouble();
        
        //calculate average
        double avg = calculateAverage(grade1, grade2, grade3, grade4, grade5);
        
        //display average
        System.out.printf("Your average grade is  %.1f ", avg);
        
       
    }//end of main method
    /**
     * This method accepts 5 integers and returns the average
     * of them as double
     */
    public static double calculateAverage(double g1, double g2, double g3, double g4, double g5)
    {
      return   (g1+g2+g3+g4+g5)/5 ;
    }    
            
}
