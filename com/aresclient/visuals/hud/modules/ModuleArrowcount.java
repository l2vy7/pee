/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleArrowcount
 *  net.minecraft.client.Minecraft
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModuleArrowcount
extends MoveableModule {
    public ModuleArrowcount(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        if (this.getRemainingArrows() < 1) {
            ModuleArrowcount.minecraft.fontRendererObj.drawStringWithShadow(String.valueOf(this.getRemainingArrows()), (float)(this.getX() + 8), (float)(this.getY() + 15), Color.WHITE.getRGB());
        } else {
            ModuleArrowcount.minecraft.fontRendererObj.drawStringWithShadow(String.valueOf(this.getRemainingArrows()), (float)(this.getX() + 8), (float)(this.getY() + 15), Color.WHITE.getRGB());
        }
        Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(new ItemStack(Items.arrow), this.getX() + 3, this.getY() - 1);
    }

    public int getWidth() {
        return 25;
    }

    public int getHeight() {
        return 30;
    }

    public String getName() {
        return "ArrowCount";
    }

    private int getRemainingArrows() {
        int i = 0;
        ItemStack[] arritemStack = Minecraft.getMinecraft().thePlayer.inventory.mainInventory;
        int n = Minecraft.getMinecraft().thePlayer.inventory.mainInventory.length;
        for (int j = 0; j < n; ++j) {
            ItemStack itemstack = arritemStack[j];
            if (itemstack == null || !itemstack.getItem().equals((Object)Items.arrow)) continue;
            i += itemstack.stackSize;
        }
        return i;
    }
}

