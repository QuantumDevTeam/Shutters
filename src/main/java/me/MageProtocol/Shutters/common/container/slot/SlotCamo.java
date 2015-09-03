package me.MageProtocol.Shutters.common.container.slot;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Z on 03/09/2015.
 */
public class SlotCamo extends Slot {

    public SlotCamo(IInventory inv, int par1, int par2, int par3) {
        super(inv, par1, par2, par3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        if(itemStack != null && itemStack.getItem() != null && Block.blockRegistry.containsId(Item.getIdFromItem(itemStack.getItem())))
        {
            Block camoBlock = (Block) Block.getBlockFromItem(itemStack.getItem());
            if(camoBlock.isNormalCube() == true)
            {
                return true;
            }
            else
                return false;
        } else
        {
            return false;
        }
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}
