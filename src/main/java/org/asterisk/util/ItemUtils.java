package org.asterisk.util;

import java.util.*;

import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import org.asterisk.wishsimulator.Item;

public class ItemUtils
{
    private static final Item[] fourCharacters = {Item.FARUZAN, Item.SAYU, Item.SHIKANOIN_HEIZOU, Item.SUCROSE, Item.CHONGYUN,
            Item.DIONA, Item.KAEYA, Item.LAYLA, Item.MIKA, Item.ROSARIA, Item.COLLEI, Item.KAVEH, Item.KIRARA,
            Item.YAOYAO, Item.BEIDOU, Item.DORI, Item.FISCHL, Item.SARA, Item.KUKI_SHINOBU, Item.LISA, Item.RAZOR,
            Item.GOROU, Item.NINGGUANG, Item.NOELLE, Item.YUNJIN, Item.BARBARA, Item.CANDACE, Item.XINGQIU,
            Item.AMBER, Item.BENNETT, Item.THOMA, Item.XIANGLING, Item.XINYAN, Item.YANFEI};
    private static final Item[] standardFiveCharacters = {Item.JEAN, Item.QIQI, Item.TIGHNARI, Item.KEQING, Item.MONA, Item.DEHYA,
            Item.DILUC};
    private static final Item[] threeWeapons = {Item.RAVEN_BOW, Item.SHARPSHOOTERS_OATH, Item.SLINGSHOT, Item.EMERALD_ORB, Item.MAGIC_GUIDE,
            Item.THRILLING_TALES_OF_DRAGON_SLAYERS, Item.BLOODTAINTED_GREATSWORD, Item.DEBATE_CLUB, Item.FERROUS_SHADOW,
            Item.BLACK_TASSEL, Item.COOL_STEEL, Item.HARBINGER_OF_DAWN, Item.SKYRIDER_SWORD};
    private static final Item[] fourWeapons = {Item.FAVONIUS_WARBOW, Item.RUST, Item.SACRIFICIAL_BOW, Item.THE_STRINGLESS, Item.EYE_OF_PERCEPTION,
            Item.FAVONIUS_CODEX, Item.THE_WIDSITH, Item.FAVONIUS_GREATSWORD, Item.RAINSLASHER, Item.SACRIFICIAL_GREATSWORD,
            Item.THE_BELL, Item.DRAGONS_BANE, Item.FAVONIUS_LANCE, Item.FAVONIUS_SWORD, Item.LIONS_ROAR,
            Item.SACRIFICIAL_SWORD, Item.THE_FLUTE};
    private static final Item[] fiveWeapons = {Item.AMOS_BOW, Item.SKYWARD_HARP, Item.LOST_PRAYER_TO_THE_SACRED_WINDS, Item.SKYWARD_ATLAS,
            Item.SKYWARD_PRIDE, Item.WOLFS_GRAVESTONE, Item.PRIMORDIAL_JADE_WINGED_SPEAR, Item.SKYWARD_SPINE,
            Item.AQUILA_FAVONIA, Item.SKYWARD_BLADE};
    private static final Item[] orderedItemList = {Item.ALBEDO, Item.ALHAITHAM, Item.ARATAKI_ITTO, Item.BAIZHU, Item.CYNO, Item.EULA,
            Item.GANYU, Item.HU_TAO, Item.KAEDEHARA_KAZUHA, Item.KAMISATO_AYAKA, Item.KAMISATO_AYATO, Item.KLEE, Item.LYNEY,
            Item.NAHIDA, Item.NEUVILLETTE, Item.NILOU, Item.RAIDEN_SHOGUN, Item.SANGONOMIYA_KOKOMI, Item.SHENHE, Item.TARTAGLIA,
            Item.VENTI, Item.WANDERER, Item.WRIOTHESLEY, Item.XIAO, Item.YAE_MIKO, Item.YELAN, Item.YOIMIYA, Item.ZHONGLI,
            Item.A_THOUSAND_FLOATING_DREAMS, Item.AQUA_SIMULACRA, Item.BEACON_OF_THE_REED_SEA, Item.CALAMITY_QUELLER, Item.CASHFLOW_SUPERVISION,
            Item.ELEGY_FOR_THE_END, Item.ENGULFING_LIGHTNING, Item.EVERLASTING_MOONGLOW, Item.FREEDOM_SWORN, Item.HARAN_GEPPAKU_FUTSU,
            Item.HUNTERS_PATH, Item.JADEFALLS_SPLENDOR, Item.KAGURAS_VERITY, Item.KEY_OF_KHAJ_NISUT, Item.LIGHT_OF_FOLIAR_INCISION,
            Item.MEMORY_OF_DUST, Item.MISTSPLITTER_REFORGED, Item.POLAR_STAR, Item.PRIMORDIAL_JADE_CUTTER, Item.REDHORN_STONETHRESHER,
            Item.SONG_OF_BROKEN_PINES, Item.STAFF_OF_HOMA, Item.STAFF_OF_THE_SCARLET_SANDS, Item.SUMMIT_SHAPER, Item.THE_FIRST_GREAT_MAGIC,
            Item.THE_UNFORGED, Item.THUNDERING_PULSE, Item.TOME_OF_THE_ETERNAL_FLOW, Item.TULAYTULLAHS_REMEMBRANCE, Item.VORTEX_VANQUISHER,
            Item.JEAN, Item.QIQI, Item.TIGHNARI, Item.KEQING, Item.MONA, Item.DEHYA, Item.DILUC, Item.AMOS_BOW, Item.SKYWARD_HARP,
            Item.LOST_PRAYER_TO_THE_SACRED_WINDS, Item.SKYWARD_ATLAS, Item.SKYWARD_PRIDE, Item.WOLFS_GRAVESTONE, Item.PRIMORDIAL_JADE_WINGED_SPEAR,
            Item.SKYWARD_SPINE, Item.AQUILA_FAVONIA, Item.SKYWARD_BLADE, Item.FARUZAN, Item.SAYU, Item.SHIKANOIN_HEIZOU, Item.SUCROSE,
            Item.CHONGYUN, Item.DIONA, Item.KAEYA, Item.LAYLA, Item.MIKA, Item.ROSARIA, Item.COLLEI, Item.KAVEH, Item.KIRARA,
            Item.YAOYAO, Item.BEIDOU, Item.DORI, Item.FISCHL, Item.SARA, Item.KUKI_SHINOBU, Item.LISA, Item.RAZOR, Item.GOROU,
            Item.NINGGUANG, Item.NOELLE, Item.YUNJIN, Item.BARBARA, Item.CANDACE, Item.XINGQIU, Item.AMBER, Item.BENNETT, Item.THOMA,
            Item.XIANGLING, Item.XINYAN, Item.YANFEI, Item.FAVONIUS_WARBOW, Item.RUST, Item.SACRIFICIAL_BOW, Item.THE_STRINGLESS,
            Item.EYE_OF_PERCEPTION, Item.FAVONIUS_CODEX, Item.THE_WIDSITH, Item.FAVONIUS_GREATSWORD, Item.RAINSLASHER, Item.SACRIFICIAL_GREATSWORD,
            Item.THE_BELL, Item.DRAGONS_BANE, Item.FAVONIUS_LANCE, Item.FAVONIUS_SWORD, Item.LIONS_ROAR, Item.SACRIFICIAL_SWORD,
            Item.THE_FLUTE, Item.RAVEN_BOW, Item.SHARPSHOOTERS_OATH, Item.SLINGSHOT, Item.EMERALD_ORB, Item.MAGIC_GUIDE,
            Item.THRILLING_TALES_OF_DRAGON_SLAYERS, Item.BLOODTAINTED_GREATSWORD, Item.DEBATE_CLUB, Item.FERROUS_SHADOW,
            Item.BLACK_TASSEL, Item.COOL_STEEL, Item.HARBINGER_OF_DAWN, Item.SKYRIDER_SWORD};


