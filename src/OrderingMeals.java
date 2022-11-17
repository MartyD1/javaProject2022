
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
//import org.controlsfx.control.spreadsheet.Grid;

import java.io.IOException;

public class OrderingMeals extends Application{

    private Stage stage;
    private Scene mealStatusScene; //scene is jframe
    private Scene starterScene;
    private Scene mainCourseScene;
    private Scene dessertScene;
    private HBox hBox;
    private Button starterButton;
    private Button mainCourseButton;
    private Button dessertButton;
    private Button backButton;
    private Button refreshButton;
    TextArea tableStarters = new TextArea();
    TextArea tableMainCourse = new TextArea();
    TextArea tableDessert = new TextArea();
    TextArea textArea = new TextArea(
            "Table Order:\n"+
                    tableStarters.getText()+"\n"+
                    tableMainCourse.getText()+"\n"+
                    tableDessert.getText() );

    @Override
    public void start(Stage s) throws IOException{
        //sets up stage
        stage =s;
        stage.setTitle("Please select meal status");

        //set up frames
        mealStatusScene = createMealStatusScene();
        starterScene = createStarterScene();
        mainCourseScene = createMainCourseScene();
        dessertScene = createDessertScene();

        stage.setScene(mealStatusScene);

        stage.show();

    }

    private Scene createMealStatusScene(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        // TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(8);
        textArea.setPrefRowCount(15);

        textArea.setText("Table Order:\n"+
                tableStarters.getText()+"\n"+
                tableMainCourse.getText()+"\n"+
                tableDessert.getText() );

        starterButton =new Button("Starters");

        starterButton.setOnAction(e-> stage.setScene(starterScene));
        //initilaise button "Starters"
        //set up action of button- set jframe to starterScene.

        mainCourseButton= new Button("Main Course");
        mainCourseButton.setOnAction(e-> stage.setScene(mainCourseScene));

        dessertButton=new Button("Desserts");
        dessertButton.setOnAction(e-> stage.setScene(dessertScene));

        refreshButton=new Button("Refresh");
        refreshButton.setOnAction(e-> textArea.setText(
                "Table Order:\n"+
                        tableStarters.getText()+"\n"+
                        tableMainCourse.getText()+"\n"+
                        tableDessert.getText()
        ));

        //hBox=new HBox(starterButton, mainCourseButton, dessertButton);
        //places buttons horizontally
        // hBox.setStyle("-fx-background-color: cyan"); //colour

        gridPane.addColumn(1, starterButton,
                mainCourseButton, dessertButton, refreshButton);//x spaces between each button
        gridPane.add( textArea, 10, 1);//places textArea (10,1)
        gridPane.setStyle("-fx-background-color: cyan");

        mealStatusScene=new Scene(gridPane, 500, 500); //size of frame

        return mealStatusScene;
    }

    private Scene createStarterScene(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20); //divides frame x axis up by num
        gridPane.setVgap(20); //divides y axis

        //TextArea tableStarters = new TextArea();
        //textFeild- 1 row box
        //textArea- any # rows/columns
        tableStarters.setPrefColumnCount(8);
        tableStarters.setPrefRowCount(15);

        tableStarters.setText("\nStarters:");

        Button soupButton=new Button("Soup");
        soupButton.setOnAction(e->
                tableStarters.setText( tableStarters.getText()+ "\nSoup") );

        Button briegeButton=new Button("Briege");
        briegeButton.setOnAction(e->
                tableStarters.setText( tableStarters.getText()+ "\nBriege") );

        Button volivontButton=new Button("volivont");
        volivontButton.setOnAction(e->
                tableStarters.setText( tableStarters.getText()+ "\nVolivont") );

        backButton=new Button("back");
        backButton.setOnAction(e->stage.setScene(mealStatusScene) );
        //backButton.setOnAction(e-> textArea.setText("Yo"));
        // tableStarters.getText()+"\n"+
        // tableMainCourse.getText()+"\n"+
        // tableDessert.getText()
        // ) );

        // hBox=new HBox(soupButton);
        // hBox.setStyle("-fx-background-color: cyan");

        gridPane.addColumn(1, soupButton, briegeButton, volivontButton, backButton);//x spaces between each button
        gridPane.add( tableStarters, 10, 1);//places textArea (10,1)
        gridPane.setStyle("-fx-background-color: cyan");

        //GridPane.setColumnSpan(tableStarters, 10);

        starterScene=new Scene( gridPane, 500, 500);
        return starterScene;
    }

    private Scene createMainCourseScene(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        //TextArea tableMainCourse = new TextArea();

        tableMainCourse.setPrefColumnCount(8);
        tableMainCourse.setPrefRowCount(15);

        tableMainCourse.setText("\nMain Course:");

        Button beefButton=new Button("Beef");
        beefButton.setOnAction(e->
                tableMainCourse.setText( tableMainCourse.getText()+ "\nBeef") );

        Button pizzaButton=new Button("Pizza");
        pizzaButton.setOnAction(e->
                tableMainCourse.setText( tableMainCourse.getText()+ "\nPizza") );

        Button backButton=new Button("back");
        backButton.setOnAction(e-> stage.setScene(mealStatusScene) );

        gridPane.addColumn(1, beefButton, pizzaButton, backButton);//x spaces between each button
        gridPane.add( tableMainCourse, 10, 1);
        gridPane.setStyle("-fx-background-color: cyan");

        mainCourseScene=new Scene( gridPane, 500, 500);
        return mainCourseScene;
    }

    private Scene createDessertScene(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        //TextArea tableDessert = new TextArea();

        tableDessert.setPrefColumnCount(8);
        tableDessert.setPrefRowCount(15);

        tableDessert.setText("\nDesserts:");

        Button iceCreamButton=new Button("Ice Cream");
        iceCreamButton.setOnAction(e->
                tableDessert.setText( tableDessert.getText()+ "\nIce Cream") );

        Button brownieButton=new Button("Brownie");
        brownieButton.setOnAction(e->
                tableDessert.setText( tableDessert.getText()+ "\nBrownie") );

        Button backButton=new Button("back");
        backButton.setOnAction(e-> stage.setScene(mealStatusScene) );

        gridPane.addColumn(1, iceCreamButton, brownieButton, backButton);//x spaces between each button
        gridPane.add( tableDessert, 10, 1);
        gridPane.setStyle("-fx-background-color: cyan");

        dessertScene=new Scene( gridPane, 500, 500);
        return dessertScene;
    }

    public static void main(String[] args) {
        launch();
    }

}