package me.MageProtocol.Shutters.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import me.MageProtocol.Shutters.common.object.block.custom.tileentity.ShutterCoreTileEntity;

/**
 * Created by Z on 01/09/2015.
 */
public class ShuttersHandler implements IMessageHandler<ShuttersMessage, IMessage>
{

    @Override
    public IMessage onMessage(ShuttersMessage message, MessageContext ctx)
    {
        ShutterCoreTileEntity tileEntity = (ShutterCoreTileEntity) ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x,
                message.y, message.z);

        if(tileEntity != null)
        {
            tileEntity.ActivationType = message.ActivationType;
            tileEntity.ShutterRotation = message.Rotation;
            tileEntity.ShutterDoorType = message.ShutterType;
            tileEntity.DropdownAmount = message.DropdownAmount;
            tileEntity.markDirty();
        }
        return null;
    }

}
