package me.MageProtocol.Shutters.common.object;

import me.MageProtocol.Shutters.common.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Z on 30/08/2015.
 */
public class CreativeTab extends CreativeTabs
{
    public CreativeTab()
    {
        super(Reference.MODID);
    }

    @Override
    public Item getTabIconItem()
    {
        return Items.skull;
    }
}