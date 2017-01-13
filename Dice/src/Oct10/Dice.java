
package Oct10;

import java.security.SecureRandom;

/**
 *
 * @author NTHock
 */
public class Dice 
{
    private int numOfSides, faceValue;
    
    /**
    *constructor that accepts the# of the sides on the Dice object
    *@param initialNumberOfSides, valid range is 2-144
    */
    public Dice(int initialNumberOfSides)
    {
        setNumberOfSides(initialNumberOfSides);
        rollDice();
    }// end of constructor
    
    /**
     * This method will return the current face value of the die
     * @return 
     */
    public int getFaceValue(){
        return faceValue;
    }
    
    /**
     * This method will simulate rolling a dice object
     */
    public void rollDice()
    {
        SecureRandom rng = new SecureRandom();
        faceValue = rng.nextInt(numOfSides)+1;
    }
    
    /**
     * This method will validate that the number of sides is
     * within the range 2-144, if outside the range it will
     * create an IllegalArgumentException
     * @param numOfSides
     */
    public void setNumberOfSides(int numOfSides)
    {
        if (numOfSides < 2 || numOfSides > 144)
            throw new IllegalArgumentException("The number of sides must be 2-144");
        else
            this.numOfSides = numOfSides;
    }
}
