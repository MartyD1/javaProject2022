import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingApp extends Application {

    private Stage stage;

    private Scene mainMenuScene;
    private VBox vboxMenu;
    private Button bookingButton;
    private Button cancelButton;
    private Button showButton;


    private Button menuButton;

    private Scene bookingScene;
    private Scene cancelScene;
    private Scene showScene;
    private VBox vboxFunction;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setTitle("Switching Scenes -- Reservations");

        mainMenuScene = createMainMenuScene();
        bookingScene = createBookingScene();
        cancelScene = createCancelScene();
        showScene = createShowScene();

        stage.setScene(mainMenuScene);

        stage.show();
    }

    private Scene createMainMenuScene() {
        bookingButton = new Button("Make a booking");
        bookingButton.setOnAction(e -> switchScenes(bookingScene));

        cancelButton = new Button("Cancel a booking");
        cancelButton.setOnAction(e -> switchScenes(cancelScene));

        showButton = new Button("Show bookings for day");
        showButton.setOnAction(e -> switchScenes(showScene));

        vboxMenu = new VBox(bookingButton, cancelButton, showButton);
        vboxMenu.setStyle("-fx-background-color: green");


        mainMenuScene = new Scene(vboxMenu, 800, 500);
        return mainMenuScene;
    }



    private Scene createBookingScene() {
        mainMenuButton();
        vboxFunction = new VBox(menuButton);
        vboxFunction.setStyle("-fx-background-color: blue");
        bookingScene = new Scene(vboxFunction, 600, 300);

        return bookingScene;
    }

    private Scene createCancelScene() {
        mainMenuButton();
        vboxFunction = new VBox(menuButton);
        vboxFunction.setStyle("-fx-background-color: red");
        cancelScene = new Scene(vboxFunction, 500, 200);

        return cancelScene;
    }

    private Scene createShowScene() {
        mainMenuButton();
        vboxFunction = new VBox(menuButton);
        vboxFunction.setStyle("-fx-background-color: orange");
        showScene = new Scene(vboxFunction, 100, 600);

        return showScene;
    }

    public void switchScenes(Scene scene) {
        stage.setScene(scene);
    }

    public void mainMenuButton() {
        menuButton = new Button("Return to menu");
        menuButton.setOnAction(e -> switchScenes(mainMenuScene));
    }

    public static void main(String[] args) {
        launch();
    }
}
