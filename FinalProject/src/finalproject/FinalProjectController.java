package finalproject;

import static finalproject.FinalProject.room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FinalProjectController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void beginTap(ActionEvent event) {
        room.toDirectionSelection();
    }
}
