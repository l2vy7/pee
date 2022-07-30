/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleTogglesprint
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleTogglesprint
extends MoveableModule {
    public ModuleTogglesprint(int x, int y) {
        super(x, y, true);
    }

    public boolean isRenderDummy() {
        return true;
    }

    public void render() {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(Minecraft.getMinecraft().thePlayer.movementInput.getDisplayText(), (float)this.getX(), (float)this.getY(), Color.white.getRGB());
    }

    public void renderDummy() {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("\u00a7f[" + ConfigManager.settings.ModColor + "Sprinting Toggled" + "\u00a7f]", (float)this.getX(), (float)this.getY(), Color.white.getRGB());
    }

    public int getWidth() {
        return ModuleTogglesprint.minecraft.fontRendererObj.getStringWidth(this.isRenderDummy() ? "\u00a7f[" + ConfigManager.settings.ModColor + "Sprinting Toggled" + "\u00a7f]" : Minecraft.getMinecraft().thePlayer.movementInput.getDisplayText());
    }

    public int getHeight() {
        return ModuleTogglesprint.minecraft.fontRendererObj.FONT_HEIGHT;
    }

    public String getName() {
        return "Togglesprint";
    }
}

