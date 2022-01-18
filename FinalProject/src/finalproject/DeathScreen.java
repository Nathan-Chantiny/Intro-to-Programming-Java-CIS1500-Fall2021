package finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DeathScreen extends Application{
    
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
        // change the name of your fxml file to match
        Parent root = FXMLLoader.load(getClass().getResource("DeathScreen.fxml"));
        stage.setTitle("GAME OVER");
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
