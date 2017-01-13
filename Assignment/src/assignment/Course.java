
package assignment;

/**
 *
 * @author NTHock
 */
public class Course {
    private String name;
    private String code; 
    private String instructor;
    private int mark;
    private String letter;
    private int average;
    
    
    public Course(){
        this.name = "";
        this.code = "";
        this.instructor = "";
        this.letter = "";
        this.mark = 0;
      
    }
    
    public Course(String name, String code, String instructor, String letter, int mark){
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.letter = letter;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    
            

    public String getLetter() {
        return letter;
    }

    public void setLetter() {
         if ((mark <= 100) && (mark >= 80))
            letter = "A";
        else if ((mark >= 70) && (mark <= 79))
            letter = "B";
        else if ((mark >= 60) && (mark <= 69))
            letter = "C";
        else if ((mark >= 50) && (mark <= 59))
            letter = "D";
        else if ((mark >= 0) && (mark <= 49))
            letter = "F";
        else letter = "Unapplicable";
    }
    
    
    
    
}
