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
import javafx.scene.control.*;

public class ShopPlayerInventoryController implements Initializable {

    private ArrayList<String> quantityChoice = new ArrayList<>();
    private ArrayList<String> inventory = new ArrayList<>();
    private String[] options = {"Choose an item", "", "", "", "", "", "", "", ""};

    private int cost;
    private int price;
    private int quantity;
    private int choice;

    @FXML
    private ChoiceBox<String> shopInventory;
    @FXML
    private ChoiceBox<String> shopQuantity;
    @FXML
    private Label pricePerItem;
    @FXML
    private Label totalCostOfItems;
    @FXML
    private ListView<String> inventoryList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quantityChoice.add("Choose a quantity");

        if (false) {//Integer.parseInt(shop.getQuantity(0)) > 0) {
            options[1] = shop.getITEM1();
        } else {
            options[1] = "FRESH OUT";
        }
        if (Integer.parseInt(shop.getQuantity(1)) > 0) {
            options[2] = shop.getITEM2();
        } else {
            options[2] = "FRESH OUT";
        }
        if (Integer.parseInt(shop.getQuantity(2)) > 0) {
            options[3] = shop.getITEM3();
        } else {
            options[3] = "FRESH OUT";
        }
        if (Integer.parseInt(shop.getQuantity(3)) > 0) {
            options[4] = shop.getITEM4();
        } else {
            options[4] = "FRESH OUT";
        }
        if (Integer.parseInt(shop.getQuantity(4)) > 0) {
            options[5] = shop.getITEM5();
        } else {
            options[5] = "FRESH OUT";
        }
        if (Integer.parseInt(shop.getQuantity(5)) > 0) {
            options[6] = shop.getITEM6();
        } else {
            options[6] = "FRESH OUT";
        }
        if (Integer.parseInt(shop.getQuantity(6)) > 0) {
            options[7] = shop.getITEM7();
        } else {
            options[7] = "FRESH OUT";
        }
        if (Integer.parseInt(shop.getQuantity(7)) > 0) {
            options[8] = shop.getITEM8();
        } else {
            options[8] = "FRESH OUT";
        }

        shopInventory.setItems(FXCollections.observableArrayList(options));
        shopInventory.getSelectionModel().selectFirst();
        shopInventory.setTooltip(new Tooltip("Select an item"));

