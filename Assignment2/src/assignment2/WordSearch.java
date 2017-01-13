package assignment2;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NTHock
 */
public class WordSearch {
    private char[][] grid;
    private int numOfWords;
    private String[] words ;
    
    /**
     * This constructor will get the number of words
     * @param args 
     */
    public WordSearch()
    {   
    numOfWords = getNumWords();    
    grid = new char[numOfWords][numOfWords];    
    }//end of constructor
    
    
    public static void main (String[] args)
    {
        WordSearch myPuzzle = new WordSearch();
        myPuzzle.getWords();
        myPuzzle.fillEmpties();
        System.out.println(myPuzzle.toString());
        //bonus
        myPuzzle.printToFile();
    }// end of main method
    
    /**
     * This method will get the number of words from user
     */
    public int getNumWords()
    {
        Scanner keyboard = new Scanner(System.in);
        int numOfWords = 0;
        
        do{
            
            System.out.printf("How many words will go in the puzzle? ");
            try{
                numOfWords = keyboard.nextInt();
                }catch (InputMismatchException | NullPointerException ex){
                    System.out.printf("Please enter a number between 5 - 20%n");
                    
                }
                           
        }while (numOfWords > 20 || numOfWords < 5);
        
        return numOfWords;
    }
    /**
     * This method will get the words from the user and validate it
     * 
     */
    public void getWords()
    {
        Scanner keyboard = new Scanner(System.in);
        String[] words = new String[numOfWords];
        
        
        for (int i = 0; i< words.length; i++){
            do{
                System.out.printf("Please enter a new word: ");
                words[i] = keyboard.nextLine().trim().toUpperCase();
                try{ //check if the word entered contains space
                
                    if (words[i].contains(" "))
                            throw new IllegalArgumentException("words cannot have spaces in them%n");
                }
                catch (IllegalArgumentException exception)
                {
                        if (i < 1){
                            try{
                                System.out.printf("%s: words cannot have spaces in them%n", exception);
                                Arrays.asList(words).remove(words[i]);
                            }catch(ArrayIndexOutOfBoundsException |UnsupportedOperationException e){
                                i++;
                            }
                        }else
                            System.out.printf("%s: words cannot have spaces in them%n", exception);
                            i -= 1;
                }
                try{ //check if the word entered is too short
                if (words[i].length() < 2)
                        throw new IllegalArgumentException();
                }
                catch (IllegalArgumentException  exception)
                {
                        if (i < 1){
                            try{
                                Arrays.asList(words).clear();
                            }catch(ArrayIndexOutOfBoundsException |UnsupportedOperationException e){
                                System.out.printf("%s: %s is too short for this puzzle, it must be at least 2 characters%n",exception, words[i]);
                                i++;
                            }
                        }else
                            System.out.printf("%s: %s is too short for this puzzle, it must be at least 2 characters%n",exception, words[i]);
                            i -= 1;
                }
                try{ //check if the word entered is too long
                    if (words[i].length() > numOfWords)
                        throw new IllegalArgumentException();
                }
                catch (IllegalArgumentException exception)
                {
                    if (i < 1){
                        try{
                            System.out.printf("%s: %s is too long for this puzzle, it must be %d characters or less%n",exception, words[i],numOfWords);
                            Arrays.asList(words).remove(words[i]);
                        }catch(ArrayIndexOutOfBoundsException |UnsupportedOperationException e){
                            i++;
                        }
                    }else
                    System.out.printf("%s: %s is too long for this puzzle, it must be %d characters or less%n",exception, words[i],numOfWords);
                    i -= 1;
            }
        }while(words[i].contains(" ") | words[i].length()>words.length| words[i].length()<2);
            
            try{ //check if the word entered is already entered
                for (int j =0; j< words.length; j++){
                    if (words[i].equalsIgnoreCase(words[j]) && i != j)
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException exception)
            {
                    System.out.printf("%s: That word is already in the word list%n", exception);
                    i -= 1;
            }
            
        }// end of for loop
        
        Arrays.sort(words);
        this.words = words;
    }// end of getWords() method
    
    
    
    /**
     * Fill up the grid with chars
     */
    public void fillEmpties()
    {
        Random rng = new SecureRandom();
       
       for (int row = 0; row < grid.length; row++)
        {
            
            String word = words[row];
            int random = rng.nextInt((grid.length - word.length())+1);
            
            for (int col =0; col <words[row].length(); col++)
            {
                grid[col+random][row] = word.charAt(col);
            }//end of column for loop
        }   //end of row for loop
       
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
            'S','T','U','V','W','X','Y','Z'};
        
            
        boolean nothing = true;    
        for (int row = 0; row < grid.length; row++)
        {
            for (int col =0; col <grid.length; col++)
            {
                if(grid[row][col] != 0)
                    nothing= false;
               else
                    grid[row][col] = Array.getChar(letters, rng.nextInt(26));
            }//end of column for loop
        }   //end of row for loop
      
    }
    
    /**
     * Converts grid to string with the list of words
     * @return 
     */
    public String toString()
    {
        String string= "";
        for (int row = 0; row < grid.length; row++)
        {
            for (int col =0; col <grid.length; col++)
            {
                    string += String.format("%3c", grid[row][col]);
            }//end of column for loop
            
                string += String.format("%n");
        }   //end of column for loop
        
        string += String.format("%n");
        string += String.format("Here are the words to find: %n");
        
        for (int i=0; i< words.length;i++) {
            string += String.format("%s%n",words[i]);
        }
        
        return string ;
    
}
    /**
     * This will print the grid and words to a file called "puzzle.txt"
     */
    public void printToFile()
    {
        
        String string= "";
        string += toString();
        try {
            Formatter outputStream = new Formatter("puzzle.txt");
            outputStream.format(string);
            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("Sorry I cannot write to the file");
        }
            
        
    }//end of printToFile method
}