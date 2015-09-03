package me.MageProtocol.Shutters.common.object.block;

import me.MageProtocol.Shutters.Shutters;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Z on 30/08/2015.
 */
public class ShuttersBlock extends Block {

    public ShuttersBlock()
    {
        super(Material.rock);
        this.setCreativeTab(Shutters.creativeTab);
    }

}
