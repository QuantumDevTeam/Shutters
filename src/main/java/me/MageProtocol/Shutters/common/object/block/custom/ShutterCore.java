package me.MageProtocol.Shutters.common.object.block.custom;

import me.MageProtocol.Shutters.Shutters;
import me.MageProtocol.Shutters.common.object.block.ShuttersBlock;
import me.MageProtocol.Shutters.common.object.block.custom.tileentity.ShutterCoreTileEntity;
import me.MageProtocol.Shutters.common.util.GuiID;
import me.MageProtocol.Shutters.common.util.LogHelper;
import me.MageProtocol.Shutters.common.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Z on 30/08/2015.
 */
public class ShutterCore extends ShuttersBlock implements ITileEntityProvider
{
    public ShutterCore()
    {
        super();
        this.setBlockName(Reference.MODID + "ShutterCore");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new ShutterCoreTileEntity();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (world.getTileEntity(x, y, z) instanceof ShutterCoreTileEntity) {
            ShutterCoreTileEntity tileEntity = (ShutterCoreTileEntity) world.getTileEntity(x, y, z);

            if(player.isSneaking()) {
                if (!world.isRemote) {
                    if (player != null) {
                        LogHelper.debug("GUI Code Active: Initialising");
                        player.openGui(Shutters.instance, GuiID.ShutterCore, world, x, y, z);
                    }
                }
            } else
            {
                if(tileEntity.getActivationType() == 1 ) {
                    if(!world.isRemote) {
                        LogHelper.debug("ActivationType: 1 - Activated");
                        player.addChatComponentMessage(new ChatComponentText("Shutter Door Activation: " + tileEntity.getActivationType()));
                        player.addChatComponentMessage(new ChatComponentText("Shutter door style: " + tileEntity.getShutterDoorType()));
                        player.addChatComponentMessage(new ChatComponentText("Shutter door rotation: " + tileEntity.getShutterRotation()));
                        player.addChatComponentMessage(new ChatComponentText("Shutter Dropdown Amount: " + tileEntity.getDropdownAmount()));
                    }
                    // Activate Shutter Based on Shutter Type and Rotation
                }
                 else if(tileEntity.getActivationType() == 2)
                {
                    if(!world.isRemote) {
                        LogHelper.debug("ActivationType: 2 - Activated");
                        player.addChatComponentMessage(new ChatComponentText("Shutter Door Activation: " + tileEntity.getActivationType()));
                        player.addChatComponentMessage(new ChatComponentText("Shutter door style: " + tileEntity.getShutterDoorType()));
                        player.addChatComponentMessage(new ChatComponentText("Shutter door rotation: " + tileEntity.getShutterRotation()));
                        return false;
                    }
                }
            }


        }
        return true;
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        TileEntity te = world.getTileEntity(x, y, z);

        if(te != null && te instanceof ShutterCoreTileEntity)
        {
            ShutterCoreTileEntity shutter = (ShutterCoreTileEntity) te;

            if(shutter.getStackInSlot(0) != null)
            {
                ItemStack block = shutter.getStackInSlot(0);

                if(block.getItem() != null && block.getItem() instanceof ItemBlock)
                {
                    ItemBlock ib = (ItemBlock) block.getItem();
                    Block b = Block.getBlockFromItem(ib);
                    if(b.isOpaqueCube())
                        return b.getIcon(block.getItemDamage(), side);
                }
            }
        }

        //TODO return default texture here
        return null;
    }
}
