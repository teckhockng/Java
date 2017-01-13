/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class WarmUp 
{
    public static void main(String[]args )
    {
        
        System.out.printf("Enter your name");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        System.out.printf("Enter the year you're born");
        int year = keyboard.nextInt();
        
        int age = getAge(year);
        
        System.out.printf("%s, you are %d years old%n%n", name, age);
        
    }
    
    /**
     *
     * @return
     */
    public static int getAge(int year)
    {
       return LocalDate.now().getYear() -  year; 
    }

    
}
