/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleCps
 *  net.minecraft.client.Minecraft
 *  org.lwjgl.input.Mouse
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;

public class ModuleCps
extends MoveableModule {
    private List<Long> clicks = new ArrayList();
    private boolean wasPressed;
    private long lastPressed;
    private List<Long> clicks2 = new ArrayList();
    private boolean wasPressed2;
    private long lastPressed2;

    public ModuleCps(int x, int y) {
        super(x, y, true);
    }

    private int getCPS() {
        long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000L < time);
        long time2 = System.currentTimeMillis();
        this.clicks2.removeIf(aLong2 -> aLong2 + 1000L < time2);
        return this.clicks.size();
    }

    public void render() {
        boolean lpressed = Mouse.isButtonDown((int)0);
        boolean rpressed = Mouse.isButtonDown((int)1);
        if (lpressed != this.wasPressed) {
            this.lastPressed = System.currentTimeMillis() + 10L;
            this.wasPressed = lpressed;
            if (lpressed) {
                this.clicks.add(this.lastPressed);
            }
        }
        if (rpressed != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10L;
            this.wasPressed2 = rpressed;
            if (rpressed) {
                this.clicks2.add(this.lastPressed2);
            }
        }
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "CPS\u00a7f] " + this.getCPS(), (float)this.getX(), (float)this.getY(), Color.white.getRGB());
    }

    public int getWidth() {
        return Minecraft.getMinecraft().fontRendererObj.getStringWidth("[" + ConfigManager.settings.ModColor + "CPS\u00a7f] " + this.getCPS());
    }

    public int getHeight() {
        return ModuleCps.minecraft.fontRendererObj.FONT_HEIGHT;
    }

    public String getName() {
        return "Cps";
    }
}

