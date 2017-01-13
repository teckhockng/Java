package assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author NTHock
 */


public class Assignment2Gui extends Application{
    
    Stage window;
    Scene scene1, scene2, scene3;
    TextField wordInput;
    private int numOfWords;
    TableView<Words> table;
    private String updateLabel;
    ArrayList<String> wordList;
    private char[][] grid;
    Spinner<Integer> spinner;
    ObservableList<Words> words = FXCollections.observableArrayList();
    
    public Assignment2Gui(){
    wordList = new ArrayList<>();

}
    
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Create Word Search");
        
        Label sizeOfPuzzle = new Label();
        sizeOfPuzzle.setText("Size of Puzzle");
        sizeOfPuzzle.setStyle("-fx-text-fill: green;");
        
        spinner = new Spinner(5,20,5);
       
        
        Button createPuzzle = new Button();
        createPuzzle.setText("Create Puzzle");
        createPuzzle.setOnAction((e -> setScene2()));
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(sizeOfPuzzle, spinner);
        
        VBox verticalLayout = new VBox(10);
        verticalLayout.setPadding(new Insets(10,10,10,10));
        verticalLayout.getChildren().addAll(hBox, createPuzzle);
        
        scene1 = new Scene(verticalLayout, 400, 400);
        window.setScene(scene1);
        window.show();
    }// end of Start
    
    public void setScene2()
    {
        window.setTitle("Add Words to Puzzle");
        
        wordInput = new TextField();
        wordInput.setPromptText("Enter new word");
        wordInput.setMinWidth(80);
        
        //word table 
        TableColumn<Words,String> wordTable = new TableColumn<>();
        wordTable.setMinWidth(400);
        wordTable.setCellValueFactory(new PropertyValueFactory<>("words"));
        
        table = new TableView<>();
        table.setItems(getWords());
        table.getColumns().addAll(wordTable);
        
        Label label = new Label("");
        
        Label word = new Label("Word List");
        
        Button addButton = new Button("Add word to Puzzle");
        
        addButton.setOnAction(e -> addButtonClicked(label));
        
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(wordInput, addButton);
        
        VBox verticalLayout = new VBox(10);
        verticalLayout.setPadding(new Insets(10,10,10,10));
        verticalLayout.getChildren().addAll(hBox, word, table, label);
        
        scene2 = new Scene(verticalLayout, 400, 400);
        window.setScene(scene2);
        window.show();
        
        numOfWords = spinner.getValue();
        grid = new char[numOfWords][numOfWords];
    }//end of setScene2 method
    
    public void addButtonClicked(Label label)
    {
        String word="";
        try{
            word = wordInput.getText().trim().toUpperCase();
            wordInput.setStyle("-fx-text-box-border: blue");
            Words newWord = new Words();
            newWord.setWords(validateWord(word));
            table.getItems().add(newWord);
            wordList.add(word);
        }catch(IllegalArgumentException e ){
            updateLabel = e.getMessage();
            wordInput.setStyle("-fx-text-box-border: red");
            label.setText(updateLabel);
        }
        wordInput.clear();
        
        if (wordList.size() == numOfWords)
        {
            setScene3();
        }
        System.out.printf("%d %s", numOfWords, wordList);
        //System.out.printf("The grid length is %d",  grid.length);
    }// end of addButtonClicked method
    
    /**
     * This method will validate the words entered
     * @return 
     */
    public String validateWord(String word){
        
         //validate words doesnt have space between them
        if (word.contains(" ")){
            throw new IllegalArgumentException(String.format("Words cannot have spaces in them"));
        }
        //validate words isnt too short
        if (word.length()<2){
            throw new IllegalArgumentException(String.format("%s is too short for this puzzle, it must be at least 2 characters",word));
        }
        //validate words isnt too long
        if (word.length() > numOfWords){
            throw new IllegalArgumentException(String.format("%s is too long for this puzzle, it must be %d characters or less%n",word, numOfWords));
        }
        //validate words isnt repeated
        if (wordList.size()> 0){
            for (int i= 0; i< wordList.size(); i++)
            {
                if(word.equalsIgnoreCase(wordList.get(i)) ){
                    throw new IllegalArgumentException(String.format("That word is already in the word list"));
                }
            }
        }
        return word;
    }
    public ObservableList<Words> getWords(){
        
        return words;
       }
    
    
    public void fillEmpties()
    {
        Random rng = new SecureRandom();
       
       for (int row = 0; row < grid.length; row++)
        {
            
            String word = wordList.get(row);
            int random = rng.nextInt((grid.length - word.length())+1);
            
            for (int col =0; col <wordList.get(row).length(); col++)
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
        
        for (int i=0; i< wordList.size();i++) {
            string += String.format("%s%n",wordList.get(i));
        }
        
        return string ;
    }

    public void setScene3() {
        window.setTitle("Add Words to Puzzle");
        Collections.sort(wordList);
            
        fillEmpties();
        Label puzzle = new Label(toString());
        
        Button sendToFile = new Button("Send to File");
        sendToFile.setOnAction(e -> sendToFile());
        
        Button horizontal = new Button("Horizontal");
        horizontal.setOnAction(e -> horizontal(puzzle));
        
        Button vertical = new Button("Vertical");
        vertical.setOnAction(e -> vertical());
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(sendToFile, horizontal, vertical);
        
        VBox verticalLayout = new VBox(10);
        verticalLayout.setPadding(new Insets(10,10,10,10));
        verticalLayout.getChildren().addAll(puzzle, hBox);
        
        scene3 = new Scene(verticalLayout, 700, 800);
        window.setScene(scene3);
        window.show();
    }
    
    /**
     * Send the puzzle to a file
     */
    public void sendToFile()
    {
        FileChooser fileChooser = new FileChooser();
  
              //Set extension filter
              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
              fileChooser.getExtensionFilters().add(extFilter);
              
              //Show save file dialog
              File file = fileChooser.showSaveDialog(window);
              
              if(file != null){
                  SaveFile(toString(), file);
              }
          }
      
    public void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            
        }
         
    } 
    public void vertical()
    {
        setScene3();
    }
    
    public void horizontal(Label puzzle)
    {
        Random rng = new SecureRandom();
       
       for (int row = 0; row < grid.length; row++)
        {
            
            String word = wordList.get(row);
            int random = rng.nextInt((grid.length - word.length())+1);
            
            for (int col =0; col <wordList.get(row).length(); col++)
            {
                grid[row][col+random] = word.charAt(col);
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
        
        String changeLabel = toString();
        puzzle.setText(changeLabel);
    }
}//end of class
