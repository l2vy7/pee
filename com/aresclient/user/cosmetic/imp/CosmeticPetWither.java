/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticPetWither
 *  com.aresclient.user.cosmetic.imp.CosmeticPetWither$GhastModel
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.user.cosmetic.imp.CosmeticPetWither;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticPetWither
extends Cosmetic {
    GhastModel ghastmodel;
    public static final ResourceLocation TEXTURE = new ResourceLocation("Ares/wither.png");
    double j = -0.6;

    public CosmeticPetWither(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        this.ghastmodel = new GhastModel(playerRendererIn);
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        if (entitylivingbaseIn == Minecraft.getMinecraft().thePlayer && ConfigManager.settings.WitherPet == 2) {
            GlStateManager.pushMatrix();
            this.playerRenderer.bindTexture(TEXTURE);
            if (ConfigManager.settings.Shoulder == 1) {
                GlStateManager.translate((double)0.7, (double)this.j, (double)0.0);
            } else {
                GlStateManager.translate((double)-0.7, (double)this.j, (double)0.0);
            }
            if (entitylivingbaseIn.isSneaking()) {
                GlStateManager.translate((double)0.0, (double)0.045, (double)0.0);
            }
            this.ghastmodel.render((Entity)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, HeadPitch, HeadPitch, scale / 4.0f);
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public int getCosmeticId() {
        return 0;
    }
}

