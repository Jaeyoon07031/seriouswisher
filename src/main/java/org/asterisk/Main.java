package org.asterisk;

import java.util.*;
import org.asterisk.wishsimulator.*;
import org.asterisk.paymentprocessor.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        WishSimulator simulator = new WishSimulator();
        PaymentProcessor payments = new PaymentProcessor();

        System.out.println("INTRODUCTION_TEXT");

        for (;;)
        {
            System.out.println("CHOOSE_MENU_TEXT");
            String choice = console.nextLine();

            if (choice.equalsIgnoreCase("WISH"))
            {
                wishMenu();
            }
            else if (choice.equalsIgnoreCase("SHOP"))
            {
                shopMenu();
            }
            else if (choice.equalsIgnoreCase("INVENTORY"))
            {
                inventoryMenu();
            }
            else if (choice.equalsIgnoreCase("CHECKOUT"))
            {
                checkoutMenu(payments);
            }
            else
            {
                System.out.println("INVALID_CHOICE_TEXT");
            }
        }
    }

    private static void wishMenu()
    {

    }

    private static void shopMenu()
    {

    }

    private static void inventoryMenu()
    {

    }

    private static void checkoutMenu(PaymentProcessor payments)
    {
        final int TEMP_BALANCE = 100;
        payments.initializeTransaction(TEMP_BALANCE);
    }
}