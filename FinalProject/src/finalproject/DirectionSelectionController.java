package finalproject;

import static finalproject.FinalProject.player;
import static finalproject.FinalProject.room;
import static finalproject.FinalProject.stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DirectionSelectionController implements Initializable {
    public static Shop shop = new Shop();
    public static NPC npc;

    @FXML
    private Label numberOfMonstersSlain;
    @FXML
    private Label playerCP;
    @FXML
    private Label playerStats;
    @FXML
    private Label warningBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        npc = new NPC();
        room.isThereAMonster();
        room.getGold();
        warningBox.setText(shop.updateShop());
        numberOfMonstersSlain.setText(Integer.toString(player.getMonstersSlain()));
        String string = "(" + room.getX() + "," + room.getY() + ")";
        playerCP.setText(string);
        playerStats.setText(""
                + "Player Stats: \n"
                + "Hit Points: " + player.getPlayerHitPoints() + "\n"
                + "Strength: " + player.getPlayerStrength() + "\n"
                + "Dexterity: " + player.getPlayerDexterity() + "\n"
                + "Intelligence: " + player.getPlayerIntelligence() + "\n"
                + "Total Gold: " + player.getPlayerTotalGold());
    }

    @FXML
    private void upTap(ActionEvent event) {
        if (room.getRow() > 0) {
            if (room.isRoomBlocked(-1, 0)) {
                warningBox.setText("THE ROOM IS BLOCKED YOU CANNOT GO THAT WAY");
            } else {
                room.setRow(-1);

                room.toDungeonScene();
            }
        } else {
            warningBox.setText("YOU ARE AT THE EDGE OF THE MAZE YOU CANNOT GO THAT WAY");
        }
    }

    @FXML
    private void downTap(ActionEvent event) {
        if (room.getRow() < 10) {
            if (room.isRoomBlocked(1, 0)) {
                warningBox.setText("THE ROOM IS BLOCKED YOU CANNOT GO THAT WAY");
            } else {
                room.setRow(1);

                room.toDungeonScene();
            }
        } else {
            warningBox.setText("YOU ARE AT THE EDGE OF THE MAZE YOU CANNOT GO THAT WAY");
        }
    }

    @FXML
    private void rightTap(ActionEvent event) {
        if (room.getColumn() < 10) {
            if (room.isRoomBlocked(0, 1)) {
                warningBox.setText("THE ROOM IS BLOCKED YOU CANNOT GO THAT WAY");
            } else {
                room.setColumn(1);

                room.toDungeonScene();
            }
        } else {
            warningBox.setText("YOU ARE AT THE EDGE OF THE MAZE YOU CANNOT GO THAT WAY");
        }
    }

    @FXML
    private void leftTap(ActionEvent event) {
        if (room.getColumn() > 0) {
            if (room.isRoomBlocked(0, -1)) {
                warningBox.setText("THE ROOM IS BLOCKED YOU CANNOT GO THAT WAY");
            } else {
                room.setColumn(-1);

                room.toDungeonScene();
            }
        } else {
            warningBox.setText("YOU ARE AT THE EDGE OF THE MAZE YOU CANNOT GO THAT WAY");
        }
    }

    @FXML
    private void mapTap(ActionEvent event) {
        Map toMap = new Map();
        try {
            toMap.start(stage);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void shopTap(ActionEvent event) {
        room.toShopPlayerInventory();
    }
}
