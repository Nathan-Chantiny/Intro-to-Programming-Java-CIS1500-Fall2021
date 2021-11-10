package project4;

import java.io.File;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Project4 {

    public static Scanner stringKeeb = new Scanner(System.in);
    public static Scanner doubleKeeb = new Scanner(System.in);
    public static Scanner integerKeeb = new Scanner(System.in);

    public static String itemName = "";
    public static String managerFunctions = "";
    public static File fileName;

    public static void main(String[] args) {
        System.out.println("To exit type \"QUIT\" at any time");
        int j = 0;
        while (j != 1) {
            System.out.println("Are you the store owner (manager) "
                    + "or are you shopping at the store (shopper)?");
            String usersAuthority = stringKeeb.nextLine();

            if (usersAuthority.equalsIgnoreCase("manager")) {
                j = 1;
                manage();
            } else if (usersAuthority.equalsIgnoreCase("shopper")) {
                j = 1;
                shop();
            } else if (usersAuthority.equalsIgnoreCase("QUIT")) {
                break;
            } else {
                System.out.println("That is not an option");
            }
        }
    }

    public static void manage() {
        while (!managerFunctions.equalsIgnoreCase("QUIT")) {
            System.out.println("Would you like to add item(s), change item(s) or delete item(s)? ");
            managerFunctions = stringKeeb.nextLine();
            if (managerFunctions.equalsIgnoreCase("add")) {
                addItem();
            } else if (managerFunctions.equalsIgnoreCase("change")) {
                changeItem();
            } else if (managerFunctions.equalsIgnoreCase("delete")) {
                deleteItem();
            } else if (managerFunctions.equalsIgnoreCase("QUIT")) {
                managerFunctions = "QUIT";
            } else {
                System.out.println("That is not an option");
            }
        }
        managerFunctions = "";
    }

    public static void shop() {
        String shoppersItem = "";
        String itemPrice = "";
        String itemQuantity = "";

        double result = 0.0;
        int quantity = 0;

        ArrayList<Double> results = new ArrayList<>();

        while (!shoppersItem.equalsIgnoreCase("QUIT")) {
            System.out.println("What would you like to buy? ");
            shoppersItem = stringKeeb.nextLine();
            if (!shoppersItem.equalsIgnoreCase("QUIT")) {
                fileName = new File(shoppersItem.concat(".txt"));
                if (fileName.exists()) {
                    TxtTools txtTools = new TxtTools(fileName);

                    itemPrice = txtTools.fileRead(shoppersItem, 1);
                    itemQuantity = txtTools.fileRead(shoppersItem, 2);

                    System.out.println("\nPrice and quantity for " + shoppersItem + ":\n"
                            + "$" + itemPrice + "\n"
                            + itemQuantity + "\n");

                    System.out.println("How many would you like to buy? ");
                    quantity = integerKeeb.nextInt();
                    if (quantity <= parseInt(itemQuantity) && quantity > 0 && !itemQuantity.equals("0")) {
                        double cost = (parseDouble(itemPrice)) * quantity;
                        results.add(cost);

                        quantity = parseInt(itemQuantity) - quantity;
                        itemQuantity = Integer.toString(quantity);
                        txtTools.fileOverwrite(shoppersItem, itemPrice, itemQuantity);
                    } else if (itemQuantity.equals("0")) {
                        System.out.println("Item is not in stock");
                    } else if (quantity == 0) {

                    } else {
                        System.out.println("We only have " + itemQuantity + " in stock, "
                                + "please make sure you choose a quantity less than or equal to that");
                    }
                } else {
                    System.out.println("We do not sell that");
                }
            }
        }

        if (!shoppersItem.equalsIgnoreCase("QUIT")) {
            for (int i = 0; i < results.size(); i++) {
                result += results.get(i);
            }

            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            System.out.println("The price for your goods is " + formatter.format(result));
            System.out.println("Please enter your payment information ");
            String paymentInfo = stringKeeb.nextLine();

            System.out.println("Thank you for shopping at my store! ");
        }
    }

    public static void addItem() {
        double itemPrice = 0.0;
        int itemQuantity = 0;

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();

        while (!managerFunctions.equalsIgnoreCase("QUIT")) {
            System.out.println("What is the name of the product you would like to add? ");
            itemName = stringKeeb.nextLine();
            if (!itemName.equalsIgnoreCase("QUIT")) {
                name.add(itemName);

                System.out.println("What is the price of the product? ");
                itemPrice = doubleKeeb.nextDouble();
                price.add(itemPrice);

                System.out.println("What is the quantity of the item? ");
                itemQuantity = integerKeeb.nextInt();
                quantity.add(itemQuantity);
            } else {
                managerFunctions = "QUIT";
            }
        }
        managerFunctions = "";

        for (int i = 0; i < name.size(); i++) {
            fileName = new File(name.get(i).concat(".txt"));
            TxtTools txtTools = new TxtTools(fileName);
            txtTools.createTxt(name.get(i), price.get(i), quantity.get(i));
        }
    }

    public static void changeItem() {
        while (!managerFunctions.equalsIgnoreCase("QUIT")) {
            System.out.println("What item would you like to change? ");
            itemName = stringKeeb.nextLine();
            if (!itemName.equalsIgnoreCase("QUIT")) {
                fileName = new File(itemName.concat(".txt"));
                if (fileName.exists()) {
                    TxtTools txtTools = new TxtTools(fileName);

                    String name = txtTools.fileRead(itemName, 0);
                    String price = txtTools.fileRead(itemName, 1);
                    String quantity = txtTools.fileRead(itemName, 2);

                    System.out.println("\nCurrent price and quantity for " + name + ":\n"
                            + "$" + price + "\n"
                            + quantity + "\n");

                    txtTools.changeFile(name, price, quantity);
                } else {
                    System.out.println(itemName + " does not exist");
                }
            } else {
                managerFunctions = "QUIT";
            }
        }
        managerFunctions = "";
    }

    public static void deleteItem() {
        while (!managerFunctions.equalsIgnoreCase("QUIT")) {
            System.out.println("What item would you like to delete? ");
            itemName = stringKeeb.nextLine();
            if (!itemName.equalsIgnoreCase("QUIT")) {
                fileName = new File(itemName.concat(".txt"));
                if (fileName.exists()) {
                    fileName.delete();
                } else {
                    System.out.println(itemName + " does not exist");
                }
            } else {
                managerFunctions = "QUIT";
            }
        }
        managerFunctions = "";
    }
}
