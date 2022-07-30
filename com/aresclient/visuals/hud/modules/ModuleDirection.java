/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleDirection
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ModuleDirection
extends MoveableModule {
    private static ScaledResolution scaledResolution = new ScaledResolution(minecraft);
    private static final boolean enabledDefault = true;
    public static boolean enabled = true;
    private static final String alignModeDefault = "topcenter";
    public static String alignMode = "topcenter";
    private static final String markerColorDefault = "c";
    public static String markerColor = "c";
    private static final int compassIndexDefault = 0;
    public static int compassIndex = 0;
    private static final int xOffsetDefault = 2;
    public static int xOffset = 2;
    private static final int yOffsetDefault = 2;
    public static int yOffset = 2;
    private static final int yOffsetBottominecraftenterDefault = 41;
    public static int yOffsetBottominecraftenter = 41;
    private static final boolean applyXOffsetToCenterDefault = false;
    public static boolean applyXOffsetToCenter = false;
    private static final boolean applyYOffsetToMiddleDefault = false;
    public static boolean applyYOffsetToMiddle = false;
    private static final boolean showInChatDefault = true;
    public static boolean showInChat = true;

    public ModuleDirection(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        int direction = MathHelper.floor_double((double)((double)(ModuleDirection.minecraft.thePlayer.rotationYaw * 256.0f / 360.0f) + 0.5)) & 0xFF;
        int yBase = this.getY();
        int xBase = this.getX();
        minecraft.getTextureManager().bindTexture(new ResourceLocation("Ares/direction/Colors/" + ConfigManager.settings.ModColor + ".png"));
        if (direction < 128) {
            Gui.drawTexturedModalRect((int)xBase, (int)yBase, (int)direction, (int)(compassIndex * 24), (int)65, (int)12);
        } else {
            Gui.drawTexturedModalRect((int)xBase, (int)yBase, (int)(direction - 128), (int)(compassIndex * 24 + 12), (int)65, (int)12);
        }
        ModuleDirection.minecraft.fontRendererObj.drawString(String.valueOf(ConfigManager.settings.ModColor) + "|", xBase + 32, yBase + 1, 0xFFFFFF);
        ModuleDirection.minecraft.fontRendererObj.drawString(String.valueOf(ConfigManager.settings.ModColor) + "|", xBase + 32, yBase + 4, 0xFFFFFF);
    }

    private static int getX(int width) {
        return !(alignMode.equalsIgnoreCase(alignModeDefault) || alignMode.equalsIgnoreCase("middlecenter") || alignMode.equalsIgnoreCase("bottominecraftenter")) ? (!(alignMode.equalsIgnoreCase("topright") || alignMode.equalsIgnoreCase("middleright") || alignMode.equalsIgnoreCase("bottomright")) ? xOffset : scaledResolution.getScaledWidth() - width - xOffset) : scaledResolution.getScaledWidth() / 2 - width / 2 + (applyXOffsetToCenter ? xOffset : 0);
    }

    private static int getY(int rowCount, int height) {
        return !(alignMode.equalsIgnoreCase("middleleft") || alignMode.equalsIgnoreCase("middlecenter") || alignMode.equalsIgnoreCase("middleright")) ? (!alignMode.equalsIgnoreCase("bottomleft") && !alignMode.equalsIgnoreCase("bottomright") ? (alignMode.equalsIgnoreCase("bottominecraftenter") ? scaledResolution.getScaledHeight() - rowCount * height - yOffsetBottominecraftenter : yOffset) : scaledResolution.getScaledHeight() - rowCount * height - yOffset) : scaledResolution.getScaledHeight() / 2 - rowCount * height / 2 + (applyYOffsetToMiddle ? yOffset : 0);
    }

    public int getWidth() {
        return 66;
    }

    public int getHeight() {
        return 14;
    }

    public String getName() {
        return "Direction HUD";
    }
}

