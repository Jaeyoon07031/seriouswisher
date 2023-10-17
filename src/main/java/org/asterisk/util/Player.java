package org.asterisk.util;

import org.asterisk.wishsimulator.*;
import java.util.ArrayList;

public class Player
{
    private int primogems;
    private int blueFates;
    private int purpleFates;
    private int outstandingBalance;

    private ItemManifest inventory;

    public Player()
    {
        primogems = 16000;
        blueFates = 50;
        purpleFates = 0;
        outstandingBalance = 0;

        inventory = new ItemManifest(new ArrayList<Item>());
    }

    public int getPrimogems()
    {
        return primogems;
    }

    public void setPrimogems(int newAmount)
    {
        primogems = newAmount;
    }
    public int getBlueFates()
    {
        return blueFates;
    }

    public void setBlueFates(int newAmount)
    {
        blueFates = newAmount;
    }
    public int getPurpleFates()
    {
        return purpleFates;
    }

    public void setPurpleFates(int newAmount)
    {
        purpleFates = newAmount;
    }

    public int getOutstandingBalance()
    {
        return outstandingBalance;
    }

    public void setOutstandingBalance(int newAmount)
    {
        outstandingBalance = newAmount;
    }

    public ItemManifest getInventory()
    {
        return inventory;
    }

    public void setInventory(ItemManifest newAmount)
    {
        inventory = newAmount;
    }
}