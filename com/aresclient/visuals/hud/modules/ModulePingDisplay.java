/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.Position
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModulePingDisplay
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.Position;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import net.minecraft.client.Minecraft;

public class ModulePingDisplay
extends MoveableModule {
    public Position pos;

    public ModulePingDisplay(int x, int y, boolean enable) {
        super(x, y, enable);
    }

    public void render() {
        ModulePingDisplay.minecraft.fontRendererObj.drawStringWithShadow(String.valueOf(Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime()) + "[" + ConfigManager.settings.ModColor + "Ping\u00a7f] ", (float)(this.pos.getX() + 1), (float)(this.pos.getY() + 1), -1);
    }

    public int getWidth() {
        return ModulePingDisplay.minecraft.fontRendererObj.getStringWidth("[" + ConfigManager.settings.ModColor + "Ping\u00a7f] " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime());
    }

    public int getHeight() {
        return ModulePingDisplay.minecraft.fontRendererObj.FONT_HEIGHT;
    }

    public String getName() {
        return null;
    }
}

