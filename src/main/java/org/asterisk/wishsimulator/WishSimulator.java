package org.asterisk.wishsimulator;

import java.util.ArrayList;
import org.asterisk.wishsimulator.Item;

public class WishSimulator
{
    public WishSimulator()
    {

    }

    public ItemManifest simulateStandardWish(int pulls)
    {
        return new ItemManifest(new ArrayList<Item>());
    }

    public ItemManifest simulateLimitedWish(int pulls)
    {
        return new ItemManifest(new ArrayList<Item>());
    }

    public ItemManifest simulateWeaponWish(int pulls)
    {
        return new ItemManifest(new ArrayList<Item>());
    }
}