        shopInventory.getSelectionModel().selectedItemProperty().addListener(
                (options, oldValue, newValue) -> {
                    if (newValue.contains("Stat Boost")) {
                        shopInventory.setTooltip(new Tooltip("Maximizes stats for next fight"));
                        pricePerItem.setText("$" + shop.getPRICES(0));
                        price = Integer.parseInt(shop.getPRICES(0));
                        choice = 1;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(0)));

                    } else if (newValue.contains("Health Restore")) {
                        shopInventory.setTooltip(new Tooltip("Restores your health to 20"));
                        pricePerItem.setText("$" + shop.getPRICES(1));
                        price = Integer.parseInt(shop.getPRICES(1));
                        choice = 2;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(1)));

                    } else if (newValue.contains("Doll")) {
                        shopInventory.setTooltip(new Tooltip("Guarantees you're able to safely run away"));
                        pricePerItem.setText("$" + shop.getPRICES(2));
                        price = Integer.parseInt(shop.getPRICES(2));
                        choice = 3;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(2)));

                    } else if (newValue.contains("Money Shower")) {
                        shopInventory.setTooltip(new Tooltip("Gold in room multiplied by 5"));
                        pricePerItem.setText("$" + shop.getPRICES(3));
                        price = Integer.parseInt(shop.getPRICES(3));
                        choice = 4;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(3)));

                    } else if (newValue.contains("Invincibility")) {
                        shopInventory.setTooltip(new Tooltip("Take no damage during your next fight"));
                        pricePerItem.setText("$" + shop.getPRICES(4));
                        price = Integer.parseInt(shop.getPRICES(4));
                        choice = 5;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(4)));

                    } else if (newValue.contains("Accuracy Boost")) {
                        shopInventory.setTooltip(new Tooltip("Your attacks won't miss during your next fight"));
                        pricePerItem.setText("$" + shop.getPRICES(5));
                        price = Integer.parseInt(shop.getPRICES(5));
                        choice = 6;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(5)));

                    } else if (newValue.contains("Weaken Monster")) {
                        shopInventory.setTooltip(new Tooltip("Next monsters stats reduced to 1"));
                        pricePerItem.setText("$" + shop.getPRICES(6));
                        price = Integer.parseInt(shop.getPRICES(6));
                        choice = 7;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(6)));

                    } else if (newValue.contains("Instakill")) {
                        shopInventory.setTooltip(new Tooltip("Monster dies upon use"));
                        pricePerItem.setText("$" + shop.getPRICES(7));
                        price = Integer.parseInt(shop.getPRICES(7));
                        choice = 8;
                        updateShopQuantity(Integer.parseInt(shop.getQuantity(7)));

                    } else if (newValue.contains("FRESH OUT")) {
                        shopInventory.setTooltip(new Tooltip("Select an item"));
                        pricePerItem.setText("");
                        price = 0;
                        choice = 0;
                        updateShopQuantity(0);

                    }
                });

        shopQuantity.setItems(FXCollections.observableArrayList(quantityChoice));
        shopQuantity.getSelectionModel().selectFirst();
        shopQuantity.setTooltip(new Tooltip("Select a quantity"));

        shopQuantity.getSelectionModel().selectedItemProperty().addListener(
                (options, oldValue, newValue) -> {
                    if (newValue == null) {
                        quantity = 0;
                        totalCostOfItems.setText("");
                    } else {
                        if (newValue.contentEquals("1")) {
                            quantity = 1;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("2")) {
                            quantity = 2;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("3")) {
                            quantity = 3;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("4")) {
                            quantity = 4;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("5")) {
                            quantity = 5;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("6")) {
                            quantity = 6;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("7")) {
                            quantity = 7;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("8")) {
                            quantity = 8;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contains("9")) {
                            quantity = 9;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        } else if (newValue.contentEquals("10")) {
                            quantity = 10;
                            cost = price * quantity;
                            totalCostOfItems.setText("Total cost: $" + cost);

                        }
                    }
                });

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
    }

    @FXML
    private void buyTap(ActionEvent event) {
        if (cost > player.getPlayerTotalGold() && quantity > 0) {
            totalCostOfItems.setText("YOU CANNOT AFFORD THESE ITEMS");
        } else if (quantity > 0 && cost <= player.getPlayerTotalGold()) {
            int playerTotalGold = player.getPlayerTotalGold();
            player.setPlayerTotalGold(playerTotalGold - cost);
            if (choice == 1) {
                player.setPlayerItemQuantity(0, quantity);
                shop.setQuantity(0, Integer.parseInt(shop.getQuantity(0)) - quantity);

            } else if (choice == 2) {
                player.setPlayerItemQuantity(1, quantity);
                shop.setQuantity(1, Integer.parseInt(shop.getQuantity(1)) - quantity);

            } else if (choice == 3) {
                player.setPlayerItemQuantity(2, quantity);
                shop.setQuantity(2, Integer.parseInt(shop.getQuantity(2)) - quantity);

            } else if (choice == 4) {
                player.setPlayerItemQuantity(3, quantity);
                shop.setQuantity(3, Integer.parseInt(shop.getQuantity(3)) - quantity);

            } else if (choice == 5) {
                player.setPlayerItemQuantity(4, quantity);
                shop.setQuantity(4, Integer.parseInt(shop.getQuantity(4)) - quantity);

            } else if (choice == 6) {
                player.setPlayerItemQuantity(5, quantity);
                shop.setQuantity(5, Integer.parseInt(shop.getQuantity(5)) - quantity);

            } else if (choice == 7) {
                player.setPlayerItemQuantity(6, quantity);
                shop.setQuantity(6, Integer.parseInt(shop.getQuantity(6)) - quantity);

            } else if (choice == 8) {
                player.setPlayerItemQuantity(7, quantity);
                shop.setQuantity(7, Integer.parseInt(shop.getQuantity(7)) - quantity);

            }

            room.toShopPlayerInventory();
        }
    }

    @FXML
    private void leaveShopTap(ActionEvent event) {
        room.toDirectionSelection();
    }

    private void updateShopQuantity(int quantityOfItem) {
        quantityChoice.clear();
        quantityChoice.add("Choose a quantity");
        for (int i = 0; i < quantityOfItem; i++) {
            Integer j = i + 1;
            quantityChoice.add(j.toString());
        }
        shopQuantity.setItems(FXCollections.observableArrayList(quantityChoice));
    }
}
