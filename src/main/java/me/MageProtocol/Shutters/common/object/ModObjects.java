package me.MageProtocol.Shutters.common.object;

/**
 * Created by Z on 30/08/2015.
 */

import cpw.mods.fml.common.registry.GameRegistry;
import me.MageProtocol.Shutters.common.util.LogHelper;

public class ModObjects
{
    // Block Declarations


    //Item Declarations


    public static void init()
    {
        LogHelper.info("Registering blocks and tiles!");
        registerBlocks();
        registerTiles();
        LogHelper.info("Registering items!");
        registerItems();
        LogHelper.info("Registering recipes!");
        registerRecipes();
    }

    private static void registerBlocks()
    {

    }

    private static void registerTiles()
    {

    }

    private static void registerItems()
    {

    }

    private static void registerRecipes()
    {
        /*GameRegistry.addRecipe(new ItemStack(tablet), "VVV", "VVV", "VVV", 'V', new ItemStack(voidPearl)); Placeholder Recipe */
    }
}
