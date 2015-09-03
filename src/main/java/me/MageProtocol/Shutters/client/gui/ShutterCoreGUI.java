package me.MageProtocol.Shutters.client.gui;

import me.MageProtocol.Shutters.Shutters;
import me.MageProtocol.Shutters.common.container.ShutterCoreContainer;
import me.MageProtocol.Shutters.common.network.ShuttersMessage;
import me.MageProtocol.Shutters.common.object.block.custom.tileentity.ShutterCoreTileEntity;
import me.MageProtocol.Shutters.common.util.LogHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Z on 30/08/2015.
 */
public class ShutterCoreGUI extends GuiContainer {

    private ShutterCoreTileEntity te;
    private int ActivationType;
    private int ShutterType;
    private int ShutterRotation;
    private int DropdownAmount;

    public ShutterCoreGUI(InventoryPlayer invPlayer, ShutterCoreTileEntity te) {
        super(new ShutterCoreContainer(invPlayer, te));
        this.te = te;
        this.ActivationType = te.getActivationType();
        this.ShutterType = te.getShutterDoorType();
        this.ShutterRotation = te.getShutterRotation();
        this.DropdownAmount = te.getDropdownAmount();
    }



    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        mc.fontRenderer.drawString("Shutter Controller", 5, 5, 000000);
        mc.fontRenderer.drawString(Integer.toString(ActivationType), 20, 20, 000000);
        mc.fontRenderer.drawString("Activation Type", 45, 20, 000000);
        mc.fontRenderer.drawString(Integer.toString(ShutterType), 20, 40, 000000);
        mc.fontRenderer.drawString("Shutter Type", 45, 40, 000000);
        mc.fontRenderer.drawString(Integer.toString(ShutterRotation), 20, 60, 000000);
        mc.fontRenderer.drawString("Shutter Rotation", 45, 60, 000000);
        mc.fontRenderer.drawString(Integer.toString(DropdownAmount), 20, 80, 000000);
        mc.fontRenderer.drawString("Dropdown Amount", 45, 80, 000000);
        //Camo Slot Text
        mc.fontRenderer.drawString("Camo Block",45, 100, 000000);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        ResourceLocation texture = new ResourceLocation("shutters", "/textures/gui/ShutterCoreGUI.png");

        this.xSize = 178;
        this.ySize = 219;
        mc.renderEngine.bindTexture(texture);

        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.ActivationType = te.getActivationType();
        this.ShutterType = te.getShutterDoorType();
        this.ShutterRotation = te.getShutterRotation();
        this.DropdownAmount = te.getDropdownAmount();
    }

    @Override
    public void initGui()
    {
        super.initGui();

        //Activation Type Switching
        buttonList.add(new GuiButton(1, guiLeft + 5, guiTop + 20, 10, 10, "-"));
        buttonList.add(new GuiButton(2, guiLeft + 30, guiTop + 20, 10, 10, "+"));

        //Shutter Type Switching
        buttonList.add(new GuiButton(3, guiLeft + 5, guiTop + 40, 10, 10, "-"));
        buttonList.add(new GuiButton(4, guiLeft + 30, guiTop + 40, 10, 10, "+"));

        //Shutter Rotation Switching
        buttonList.add(new GuiButton(5, guiLeft + 5, guiTop + 60, 10, 10, "-"));
        buttonList.add(new GuiButton(6, guiLeft + 30, guiTop + 60, 10, 10, "+"));

        //Dropdown Amount Changing
        buttonList.add(new GuiButton(7, guiLeft + 5, guiTop + 80, 10, 10, "-"));
        buttonList.add(new GuiButton(8, guiLeft + 30, guiTop + 80, 10, 10, "+"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton)
    {
        switch(guibutton.id)
        {
            //Activation Type Button (-)
            case 1:
            {
                if(ActivationType <= 0 || ActivationType > 2)
                {
                    LogHelper.fatal("Fatal Error in defining ActivationType");
                    te.setActivationType(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ActivationType == 1)
                {
                    te.setActivationType(ActivationType + 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ActivationType == 2)
                {
                    te.setActivationType(ActivationType - 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }

                break;
            }
            //Activation Type Button (+)
            case 2:
            {
                if(ActivationType <= 0 || ActivationType > 2)
                {
                    LogHelper.fatal("Fatal Error in Defining ActivationType");
                    te.setActivationType(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ActivationType == 1)
                {
                    te.setActivationType(ActivationType + 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ActivationType == 2)
                {
                    te.setActivationType(ActivationType - 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }

                break;
            }
            //Shutter Type Switching (-)
            case 3:
            {
                if(ShutterType <= 0 || ShutterType > 3)
                {
                    LogHelper.fatal("Fatal Error defining ShutterType");
                    te.setShutterDoorType(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterType == 1)
                {
                    te.setShutterDoorType(3);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterType == 2)
                {
                    te.setShutterDoorType(ShutterType - 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterType == 3)
                {
                    te.setShutterDoorType(ShutterType - 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }

                break;
            }
            //Shutter Type Switching (+)
            case 4:
            {
                if(ShutterType <= 0 || ShutterType > 3)
                {
                    LogHelper.fatal("Fatal error defining ShutterType");
                    te.setShutterDoorType(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterType == 1)
                {
                    te.setShutterDoorType(ShutterType + 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterType == 2)
                {
                    te.setShutterDoorType(ShutterType + 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterType == 3)
                {
                    te.setShutterDoorType(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                break;
            }
            //Shutter Rotation Switching (-)
            case 5:
            {
                if(ShutterRotation <= 0 || ShutterRotation > 4)
                {
                    LogHelper.fatal("Fatal Error defining ShutterRotation");
                    te.setShutterRotation(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));

                }
                else if(ShutterRotation == 1)
                {
                    te.setShutterDoorType(4);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterRotation == 2)
                {
                    te.setShutterRotation(ShutterRotation - 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterRotation == 3)
                {
                    te.setShutterRotation(ShutterRotation - 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterRotation == 4)
                {
                    te.setShutterRotation(ShutterRotation - 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }

                break;
            }

            //Shutter Rotation Switching (+)
            case 6:
            {
                if(ShutterRotation <= 0 || ShutterRotation > 4)
                {
                    LogHelper.fatal("Fatal Error defining ShutterRotation");
                    te.setShutterRotation(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterRotation == 1)
                {
                    te.setShutterRotation(ShutterRotation + 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterRotation == 2)
                {
                    te.setShutterRotation(ShutterRotation + 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterRotation == 3)
                {
                    te.setShutterRotation(ShutterRotation + 1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }
                else if(ShutterRotation == 4)
                {
                    te.setShutterRotation(1);
                    Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                }

                break;
            }

            //Dropdown Amount Switching (-)
            case 7:
            {
                if(ShutterType == 1)
                {
                    DropdownAmount = DropdownAmount - 1;
                    if (DropdownAmount > 0)
                    {
                        te.setDropdownAmount(DropdownAmount);
                        Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                    }
                }
                else
                {
                    return;
                }

                break;
            }

            //Dropdown Amount Switching (+)
            case 8:
            {
                if(ShutterType == 1)
                {
                    if (DropdownAmount > 0)
                    {
                        DropdownAmount = DropdownAmount + 1;
                        te.setDropdownAmount(DropdownAmount);
                        Shutters.network.sendToServer(new ShuttersMessage(te.xCoord, te.yCoord, te.zCoord, te.ActivationType, te.ShutterRotation, te.ShutterDoorType, te.DropdownAmount));
                    }
                }
                else
                {
                    return;
                }

                break;
            }
        }
    }
}
