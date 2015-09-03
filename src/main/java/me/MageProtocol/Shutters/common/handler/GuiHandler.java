package me.MageProtocol.Shutters.common.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import me.MageProtocol.Shutters.client.gui.ShutterCoreGUI;
import me.MageProtocol.Shutters.common.container.ShutterCoreContainer;
import me.MageProtocol.Shutters.common.object.block.custom.tileentity.ShutterCoreTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Z on 30/08/2015.
 */
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity te = world.getTileEntity(x, y, z);
        switch (ID)
        {
            case 0:
                return new ShutterCoreContainer(player.inventory, (ShutterCoreTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity te = world.getTileEntity(x, y, z);
        switch (ID)
        {
            case 0:
                return new ShutterCoreGUI(player.inventory, (ShutterCoreTileEntity) te);
        }
        return null;
    }
}
