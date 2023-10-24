package org.asterisk.menus;

import java.util.*;

import com.diogonunes.jcolor.*;

import org.asterisk.util.*;
import org.asterisk.wishsimulator.*;

public class WishMenu
{
    private static final String STAR = "✪";
    private static final AnsiFormat THREE_STAR = new AnsiFormat(Attribute.BRIGHT_WHITE_TEXT(), Attribute.BLUE_BACK());
    private static final AnsiFormat FOUR_STAR = new AnsiFormat(Attribute.BRIGHT_WHITE_TEXT(), Attribute.MAGENTA_BACK(), Attribute.ITALIC());
    private static final AnsiFormat FIVE_STAR = new AnsiFormat(Attribute.BRIGHT_WHITE_TEXT(), Attribute.YELLOW_BACK(), Attribute.BOLD());

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
                player.setPurpleFates(player.getPurpleFates() - wishCount);
                printWishResults(result);

                ItemManifest oldInventory = player.getInventory();
                oldInventory.addAll(result.getArray());
                player.setInventory(oldInventory);
                return;
            }
            else if (response.equalsIgnoreCase("WEAPON"))
            {
                //TODO: make weapon banner
                System.out.println("You are now pulling on the Limited Weapon Banner.");
                int wishCount = askLimitedWishCount(console, player);
                return;
            }
            else if (response.equalsIgnoreCase("STANDARD"))
            {
                System.out.println("You are now pulling on the Standard Banner.");
                int wishCount = askStandardWishCount(console, player);

                ItemManifest result = simulator.simulateStandardWish(player, wishCount);
                player.setBlueFates(player.getBlueFates() - wishCount);
                printWishResults(result);

                ItemManifest oldInventory = player.getInventory();
                oldInventory.addAll(result.getArray());
                player.setInventory(oldInventory);
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
        System.out.println("Wish Results");
        for (Item item : manifest.getArray())
        {
            String output = "";
            output = output + ItemUtils.getItemDisplayName(item) + " - ";
            for (int i = 0; i < ItemUtils.getItemRarity(item); i++)
            {
               output = output + STAR;
            }

            if (ItemUtils.getItemRarity(item) == 3)
            {
                System.out.println(THREE_STAR.format(output));
            }
            else if (ItemUtils.getItemRarity(item) == 4)
            {
                System.out.println(FOUR_STAR.format(output));
            }
            else
            {
                System.out.println(FIVE_STAR.format(output));
            }
        }
    }
}