    private static final Item limitedFiveCharacter = Item.WRIOTHESLEY;
    private static final Item limitedFiveWeapon = Item.CASHFLOW_SUPERVISION;

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
            case FARUZAN -> "Faruzan";
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
            case ALBEDO -> "Albedo";
            case ALHAITHAM -> "Alhaitham";
            case ARATAKI_ITTO -> "Arataki Itto";
            case BAIZHU -> "Baizhu";
            case CYNO -> "Cyno";
            case EULA -> "Eula";
            case GANYU -> "Ganyu";
            case HU_TAO -> "Hu Tao";
            case KAEDEHARA_KAZUHA -> "Kaedehara Kazuha";
            case KAMISATO_AYAKA -> "Kamisato Ayaka";
            case KAMISATO_AYATO -> "Kamisato Ayato";
            case KLEE -> "Klee";
            case LYNEY -> "Lyney";
            case NAHIDA -> "Nahida";
            case NEUVILLETTE -> "Neuvillette";
            case NILOU -> "Nilou";
            case RAIDEN_SHOGUN -> "Raiden Shogun";
            case SANGONOMIYA_KOKOMI -> "Sangonomiya Kokomi";
            case SHENHE -> "Shenhe";
            case TARTAGLIA -> "Tartaglia";
            case VENTI -> "Venti";
            case WANDERER -> "Wanderer";
            case WRIOTHESLEY -> "Wriothesley";
            case XIAO -> "Xiao";
            case YAE_MIKO -> "Yae Miko";
            case YELAN -> "Yelan";
            case YOIMIYA -> "Yoimiya";
            case ZHONGLI -> "Zhongli";
            case A_THOUSAND_FLOATING_DREAMS -> "A Thousand Floating Dreams";
            case AQUA_SIMULACRA -> "Aqua Simulacra";
            case BEACON_OF_THE_REED_SEA -> "Beacon of the Reed Sea";
            case CALAMITY_QUELLER -> "Calamity Queller";
            case CASHFLOW_SUPERVISION -> "Cashflow Supervision";
            case ELEGY_FOR_THE_END -> "Elegy for the End";
            case ENGULFING_LIGHTNING -> "Engulfing Lightning";
            case EVERLASTING_MOONGLOW -> "Everlasting Moonglow";
            case FREEDOM_SWORN -> "Freedom Sworn";
            case HARAN_GEPPAKU_FUTSU -> "Haran Geppaku Futsu";
            case HUNTERS_PATH -> "Hunter's Path";
            case JADEFALLS_SPLENDOR -> "Jadefall's Splendor";
            case KAGURAS_VERITY -> "Kagura's Verity";
            case KEY_OF_KHAJ_NISUT -> "Key of Khaj-Nisut";
            case LIGHT_OF_FOLIAR_INCISION -> "Light of Foliar Incision";
            case MEMORY_OF_DUST -> "Memory of Dust";
            case MISTSPLITTER_REFORGED -> "Mistsplitter Reforged";
            case POLAR_STAR -> "Polar Star";
            case PRIMORDIAL_JADE_CUTTER -> "Primordial Jade Cutter";
            case REDHORN_STONETHRESHER -> "Redhorn Stonethresher";
            case SONG_OF_BROKEN_PINES -> "Song of Broken Pines";
            case STAFF_OF_HOMA -> "Staff of Homa";
            case STAFF_OF_THE_SCARLET_SANDS -> "Staff of the Scarlet Sands";
            case SUMMIT_SHAPER -> "Summit Shaper";
            case THE_FIRST_GREAT_MAGIC -> "The First Great Magic";
            case THE_UNFORGED -> "The Unforged";
            case THUNDERING_PULSE -> "Thundering Pulse";
            case TOME_OF_THE_ETERNAL_FLOW -> "Tome of the Eternal Flow";
            case TULAYTULLAHS_REMEMBRANCE -> "Tulaytullah's Remembrance";
            case VORTEX_VANQUISHER -> "Vortex Vanquisher";
        };
    }

    public static int getItemRarity(Item item)
    {
        return switch (item) {
            case JEAN, QIQI, TIGHNARI, KEQING, MONA, DEHYA, DILUC, AMOS_BOW, SKYWARD_HARP, LOST_PRAYER_TO_THE_SACRED_WINDS,
                    SKYWARD_ATLAS, SKYWARD_PRIDE, WOLFS_GRAVESTONE, PRIMORDIAL_JADE_WINGED_SPEAR, SKYWARD_SPINE, AQUILA_FAVONIA,
                    SKYWARD_BLADE, ALBEDO, ALHAITHAM, ARATAKI_ITTO, BAIZHU, CYNO, EULA, GANYU, HU_TAO, KAEDEHARA_KAZUHA, KAMISATO_AYAKA,
                    KAMISATO_AYATO, KLEE, LYNEY, NAHIDA, NEUVILLETTE, NILOU, RAIDEN_SHOGUN, SANGONOMIYA_KOKOMI, SHENHE, TARTAGLIA,
                    VENTI, WANDERER, WRIOTHESLEY, XIAO, YAE_MIKO, YELAN, YOIMIYA, ZHONGLI, A_THOUSAND_FLOATING_DREAMS, AQUA_SIMULACRA,
                    BEACON_OF_THE_REED_SEA, CALAMITY_QUELLER, CASHFLOW_SUPERVISION, ELEGY_FOR_THE_END, ENGULFING_LIGHTNING,
                    EVERLASTING_MOONGLOW, FREEDOM_SWORN, HARAN_GEPPAKU_FUTSU, HUNTERS_PATH, JADEFALLS_SPLENDOR, KAGURAS_VERITY,
                    KEY_OF_KHAJ_NISUT, LIGHT_OF_FOLIAR_INCISION, MEMORY_OF_DUST, MISTSPLITTER_REFORGED, POLAR_STAR, PRIMORDIAL_JADE_CUTTER,
                    REDHORN_STONETHRESHER, SONG_OF_BROKEN_PINES, STAFF_OF_HOMA, STAFF_OF_THE_SCARLET_SANDS, SUMMIT_SHAPER, THE_FIRST_GREAT_MAGIC,
                    THE_UNFORGED, THUNDERING_PULSE, TOME_OF_THE_ETERNAL_FLOW, TULAYTULLAHS_REMEMBRANCE, VORTEX_VANQUISHER ->
                    5;
            case FARUZAN, SAYU, SHIKANOIN_HEIZOU, SUCROSE, CHONGYUN, DIONA, KAEYA, LAYLA, MIKA, ROSARIA, COLLEI, KAVEH, KIRARA,
                    YAOYAO, BEIDOU, DORI, FISCHL, SARA, KUKI_SHINOBU, LISA, RAZOR, GOROU, NINGGUANG, NOELLE, YUNJIN, BARBARA,
                    CANDACE, XINGQIU, AMBER, BENNETT, THOMA, XIANGLING, XINYAN, YANFEI, FAVONIUS_WARBOW, RUST, SACRIFICIAL_BOW,
                    THE_STRINGLESS, EYE_OF_PERCEPTION, FAVONIUS_CODEX, THE_WIDSITH, FAVONIUS_GREATSWORD, RAINSLASHER, SACRIFICIAL_GREATSWORD,
                    THE_BELL, DRAGONS_BANE, FAVONIUS_LANCE, FAVONIUS_SWORD, LIONS_ROAR, SACRIFICIAL_SWORD, THE_FLUTE ->
                    4;
            case RAVEN_BOW, SHARPSHOOTERS_OATH, SLINGSHOT, EMERALD_ORB, MAGIC_GUIDE, THRILLING_TALES_OF_DRAGON_SLAYERS, BLOODTAINTED_GREATSWORD,
                    DEBATE_CLUB, FERROUS_SHADOW, BLACK_TASSEL, COOL_STEEL, HARBINGER_OF_DAWN, SKYRIDER_SWORD ->
                    3;
        };
    }

    public static ArrayList<Item> getOrderedItemList()
    {
        return new ArrayList<Item>(Arrays.asList(orderedItemList));
    }

    //TODO: change String banner to an enum?
    public static ArrayList<Item> getItems(String banner, String type, int rarity)
    {
        //TODO: different stuff for limited
        if (banner.equals("STANDARD") || banner.equals("LIMITED") || banner.equals("WEAPON"))
        {
            if (type.equals("CHARACTER"))
            {
                if (rarity == 4)
                {
                    return new ArrayList<Item>(Arrays.asList(fourCharacters));
                }
                else if (rarity == 5)
                {
                    return new ArrayList<Item>(Arrays.asList(standardFiveCharacters));
                }
            }
            else if (type.equals("WEAPON"))
            {
                if (rarity == 3)
                {
                    return new ArrayList<Item>(Arrays.asList(threeWeapons));
                }
                else if (rarity == 4)
                {
                    return new ArrayList<Item>(Arrays.asList(fourWeapons));
                }
                else if (rarity == 5)
                {
                    return new ArrayList<Item>(Arrays.asList(fiveWeapons));
                }
            }
        }

        return null;
    }

    public static String getPrintedString(Item item)
    {
        final String STAR = "✪";
        final AnsiFormat THREE_STAR = new AnsiFormat(Attribute.BRIGHT_WHITE_TEXT(), Attribute.BLUE_BACK());
        final AnsiFormat FOUR_STAR = new AnsiFormat(Attribute.BRIGHT_WHITE_TEXT(), Attribute.MAGENTA_BACK(), Attribute.ITALIC());
        final AnsiFormat FIVE_STAR = new AnsiFormat(Attribute.BRIGHT_WHITE_TEXT(), Attribute.YELLOW_BACK(), Attribute.BOLD());

        String output = "";
        output = output + ItemUtils.getItemDisplayName(item) + " - ";
        for (int i = 0; i < ItemUtils.getItemRarity(item); i++)
        {
            output = output + STAR;
        }

        if (ItemUtils.getItemRarity(item) == 3)
        {
            return THREE_STAR.format(output);
        }
        else if (ItemUtils.getItemRarity(item) == 4)
        {
            return FOUR_STAR.format(output);
        }
        else
        {
            return FIVE_STAR.format(output);
        }
    }

    public static Item getLimitedFiveCharacter()
    {
        return limitedFiveCharacter;
    }

    public static Item getLimitedFiveWeapon()
    {
        return limitedFiveWeapon;
    }
}
