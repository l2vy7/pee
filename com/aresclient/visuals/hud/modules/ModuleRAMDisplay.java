/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleRAMDisplay
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleRAMDisplay
extends MoveableModule {
    public ModuleRAMDisplay(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        Runtime runtime = Runtime.getRuntime();
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "RAM\u00a7f] " + (runtime.totalMemory() - runtime.freeMemory()) * 100L / runtime.maxMemory() + "% ", (float)this.getX(), (float)this.getY(), Color.white.getRGB());
    }

    public int getWidth() {
        Runtime runtime = Runtime.getRuntime();
        return ModuleRAMDisplay.minecraft.fontRendererObj.getStringWidth("[" + ConfigManager.settings.ModColor + "RAM\u00a7f] " + (runtime.totalMemory() - runtime.freeMemory()) * 100L / runtime.maxMemory() + "% ");
    }

    public int getHeight() {
        return ModuleRAMDisplay.minecraft.fontRendererObj.FONT_HEIGHT;
    }

    public String getName() {
        return "RAM Display";
    }
}

