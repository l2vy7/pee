/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticHalo
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
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
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticHalo
extends Cosmetic {
    private ModelRenderer band1;
    private ModelRenderer band2;
    private ModelRenderer band3;
    private ModelRenderer band4;

    public CosmeticHalo(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        this.band1 = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
        this.band1.addBox(-3.5f, -13.0f, -4.0f, 7, 1, 1);
        this.band2 = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
        this.band2.addBox(3.0f, -13.0f, -3.5f, 1, 1, 7);
        this.band3 = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
        this.band3.addBox(-4.0f, -13.0f, -3.5f, 1, 1, 7);
        this.band4 = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
        this.band4.addBox(-3.5f, -13.0f, 3.0f, 7, 1, 1);
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        if (Ares.getAres().getUserManger().hasCosmetic(entitylivingbaseIn.getUniqueID().toString(), this.getCosmeticId()) || ConfigManager.settings.Halo == 2 && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.pushMatrix();
            if (entitylivingbaseIn.isSneaking()) {
                GL11.glTranslated((double)0.0, (double)0.225, (double)0.0);
            }
            this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/halo/halo" + ConfigManager.settings.HaloTexture + ".png"));
            this.band1.rotateAngleX = 0.0f;
            this.band1.rotateAngleY = 0.0f;
            this.band1.rotationPointX = 0.0f;
            this.band1.rotationPointY = 0.0f;
            this.band1.render(scale);
            this.band2.rotateAngleX = 0.0f;
            this.band2.rotateAngleY = 0.0f;
            this.band2.rotationPointX = 0.0f;
            this.band2.rotationPointY = 0.0f;
            this.band2.render(scale);
            this.band3.rotateAngleX = 0.0f;
            this.band3.rotateAngleY = 0.0f;
            this.band3.rotationPointX = 0.0f;
            this.band3.rotationPointY = 0.0f;
            this.band3.render(scale);
            this.band4.rotateAngleX = 0.0f;
            this.band4.rotateAngleY = 0.0f;
            this.band4.rotationPointX = 0.0f;
            this.band4.rotationPointY = 0.0f;
            this.band4.render(scale);
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public int getCosmeticId() {
        return 5;
    }
}

