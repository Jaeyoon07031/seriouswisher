package org.asterisk.wishsimulator;

import java.util.*;

import org.asterisk.util.ItemUtils;
import org.asterisk.util.Player;
import org.asterisk.wishsimulator.Item;

public class WishSimulator
{
    private final Random gen;

    private final double FIVE_CHANCE = 0.006;
    private final double WEAPON_FIVE_CHANCE = 0.008;
    private final double FOUR_CHANCE = 0.051;

    public WishSimulator()
    {
        this.gen = new Random();
    }

    public ItemManifest simulateStandardWish(Player player, int pulls)
    {
        ItemManifest results = new ItemManifest(new ArrayList<Item>());
        int fourPity = player.getStandardFourPity();
        int fivePity = player.getStandardFivePity();

        for (int i = 0; i < pulls; i++)
        {
            fourPity++;
            fivePity++;

            if (fivePity > 75)
            {
                if (gen.nextDouble() < FIVE_CHANCE + ((fivePity - 75) * 0.06))
                {
                    results.add(addStandardFive());
                    fivePity = 0;
                    continue;
                }
            }
            else
            {
                if (gen.nextDouble() < FIVE_CHANCE)
                {
                    results.add(addStandardFive());
                    fivePity = 0;
                    continue;
                }
            }

            if (fourPity == 10)
            {
                results.add(addStandardFour());
                fourPity = 0;
                continue;
            }
            else
            {
                if (gen.nextDouble() < FOUR_CHANCE)
                {
                    results.add(addStandardFour());
                    fourPity = 0;
                    continue;
                }
            }

            int chosenThree = gen.nextInt(ItemUtils.getItems("STANDARD", "WEAPON", 3).size());
            results.add(ItemUtils.getItems("STANDARD", "WEAPON", 3).get(chosenThree));
        }

        player.setStandardFourPity(fourPity);
        player.setStandardFivePity(fivePity);

        return results;
    }

    public ItemManifest simulateLimitedWish(Player player, int pulls)
    {
        ItemManifest results = new ItemManifest(new ArrayList<Item>());
        int fourPity = player.getLimitedFourPity();
        int fivePity = player.getLimitedFivePity();

        for (int i = 0; i < pulls; i++)
        {
            fourPity++;
            fivePity++;

            if (fivePity > 75)
            {
                if (gen.nextDouble() < FIVE_CHANCE + ((fivePity - 75) * 0.06))
                {
                    results.add(addLimitedFive());
                    fivePity = 0;
                    continue;
                }
            }
            else
            {
                if (gen.nextDouble() < FIVE_CHANCE)
                {
                    results.add(addLimitedFive());
                    fivePity = 0;
                    continue;
                }
            }

            if (fourPity == 10)
            {
                results.add(addLimitedFour());
                fourPity = 0;
                continue;
            }
            else
            {
                if (gen.nextDouble() < FOUR_CHANCE)
                {
                    results.add(addLimitedFour());
                    fourPity = 0;
                    continue;
                }
            }

            int chosenThree = gen.nextInt(ItemUtils.getItems("LIMITED", "WEAPON", 3).size());
            results.add(ItemUtils.getItems("LIMITED", "WEAPON", 3).get(chosenThree));
        }

        player.setLimitedFourPity(fourPity);
        player.setLimitedFivePity(fivePity);

        return results;
    }

    public ItemManifest simulateWeaponWish(int pulls)
    {
        return new ItemManifest(new ArrayList<Item>());
    }

    public Item addStandardFive()
    {
        if (gen.nextInt(2) == 0)
        {
            int chosenFive = gen.nextInt(ItemUtils.getItems("STANDARD", "CHARACTER", 5).size());
            return ItemUtils.getItems("STANDARD", "CHARACTER", 5).get(chosenFive);
        }
        else
        {
            int chosenFive = gen.nextInt(ItemUtils.getItems("STANDARD", "WEAPON", 5).size());
            return ItemUtils.getItems("STANDARD", "WEAPON", 5).get(chosenFive);
        }
    }

    public Item addStandardFour()
    {
        if (gen.nextInt(2) == 0)
        {
            int chosenFour = gen.nextInt(ItemUtils.getItems("STANDARD", "CHARACTER", 4).size());
            return ItemUtils.getItems("STANDARD", "CHARACTER", 4).get(chosenFour);
        }
        else
        {
            int chosenFour = gen.nextInt(ItemUtils.getItems("STANDARD", "WEAPON", 4).size());
            return ItemUtils.getItems("STANDARD", "WEAPON", 4).get(chosenFour);
        }
    }

    public Item addLimitedFive()
    {
        if (gen.nextInt(2) == 0)
        {
            int chosenFive = gen.nextInt(ItemUtils.getItems("LIMITED", "CHARACTER", 5).size());
            return ItemUtils.getItems("LIMITED", "CHARACTER", 5).get(chosenFive);
        }
        else
        {
            return ItemUtils.getLimitedFiveCharacter();
        }
    }

    public Item addLimitedFour()
    {
        if (gen.nextInt(2) == 0)
        {
            int chosenFive = gen.nextInt(ItemUtils.getItems("LIMITED", "CHARACTER", 4).size());
            return ItemUtils.getItems("LIMITED", "CHARACTER", 4).get(chosenFive);
        }
        else
        {
            int chosenFive = gen.nextInt(ItemUtils.getItems("LIMITED", "WEAPON", 4).size());
            return ItemUtils.getItems("LIMITED", "WEAPON", 4).get(chosenFive);
        }
    }
}
