/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleShowPing
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleShowPing
extends MoveableModule {
    public ModuleShowPing(int x, int y, boolean enable) {
        super(x, y, true);
    }

    public void render() {
        if (!Minecraft.getMinecraft().isIntegratedServerRunning()) {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Ping\u00a7f] " + ModuleShowPing.minecraft.getCurrentServerData().pingToServer + "ms", (float)this.getX(), (float)this.getY(), Color.white.getRGB());
        } else {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Ping\u00a7f] 0", (float)this.getX(), (float)this.getY(), -1);
        }
    }

    public int getWidth() {
        return Minecraft.getMinecraft().fontRendererObj.getStringWidth("[" + ConfigManager.settings.ModColor + "Ping\u00a7f] " + ModuleShowPing.minecraft.getCurrentServerData().pingToServer);
    }

    public int getHeight() {
        return ModuleShowPing.minecraft.fontRendererObj.FONT_HEIGHT;
    }

    public String getName() {
        return "Ping";
    }
}

