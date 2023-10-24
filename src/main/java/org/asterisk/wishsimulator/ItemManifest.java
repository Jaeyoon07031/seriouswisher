package org.asterisk.wishsimulator;

import java.util.*;

public class ItemManifest
{
    ArrayList<Item> unsortedManifest;
    HashMap<Item, Integer> itemCount;

    public ItemManifest(ArrayList<Item> itemList)
    {
        unsortedManifest = new ArrayList<Item>();
        itemCount = new HashMap<Item, Integer>();

        addAll(itemList);
    }

    public void add(Item item)
    {
        unsortedManifest.add(item);
        if (itemCount.containsKey(item))
        {
            itemCount.put(item, itemCount.get(item) + 1);
        }
        else
        {
            itemCount.put(item, 1);
        }
    }

    public void addAll(ArrayList<Item> itemList)
    {
        for (Item item : itemList)
        {
            add(item);
        }
    }

    public ArrayList<Item> getArray()
    {
        return unsortedManifest;
    }

    public Map<Item, Integer> getMap()
    {
        return itemCount;
    }
}
