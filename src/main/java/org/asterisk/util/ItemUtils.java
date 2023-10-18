package org.asterisk.util;

import java.util.*;
import org.asterisk.wishsimulator.Item;

public class ItemUtils
{
    public static String getItemDisplayName(Item item)
    {
        return switch (item) {
            case JEAN -> "Jean";
            case QIQI -> "Qiqi";
            case TIGHNARI -> "Tighnari";
            case KEQING -> "Keqing";
            case MONA -> "Mona";
            case DEHYA -> "Dehya";
            case DILUC -> "Diluc";
            case FARUZAN -> "Faruzaan";
            case SAYU -> "Sayu";
            case SHIKANOIN_HEIZOU -> "Shikanoin Heizou";
            case SUCROSE -> "Sucrose";
            case CHONGYUN -> "Chongyun";
            case DIONA -> "Diona";
            case KAEYA -> "Kaeya";
            case LAYLA -> "Layla";
            case MIKA -> "Mika";
            case ROSARIA -> "Rosaria";
            case COLLEI -> "Collei";
            case KAVEH -> "Kaveh";
            case KIRARA -> "Kirara";
            case YAOYAO -> "Yaoyao";
            case BEIDOU -> "Beidou";
            case DORI -> "Dori";
            case FISCHL -> "Fischl";
            case SARA -> "Sara";
            case KUKI_SHINOBU -> "Kuki Shinobu";
            case LISA -> "Lisa";
            case RAZOR -> "Razor";
            case GOROU -> "Gorou";
            case NINGGUANG -> "Ningguang";
            case NOELLE -> "Noelle";
            case YUNJIN -> "Yunjin";
            case BARBARA -> "Barbara";
            case CANDACE -> "Candace";
            case XINGQIU -> "Xingqiu";
            case AMBER -> "Amber";
            case BENNETT -> "Bennett";
            case THOMA -> "Thoma";
            case XIANGLING -> "Xiangling";
            case XINYAN -> "Xinyan";
            case YANFEI -> "Yanfei";
            case AMOS_BOW -> "Amos Bow";
            case SKYWARD_HARP -> "Skyward Harp";
            case LOST_PRAYER_TO_THE_SACRED_WINDS -> "Lost Prayer to the Sacred Winds";
            case SKYWARD_ATLAS -> "Skyward Atlas";
            case SKYWARD_PRIDE -> "Skyward Pride";
            case WOLFS_GRAVESTONE -> "Wolf's Gravestone";
            case PRIMORDIAL_JADE_WINGED_SPEAR -> "Primordial Jade Winged Spear";
            case SKYWARD_SPINE -> "Skyward Spine";
            case AQUILA_FAVONIA -> "Aquila Favonia";
            case SKYWARD_BLADE -> "Skyward Blade";
            case FAVONIUS_WARBOW -> "Favonius Warbow";
            case RUST -> "Rust";
            case SACRIFICIAL_BOW -> "Sacrificial Bow";
            case THE_STRINGLESS -> "The Stringless";
            case EYE_OF_PERCEPTION -> "Eye of Perception";
            case FAVONIUS_CODEX -> "Favonius Codex";
            case THE_WIDSITH -> "The Widsith";
            case FAVONIUS_GREATSWORD -> "Favonius Greatsword";
            case RAINSLASHER -> "Rainslasher";
            case SACRIFICIAL_GREATSWORD -> "Sacrificial Greatsword";
            case THE_BELL -> "The Bell";
            case DRAGONS_BANE -> "Dragon's Bane";
            case FAVONIUS_LANCE -> "Favonius Lance";
            case FAVONIUS_SWORD -> "Favonius Sword";
            case LIONS_ROAR -> "Lion's Roar";
            case SACRIFICIAL_SWORD -> "Sacrificial Sword";
            case THE_FLUTE -> "The Flute";
            case RAVEN_BOW -> "Raven Bow";
            case SHARPSHOOTERS_OATH -> "Sharpshooter's Oath";
            case SLINGSHOT -> "Slingshot";
            case EMERALD_ORB -> "Emerald Orb";
            case MAGIC_GUIDE -> "Magic Guide";
            case THRILLING_TALES_OF_DRAGON_SLAYERS -> "Thrilling Tales of Dragon Slayers";
            case BLOODTAINTED_GREATSWORD -> "Bloodtainted Greatsword";
            case DEBATE_CLUB -> "Debate Club";
            case FERROUS_SHADOW -> "Ferrous Shadow";
            case BLACK_TASSEL -> "Black Tassel";
            case COOL_STEEL -> "Cool Steel";
            case HARBINGER_OF_DAWN -> "Harbinger of Dawn";
            case SKYRIDER_SWORD -> "Skyrider Sword";
        };


    }

