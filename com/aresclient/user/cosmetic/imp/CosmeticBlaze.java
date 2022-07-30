/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticBlaze
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.user.cosmetic.imp;

import com.aresclient.Ares;
import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticBlaze
extends Cosmetic {
    private ModelRenderer[] blazeSticks = new ModelRenderer[12];

    public CosmeticBlaze(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        for (int i = 0; i < this.blazeSticks.length; ++i) {
            this.blazeSticks[i] = new ModelRenderer((ModelBase)this.playerModel, 0, 16);
            this.blazeSticks[i].addBox(0.0f, 0.0f, 0.0f, 2, 8, 2);
        }
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        if (Ares.getAres().getUserManger().hasCosmetic(entitylivingbaseIn.getUniqueID().toString(), this.getCosmeticId()) || ConfigManager.settings.Blaze == 2 && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.pushMatrix();
            this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/blaze/blaze" + ConfigManager.settings.BlazeTexture + ".png"));
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            this.setRotationAngles(ageInTicks);
            ModelRenderer[] arrmodelRenderer = this.blazeSticks;
            int n = this.blazeSticks.length;
            for (int i = 0; i < n; ++i) {
                ModelRenderer blazeStick = arrmodelRenderer[i];
                blazeStick.render(scale);
            }
            GlStateManager.popMatrix();
        }
    }

    public void setRotationAngles(float Ticks) {
        float f = Ticks * (float)Math.PI * -0.1f;
        for (int i = 0; i < 4; ++i) {
            this.blazeSticks[i].rotationPointY = -2.0f + MathHelper.cos((float)(((float)(i * 2) + Ticks) * 0.25f));
            this.blazeSticks[i].rotationPointX = MathHelper.cos((float)f) * 9.0f;
            this.blazeSticks[i].rotationPointZ = MathHelper.sin((float)f) * 9.0f;
            f += 1.0f;
        }
        f = 0.7853982f + Ticks * (float)Math.PI * 0.03f;
        for (int j = 4; j < 8; ++j) {
            this.blazeSticks[j].rotationPointY = 2.0f + MathHelper.cos((float)(((float)(j * 2) + Ticks) * 0.25f));
            this.blazeSticks[j].rotationPointX = MathHelper.cos((float)f) * 7.0f;
            this.blazeSticks[j].rotationPointZ = MathHelper.sin((float)f) * 7.0f;
            f += 1.0f;
        }
        f = 0.47123894f + Ticks * (float)Math.PI * -0.05f;
        for (int k = 8; k < 12; ++k) {
            this.blazeSticks[k].rotationPointY = 11.0f + MathHelper.cos((float)(((float)k * 1.5f + Ticks) * 0.5f));
            this.blazeSticks[k].rotationPointX = MathHelper.cos((float)f) * 5.0f;
            this.blazeSticks[k].rotationPointZ = MathHelper.sin((float)f) * 5.0f;
            f += 1.0f;
        }
    }

    public int getCosmeticId() {
        return 2;
    }
}

