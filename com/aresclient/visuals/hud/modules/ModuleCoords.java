/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleCoords
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleCoords
extends MoveableModule {
    public ModuleCoords(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "X\u00a7f] " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L, (float)this.getX(), (float)this.getY(), Color.white.getRGB());
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Y\u00a7f] " + Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0) / 1000L, (float)this.getX(), (float)(this.getY() + 10), Color.white.getRGB());
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Z\u00a7f] " + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0) / 1000L, (float)this.getX(), (float)(this.getY() + 20), Color.white.getRGB());
    }

    public int getWidth() {
        double length = (Minecraft.getMinecraft().thePlayer.posX + Minecraft.getMinecraft().thePlayer.posZ + Minecraft.getMinecraft().thePlayer.posY) / 3.0;
        return ModuleCoords.minecraft.fontRendererObj.getStringWidth("[\u00a74X\u00a7f] " + Math.round(length * 1000.0) / 1000L) + 2;
    }

    public int getHeight() {
        return 30;
    }

    public String getName() {
        return "Coords";
    }
}

