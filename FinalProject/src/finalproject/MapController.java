package finalproject;

import static finalproject.FinalProject.room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MapController implements Initializable {

    @FXML
    private Label mapBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String map = room.map();
        mapBox.setText(map);
    }    

    @FXML
    private void closeTap(ActionEvent event) {
        room.toDirectionSelection();
    }
    
}
