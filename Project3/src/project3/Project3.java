package project3;

import java.util.Scanner;

public class Project3 {

    public static Scanner intKeyboard = new Scanner(System.in);
    public static Scanner stringKeyboard = new Scanner(System.in);

    public static int numberOfPlanes;

    public static String[] planeMakes;
    public static String[] planeModels;
    public static String[] planeNumbers;
    public static int[] planeMaxAltitudes;

    public static void main(String[] args) {

        int whichPlane;

        System.out.print("How many planes are there? ");
        numberOfPlanes = intKeyboard.nextInt();

        planeMakes = new String[numberOfPlanes];
        planeModels = new String[numberOfPlanes];
        planeNumbers = new String[numberOfPlanes];
        planeMaxAltitudes = new int[numberOfPlanes];

        planeInfoAssignment();

        planeInformation();

        String wantInfo = "yes";

        while (wantInfo.equalsIgnoreCase("YES")) {
            System.out.print("What plane do you want to find out about? ");
            whichPlane = intKeyboard.nextInt();
            planeAssignment(whichPlane);

            System.out.print("Do you want more information (yes or no)? ");
            wantInfo = stringKeyboard.nextLine();
        }
    }

    public static String planeMake(String prompt) {
        String planeMake;

        System.out.print(prompt);
        planeMake = stringKeyboard.nextLine();

        return planeMake;
    }

    public static String planeModel(String prompt) {
        String planeModel;

        System.out.print(prompt);
        planeModel = stringKeyboard.nextLine();

        return planeModel;
    }

    public static String planeNumber(String prompt) {
        String planeNumber;

        System.out.print(prompt);
        planeNumber = stringKeyboard.nextLine();

        return planeNumber;
    }

    public static int planeMaxAltitude(String prompt) {
        int planeMaxAltitude;

        System.out.print(prompt);
        planeMaxAltitude = intKeyboard.nextInt();

        return planeMaxAltitude;
    }

    public static void planeInfoAssignment() {
        for (int i = 0; i < numberOfPlanes; i++) {
            System.out.println("\nPlane " + (i + 1) + ":");
            planeMakes[i] = planeMake("\nWhat is the make of the plane? ");
            planeModels[i] = planeModel("\nWhat is the model of the plane? ");
            planeNumbers[i] = planeNumber("\nWhat is the number of the plane? ");
            planeMaxAltitudes[i] = planeMaxAltitude("\nWhat is the max altitude in meters of the plane? ");
        }
    }

    public static void planeInformation() {
        System.out.println("\nPlane information:\n");
        for (int i = 0; i < numberOfPlanes; i++) {
            System.out.print(""
                    + "     Plane " + (i + 1) + ":\n"
                    + "        Make: " + planeMakes[i] + "\n"
                    + "       Model: " + planeModels[i] + "\n"
                    + "      Number: " + planeNumbers[i] + "\n"
                    + "Max Altitude: " + planeMaxAltitudes[i] + "\n\n");
        }
    }

    public static void planeAssignment(int i) {
        if (i >= 0 && i <= numberOfPlanes) {
            i--;
            System.out.println("\n~~~~~~~~ Plane " + (i + 1) + " ~~~~~~~~~");
            System.out.println("        Make: " + planeMakes[i]);
            System.out.println("       Model: " + planeModels[i]);
            System.out.println("      Number: " + planeNumbers[i]);
            System.out.println("Max Altitude: " + planeMaxAltitudes[i]);
            System.out.println("");
        } else {
            System.out.println("Not a valid number");
        }
    }
}
