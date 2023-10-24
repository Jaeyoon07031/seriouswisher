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
        InventoryMenu inventoryMenu = new InventoryMenu();
        PaymentProcessor payments = new PaymentProcessor();

        //TODO: write an introduction and gambling hotline thing lmao
        System.out.println("INTRODUCTION_TEXT");

        for (;;)
        {
            System.out.println("CHOOSE_MENU_TEXT");
            String choice = console.nextLine();

            if (choice.equalsIgnoreCase("WISH"))
            {
                WishMenu.wishMenu(console, simulator, player);
            }
            else if (choice.equalsIgnoreCase("SHOP"))
            {
                shopMenu();
            }
            else if (choice.equalsIgnoreCase("INVENTORY"))
            {
                inventoryMenu(inventoryMenu, player);
            }
            else if (choice.equalsIgnoreCase("CHECKOUT"))
            {
                checkoutMenu(payments);
            }
            else if (choice.equalsIgnoreCase("HELP"))
            {
                helpMenu();
            }
            else
            {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void shopMenu()
    {

    }

    private static void inventoryMenu(InventoryMenu inventoryMenu, Player player)
    {
        inventoryMenu.openMenu(player);
    }

    private static void checkoutMenu(PaymentProcessor payments)
    {
        final int TEMP_BALANCE = 100;
        payments.initializeTransaction(TEMP_BALANCE);
    }

    private static void helpMenu()
    {
        //TODO: write useful info
        System.out.println("USEFUL_INFO_TEXT");
    }
}