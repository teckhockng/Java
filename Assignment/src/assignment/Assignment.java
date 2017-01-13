package assignment;

import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class Assignment {

    public static void main(String[] args) 
    {
        
       double grade1 = getGrade();
       double grade2 = getGrade();
       double grade3 = getGrade();
       double grade4 = getGrade();
       double grade5 = getGrade();
       double overall = getOverall(grade1,grade2,grade3,grade4,grade5);
       
        
        
        
        System.out.printf("%nThe mark for the first course was %.0f%%, the letter grade is %s ", grade1,getLetterGrade(grade1));
        System.out.printf("%nThe mark for the second course was %.0f%%, the letter grade is %s ", grade2,getLetterGrade(grade2));
        System.out.printf("%nThe mark for the third course was %.0f%%, the letter grade is %s ", grade3,getLetterGrade(grade3));
        System.out.printf("%nThe mark for the fourth course was %.0f%%, the letter grade is %s ", grade4,getLetterGrade(grade4));
        System.out.printf("%nThe mark for the fifth course was %.0f%%, the letter grade is %s ", grade5,getLetterGrade(grade5));
        System.out.printf("%nThe overall average mark is %.1f%%, which is a letter grade of %s%n ", overall, getLetterGrade(overall));
    }   
        public static double getGrade()
        {
            System.out.printf("Please enter a grade: ");
            Scanner keyboard = new Scanner(System.in);
            return  keyboard.nextDouble();
        }
        
        
        public static String getLetterGrade(double letterGrade)
        {
        String getLetterGrade = "";
            //identify the letter grade for overall grade
        if ((letterGrade <= 100) && (letterGrade >= 80))
            getLetterGrade = "A";
        else if ((letterGrade >= 70) && (letterGrade <= 79))
            getLetterGrade = "B";
        else if ((letterGrade >= 60) && (letterGrade <= 69))
            getLetterGrade = "C";
        else if ((letterGrade >= 50) && (letterGrade <= 59))
            getLetterGrade = "D";
        else if ((letterGrade >= 0) && (letterGrade <= 49))
            getLetterGrade = "E";
        else getLetterGrade = "Unapplicable";
        return getLetterGrade;
        }
        
        public static double getOverall(double grade1,double grade2,double grade3,double grade4,double grade5)
        {
            return (grade1 + grade2 + grade3 + grade4 + grade5)/5 ;
        }
        
        
        
        
                
        
        
   
    
    
}
