package finalproject;

import java.util.Random;

public class Shop {

    private final String ITEM1 = "Stat Boost";
    private final String ITEM2 = "Health Restore";
    private final String ITEM3 = "Doll";
    private final String ITEM4 = "Money Shower";
    private final String ITEM5 = "Invincibility";
    private final String ITEM6 = "Accuracy Boost";
    private final String ITEM7 = "Weaken Monster";
    private final String ITEM8 = "Instakill";
    
    private final String[] PRICES = {"10", "10", "3", "5", "10", "3", "3", "15"};
    private String[] quantity = {"", "", "", "", "", "", "", ""};
    
    public Shop() {
        changeQuantity();
    }

    public String getITEM1() {
        return ITEM1;
    }

    public String getITEM2() {
        return ITEM2;
    }

    public String getITEM3() {
        return ITEM3;
    }

    public String getITEM4() {
        return ITEM4;
    }

    public String getITEM5() {
        return ITEM5;
    }

    public String getITEM6() {
        return ITEM6;
    }

    public String getITEM7() {
        return ITEM7;
    }

    public String getITEM8() {
        return ITEM8;
    }

    public String getPRICES(int indexValue) {
        return PRICES[indexValue];
    }

    public String getQuantity(int indexValue) {
        return quantity[indexValue];
    }

    public void setQuantity(int indexValue, Integer quantity) {
        this.quantity[indexValue] = quantity.toString();
    }
    
    public String updateShop() {
        if (randomNumber(5) == 0) {
            changeQuantity();
            return "SHOP HAS BEEN RESTOCKED";
        } else {
            return "";
        }
    }
    
    private void changeQuantity() {
        for (int i = 0; i < 8; i++) {
            Integer randomNumber = randomNumber(10);
            if (randomNumber(2) == 0) {
                randomNumber = 0;
            }
            quantity[i] = randomNumber.toString();
        }
    }

    private int randomNumber(int i) {
        Random rNG = new Random();

        int number = rNG.nextInt(i);

        return number;
    }
}