    //TODO: change String banner to an enum?
    public static ArrayList<Item> getItems(String banner, String type, int rarity)
    {
        if (banner.equals("STANDARD"))
        {
            if (type.equals("CHARACTER"))
            {
                if (rarity == 4)
                {
                    Item[] standardCharacters = {Item.FARUZAN, Item.SAYU, Item.SHIKANOIN_HEIZOU, Item.SUCROSE, Item.CHONGYUN,
                            Item.DIONA, Item.KAEYA, Item.LAYLA, Item.MIKA, Item.ROSARIA, Item.COLLEI, Item.KAVEH, Item.KIRARA,
                            Item.YAOYAO, Item.BEIDOU, Item.DORI, Item.FISCHL, Item.SARA, Item.KUKI_SHINOBU, Item.LISA, Item.RAZOR,
                            Item.GOROU, Item.NINGGUANG, Item.NOELLE, Item.YUNJIN, Item.BARBARA, Item.CANDACE, Item.XINGQIU,
                            Item.AMBER, Item.BENNETT, Item.THOMA, Item.XIANGLING, Item.XINYAN, Item.YANFEI
                    };
                    return new ArrayList<Item>(Arrays.asList(standardCharacters));
                }
                else if (rarity == 5)
                {
                    Item[] standardCharacters = {Item.JEAN, Item.QIQI, Item.TIGHNARI, Item.KEQING, Item.MONA, Item.DEHYA,
                            Item.DILUC};
                    return new ArrayList<Item>(Arrays.asList(standardCharacters));
                }
            }
            else if (type.equals("WEAPON"))
            {
                if (rarity == 3)
                {
                    Item[] weapons = {Item.RAVEN_BOW, Item.SHARPSHOOTERS_OATH, Item.SLINGSHOT, Item.EMERALD_ORB, Item.MAGIC_GUIDE,
                            Item.THRILLING_TALES_OF_DRAGON_SLAYERS, Item.BLOODTAINTED_GREATSWORD, Item.DEBATE_CLUB, Item.FERROUS_SHADOW,
                            Item.BLACK_TASSEL, Item.COOL_STEEL, Item.HARBINGER_OF_DAWN, Item.SKYRIDER_SWORD
                    };
                    return new ArrayList<Item>(Arrays.asList(weapons));
                }
                else if (rarity == 4)
                {
                    Item[] weapons = {Item.FAVONIUS_WARBOW, Item.RUST, Item.SACRIFICIAL_BOW, Item.THE_STRINGLESS, Item.EYE_OF_PERCEPTION,
                            Item.FAVONIUS_CODEX, Item.THE_WIDSITH, Item.FAVONIUS_GREATSWORD, Item.RAINSLASHER, Item.SACRIFICIAL_GREATSWORD,
                            Item.THE_BELL, Item.DRAGONS_BANE, Item.FAVONIUS_LANCE, Item.FAVONIUS_SWORD, Item.LIONS_ROAR,
                            Item.SACRIFICIAL_SWORD, Item.THE_FLUTE
                    };
                    return new ArrayList<Item>(Arrays.asList(weapons));
                }
                else if (rarity == 5)
                {
                    Item[] weapons = {Item.AMOS_BOW, Item.SKYWARD_HARP, Item.LOST_PRAYER_TO_THE_SACRED_WINDS, Item.SKYWARD_ATLAS,
                            Item.SKYWARD_PRIDE, Item.WOLFS_GRAVESTONE, Item.PRIMORDIAL_JADE_WINGED_SPEAR, Item.SKYWARD_SPINE,
                            Item.AQUILA_FAVONIA, Item.SKYWARD_BLADE
                    };
                    return new ArrayList<Item>(Arrays.asList(weapons));
                }
            }
        }

        return null;
    }
}
