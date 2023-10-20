package org.asterisk.menus;

import java.util.Scanner;

import org.asterisk.util.*;
import org.asterisk.wishsimulator.*;

public class WishMenu
{
    public static void wishMenu(Scanner console, WishSimulator simulator, Player player)
    {
        for (;;)
        {
            System.out.println("WISH_MENU_INTRO_TEXT");
            System.out.println("LIMITED - A rotating banner where you can get limited characters");
            System.out.println("WEAPON - A rotating banner where you can get limited weapons for limited characters");
            System.out.println("STANDARD - A static banner where you can always get standard characters and standard weapons");

            String response = console.nextLine();

            if (response.equalsIgnoreCase("LIMITED"))
            {
                System.out.println("You are now pulling on the Limited Character Banner.");
                int wishCount = askLimitedWishCount(console, player);

                ItemManifest result = simulator.simulateLimitedWish(player, wishCount);
                return;
            }
            else if (response.equalsIgnoreCase("WEAPON"))
            {
                System.out.println("You are now pulling on the Limited Weapon Banner.");
                int wishCount = askLimitedWishCount(console, player);
                return;
            }
            else if (response.equalsIgnoreCase("STANDARD"))
            {
                System.out.println("You are now pulling on the Standard Banner.");
                int wishCount = askStandardWishCount(console, player);

                ItemManifest result = simulator.simulateStandardWish(player, wishCount);
                return;
            }
            else
            {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    //TODO: fix getting stuck in wishUI forever if you have 0 pulls

    private static int askLimitedWishCount(Scanner console, Player player)
    {
        int primoPulls = (player.getPrimogems() / 160);
        int fatePulls = player.getPurpleFates();

        for (;;)
        {
            int response = InputUtils.inputProtectedInteger("How many pulls do you want to do? (Max 10 at a time)",
                    console, 1, 10);

            if (response > primoPulls + fatePulls)
            {
                System.out.println("Not enough fates to pull " + response + " times.");
                continue;
            }
            else if (response > fatePulls)
            {
                System.out.println("Need " + (response - fatePulls) + " more fates. Convert " + ((response - fatePulls) * 160) + " primogems?");
                System.out.print("Y/N:   ");
                String convertResponse = console.nextLine();

                if (convertResponse.equalsIgnoreCase("Y"))
                {
                    player.setPrimogems(player.getPrimogems() - ((response - fatePulls) * 160));
                    player.setPurpleFates(player.getPurpleFates() + (response - fatePulls));
                    //TODO: fix pulls not being consumed
                }
                else
                {
                    continue;
                }
            }

            return response;
        }
    }

    private static int askStandardWishCount(Scanner console, Player player)
    {

        int primoPulls = (player.getPrimogems() / 160);
        int fatePulls = player.getBlueFates();

        for (;;)
        {
            int response = InputUtils.inputProtectedInteger("How many pulls do you want to do? (Max 10 at a time)",
                    console, 1, 10);

            if (response > primoPulls + fatePulls)
            {
                System.out.println("Not enough fates to pull " + response + " times.");
                continue;
            }
            else if (response > fatePulls)
            {
                System.out.println("Need " + (response - fatePulls) + " more fates. Convert " + ((response - fatePulls) * 160) + " primogems?");
                System.out.print("Y/N:   ");
                String convertResponse = console.nextLine();

                if (convertResponse.equalsIgnoreCase("Y"))
                {
                    player.setPrimogems(player.getPrimogems() - ((response - fatePulls) * 160));
                    player.setPurpleFates(player.getBlueFates() + (response - fatePulls));
                }
                else
                {
                    continue;
                }
            }

            return response;
        }
    }

    private static void printWishResults(ItemManifest manifest)
    {

    }
}
