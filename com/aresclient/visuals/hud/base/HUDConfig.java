/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.HUDConfig
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleArmorHud
 *  com.aresclient.visuals.hud.modules.ModuleArrowcount
 *  com.aresclient.visuals.hud.modules.ModuleBiome
 *  com.aresclient.visuals.hud.modules.ModuleCoords
 *  com.aresclient.visuals.hud.modules.ModuleCps
 *  com.aresclient.visuals.hud.modules.ModuleDirection
 *  com.aresclient.visuals.hud.modules.ModuleFPS
 *  com.aresclient.visuals.hud.modules.ModuleKeystrokes
 *  com.aresclient.visuals.hud.modules.ModulePotions
 *  com.aresclient.visuals.hud.modules.ModuleRAMDisplay
 *  com.aresclient.visuals.hud.modules.ModuleTogglesprint
 *  com.aresclient.visuals.hud.modules.ModuleWatermark
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 */
package com.aresclient.visuals.hud.base;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.aresclient.visuals.hud.modules.ModuleArmorHud;
import com.aresclient.visuals.hud.modules.ModuleArrowcount;
import com.aresclient.visuals.hud.modules.ModuleBiome;
import com.aresclient.visuals.hud.modules.ModuleCoords;
import com.aresclient.visuals.hud.modules.ModuleCps;
import com.aresclient.visuals.hud.modules.ModuleDirection;
import com.aresclient.visuals.hud.modules.ModuleFPS;
import com.aresclient.visuals.hud.modules.ModuleKeystrokes;
import com.aresclient.visuals.hud.modules.ModulePotions;
import com.aresclient.visuals.hud.modules.ModuleRAMDisplay;
import com.aresclient.visuals.hud.modules.ModuleTogglesprint;
import com.aresclient.visuals.hud.modules.ModuleWatermark;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class HUDConfig {
    public List<MoveableModule> moveableModules = new ArrayList();
    public Minecraft minecraft = Minecraft.getMinecraft();
    ScaledResolution sr = new ScaledResolution(this.minecraft);

    public HUDConfig() {
        this.setModules();
    }

    public void setModules() {
        this.moveableModules.clear();
        this.moveableModules.add(new ModuleCoords(15, 15));
        this.moveableModules.add(new ModuleFPS(15, 45));
        this.moveableModules.add(new ModuleTogglesprint(15, 55));
        this.moveableModules.add(new ModuleCps(15, 65));
        this.moveableModules.add(new ModuleBiome(15, 75));
        this.moveableModules.add(new ModuleDirection(150, 5));
        this.moveableModules.add(new ModuleKeystrokes(15, 100));
        this.moveableModules.add(new ModuleWatermark(this.sr.getScaledWidth() - 30, 5));
        this.moveableModules.add(new ModuleArmorHud(15, this.sr.getScaledHeight() - 70));
        this.moveableModules.add(new ModulePotions(300, 180));
        this.moveableModules.add(new ModuleArrowcount(200, 180));
        this.moveableModules.add(new ModuleRAMDisplay(210, 200));
    }
}

