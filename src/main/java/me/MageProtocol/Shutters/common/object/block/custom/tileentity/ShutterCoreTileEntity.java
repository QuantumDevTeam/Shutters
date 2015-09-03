package me.MageProtocol.Shutters.common.object.block.custom.tileentity;

import me.MageProtocol.Shutters.common.util.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Z on 30/08/2015.
 */
public class ShutterCoreTileEntity extends TileEntity implements IInventory
{

    private ItemStack[] inv;

    public ShutterCoreTileEntity() {
        inv = new ItemStack[1];
    }
    /**
     * Rotations:
     * 1 and 3: North - South, South - North
     * 2 and 4: East - West, West - East
     */
    public int ShutterRotation = 1;

    /**
     * Shutter Type:
     * 1: Garage Door (Straight Down)
     * 2: Nuclear Blast Door (3x3 Under Block in set Rotation):
     *     Will place blocks 5 wide and 3 blocks down under to create the Frame
     * 3: Elevator Door (4x2 Under Block in set Rotation)
     */
    public int ShutterDoorType = 1;

    /**
     * ActivateType:
     * 1: Redstone
     * 2: Right Click with Opening Tool
     */
    public int ActivationType = 1;

    /**
     * DropdownAmount:
     * This amount shows how many blocks down the Shutter Type 1 can go down.
     */
    public int DropdownAmount = 1;

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        ActivationType = nbtTagCompound.getInteger("ActivationType");

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("ActivationType", ActivationType);

    }

    public int getShutterRotation() {
        return ShutterRotation;
    }

    public int getShutterDoorType()
    {
        return ShutterDoorType;
    }

    public int getActivationType()
    {
        return ActivationType;
    }

    public int getDropdownAmount() { return DropdownAmount; }

    public void setActivationType(int type) {
        if(type == 1 || type == 2)
            ActivationType = type;
        else
            LogHelper.debug("ActivationType can only be 1 or 2!");
    }

    public void setShutterDoorType(int type) {
        if(type == 1 || type == 2 || type == 3)
            ShutterDoorType = type;
        else
            LogHelper.debug("ActivationType can only be 1, 2 or 3!");
    }

    public void setShutterRotation(int rotation) {
        if (rotation == 1 || rotation == 2 || rotation == 3 || rotation == 4)
            ShutterRotation = rotation;
        else
            LogHelper.debug("ShutterRotation can only be 1, 2, 3 or 4!");
    }

    public void setDropdownAmount(int amount)
    {
        DropdownAmount = amount;
    }

    @Override
    public int getSizeInventory() {
        // TODO Auto-generated method stub
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inv[slot];
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, blockMetadata, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
        if(slot == 0)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }

    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amt) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amt);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null)
        {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public String getInventoryName() {
        return "infoPane.InfoPane";
    }

    @Override
    public boolean hasCustomInventoryName() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void openInventory() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeInventory() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        // TODO Auto-generated method stub
        return false;
    }

}
