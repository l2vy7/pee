/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.imp.capes.particle.ParticleStar
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.WorldRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.user.cosmetic.imp.capes.particle;

import java.beans.ConstructorProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ParticleStar {
    private static final long FADE_TIME = 250000L;
    private double x;
    private double y;
    private long timestampSpawned;

    public void render() {
        double starSize = (double)(this.timestampSpawned - System.currentTimeMillis()) / 30000.0;
        double offset = starSize / 2.0;
        GL11.glColor4f((float)255.0f, (float)255.0f, (float)255.0f, (float)255.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Ares/Capes/Star/star.png"));
        this.drawTexture(this.x - offset, this.y - offset, 0.0, 0.0, 255.0, 255.0, starSize, starSize, 1.2f);
    }

    public boolean isFadedOut() {
        return System.currentTimeMillis() - this.timestampSpawned > 2500L;
    }

    public void drawTexture(double x, double y, double texturePosX, double texturePosY, double imageWidth, double imageHeight, double maxWidth, double maxHeight, float alpha) {
        GL11.glPushMatrix();
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        double sizeWidth = maxWidth / imageWidth;
        double sizeHeight = maxHeight / imageHeight;
        GL11.glScaled((double)sizeWidth, (double)sizeHeight, (double)0.0);
        this.drawUVTexture(x / sizeWidth, y / sizeHeight, texturePosX, texturePosY, x / sizeWidth + imageWidth - x / sizeWidth, y / sizeHeight + imageHeight - y / sizeHeight);
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    private void drawUVTexture(double x, double y, double textureX, double textureY, double width, double height) {
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        int xi = 25;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        worldrenderer.pos(x + 0.0, y + height, (double)xi).tex((double)((float)(textureX + 0.0) * 0.00390625f), (double)((float)(textureY + height) * 0.00390625f)).endVertex();
        worldrenderer.pos(x + width, y + height, (double)xi).tex((double)((float)(textureX + width) * 0.00390625f), (double)((float)(textureY + height) * 0.00390625f)).endVertex();
        worldrenderer.pos(x + width, y + 0.0, (double)xi).tex((double)((float)(textureX + width) * 0.00390625f), (double)((float)(textureY + 0.0) * 0.00390625f)).endVertex();
        worldrenderer.pos(x + 0.0, y + 0.0, (double)xi).tex((double)((float)(textureX + 0.0) * 0.00390625f), (double)((float)(textureY + 0.0) * 0.00390625f)).endVertex();
        tessellator.draw();
    }

    @ConstructorProperties(value={"x", "y", "timestampSpawned"})
    public ParticleStar(double x, double y, long timestampSpawned) {
        this.x = x;
        this.y = y;
        this.timestampSpawned = timestampSpawned;
    }
}

