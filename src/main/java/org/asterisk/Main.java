package org.asterisk;

import java.util.*;
import org.asterisk.util.Player;
import org.asterisk.menus.*;
import org.asterisk.wishsimulator.*;
import org.asterisk.paymentprocessor.*;

//TODO: change all the for(;;)s in the program for legit loops please thanks future me

public class Main
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        Player player = new Player();
        WishSimulator simulator = new WishSimulator();
        InventoryMenu inventory = new InventoryMenu();
        PaymentProcessor payments = new PaymentProcessor();
        ShopMenu shop = new ShopMenu();

        double outstandingBalance = 0;

        System.out.println("Welcome to \"Serious Wisher\"!");

        for (;;)
        {
            System.out.println("Choose a menu: ");
            System.out.println("WISH - wish for new items");
            System.out.println("SHOP - obtain more gems");
            System.out.println("INVENTORY - see the items you have already obtained");
            System.out.println("CHECKOUT - pay for your gem purchases");
            System.out.println("HELP - see a short tutorial");
            System.out.println("EXIT - exit the program");

            String choice = console.nextLine();

            if (choice.equalsIgnoreCase("WISH"))
            {
                // why is this the only one not instantiated???
                WishMenu.wishMenu(console, simulator, player);
            }
            else if (choice.equalsIgnoreCase("SHOP"))
            {
                outstandingBalance = outstandingBalance + shop.shopMenu(player, console);
            }
            else if (choice.equalsIgnoreCase("INVENTORY"))
            {
                inventory.inventoryMenu(player);
            }
            else if (choice.equalsIgnoreCase("CHECKOUT"))
            {
                if (outstandingBalance == 0)
                {
                    System.out.println("You don't have an outstanding balance!");
                    continue;
                }
                payments.initializeTransaction(outstandingBalance, console);
                outstandingBalance = 0;
            }
            else if (choice.equalsIgnoreCase("HELP"))
            {
                helpMenu();
            }
            else if (choice.equalsIgnoreCase("EXIT"))
            {
                if (outstandingBalance == 0)
                {
                    System.out.println("Thank you for playing!");
                    return;
                }
                else
                {
                    System.out.println("You still have an outsanding balance, pay that in CHECKOUT first!");
                }
            }
            else
            {
                System.out.println("Not a valid option, try again");
            }
        }
    }

    private static void helpMenu()
    {
        //TODO: write useful info
        System.out.println("\"Wish\" for characters and items!");
        System.out.println("\"Intertwined Fate\" used for LIMITED and WEAPON wishes");
        System.out.println("\"Acquaint Fate\" used for STANDARD wishes");
        System.out.println("Each Fate is 160 \"Primogems\" each, and can be converted when you wish");
        System.out.println("4-Star Item GUARANTEED every 10 pulls on any banner");
        System.out.println("5-Star Item GUARANTEED every 90 pulls on STANDARD/LIMITED, or 80 pulls on WEAPON");
        System.out.println("Probability of 5-STar Item increases significantly in the last 10 pulls before guaranteed");
        System.out.println("50% Probability of a LIMITED 5-Star Character, 50% Probability of a STANDARD 5-Star Character when pulling on LIMITED");
        System.out.println("75% Probability of a LIMITED 5-Star Weapon, 25% Probability of a STANDARD 5-Star Weapon when pulling on WEAPON");
    }
}