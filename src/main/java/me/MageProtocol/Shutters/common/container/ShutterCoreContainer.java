package me.MageProtocol.Shutters.common.container;

import me.MageProtocol.Shutters.common.container.slot.SlotCamo;
import me.MageProtocol.Shutters.common.object.block.custom.tileentity.ShutterCoreTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Z on 30/08/2015.
 */
public class ShutterCoreContainer extends Container
{
    protected ShutterCoreTileEntity tileEntity;
    private final IInventory playerInv;

    public ShutterCoreContainer(InventoryPlayer invPlayer, ShutterCoreTileEntity te)
    {
        tileEntity = te;
        addSlots(invPlayer);
        bindPlayerInventory(invPlayer);
        this.playerInv = invPlayer;
    }

    public void addSlots(InventoryPlayer inventoryPlayer)
    {
        addSlotToContainer(new SlotCamo(tileEntity, 0, 20, 100));
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        8 + j * 18 + 1, 84 + i * 18 + 53));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18 + 1, 195));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(par2);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            //merges the item into player inventory since its in the tileEntity
            if (par2 < tileEntity.getSizeInventory()) {
                if (!this.mergeItemStack(stackInSlot, tileEntity.getSizeInventory(), 36+tileEntity.getSizeInventory(), true)) {
                    return null;
                }
            }
            //places it into the tileEntity is possible since its in the player inventory
            else if (!this.mergeItemStack(stackInSlot, 0, tileEntity.getSizeInventory(), false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(par1EntityPlayer, stackInSlot);
        }
        return stack;

    }
}
