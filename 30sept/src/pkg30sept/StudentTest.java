package pkg30sept;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author NTHock
 */
public class StudentTest {
    public static void main(String[] args)
    {
        Student nicholas = new Student(10001, "Nicholas", "Plume", "np@netFlixView.com",
                LocalDate.of(1995, Month.FEBRUARY, 21));
        Student teck = new Student(10002, "Teck", "Hock Ng", "teck@youtubeViewer.com",
                LocalDate.of(1997, Month.MAY, 25));
        
        System.out.printf("Student Nicholas: %s%n", nicholas.toString());
        System.out.printf("Student Teck: %s%n", teck.toString());
        
        System.out.printf("%n%s is %d years old", nicholas.toString(), nicholas.getAge());
        System.out.printf("%n%s is %d years old", teck.toString(), teck.getAge());
        
    }
    
}
