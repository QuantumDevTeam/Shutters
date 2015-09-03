package me.MageProtocol.Shutters.common.util;

/**
 * Created by Z on 03/09/2015.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class ClientUtils
{
    public static Minecraft mc()
    {
        return Minecraft.getMinecraft();
    }

    public static FontRenderer font()
    {
        return mc().fontRenderer;
    }
}
