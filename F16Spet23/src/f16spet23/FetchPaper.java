
package f16spet23;

import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class FetchPaper 
{
   public static void main(String[] args) //main method, void = nothing
   {
       System.out.printf("Hmmmm...I wonder what is in the paper today?%n");
       String headLine = getMeThePaper();
       
       System.out.printf("The big headline today is: \"%s\"%n", headLine);
       
       String password;
       
       do
       {  
       System.out.printf("%n%nWhat is your password?: "); //ask for password
       Scanner keyboard = new Scanner(System.in); // send pw for validation
       password = keyboard.nextLine(); //variable
       System.out.printf("%nLogin successful: %b%n", validatePassword(password));
       } while (!validatePassword(password));
       
       }   
       
   //access     no instance required   return type    name of the method
   public        static                 boolean      validatePassword(String pw)//Arguments are "local" variables to a method
   {
       if (pw.equalsIgnoreCase("123Password"))
           return true;
       else
           return false;
       
       //return pw.equalsIgnoreCase("123Password")
   }        
   
   public static String getMeThePaper() //
   {
       return "Yahoo had a major security breach";
   }
}
