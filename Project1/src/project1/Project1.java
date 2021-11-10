package project1;

import java.text.NumberFormat;
import java.util.Scanner;

public class Project1 {

    //Most of the stuff for the calculations
    public static NumberFormat formatter = NumberFormat.getCurrencyInstance();

    //doubles
    public static final double SMALL = 6.0;
    public static final double MEDIUM = 8.0;
    public static final double LARGE = 10.0;
    public static double pizzaOrder = 0.0;
    public static double remainingSlices = 0.0;
    public static double cost;

    //Integers
    public static int output;
    public static int row = 0;
    public static int counter = 0;

    //Strings
    public static String numberOfGuests = null;
    public static String averagePizzaSlices = null;
    public static String name = null;
    public static String costCalculation = "z";
    public static String pizzaPlace = "z";

    //Matrices full of prices for the pizzas
    //This was the best I could do without figuring out the cost of every ingredient
    public static double[][] dominoes = {
        {7.00, 8.25, 9.50, 10.50, 11.50, 12.50, 13.50, 14.50, 15.50, 16.50, 17.50}, //small pizza prices 0-10 toppings
        {9.00, 10.75, 12.50, 13.75, 15.00, 16.25, 17.50, 18.75, 20.00, 21.25, 22.50}, //medium pizza prices 0-10 toppings
        {12.00, 14.25, 16.50, 18.00, 19.50, 21.00, 22.50, 24.00, 25.50, 27.00, 28.50} //large pizza prices 0-10 toppings
    };
    public static double[][] papaJohns = {
        {7.99, 7.99, 8.99, 9.99, 10.99, 11.99, 12.99, 12.99, 12.99, 12.99, 12.99}, //small pizza prices 0-10 toppings
        {9.99, 9.99, 11.24, 12.49, 13.74, 14.99, 15.99, 15.99, 15.99, 15.99, 15.99}, //medium pizza prices 0-10 toppings
        {12.99, 12.99, 14.49, 15.99, 17.49, 18.99, 20.49, 21.99, 21.99, 21.99, 21.99} //large pizza prices 0-10 toppings
    };
    public static double[][] hungryHowies = {
        {7.00, 8.94, 10.88, 12.82, 14.76, 16.45, 18.14, 19.83, 21.52, 23.21, 24.90}, //small pizza prices 0-10 toppings
        {9.00, 11.39, 13.78, 16.17, 18.56, 20.45, 22.34, 24.23, 26.12, 28.01, 29.90}, //medium pizza prices 0-10 toppings
        {11.00, 13.84, 16.68, 19.52, 22.36, 24.45, 26.54, 28.63, 30.72, 32.81, 34.90} //large pizza prices 0-10 toppings
    };
    public static double[][] jets = {
        {9.99, 11.48, 12.97, 14.46, 15.95, 17.44, 18.93, 20.42, 21.91, 23.40, 24.89}, //small pizza prices 0-10 toppings
        {11.99, 13.68, 15.37, 17.06, 18.75, 20.44, 22.13, 23.82, 25.51, 27.20, 28.89},//medium pizza prices 0-10 toppings
        {13.99, 15.88, 17.77, 19.66, 21.55, 23.44, 25.33, 27.22, 29.11, 31.00, 32.89} //large pizza prices 0-10 toppings
    };
    public static double[][] cottageInn = {
        {7.49, 9.99, 12.49, 14.99, 17.49, 19.99, 22.49, 24.99, 26.24, 27.49, 28.74}, //small pizza prices 0-10 toppings
        {8.99, 11.99, 14.99, 17.99, 20.99, 23.99, 26.99, 29.99, 31.49, 32.99, 34.49}, //medium pizza prices 0-10 toppings
        {10.99, 14.49, 17.99, 21.49, 24.99, 28.49, 31.99, 35.49, 37.24, 38.99, 40.74} //large pizza prices 0-10 toppings
    };

