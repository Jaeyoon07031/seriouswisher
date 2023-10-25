package org.asterisk.menus;

import java.util.*;

import org.asterisk.util.*;

public class ShopMenu
{
    private final double[] prices = {0, 0.99, 4.99, 14.99, 29.99, 49.99, 99.99};
    private final int[] crystals = {0, 60, 330, 1090, 2240, 3880, 8080};

    public double shopMenu(Player player, Scanner console)
    {
        System.out.println("Top-Up Menu");
        System.out.println("Option 1 - 60 Primogems - $0.99");
        System.out.println("Option 2 - 300 Primogems + 30 Bonus - $4.99");
        System.out.println("Option 3 - 980 Primogems + 110 Bonus - $14.99");
        System.out.println("Option 4 - 1980 Primogems + 260 Bonus - $29.99");
        System.out.println("Option 5 - 3280 Primogems + 600 Bonus - $49.99");
        System.out.println("Option 6 - 6480 Primogems + 1600 Bonus - $99.99 (BEST VALUE!)");

        for (;;)
        {
            int option = InputUtils.inputProtectedInteger("Choose an Option Number", console, 1, 6);

            System.out.println(crystals[option] + " primogems were added to your account!");
            System.out.println("You may pay your outstanding balance by navigating to the CHECKOUT menu from the main screen");

            System.out.println(" - press enter to continue - ");
            console.nextLine();

            player.setPrimogems(player.getPrimogems() + crystals[option]);
            return prices[option];
        }
    }
}
