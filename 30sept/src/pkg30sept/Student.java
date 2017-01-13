package pkg30sept;

import java.time.LocalDate;

/**
 *
 * @author NTHock
 */
public class Student {
    private int studentNum;
    private String firstName, lastName, emailAddress;
    private LocalDate dateOfBirth;
    
    public Student(int stNum, String firstN, String lastN, String emailAddress, LocalDate dob)
    {
        studentNum = stNum;
        firstName = firstN;
        lastName = lastN;
        this.emailAddress = emailAddress;// without this it will take it as local variable
        dateOfBirth = dob;
    }
    /**
    This returns the Student's first and last name
    */
    public String toString()
    {
        return firstName  +" "+ lastName;
    }
    
    /**
     * This method returns the students' age in years as an integer
     */
    public int getAge()
    {
        int currentYear = LocalDate.now().getYear();
        int yearBorn = dateOfBirth.getYear();
        
        return currentYear-yearBorn;
    }
}
