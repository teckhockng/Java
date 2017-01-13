package assignment;
import java.util.stream.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author NTHock
 */
public class AssignmentGui extends Application {
    
    Stage window;
    TableView<Course> table;
    TextField nameInput, codeInput, instructorInput, markInput;
    
  
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Courses and Grades");
        
        Label labelc = new Label("The average mark is 100 which translate to a letter of A");
        
        
        //Name Column
        TableColumn<Course, String> nameColumn = new TableColumn<>("Course Name");
        nameColumn.setMinWidth(220);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
         //Code Column
        TableColumn<Course, String> codeColumn = new TableColumn<>("Course Code");
        codeColumn.setMinWidth(220);
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        
        //Name Instructor
        TableColumn<Course, String> instructorColumn = new TableColumn<>("Instructor");
        instructorColumn.setMinWidth(220);
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        
        //Name mark
        TableColumn<Course, Integer> markColumn = new TableColumn<>("Mark");
        markColumn.setMinWidth(220);
        markColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));
        
        
        
      
        
        //Lettergrade Column
        TableColumn<Course, String> letterColumn = new TableColumn<>("Letter Grade");
        letterColumn.setMinWidth(220);
        letterColumn.setCellValueFactory(new PropertyValueFactory<>("letter"));
        
        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Course Name");
        nameInput.setMinWidth(100);
        
         //code input
        codeInput = new TextField();
        codeInput.setPromptText("Course Code");
        codeInput.setMinWidth(80);
        
         //Instructor input
        instructorInput = new TextField();
        instructorInput.setPromptText("Instructor");
        instructorInput.setMinWidth(80);
        
         //mark input
        markInput = new TextField();
        markInput.setPromptText("Mark");
        markInput.setMinWidth(80);
        
        //button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked(labelc));
        
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked(labelc));
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, codeInput, instructorInput, markInput, addButton, deleteButton,labelc);
        
        
        table = new TableView<>();
        table.setItems(getCourse());
        table.getColumns().addAll(nameColumn, codeColumn, instructorColumn, markColumn, letterColumn);
        
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);
        
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
        
        
    }
    
    
    
    //Add Button Clicked
    public void addButtonClicked(Label labelc){
        Course newCourse = new Course();
        newCourse.setName(nameInput.getText());
        newCourse.setCode(codeInput.getText());
        newCourse.setInstructor(instructorInput.getText());
        newCourse.setMark(Integer.parseInt(markInput.getText()));
        newCourse.setLetter();
        
        
        
        table.getItems().add(newCourse);
        
        double Overall = table.getItems().stream().collect(Collectors.averagingDouble((course) -> course.getMark()));
        String getLetterGrade = "";
            //identify the letter grade for overall grade
        if ((Overall <= 100) && (Overall >= 80))
            getLetterGrade = "A";
        else if ((Overall >= 70) && (Overall <= 79))
            getLetterGrade = "B";
        else if ((Overall >= 60) && (Overall <= 69))
            getLetterGrade = "C";
        else if ((Overall >= 50) && (Overall <= 59))
            getLetterGrade = "D";
        else if ((Overall >= 0) && (Overall <= 49))
            getLetterGrade = "E";
        else getLetterGrade = "Unapplicable";
        String updateLabel = String.format("The average mark is %.1f which translate to a letter of %s", Overall,getLetterGrade);
        labelc.setText(updateLabel);
        
        
       
        
        nameInput.clear();
        codeInput.clear();
        instructorInput.clear();
        markInput.clear();
        
        
        
}
    
    

    
    
    //delete button clicked
    public void deleteButtonClicked(Label labelc){
       
        ObservableList<Course> courseSelected, allCourse;
        allCourse = table.getItems();
        courseSelected = table.getSelectionModel().getSelectedItems();
        
        courseSelected.forEach(allCourse::remove);
        double Overall = table.getItems().stream().collect(Collectors.averagingDouble((course) -> course.getMark()));
        String getLetterGrade = "";
            //identify the letter grade for overall grade
        if ((Overall <= 100) && (Overall >= 80))
            getLetterGrade = "A";
        else if ((Overall >= 70) && (Overall <= 79))
            getLetterGrade = "B";
        else if ((Overall >= 60) && (Overall <= 69))
            getLetterGrade = "C";
        else if ((Overall >= 50) && (Overall <= 59))
            getLetterGrade = "D";
        else if ((Overall >= 0) && (Overall <= 49))
            getLetterGrade = "E";
        else getLetterGrade = "Unapplicable";
        String updateLabel = String.format("The average mark is %.1f which translate to a letter of %s", Overall,getLetterGrade);
        labelc.setText(updateLabel); 
        
    }
    
    
    
    
    public ObservableList<Course> getCourse(){
        ObservableList<Course> course = FXCollections.observableArrayList();
        
        course.add(new Course("Programming Fundamentals","COMP 1030","Jaret Wright","A",100));
        course.add(new Course("Web Fundamentals","COMP 1002","Scott Mccrindle","A",100));
        course.add(new Course("Math for Computer ","MATH 1003","Anju Chawla","A",100));
        course.add(new Course("Communication Essentials","COMM 1016","Cornelius Van Vuuren","A",100));
        course.add(new Course("Internet of Things","COMP 1045","Ross Bigelow","A",100));
        return course;
        
        
    }
    
    
   
    
}
