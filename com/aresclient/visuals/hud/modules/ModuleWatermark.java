/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleWatermark
 *  com.aresclient.visuals.utils.GuiImageRender
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.aresclient.visuals.utils.GuiImageRender;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleWatermark
extends MoveableModule {
    public ModuleWatermark(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("\u00a7f", (float)this.getX(), (float)this.getY(), Color.white.getRGB());
        GuiImageRender.drawPicture((int)this.getX(), (int)this.getY(), (int)25, (int)25, (String)"Ares/Icons/Logos/Light.png");
    }

    public int getWidth() {
        return 25;
    }

    public int getHeight() {
        return 25;
    }

    public String getName() {
        return "Watermark";
    }
}

