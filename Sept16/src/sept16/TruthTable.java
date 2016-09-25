
package sept16;

/**
 *
 * @author NTHock
 */
public class TruthTable 
{
    public static void main(String[] args)
    {
        System.out.printf("TRUE AND TRUE = %s%n", true&&true );
        System.out.printf("FALSE AND TRUE = %s%n", false&&true );
        System.out.printf("FALSE AND FALSE = %s%n", false&&false );
        
        System.out.printf("TRUE OR TRUE = %s%n", true||true);
        System.out.printf("FALSE OR TRUE = %s%n", false||true);
        System.out.printf("FALSE OR FALSE = %s%n", false||false);
        
        //%n= new line %s= string
        System.out.printf("5 > 10 = %s%n", 5>10);
        System.out.printf("5 < 10 = %s%n", 5<10);
        System.out.printf("5 <= 10 = %S%n", 5>=10);
        System.out.printf("5 => 10 = %s%n", 5>=10);
        System.out.printf("5 == 10 = %s%n", 5==10);
        System.out.printf("5 == 5 = %s%n", 5==5);
        
    }
    
}
