package finalproject;

import static finalproject.DirectionSelectionController.npc;
import static finalproject.FinalProject.player;
import static finalproject.FinalProject.room;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class DungeonSceneController implements Initializable {

    @FXML
    private Label outputText;
    @FXML
    private Label playerHP;
    @FXML
    private Label monsterHP;
    @FXML
    private ImageView enemyPicture;
    @FXML
    private Rectangle monsterHPBox;

    private int goldInRoom;

    private int playerHitPoints;
    private int playerStrength;
    private int playerDexterity;
    private int playerIntelligence;
    private int playerTotalGold;

    private boolean isThereAMonster;
    private int monsterHitPoints;
    private int monsterStrength;
    private int monsterDexterity;
    private int monsterIntelligence;

    private int bPS;
    private int bPD;
    private int bPI;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        if (player.getPlayerStrength() != 18) {
            bPS = player.getPlayerStrength();
        }
        if (player.getPlayerDexterity() != 18) {
            bPD = player.getPlayerDexterity();
        }
        if (player.getPlayerIntelligence() != 18) {
            bPI = player.getPlayerIntelligence();
        }

        goldInRoom = room.getGoldInRoom();
        isThereAMonster = room.isIsThereAMonster();

        playerHitPoints = player.getPlayerHitPoints();
        playerStrength = player.getPlayerStrength();
        playerDexterity = player.getPlayerDexterity();
        playerIntelligence = player.getPlayerIntelligence();
        playerTotalGold = player.getPlayerTotalGold();

        playerHP.setText("Player Hit Points: "
                + healthBar(playerHitPoints));

        if (isThereAMonster) {
            enemyPicture.setVisible(isThereAMonster);
            monsterHP.setVisible(isThereAMonster);

            monsterHitPoints = npc.getMonsterHitPoints();
            monsterStrength = npc.getMonsterStrength();
            monsterDexterity = npc.getMonsterDexterity();
            monsterIntelligence = npc.getMonsterIntelligence();

            monsterHP.setText("Monster Hit Points: "
                    + healthBar(monsterHitPoints));
        } else {
            enemyPicture.setVisible(isThereAMonster);
            monsterHPBox.setVisible(false);

            monsterHitPoints = -1;
            monsterStrength = -1;
            monsterDexterity = -1;
            monsterIntelligence = -1;
        }
    }

    @FXML
    private void searchTap(ActionEvent event) throws IOException, InterruptedException {
        if (isThereAMonster) {
            outputText.setText("THERE IS A MONSTER IN THE ROOM YOU MUST FIGHT IT OR RUN AWAY");
        } else if (isThereAMonster == false) {
            int randomNumber = randomNumber(18);
            if (randomNumber < playerIntelligence) {
                player.setPlayerTotalGold(playerTotalGold + goldInRoom);
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> {
                    //resetPlayerStats();
                    room.toDirectionSelection();
                });
                outputText.setText("YOU FOUND " + goldInRoom + " PIECES OF GOLD");
                pause.play();
            } else {
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> {
                    //resetPlayerStats();
                    room.toDirectionSelection();
                });
                outputText.setText("YOU FOUND 0 PIECES OF GOLD");
                pause.play();
            }
        } else {
            outputText.setText("I don't know how you got here");
        }
    }

    @FXML
    private void fightTap(ActionEvent event) {
        if (isThereAMonster) {
            int randomNumber = randomNumber(24);
            int monsterDamage = 0;
            if (randomNumber >= monsterDexterity) {
                if ((playerStrength / 3) >= monsterHitPoints) {
                    monsterHitPoints = 0;
                    npc.setMonsterHitPoints(0);
                    isThereAMonster = false;
                    room.setIsThereAMonster(false);
                    enemyPicture.setVisible(false);
                    monsterHPBox.setVisible(false);
                    player.setPlayerHitPoints(playerHitPoints);
                    outputText.setText("YOU HAVE SUCCESSFULLY DEFEATED THE MONSTER, "
                            + "YOU MAY NOW SEARCH OR SLEEP");
                    player.setMonstersSlain();
                } else {
                    monsterHitPoints = monsterHitPoints - (playerStrength / 3);
                    npc.setMonsterHitPoints(monsterHitPoints);
                    if (monsterHitPoints > 0) {
                        if (npc.getMonsterStrength() == -1) {
                            monsterDamage = 0;
                        } else if ((monsterStrength / 3) <= 0) {
                            monsterDamage = 1;
                            playerHitPoints = playerHitPoints - 1;
                            player.setPlayerHitPoints(playerHitPoints);
                            isPlayerAlive();
                        } else {
                            monsterDamage = (monsterStrength / 3);
                            playerHitPoints = playerHitPoints - (monsterStrength / 3);
                            player.setPlayerHitPoints(playerHitPoints);
                            isPlayerAlive();
                        }
                    }
                    outputText.setText("THE MONSTER DID " + monsterDamage + " DAMAGE");
                }

                playerHP.setText("Player Hit Points: "
                        + healthBar(playerHitPoints));
                monsterHP.setText("Monster Hit Points: "
                        + healthBar(monsterHitPoints));
            } else {
                outputText.setText("YOUR ATTACK MISSED AND THE MONSTER ATTACKED YOU!");
                if (npc.getMonsterStrength() == -1) {
                    monsterDamage = 0;
                } else if ((monsterStrength / 3) <= 0) {
                    monsterDamage = 1;
                    playerHitPoints = playerHitPoints - 1;
                    isPlayerAlive();
                } else {
                    monsterDamage = (monsterStrength / 3);
                    playerHitPoints = playerHitPoints - (monsterStrength / 3);
                    isPlayerAlive();
                }
                outputText.setText("THE MONSTER DID " + monsterDamage + " DAMAGE");
                playerHP.setText("Player Hit Points: "
                        + healthBar(playerHitPoints));
                monsterHP.setText("Monster Hit Points: "
                        + healthBar(monsterHitPoints));
            }
        } else if (isThereAMonster == false && monsterHitPoints == 0) {
            outputText.setText("YOU HAVE DEFEATED THE MONSTER, YOU MAY SEARCH OR SLEEP");
        } else if (isThereAMonster == false && monsterHitPoints == -1) {
            outputText.setText("YOU CAN SEARCH OR SLEEP THERE IS NO MONSTER IN THE ROOM");
        } else {
            outputText.setText("I don't know how you got here");
        }
    }

    @FXML
    private void runTap(ActionEvent event) throws IOException, InterruptedException {
        if (isThereAMonster) {
            int randomNumber = randomNumber(24);
            int monsterDamage = 0;
            if (randomNumber < monsterIntelligence) {
                if ((monsterStrength / 3) <= 0) {
                    monsterDamage = 1;
                    playerHitPoints -= 1;
                    isPlayerAlive();
                } else {
                    monsterDamage = (monsterStrength / 3);
                    playerHitPoints = playerHitPoints - (monsterStrength / 3);
                    isPlayerAlive();
                }
                player.setPlayerHitPoints(playerHitPoints);
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> {
                    //resetPlayerStats();
                    room.toDirectionSelection();
                });
                outputText.setText("THE MONSTER CAUGHT YOU AND DID " + monsterDamage + " DAMAGE");
                playerHP.setText("Player Hit Points: " + healthBar(playerHitPoints));
                pause.play();
            } else {
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> {
                    //resetPlayerStats();
                    room.toDirectionSelection();
                });
                outputText.setText("YOU ESCAPED THE ROOM");
                pause.play();
            }
        } else if (isThereAMonster == false && monsterHitPoints == 0) {
            outputText.setText("YOU HAVE DEFEATED THE MONSTER, YOU MAY SEARCH OR SLEEP");
        } else if (isThereAMonster == false && monsterHitPoints == -1) {
            outputText.setText("YOU CAN SEARCH OR SLEEP THERE IS NO MONSTER IN THE ROOM");
        } else {
            outputText.setText("I don't know how you got here");
        }
    }

    @FXML
    private void sleepTap(ActionEvent event) throws IOException, InterruptedException {
        if (isThereAMonster == false) {
            int randomNumber = randomNumber(6);
            int monsterDamage = 0;
            if (randomNumber == 0) {
                if ((monsterStrength / 3) <= 0) {
                    monsterDamage = 1;
                    playerHitPoints -= 1;
                    isPlayerAlive();
                } else {
                    monsterDamage = (monsterStrength / 3);
                    playerHitPoints = playerHitPoints - (monsterStrength / 3);
                    isPlayerAlive();
                }
                player.setPlayerHitPoints(playerHitPoints);
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> {
                    //resetPlayerStats();
                    room.toDirectionSelection();
                });
                outputText.setText("A MONSTER FOUND YOU WHILE YOU WERE SLEEPING AND DID "
                        + monsterDamage + " DAMAGE");
                playerHP.setText("Player Hit Points: " + healthBar(playerHitPoints));
                pause.play();
            } else {
                player.setPlayerHitPoints(20);
                //resetPlayerStats();
                room.toDirectionSelection();
            }
        } else {
            outputText.setText("YOU CAN'T SLEEP NOW, THERE IS A MONSTER IN THE ROOM");
        }
    }
    
    private void resetPlayerStats() {
        if (player.getPlayerStrength() == 18) {
            player.setPlayerStrength(bPS);
        }
        if (player.getPlayerDexterity() == 18) {
            player.setPlayerDexterity(bPD);
        }
        if (player.getPlayerIntelligence() == 18) {
            player.setPlayerIntelligence(bPI);
        }
    }

    private int randomNumber(int i) {
        Random rNG = new Random();

        int number = rNG.nextInt(i);

        return number;
    }

    private String healthBar(int hitPoints) {
        String string = "";
        for (int i = 0; i < hitPoints; i++) {
            string += "♥";
        }
        if (hitPoints == 0) {
            string = "0";
        }
        return string;
    }

    private void isPlayerAlive() {
        if (playerHitPoints > 0) {

        } else {
            room.toDeathScreen();
        }
    }

    @FXML
    private void inventoryTap(ActionEvent event) {
        room.toPlayerInventory();
    }
}
