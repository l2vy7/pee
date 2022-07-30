/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleArmorHud
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModuleArmorHud
extends MoveableModule {
    public ModuleArmorHud(int x, int y) {
        super(x, y, true);
    }

    public boolean isRenderDummy() {
        return true;
    }

    private void renderItemStack(int x1, int x, int y, ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        GL11.glPushMatrix();
        int yAdd = -16 * y + 48;
        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(itemStack, x, x1 + yAdd);
        GL11.glPopMatrix();
    }

    public void render() {
        for (int o = 0; o < Minecraft.getMinecraft().thePlayer.inventory.armorInventory.length; ++o) {
            ItemStack itemStack = Minecraft.getMinecraft().thePlayer.inventory.armorInventory[o];
            this.renderItemStack(this.getY(), this.getX(), o, itemStack);
        }
    }

    public void renderDummy() {
        new Item();
        this.renderItemStack(this.getY(), this.getX(), 3, new ItemStack(Item.getItemById((int)310)));
        new Item();
        this.renderItemStack(this.getY(), this.getX(), 2, new ItemStack(Item.getItemById((int)311)));
        new Item();
        this.renderItemStack(this.getY(), this.getX(), 1, new ItemStack(Item.getItemById((int)312)));
        new Item();
        this.renderItemStack(this.getY(), this.getX(), 0, new ItemStack(Item.getItemById((int)313)));
    }

    public int getWidth() {
        return 66;
    }

    public int getHeight() {
        return 67;
    }

    public String getName() {
        return "ArmorHud";
    }
}