    public static void main(String[] args) {

        //Gets users name
        name();

        //Gets how many guests will be coming to the party from the user
        numberOfGuests();

        //Gets how many slices of pizza the user thinks each person will eat on average
        averagePizzaSlices();

        //Converts strings to doubles for calculations
        double nOG = Double.parseDouble(numberOfGuests);
        double aPS = Double.parseDouble(averagePizzaSlices);

        //Asks the user what size of pizza they want to order.
        String pizzaSize = "z";
        System.out.println("\nA small pizza has 6 slices, a medium pizza has "
                + "8 slices and a large pizza has 10 slices.");
        System.out.println("Please enter either \"s\" for a small, "
                + "\"m\" for a medium or \"l\" for a large.");

        //Loops until user enters either "s", "m" or "l"
        while (pizzaSize.equals("z")) {
            Scanner part4 = new Scanner(System.in);
            System.out.print("\n" + name + ", what size pizza would you "
                    + "like to order (s, m, or l)? ");
            pizzaSize = part4.nextLine();
            //Calculates how much pizza the user should order
            if (pizzaSize.equals("s")) {
                pizzaOrder = (nOG * aPS) / SMALL;
            } else if (pizzaSize.equals("m")) {
                pizzaOrder = (nOG * aPS) / MEDIUM;
            } else if (pizzaSize.equals("l")) {
                pizzaOrder = (nOG * aPS) / LARGE;
            } else {
                pizzaSize = "z";
            }
        }

        //Turns the number of pizzas that need to be ordered into an integer
        output = (int) pizzaOrder;

        //Finds the number of leftover pizza slices
        if (pizzaOrder != (int) pizzaOrder) {
            output += 1;
        }

        //Finds the remaining number of pizza slices and sets row for calculating price later
        if (pizzaSize.equals("s")) {
            remainingSlices = SMALL * (output - pizzaOrder);
            row = 0;
        } else if (pizzaSize.equals("m")) {
            remainingSlices = MEDIUM * (output - pizzaOrder);
            row = 1;
        } else if (pizzaSize.equals("l")) {
            remainingSlices = LARGE * (output - pizzaOrder);
            row = 2;
        }

        //Tells user how much pizza they need to order and how many leftover slices there will be
        if (output == 1 && pizzaOrder != (int) pizzaOrder && remainingSlices == 1) {
            System.out.println("\n" + name + ", you will need to order at least "
                    + "1 pizza to feed your guests");
            System.out.println("There will be 1 piece leftover "
                    + "if you order 1 pizza.\n");
        } else if (output != 1 && pizzaOrder != (int) pizzaOrder && remainingSlices == 1) {
            System.out.println("\n" + name + ", you will need to order at least " + output
                    + " pizzas to feed your guests.");
            System.out.println("There will be 1 piece leftover "
                    + "if you order " + output + " pizzas.\n");
        } else if (output == 1 && pizzaOrder != (int) pizzaOrder && remainingSlices != 1) {
            System.out.println("\n" + name + ", you will need to order at least "
                    + "1 pizza to feed your guests");
            System.out.println("There will be " + (int) remainingSlices + " pieces leftover "
                    + "if you order 1 pizza.\n");
        } else if (output != 1 && pizzaOrder != (int) pizzaOrder && remainingSlices != 1) {
            System.out.println("\n" + name + ", you will need to order at least " + output
                    + " pizzas to feed your guests.");
            System.out.println("There will be " + (int) remainingSlices + " pieces leftover "
                    + "if you order " + output + " pizzas.\n");
        } else if (output == 1 && pizzaOrder == (int) pizzaOrder) {
            System.out.println("\n" + name + ", you will need to order at least "
                    + "1 pizza to feed your guests");
            System.out.println("There will be no leftover pizza.\n");
        } else if (output != 1 && pizzaOrder == (int) pizzaOrder) {
            System.out.println("\n" + name + ", you will need to order at least " + output
                    + " pizzas to feed your guests.");
            System.out.println("There will be no leftover pizza.\n");
        }

        //Asks user if they want help calculating price and calculates price if yes
        while (costCalculation.equals("z")) {
            Scanner part6 = new Scanner(System.in);
            System.out.print("Do you need help calculating the cost (y or n)? ");
            costCalculation = part6.nextLine();
            if (costCalculation.equalsIgnoreCase("y")) {
                while (pizzaPlace.equals("z")) {
                    Scanner part7 = new Scanner(System.in);
                    System.out.println("\nWhere would you like to order pizza from? ");
                    System.out.print("You only have 5 choices: Dominoes(D), Papa Johns(PJ), "
                            + "Hungry Howies(HH), Jets(J) or Cottage Inn(CI): ");
                    pizzaPlace = part7.nextLine();
                    if (pizzaPlace.equalsIgnoreCase("D")) {
                        while (counter < 1) {
                            Scanner part8 = new Scanner(System.in);
                            System.out.print("\nHow many toppings would you like (0-10)? ");
                            int toppings = part8.nextInt();
                            if (toppings >= 0 && toppings <= 10) {
                                cost = (dominoes[row][toppings]) * output * 1.06;
                                String prettyCurrency = formatter.format(cost);

                                System.out.print("\n" + name + ", it will cost approximately " + prettyCurrency
                                        + " depending on which toppings you get");
                                counter = 1;
                            } else {
                                counter = 0;
                            }
                        }
                    } else if (pizzaPlace.equalsIgnoreCase("PJ")) {
                        while (counter < 1) {
                            Scanner part8 = new Scanner(System.in);
                            System.out.print("\nHow many toppings would you like (0-10)? ");
                            int toppings = part8.nextInt();
                            if (toppings >= 0 && toppings <= 10) {
                                cost = (papaJohns[row][toppings]) * output * 1.06;
                                String prettyCurrency = formatter.format(cost);

                                System.out.print("\n" + name + ", it will cost approximately " + prettyCurrency
                                        + " depending on which toppings you get");
                                counter = 1;
                            } else {
                                counter = 0;
                            }
                        }
                    } else if (pizzaPlace.equalsIgnoreCase("HH")) {
                        while (counter < 1) {
                            Scanner part8 = new Scanner(System.in);
                            System.out.print("\nHow many toppings would you like (0-10)? ");
                            int toppings = part8.nextInt();
                            if (toppings >= 0 && toppings <= 10) {
                                cost = (hungryHowies[row][toppings]) * output * 1.06;
                                String prettyCurrency = formatter.format(cost);

                                System.out.print("\n" + name + ", it will cost approximately " + prettyCurrency
                                        + " depending on which toppings you get");
                                counter = 1;
                            } else {
                                counter = 0;
                            }
                        }
                    } else if (pizzaPlace.equalsIgnoreCase("J")) {
                        while (counter < 1) {
                            Scanner part8 = new Scanner(System.in);
                            System.out.print("\nHow many toppings would you like (0-10)? ");
                            int toppings = part8.nextInt();
                            if (toppings >= 0 && toppings <= 10) {
                                cost = (jets[row][toppings]) * output * 1.06;
                                String prettyCurrency = formatter.format(cost);

                                System.out.print("\n" + name + ", it will cost approximately " + prettyCurrency
                                        + " depending on which toppings you get");
                                counter = 1;
                            } else {
                                counter = 0;
                            }
                        }
                    } else if (pizzaPlace.equalsIgnoreCase("CI")) {
                        while (counter < 1) {
                            Scanner part8 = new Scanner(System.in);
                            System.out.print("\nHow many toppings would you like (0-10)? ");
                            int toppings = part8.nextInt();
                            if (toppings >= 0 && toppings <= 10) {
                                cost = (cottageInn[row][toppings]) * output * 1.06;
                                String prettyCurrency = formatter.format(cost);

                                System.out.print("\n" + name + ", it will cost approximately " + prettyCurrency
                                        + " depending on which toppings you get");
                                counter = 1;
                            } else {
                                counter = 0;
                            }
                        }
                    } else {
                        pizzaPlace = "z";
                    }
                }
            } else if (costCalculation.equalsIgnoreCase("n")) {
                break;
            } else {
                costCalculation = "z";
            }
        }

        //Friendly little goodbye for the user
        System.out.println("\nI hope I was able to help you today " + name + "!");
    }

