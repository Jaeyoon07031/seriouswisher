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

        for (Item item : ItemUtils.getOrderedItemList())
        {
            if (itemMap.containsKey(item))
            {
                System.out.println(ItemUtils.getPrintedString(item) + " - Held: " + itemMap.get(item));
            }
        }
    }
}
