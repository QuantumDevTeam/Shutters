package me.MageProtocol.Shutters.common.object;

/**
 * Created by Z on 30/08/2015.
 */

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import me.MageProtocol.Shutters.Shutters;
import me.MageProtocol.Shutters.common.handler.GuiHandler;
import me.MageProtocol.Shutters.common.object.block.custom.ShutterCore;
import me.MageProtocol.Shutters.common.object.block.custom.tileentity.ShutterCoreTileEntity;
import me.MageProtocol.Shutters.common.object.item.DebugTool;
import me.MageProtocol.Shutters.common.util.LogHelper;
import me.MageProtocol.Shutters.common.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModObjects
{
    // Block Declarations

    public static Block shutterCore = new ShutterCore();

    //Item Declarations

    public static Item debugTool = new DebugTool();

    public static void init()
    {
        LogHelper.info("Registering blocks and tiles!");
        registerBlocks();
        registerTiles();
        LogHelper.info("Registering items!");
        registerItems();
        LogHelper.info("Registering recipes!");
        registerRecipes();
        LogHelper.info("Registering Handlers!");
        registerHandlers();
    }

    private static void registerBlocks()
    {
        GameRegistry.registerBlock(shutterCore, "shutterCore");
    }

    private static void registerTiles()
    {
        GameRegistry.registerTileEntity(ShutterCoreTileEntity.class, "Shutters:shutterCore");
    }

    private static void registerItems()
    {
        GameRegistry.registerItem(debugTool, "Shutters:DebugTool");
    }

    private static void registerRecipes()
    {

    }

    private static void registerHandlers()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(Shutters.instance, new GuiHandler());
    }
}
