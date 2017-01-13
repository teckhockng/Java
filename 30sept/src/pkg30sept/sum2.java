package pkg30sept;

import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class sum2 
{
 
    public static void main(String[] args)
{
    System.out.print("First number");
    Scanner keyboard = new Scanner(System.in);
    
    double num1 = keyboard.nextDouble();
    System.out.print("Second number");
    
    double num2 = keyboard.nextDouble();
    
    //send the numbers to a method called sum
    double add = sum (num1,num2);
    
    System.out.printf("Sum of both number is %f", add);
   
}

//                   method name    assign value(double)to num1
public static double sum(           double num1,double num2)
{
   return  num1 + num2;
}
}