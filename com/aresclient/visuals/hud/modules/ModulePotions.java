/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModulePotions
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.WorldRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.util.Collection;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class ModulePotions
extends MoveableModule {
    protected float zLevelFloat;

    public ModulePotions(int x, int y) {
        super(x, y, true);
    }

    public boolean isRenderDummy() {
        return true;
    }

    public void render() {
        int offsetX = 21;
        int offsetY = 14;
        int k = 16;
        int Y = this.getY();
        int X = this.getX();
        Collection collection = Minecraft.getMinecraft().thePlayer.getActivePotionEffects();
        if (!collection.isEmpty()) {
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.disableLighting();
            int l = 33;
            if (collection.size() > 5) {
                l = 132 / (collection.size() - 1);
            }
            for (PotionEffect potioneffect : Minecraft.getMinecraft().thePlayer.getActivePotionEffects()) {
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                if (potion.hasStatusIcon()) {
                    Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
                    int i1 = potion.getStatusIconIndex();
                    this.drawTexturedModalRect(X + offsetX - 20, Y + k - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
                }
                String s1 = I18n.format((String)potion.getName(), (Object[])new Object[0]);
                if (potioneffect.getAmplifier() == 1) {
                    s1 = String.valueOf(s1) + " " + I18n.format((String)"enchantment.level.2", (Object[])new Object[0]);
                } else if (potioneffect.getAmplifier() == 2) {
                    s1 = String.valueOf(s1) + " " + I18n.format((String)"enchantment.level.3", (Object[])new Object[0]);
                } else if (potioneffect.getAmplifier() == 3) {
                    s1 = String.valueOf(s1) + " " + I18n.format((String)"enchantment.level.4", (Object[])new Object[0]);
                }
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s1, (float)(X + offsetX), (float)(Y + k - offsetY), 0xFFFFFF);
                String s = Potion.getDurationString((PotionEffect)potioneffect);
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s, (float)(X + offsetX), (float)(Y + k + 10 - offsetY), 0x7F7F7F);
                k += l;
            }
        }
    }

    public void renderDummy() {
        int offsetX = 21;
        int offsetY = 14;
        int k = 16;
        int Y = this.getY();
        int X = this.getX();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableLighting();
        int l = 33;
        for (int i = 0; i < 4; ++i) {
            PotionEffect potioneffect = new PotionEffect(i + 1, 25);
            Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            if (potion.hasStatusIcon()) {
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
                int i1 = potion.getStatusIconIndex();
                this.drawTexturedModalRect(X + offsetX - 20, Y + k - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
            }
            String s1 = I18n.format((String)potion.getName(), (Object[])new Object[0]);
            if (potioneffect.getAmplifier() == 1) {
                s1 = String.valueOf(s1) + " " + I18n.format((String)"enchantment.level.2", (Object[])new Object[0]);
            } else if (potioneffect.getAmplifier() == 2) {
                s1 = String.valueOf(s1) + " " + I18n.format((String)"enchantment.level.3", (Object[])new Object[0]);
            } else if (potioneffect.getAmplifier() == 3) {
                s1 = String.valueOf(s1) + " " + I18n.format((String)"enchantment.level.4", (Object[])new Object[0]);
            }
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s1, (float)(X + offsetX), (float)(Y + k - offsetY), 0xFFFFFF);
            String s = Potion.getDurationString((PotionEffect)potioneffect);
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s, (float)(X + offsetX), (float)(Y + k + 10 - offsetY), 0x7F7F7F);
            k += l;
        }
    }

    public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
        float f = 0.00390625f;
        float f1 = 0.00390625f;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(x + 0), (double)(y + height), (double)this.zLevelFloat).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + height) * f1)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + height), (double)this.zLevelFloat).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + height) * f1)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + 0), (double)this.zLevelFloat).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + 0) * f1)).endVertex();
        worldrenderer.pos((double)(x + 0), (double)(y + 0), (double)this.zLevelFloat).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + 0) * f1)).endVertex();
        tessellator.draw();
    }

    public int getWidth() {
        return 100;
    }

    public int getHeight() {
        return 160;
    }

    public String getName() {
        return "Potionstatus";
    }
}

