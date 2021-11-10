package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TxtTools {

    private Scanner stringKeeb = new Scanner(System.in);
    private Scanner doubleKeeb = new Scanner(System.in);

    private File fileName;

    public TxtTools(File fileName) {
        this.fileName = fileName;
    }

    public void createTxt(String itemName, Double itemPrice, Integer itemQuantity) {
        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            printWriter.println(itemName);
            printWriter.println(itemPrice);
            printWriter.println(itemQuantity);

            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void changeFile(String itemName, String itemPrice, String itemQuantity) {
        System.out.println("Do you need to change the quantity or price? ");
        String changeType = stringKeeb.nextLine();
        if (changeType.equalsIgnoreCase("QUANTITY")) {
            System.out.println("What is the new quantity? ");
            itemQuantity = stringKeeb.nextLine();

            fileOverwrite(itemName, itemPrice, itemQuantity);
        } else if (changeType.equalsIgnoreCase("PRICE")) {
            System.out.println("What is the new price? ");
            itemPrice = doubleKeeb.nextLine();

            fileOverwrite(itemName, itemPrice, itemQuantity);
        } else {
            System.out.println("That is not a valid option");
        }
    }

    public String fileRead(String fileName, int i) {
        String line = "";
        fileName = fileName.concat(".txt");

        try {
            line = Files.readAllLines(Paths.get(fileName)).get(i);
        } catch (IOException e) {
            System.out.println(e);
        }

        return line;
    }

    public void fileOverwrite(String itemName, String itemPrice, String itemQuantity) {
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(fileName);

            printWriter.println(itemName);
            printWriter.println(itemPrice);
            printWriter.println(itemQuantity);

            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
