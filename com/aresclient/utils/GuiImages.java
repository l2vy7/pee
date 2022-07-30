/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.GuiImages
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiImages {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void drawPicture(int x, int y, int width, int height, String location) {
        ResourceLocation loc = new ResourceLocation(location);
        mc.getTextureManager().bindTexture(loc);
        Gui.drawModalRectWithCustomSizedTexture((int)x, (int)y, (float)0.0f, (float)0.0f, (int)width, (int)height, (float)width, (float)height);
    }

    public static void drawPictureWithTextureOffset(int x, int y, int u, int v, int width, int height, String location) {
        ResourceLocation loc = new ResourceLocation(location);
        mc.getTextureManager().bindTexture(loc);
        Gui.drawTexturedModalRect((int)x, (int)y, (int)u, (int)v, (int)width, (int)height);
    }

    public static void drawBackgroundPicture(int width, int height, String location) {
        ScaledResolution scaledResolution = new ScaledResolution(mc);
        ResourceLocation loc = new ResourceLocation(location);
        mc.getTextureManager().bindTexture(loc);
        Gui.drawModalRectWithCustomSizedTexture((int)0, (int)0, (float)0.0f, (float)0.0f, (int)scaledResolution.getScaledWidth(), (int)scaledResolution.getScaledHeight(), (float)scaledResolution.getScaledWidth(), (float)scaledResolution.getScaledHeight());
        Gui.drawRect((int)0, (int)0, (int)width, (int)height, (int)0x40000000);
    }
}

