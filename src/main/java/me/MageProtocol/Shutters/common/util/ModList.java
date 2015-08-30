package me.MageProtocol.Shutters.common.util;

import cpw.mods.fml.common.Loader;

/**
 * Created by Z on 30/08/2015.
 */
public enum ModList {

    COMPACTSTORAGE("compactstorage"),
    KCORE("kCore");

    public final String modid;

    ModList(String id)
    {
        this.modid = id;
    }

    public boolean isLoaded()
    {
        return Loader.isModLoaded(modid);
    }
}
