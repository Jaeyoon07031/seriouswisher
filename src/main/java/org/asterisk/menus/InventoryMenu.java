package org.asterisk.menus;

import java.util.*;

import org.asterisk.util.*;
import org.asterisk.wishsimulator.Item;

public class InventoryMenu
{
    public void inventoryMenu(Player player)
    {
        System.out.println("Your Inventory: ");
        Map itemMap = player.getInventory().getMap();

        boolean itemPresent = false;

        for (Item item : ItemUtils.getOrderedItemList())
        {
            if (itemMap.containsKey(item))
            {
                itemPresent = true;
                System.out.println(ItemUtils.getPrintedString(item) + " - Held: " + itemMap.get(item));
            }
        }

        if (!itemPresent)
        {
            System.out.println("It's empty in here...");
        }
    }
}
