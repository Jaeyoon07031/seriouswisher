package org.asterisk.util;

import java.util.*;
import org.asterisk.wishsimulator.Item;

public class ItemUtils
{
    public static String getItemDisplayName(Item item)
    {
        return switch (item)
        {
            case CHARACTER1 -> "Character 1";
            case CHARACTER2 -> "Character 2";
            case CHARACTER3 -> "Character 3";
            case WEAPON1 -> "Weapon 1";
            case WEAPON2 -> "Weapon 2";
            case WEAPON3 -> "Weapon 3";
            default -> null;
        };
    }
}
