package org.asterisk.wishsimulator;

import java.util.*;

public class ItemManifest
{
    ArrayList<Item> unsortedManifest;

    public ItemManifest(ArrayList<Item> itemList)
    {
        unsortedManifest = itemList;
    }

    public void add(Item item)
    {
        unsortedManifest.add(item);
    }

    public ArrayList<Item> getArray()
    {
        return unsortedManifest;
    }
}