    public static void name() {
        while (name == null) {
            Scanner part1 = new Scanner(System.in);
            System.out.print("What is your name? ");
            name = part1.nextLine();
            if (lettersOnly(name) == true) {
                break;
            } else {
                name = null;
            }
        }
    }

    public static void numberOfGuests() {
        while (numberOfGuests == null) {
            Scanner part2 = new Scanner(System.in);
            System.out.print("\n" + name + ", how many guests will be coming to the party? ");
            numberOfGuests = part2.nextLine();
            int numberOfGuestsLength = numberOfGuests.length();

            if (digitsOnly(numberOfGuests, numberOfGuestsLength) == true) {
                break;
            } else {
                numberOfGuests = null;
            }
        }
    }

    public static void averagePizzaSlices() {
        while (averagePizzaSlices == null) {
            Scanner part3 = new Scanner(System.in);
            System.out.print("\n" + name + ", how many slices of pizza do you "
                    + "think each guest will eat on average? ");
            averagePizzaSlices = part3.nextLine();
            int averagePizzaSlicesLength = averagePizzaSlices.length();

            if (digitsOnly(numberOfGuests, averagePizzaSlicesLength) == true) {
                break;
            } else {
                averagePizzaSlices = null;
            }
        }
    }

    public static boolean lettersOnly(String str) {
        return ((str != null) && (!str.equals(" ")) && (str.matches("^[a-zA-Z]*$")));
    }

    public static boolean digitsOnly(String str, int n) {
        if (str == null) {
            return false;
        } else {
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(str.charAt(i))) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

}
