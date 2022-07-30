/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleFPS
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleFPS
extends MoveableModule {
    public ModuleFPS(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        StringBuilder stringBuilder = new StringBuilder("[").append(ConfigManager.settings.ModColor).append("FPS\u00a7f] ");
        Minecraft.getMinecraft();
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(stringBuilder.append(Minecraft.getDebugFPS()).toString(), (float)this.getX(), (float)this.getY(), Color.white.getRGB());
    }

    public int getWidth() {
        StringBuilder stringBuilder = new StringBuilder("[\u00a74FPS\u00a7f] ");
        Minecraft.getMinecraft();
        return ModuleFPS.minecraft.fontRendererObj.getStringWidth(stringBuilder.append(Minecraft.getDebugFPS()).toString()) + 1;
    }

    public int getHeight() {
        return ModuleFPS.minecraft.fontRendererObj.FONT_HEIGHT;
    }

    public String getName() {
        return "FPS";
    }
}

