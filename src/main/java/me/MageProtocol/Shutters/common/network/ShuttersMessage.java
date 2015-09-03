package me.MageProtocol.Shutters.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

/**
 * Created by Z on 01/09/2015.
 */
public class ShuttersMessage implements IMessage
{

    public int x;
    public int y;
    public int z;
    public int ActivationType;
    public int Rotation;
    public int ShutterType;
    public int DropdownAmount;


    public ShuttersMessage()
    {
        this(0,0,0,0,0,0,0);
    }

    public ShuttersMessage(int x, int y, int z, int ActType, int Rot, int ShutType, int Dropdown)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ActivationType = ActType;
        this.Rotation = Rot;
        this.ShutterType = ShutType;
        this.DropdownAmount = Dropdown;
    }



    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        ActivationType = buf.readInt();
        Rotation = buf.readInt();
        ShutterType = buf.readInt();
        DropdownAmount = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(ActivationType);
        buf.writeInt(Rotation);
        buf.writeInt(ShutterType);
        buf.writeInt(DropdownAmount);
    }
}


