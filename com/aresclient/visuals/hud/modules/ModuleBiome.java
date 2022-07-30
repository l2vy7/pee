/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleBiome
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.BlockPos
 *  net.minecraft.world.biome.WorldChunkManager
 *  net.minecraft.world.chunk.Chunk
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;

public class ModuleBiome
extends MoveableModule {
    public ModuleBiome(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        BlockPos blockpos = new BlockPos(Minecraft.getMinecraft().getRenderViewEntity().posX, Minecraft.getMinecraft().getRenderViewEntity().getEntityBoundingBox().minY, Minecraft.getMinecraft().getRenderViewEntity().posZ);
        Chunk chunk = Minecraft.getMinecraft().theWorld.getChunkFromBlockCoords(blockpos);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Biome\u00a7f] " + chunk.getBiome((BlockPos)blockpos, (WorldChunkManager)Minecraft.getMinecraft().theWorld.getWorldChunkManager()).biomeName, (float)this.getX(), (float)this.getY(), Color.white.getRGB());
    }

    public int getWidth() {
        BlockPos blockpos = new BlockPos(Minecraft.getMinecraft().getRenderViewEntity().posX, Minecraft.getMinecraft().getRenderViewEntity().getEntityBoundingBox().minY, Minecraft.getMinecraft().getRenderViewEntity().posZ);
        Chunk chunk = Minecraft.getMinecraft().theWorld.getChunkFromBlockCoords(blockpos);
        return ModuleBiome.minecraft.fontRendererObj.getStringWidth("[" + ConfigManager.settings.ModColor + "Biome\u00a7f] " + chunk.getBiome((BlockPos)blockpos, (WorldChunkManager)Minecraft.getMinecraft().theWorld.getWorldChunkManager()).biomeName) + 1;
    }

    public int getHeight() {
        return ModuleBiome.minecraft.fontRendererObj.FONT_HEIGHT;
    }

    public String getName() {
        return "Biome";
    }
}

