package pkg18nov2016;

/**
 *
 * @author NTHock
 */
public class WarmUp {
    public static void main (String[] args)
    {
        int[] weather = {12 ,0, 0, 1, 2, 3, 4};
        
        int warmestTemp = getWarmestTemp(weather);
        System.out.printf("The warmest day has a temperature of %d%n", warmestTemp);
        
    }//end of main method
    
    /*
    This method receives an array of temperatures and returns the highest value
    */
    public static int getWarmestTemp(int[] temps)
    {
        int highest = temps[0];
        
        for (int i=1; i < temps.length; i++)
        {
            if (temps[i] > highest)
                highest = temps[i];
        }
        
        return highest;
    }
}
