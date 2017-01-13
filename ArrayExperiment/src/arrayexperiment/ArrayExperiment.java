package arrayexperiment;

import java.security.SecureRandom;

/**
 *
 * @author NTHock
 */
public class ArrayExperiment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //to declare a new array
        int[] grades = new int[5];
        System.out.printf("The initial value in position 0 is '%d'%n", grades[0]);
        
        //set the initial values for our array of grades
        grades[0] = 75;
        grades[1] = 92;
        grades[2] = 94;
        grades[3] = 77;
        grades[4] = 87;
        
        //create a loop to print the content of the array
        for (int i=0; i < grades.length; i++)
        {
            System.out.printf("The grade in position (or index) %d is %d%n", i, grades[i]);
        }
        
        System.out.printf("The average grade is %.1f %n",average(grades));
        
        int[] grades2 = {87, 92, 33, 101, 98, 88, 79, 70, 66, 100, 99, 86};
        System.out.printf("The average grade is %.1f %n",average(grades2));
        
        //create 1000 random numbers in the range of 1-10. Keep track of how many
        //times each number came up and then display rhe results
        SecureRandom rng = new SecureRandom();
        int[] rnCounter = new int[10];
        
        //count the random numbers
        for (int i=1; i <= 1000; i++)
        {
            rnCounter[rng.nextInt(10)]++;
        }
        
       
        //display the results
        
        for (int i=0; i < rnCounter.length; i++)
        {
            System.out.printf("%2d: %4d%n", i+1, rnCounter[i]);
        }
    }//end of main method
    
    /**
     * This method receive an array of integers and return the average
     * as double
     */
    public static double average(int[] intArray)
    {
        int sum = 0;
        
        //create a loop to go over the array and add elements
        //to the variable sum
        for (int i =0; i < intArray.length; i++)
        {
            sum = sum + intArray[i];
            System.out.printf("When i = %d, the sum is %d%n", i ,sum);
        }
        
        return (double) sum/intArray.length;
    }
    
}//end of the class
