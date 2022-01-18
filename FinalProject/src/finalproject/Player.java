package finalproject;

import static finalproject.DirectionSelectionController.npc;
import static finalproject.FinalProject.room;
import java.util.Random;

public class Player {
    private Integer[] playerItemQuantity = {0, 0, 0, 0, 0, 0, 0, 0};

    private int playerHitPoints;
    private int playerStrength;
    private int playerDexterity;
    private int playerIntelligence;
    private int playerTotalGold;
    
    private int monstersSlain;

    public Player() {
        playerHitPoints = 20;
        playerStrength = (randomNumber(6) + 1)
                + (randomNumber(6) + 1)
                + (randomNumber(6) + 1);
        playerDexterity = (randomNumber(6) + 1)
                + (randomNumber(6) + 1)
                + (randomNumber(6) + 1);
        playerIntelligence = (randomNumber(6) + 1)
                + (randomNumber(6) + 1)
                + (randomNumber(6) + 1);
        playerTotalGold = 0;
        monstersSlain = 0;
    }
    
    public void setPlayerHitPoints(int playerHitPoints) {
        this.playerHitPoints = playerHitPoints;
    }

    public void setPlayerTotalGold(int playerTotalGold) {
        this.playerTotalGold = playerTotalGold;
    }
    
    public void setMonstersSlain() {
        monstersSlain += 1;
    }

    public int getPlayerHitPoints() {
        return playerHitPoints;
    }

    public int getPlayerStrength() {
        return playerStrength;
    }

    public int getPlayerDexterity() {
        return playerDexterity;
    }

    public int getPlayerIntelligence() {
        return playerIntelligence;
    }

    public int getPlayerTotalGold() {
        return playerTotalGold;
    }
    
    public int getMonstersSlain() {
        return monstersSlain;
    }
    
    public Integer getPlayerItemQuantity(int indexValue) {
        return playerItemQuantity[indexValue];
    }
    
    public void setPlayerItemQuantity(int indexValue, Integer quantity) {
        this.playerItemQuantity[indexValue] += quantity;
    }

    public void setPlayerStrength(int playerStrength) {
        this.playerStrength = playerStrength;
    }

    public void setPlayerDexterity(int playerDexterity) {
        this.playerDexterity = playerDexterity;
    }

    public void setPlayerIntelligence(int playerIntelligence) {
        this.playerIntelligence = playerIntelligence;
    }
    //increases all player stats
    public void getITEM1Effect() {
        if (playerItemQuantity[0] > 0) {
            setPlayerStrength(18);
            setPlayerDexterity(18);
            setPlayerIntelligence(18);
            
            playerItemQuantity[0] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    //restores players health to 20
    public void getITEM2Effect() {
        if (playerItemQuantity[1] > 0) {
            playerHitPoints = 20;
            
            playerItemQuantity[1] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    //run away without fail
    public void getITEM3Effect() {
        if (playerItemQuantity[2] > 0) {
            npc.applyITEM3Effect();
            
            playerItemQuantity[2] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    //gold in room * 5
    public void getITEM4Effect() {
        if (playerItemQuantity[3] > 0) {
            room.applyITEM4Effect();
            
            playerItemQuantity[3] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    //player takes no damage next fight
    public void getITEM5Effect() {
        if (playerItemQuantity[4] > 0) {
            npc.applyITEM5Effect();
            
            playerItemQuantity[4] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    //all attacks next fight will not miss
    public void getITEM6Effect() {
        if (playerItemQuantity[5] > 0) {
            npc.applyITEM6Effect();
            
            playerItemQuantity[5] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    //reduces all monster stats to 1
    public void getITEM7Effect() {
        if (playerItemQuantity[6] > 0) {
            npc.applyITEM7Effect();
            
            playerItemQuantity[6] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    //instakills monster
    public void getITEM8Effect() {
        if (playerItemQuantity[7] > 0) {
            npc.applyITEM8Effect();
            
            playerItemQuantity[7] -= 1;
        } else {
            System.out.println("INVENTORY EMPTY");
        }
    }
    
    private int randomNumber(int i) {
        Random rNG = new Random();

        int number = rNG.nextInt(i);

        return number;
    }
}
