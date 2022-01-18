package finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinalProject extends Application {
    
    public static Stage stage;
    public static Room room = new Room();
    public static Player player = new Player();
    
    public static void main(String[] args) {
        // right click Libraries in the project, add the OpenJFX17 library
        // right click project, go to Run, add the line below to VM Options
        // --add-modules javafx.controls,javafx.fxml
        // in the Libraries, Run tab, add OpenJFX17 to the Module Path
        // in the libraries tab - make sure the project JDK platform and JFX versions match - 17 for both

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        // change the name of your fxml file to match
        Parent root = FXMLLoader.load(getClass().getResource("FinalProject.fxml"));
        stage.setTitle("Bad Adventure Game");
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
