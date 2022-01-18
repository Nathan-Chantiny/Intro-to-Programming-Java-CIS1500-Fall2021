package finalproject;

import static finalproject.DirectionSelectionController.shop;
import static finalproject.FinalProject.player;
import static finalproject.FinalProject.room;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PlayerInventoryController implements Initializable {

    @FXML
    private Label itemDescription;
    @FXML
    private ListView<String> inventoryList;

    public ArrayList<String> inventory = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (player.getPlayerItemQuantity(0) > 0) {
            inventory.add(shop.getITEM1() + " x" + player.getPlayerItemQuantity(0));
        }
        if (player.getPlayerItemQuantity(1) > 0) {
            inventory.add(shop.getITEM2() + " x" + player.getPlayerItemQuantity(1));
        }
        if (player.getPlayerItemQuantity(2) > 0) {
            inventory.add(shop.getITEM3() + " x" + player.getPlayerItemQuantity(2));
        }
        if (player.getPlayerItemQuantity(3) > 0) {
            inventory.add(shop.getITEM4() + " x" + player.getPlayerItemQuantity(3));
        }
        if (player.getPlayerItemQuantity(4) > 0) {
            inventory.add(shop.getITEM5() + " x" + player.getPlayerItemQuantity(4));
        }
        if (player.getPlayerItemQuantity(5) > 0) {
            inventory.add(shop.getITEM6() + " x" + player.getPlayerItemQuantity(5));
        }
        if (player.getPlayerItemQuantity(6) > 0) {
            inventory.add(shop.getITEM7() + " x" + player.getPlayerItemQuantity(6));
        }
        if (player.getPlayerItemQuantity(7) > 0) {
            inventory.add(shop.getITEM8() + " x" + player.getPlayerItemQuantity(7));
        }
        inventoryList.setItems(FXCollections.observableArrayList(inventory));
        inventoryList.getSelectionModel().selectedItemProperty().addListener(
                (inventory, oldValue, newValue) -> {
                    String newItem = inventoryList.getSelectionModel().getSelectedItem();
                    if (newItem.contains("Stat Boost")) {
                        itemDescription.setText(
                                "increases all stats to their highest possible value, except health\n"
                                + "Strength will be set to 18\n"
                                + "Dexterity will be set to 18\n"
                                + "Intelligence will be set to 18\n"
                        );

                    } else if (newItem.contains("Health Restore")) {
                        itemDescription.setText(
                                "Restores health to full\n"
                                + "Player hit points set to 20\n"
                        );
                    } else if (newItem.contains("Doll")) {
                        itemDescription.setText(
                                "You are able to run away without taking damage\n"
                        );
                    } else if (newItem.contains("Money Shower")) {
                        itemDescription.setText(
                                "Takes the amount of gold in the room and multiplies it by 5\n"
                        );
                    } else if (newItem.contains("Invincibility")) {
                        itemDescription.setText(
                                "Monster is unable to damage to you for the rest of the fight\n"
                        );
                    } else if (newItem.contains("Accuracy Boost")) {
                        itemDescription.setText(
                                "All your attacks will hit in the next fight"
                        );
                    } else if (newItem.contains("Weaken Monster")) {
                        itemDescription.setText(
                                "Monster stats set to lowest possible\n"
                        );
                    } else if (newItem.contains("Instakill")) {
                        itemDescription.setText(
                                "Monster dies allowing you to search or sleep safely\n"
                        );
                    } else {
                        itemDescription.setText("");
                    }
                });
    }

    @FXML
    private void useItemTap(ActionEvent event) {
        String choice = inventoryList.getSelectionModel().getSelectedItem();
        if (choice.contains("Stat Boost")) {
            player.getITEM1Effect();
        } else if (choice.contains("Health Restore")) {
            player.getITEM2Effect();
        } else if (choice.contains("Doll")) {
            player.getITEM3Effect();
        } else if (choice.contains("Money Shower")) {
            player.getITEM4Effect();
        } else if (choice.contains("Invincibility")) {
            player.getITEM5Effect();
        } else if (choice.contains("Accuracy Boost")) {
            player.getITEM6Effect();
        } else if (choice.contains("Weaken Monster")) {
            player.getITEM7Effect();
        } else if (choice.contains("Instakill")) {
            player.getITEM8Effect();
        }
        room.toPlayerInventory();
    }

    @FXML
    private void exitTap(ActionEvent event) {
        room.toDungeonScene();
    }

}
