package org.asterisk.wishsimulator;

import java.util.*;
import org.asterisk.wishsimulator.Item;

public class ItemManifest
{
    ArrayList<Item> unsortedManifest;
    ArrayList<Item> sortedManifest;

    public ItemManifest(ArrayList<Item> itemList)
    {
        unsortedManifest = itemList;
        sortedManifest = sortItemManifest(itemList);
    }

    private ArrayList<Item> sortItemManifest(ArrayList<Item> itemList)
    {
        //TODO: actually sort them
        return itemList;
    }
}
