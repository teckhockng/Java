package Oct10;

/**
 *
 * @author NTHock
 */
public class SnakeEyes {
    public static void main(String[] args)
    {
        //showing what happens with invalid creation of dice
        try{
        Dice die1 = new Dice(1);
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Sorry that was not valid # of sides");
        }
        Dice die1 = new Dice(6);
        Dice die2 = new Dice(6);
        
        System.out.printf("Die 1:%d", die1.getFaceValue());
        System.out.printf("Die 2:%d", die2.getFaceValue());
        
        int counter = 1;
        boolean snakeEyes = false;
        
        do{
            System.out.printf("Die1: %d Die2:%d Current Count: %3d%n", die1.getFaceValue(),die2.getFaceValue(),counter );
            
            die1.rollDice();
            die2.rollDice();
            counter++ ;
            snakeEyes = assessSnakeEyes(die1, die2);
        }while (!snakeEyes);
    }
    
    public static boolean assessSnakeEyes(Dice die1, Dice die2)
    {
        if (die1.getFaceValue() == 1 && die2.getFaceValue() == 1)
            return true;
        else
            return false;
    }
}
