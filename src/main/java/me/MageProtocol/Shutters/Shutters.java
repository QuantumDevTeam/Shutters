package me.MageProtocol.Shutters;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import me.MageProtocol.Shutters.common.CommonProxy;
import me.MageProtocol.Shutters.common.network.ShuttersHandler;
import me.MageProtocol.Shutters.common.network.ShuttersMessage;
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

    @Mod.Instance
    public static Shutters instance;

    public static CreativeTab creativeTab = new CreativeTab();
    public static File CONFIG_DIR;

    @SidedProxy(clientSide = "me.MageProtocol.Shutters.client.ClientProxy", serverSide = "me.MageProtocol.Shutters.common.CommonProxy")
    public static CommonProxy proxy;

    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CONFIG_DIR = new File(event.getModConfigurationDirectory(), "Shutters");

        if (!CONFIG_DIR.exists())
        {
            CONFIG_DIR.mkdirs();
        }

        Config.init(new File(CONFIG_DIR, "Shutters.cfg"));

        network = NetworkRegistry.INSTANCE.newSimpleChannel("ShuttersChannel");
        network.registerMessage(ShuttersHandler.class, ShuttersMessage.class, 0, Side.SERVER);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        proxy.registerRenderers();
        ModObjects.init();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}