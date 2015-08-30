package me.MageProtocol.Shutters.common.config;

/**
 * Created by Z on 30/08/2015.
 */
import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.MageProtocol.Shutters.common.util.Reference;
import net.minecraftforge.common.config.Configuration;

public class Config
{
    public static Configuration configuration;

    //Declaring Config Options
    public static boolean logDebug;

    public static void init(File file)
    {
        if (configuration == null)
        {
            configuration = new Configuration(file);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        logDebug = configuration.getBoolean("debugLogging", "misc", false, "Enable debug logging.");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            loadConfiguration();
        }
    }
}
