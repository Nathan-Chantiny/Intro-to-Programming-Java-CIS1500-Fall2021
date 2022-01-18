package finalproject;

import static finalproject.FinalProject.stage;
import java.util.Random;

public class Room {

    private int row;
    private int y;
    private int column;
    private int x;

    private int gold;
    private boolean isThereAMonster;

    private String[][] mapOutput = new String[11][11];
    private String[][] blockedRoomsMap = new String[11][11];

    public Room() {
        row = randomNumber(11);
        y = 5 - row;
        column = randomNumber(11);
        x = column - 5;

        makeMaps();
    }

    private void makeMaps() {
        mapOutput();
        blockedRooms();
    }

    private void mapOutput() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                mapOutput[i][j] = "???????";
            }
        }
        mapOutput[row][column] = "~~~~~";
    }

    private void blockedRooms() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                blockedRoomsMap[i][j] = "";
            }
        }
        for (int i = 0; i < 30; i++) {
            blockedRoomsMap[randomNumber(11)][randomNumber(11)] = "▓▓▓▓▓";
        }
        blockedRoomsMap[row][column] = "";
    }

    public void setRow(int changeInPosition) {
        row += changeInPosition;
        y = 5 - row;
    }

    public void setColumn(int changeInPosition) {
        column += changeInPosition;
        x = column - 5;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getGold() {
        gold = randomNumber(20);
        return gold;
    }
    
    public int getGoldInRoom() {
        return gold;
    }

    public boolean isIsThereAMonster() {
        return isThereAMonster;
    }

    public void setIsThereAMonster(boolean isThereAMonster) {
        this.isThereAMonster = isThereAMonster;
    }
    
    public void applyITEM4Effect() {
        gold *= 5;
    }

    public boolean isThereAMonster() {
        int zeroOrOne = randomNumber(2);
        if (zeroOrOne == 0) {
            isThereAMonster = true;
            return true;
        } else {
            isThereAMonster = false;
            return false;
        }
    }

    public boolean isRoomBlocked(int changeInRow, int changeInColumn) {
        int a = row + changeInRow;
        int b = column + changeInColumn;

        if (blockedRoomsMap[a][b].equals("▓▓▓▓▓")) {
            mapOutput[a][b] = "▓▓▓▓▓";
            return true;
        } else {
            mapOutput[a][b] = "~~~~~";
            return false;
        }
    }

    public String map() {
        String string = "";
        mapOutput[row][column] = "~~X~~";
        string += "----------------------------------------------------------------------------------------------\n";
        string += "|";
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                string += mapOutput[i][j] + "|";
            }
            string += "\n----------------------------------------------------------------------------------------------\n";
            string += "|";
        }
        mapOutput[row][column] = "~~~~~";
        return string;

    }

    public void toDirectionSelection() {
        DirectionSelection toDirectionSelection = new DirectionSelection();
        try {
            toDirectionSelection.start(stage);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void toShopPlayerInventory() {
        ShopPlayerInventory toDirectionSelection = new ShopPlayerInventory();
        try {
            toDirectionSelection.start(stage);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void toDungeonScene() {
        DungeonScene toDungeonScene = new DungeonScene();
        try {
            toDungeonScene.start(stage);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void toMap() {
        Map toMap = new Map();
        try {
            toMap.start(stage);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void toPlayerInventory() {
        PlayerInventory toPlayerInventory = new PlayerInventory();
        try {
            toPlayerInventory.start(stage);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void toDeathScreen() {
        DeathScreen toDeathScreen = new DeathScreen();
        try {
            toDeathScreen.start(stage);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public int randomNumber(int i) {
        Random rNG = new Random();

        int number = rNG.nextInt(i);

        return number;
    }
}
