package me.MageProtocol.Shutters;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.MageProtocol.Shutters.common.object.ModObjects;
import me.MageProtocol.Shutters.common.config.Config;
import me.MageProtocol.Shutters.common.object.CreativeTab;
import me.MageProtocol.Shutters.common.util.Reference;

import java.io.File;

/**
 * Created by Z on 30/08/2015.
 */
@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Shutters
{
    public static CreativeTab creativeTab = new CreativeTab();
    public static File CONFIG_DIR;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CONFIG_DIR = new File(event.getModConfigurationDirectory(), "Shutters");

        if (!CONFIG_DIR.exists())
        {
            CONFIG_DIR.mkdirs();
        }

        Config.init(new File(CONFIG_DIR, "Shutters.cfg"));

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModObjects.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}