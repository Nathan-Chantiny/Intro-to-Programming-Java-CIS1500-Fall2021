package project2;

import java.awt.AWTException;
import java.util.Random;
import java.util.Scanner;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Project2 {

    // Scanner
    public static Scanner keyboard = new Scanner(System.in);

    // Variables
    public static String commands = "";

    public static int health = 10;
    public static int turnNumber = 0;
    public static int northCounter = 0;
    public static int eastCounter = 0;
    public static int southCounter = 0;
    public static int westCounter = 0;
    public static int hideCounter = 0;
    public static int searchCounter = 0;
    public static int fightCounter = 0;
    public static int sneakCounter = 0;
    public static int sleepCounter = 0;
    public static int turnOneCheck = 0;
    public static int storyNumber;
    public static int searchNumber;

    // Some RNG to make the game a very very very small amount more interesting
    public static Random rNG = new Random();

    public static void main(String[] args) {

        introduction();

        // Main code for the game
        while (!commands.equals("diggersby")) {
            // Random number between 0 & 2, including 0 and 2
            storyNumber = rNG.nextInt(3);

            // Recurring message for user to play the game
            if (turnOneCheck == 0 && commands.equalsIgnoreCase("")) {
                // Message for first turn
                mousePositionClick(683, 512);
                pause(100);
                clearScreen();
                userMove("What will your move be? ");
                turnOneCheck++;
            } else if (turnOneCheck >= 0 && commands.equalsIgnoreCase("help")
                    || commands.equalsIgnoreCase("health") || commands.equalsIgnoreCase("Sleep")) {
                // So that commands list or health isn't immediatly cleared
                System.out.print("What will your next move be? ");
                commands = keyboard.nextLine();
            } else {
                // Message for turns that are greater than 1
                pause(5000);
                clearScreen();
                userMove("What will your next move be? ");
            }

            // All the possible commands
            if (commands.equalsIgnoreCase("North") && health > 1) {
                north();

                health--;
                northCounter++;
            } else if (commands.equalsIgnoreCase("East") && health > 1) {
                east();

                health--;
                eastCounter++;
            } else if (commands.equalsIgnoreCase("South") && health > 1) {
                south();

                health--;
                southCounter++;
            } else if (commands.equalsIgnoreCase("West") && health > 1) {
                west();

                health--;
                westCounter++;
            } else if (commands.equalsIgnoreCase("Hide")) {
                hide();

                hideCounter++;
            } else if (commands.equalsIgnoreCase("Search")) {
                searchNumber = rNG.nextInt(10);

                search();

                searchCounter++;
            } else if (commands.equalsIgnoreCase("Fight")) {
                fight();

                fightCounter++;
            } else if (commands.equalsIgnoreCase("Sneak")) {
                sneak();

                sneakCounter++;
            } else if (commands.equalsIgnoreCase("Sleep")) {
                sleep();

                sleepCounter++;
            } else if (commands.equalsIgnoreCase("diggersby")) { // Diggersby is my favorite pokemon
                clearScreen();
                pause(100);

                turnNumber++;
                congratsScreen();
            } else if (commands.equalsIgnoreCase("help")) {
                help();
            } else if (commands.equalsIgnoreCase("Health")) {
                healthCheck();
            } else if (health == 1) {
                warning();
            } else {
                disappointment();
            }
        }
    }

    // Displays the introduction
    public static void introduction() {
        System.out.print("In Honor of Zork\n" + "I give you..."
                + "\n\"Zork the Bad Version\"\n");
        System.out.println("\n"
                + "You wake up from a long rest.\n"
                + "After trying to figure out what you want to do with your day, "
                + "you decide you want to explore.\n"
                + "You eat a hearty meal, drink some coffee and then head out on your adventure.\n"
                + "To beat the game you must guess the secret escape word.\n"
                + "\nIf you need help type \"help\"\n"
        );
        pause(10000);
    }

    // Gets what the user wants their next move to be
    public static String userMove(String prompt) {
        System.out.print(prompt);
        pause(500);
        mousePositionClick(683, 256);
        commands = keyboard.nextLine();

        return commands;
    }

    // Commands list
    public static void north() {
        System.out.println("");
        if (storyNumber == 0) {
            System.out.println(
                    "You head north and encounter a well lit cave"
            );
        } else if (storyNumber == 1) {
            System.out.println(
                    "You head north and encounter a dark cavern"
            );
        } else if (storyNumber == 2) {
            System.out.println(
                    "You head north and encounter a damp ravine"
            );
        }
    }

    public static void east() {
        System.out.println("");
        if (storyNumber == 0) {
            System.out.println(
                    "You head east and encounter a lake"
            );
        } else if (storyNumber == 1) {
            System.out.println(
                    "You head east and encounter a great sea"
            );
        } else if (storyNumber == 2) {
            System.out.println(
                    "You head east and encounter a small creek"
            );
        }
    }

    public static void south() {
        System.out.println("");
        if (storyNumber == 0) {
            System.out.println(
                    "You head south and encounter a castle"
            );
        } else if (storyNumber == 1) {
            System.out.println(
                    "You head south and encounter a small village"
            );
        } else if (storyNumber == 2) {
            System.out.println(
                    "You head south and encounter a bustling market"
            );
        }
    }

    public static void west() {
        System.out.println("");
        if (storyNumber == 0) {
            System.out.println(
                    "You head west and encounter a vast dry desert"
            );
        } else if (storyNumber == 1) {
            System.out.println(
                    "You head west and encounter a wide open plain"
            );
        } else if (storyNumber == 2) {
            System.out.println(
                    "You head west and encounter a wet forest"
            );
        }
    }

    public static void hide() {
        System.out.println("");
        if (storyNumber == 0) {
            System.out.println(
                    "You quickly jump behind the nearest rock"
            );
        } else if (storyNumber == 1) {
            System.out.println(
                    "You quickly jump behind the nearest tree"
            );
        } else if (storyNumber == 2) {
            System.out.println(
                    "You quickly jump down and grab onto the nearest ledge"
            );
        }
    }

    public static void search() {
        System.out.println("");
        if (searchNumber >= 0 && searchNumber <= 2) {
            System.out.println(
                    "After searching hard for several minutes you find nothing, "
                    + "but are now covered in dirt"
            );
        } else if (searchNumber >= 3 && searchNumber <= 5) {
            System.out.println(
                    "You're feeling lazy so you quickly scan the area and move on"
            );
        } else if (searchNumber >= 6 && searchNumber <= 8) {
            System.out.println(
                    "You look around and see only mud, "
                    + "so you decide it's not worth it to look for anything"
            );
        } else if (searchNumber == 9) {
            // Reward for persistently searching
            System.out.println(""
                    + "After looking around and digging at the ground you notice what appears "
                    + "to be the corner of a wooden box.\nYou keep digging to discover that "
                    + "you have found a small wooden box.\nIt looks old and feels rather heavy "
                    + "for its size.\nThere is no lock or anything else preventing you from "
                    + "getting into the box so you decide to open it.\nIn it you find a vial "
                    + "filled with a glowing red substance.\nYou find nothing else in the box, "
                    + "but decide to drink it because why not?\nA couple of seconds after "
                    + "drinking it you begin to feel amazing, as if Zork himself had just "
                    + "breathed new life into your lungs."
            );
            // 10% chance of getting +20 health
            health += 20;
            System.out.println("\nHealth: " + health);
            pause(20000);
        }
    }

    public static void fight() {
        System.out.println("");
        if (storyNumber == 0) {
            System.out.println(
                    "You bravely face a great 5 headed dragon with nothing but"
            );
        } else if (storyNumber == 1) {
            System.out.println(
                    "You find a local itching for a fight and you can't turn down a challenge"
            );
        } else if (storyNumber == 2) {
            System.out.println(
                    "You encounter a wild beast that doesn't appear to have eaten in days"
            );
        }
    }

    public static void sneak() {
        System.out.println("");
        if (storyNumber == 0) {
            System.out.println(
                    "You get down and army crawl under the barrier"
            );
        } else if (storyNumber == 1) {
            System.out.println(
                    "You crouch down and tip toe around some guards"
            );
        } else if (storyNumber == 2) {
            System.out.println(
                    "You jump in a nearby lake to swim around danger"
            );
        }
    }

    public static void sleep() {
        System.out.println("");
        if (health >= 10) {
            // In case health is greater than or equal to 10, health does not change
            System.out.println("You quickly drift off to sleep after adventuring all day");
            System.out.println("\nHealth: " + health + "\n");
        } else if (health >= 1 && health < 10) {
            System.out.println("You quickly drift off to sleep after adventuring all day");
            health = 10;
            System.out.println("\nHealth: " + health + "\n");
        }
    }

    public static void healthCheck() {
        System.out.println("\nHealth: " + health + "\n");
    }

    public static void help() {
        System.out.println("\nCommand list:\n"
                + "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
                + "<> North -- Move to the north of your current position to face a new challenge. <>\n"
                + "<> East --- Move to the east of your current position to face a new challenge.  <>\n"
                + "<> South -- Move to the south of your current position to face a new challenge. <>\n"
                + "<> West --- Move to the west of your current position to face a new challenge.  <>\n"
                + "<> Hide --- Hide wherever you possibly can and hope you're not found.           <>\n"
                + "<> Search - Look around in hopes of finding something helpful.                  <>\n"
                + "<> Fight -- Fight off whatever might be putting you in danger.                  <>\n"
                + "<> Sneak -- Sneak past whatever foe is in your way.                             <>\n"
                + "<> Sleep -- Go to sleep and fully restore your health to 10.                    <>\n"
                + "<> Health - Type Health to check your current health.                           <>\n"
                + "<> help --- Type help to see this list of commands again.                       <>\n"
                + "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
        );
    }

    // Warns player that they must sleep to restore their health, and tells them their health
    public static void warning() {
        System.out.println("\nYou must sleep to restore your health");
        System.out.println("\nHealth: " + health);
    }

    // For when the player does something they're not supposed to do
    public static void disappointment() {
        System.out.println("\nYou can't do that");
    }

    // Congratulates the player on beating the game
    public static void congratsScreen() {
        // Little calculation for stat output to user
        turnNumber = turnNumber + northCounter + eastCounter + southCounter + westCounter
                + hideCounter + searchCounter + fightCounter + sneakCounter + sleepCounter;

        // Tells the user their stats
        System.out.println("\nYou've guessed the secret escape word and have beaten the game!");
        System.out.println("Congratulations on escaping that terrible game!");
        System.out.println("\n"
                + "<><><><><><><><><><><><><><><><><><><><><><><><><><><>\n"
                + "<> You used the--------North command " + northCounter + " times\n"
                + "<> You used the---------East command " + eastCounter + " times\n"
                + "<> You used the--------South command " + southCounter + " times\n"
                + "<> You used the---------West command " + westCounter + " times\n"
                + "<> You used the---------Hide command " + hideCounter + " times\n"
                + "<> You used the-------Search command " + searchCounter + " times\n"
                + "<> You used the--------Fight command " + fightCounter + " times\n"
                + "<> You used the--------Sneak command " + sneakCounter + " times\n"
                + "<> You used the--------Sleep command " + sleepCounter + " times\n"
                + "<> You used the---secret escape word 1 time\n"
                + "<> ***************************************************\n"
                + "<> For a total of ================== " + turnNumber + " turns\n"
                + "<> You had " + health + " health\n"
                + "<><><><><><><><><><><><><><><><><><><><><><><><><><><>"
        );
    }

    public static void mousePositionClick(int x, int y) {
        try {
            Robot robot = new Robot();
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            System.out.println("beep boop");
        }
    }

    public static void clearScreen() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException e) {
            System.out.println("beep boop");
        }
    }

    public static void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.out.println("fast forward I suppose");
        }
    }
}
