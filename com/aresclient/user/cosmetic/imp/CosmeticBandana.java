/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticBandana
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBiped
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
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticBandana
extends Cosmetic {
    private ModelRenderer band1;
    private ModelRenderer band2;
    private ModelRenderer band3;
    private ModelRenderer band4;

    public CosmeticBandana(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        ModelBiped modelBiped = new ModelBiped();
        this.band1 = new ModelRenderer((ModelBase)modelBiped, 0, 0);
        this.band1.addBox(-4.5f, -7.0f, -4.5f, 9, 2, 1);
        this.band2 = new ModelRenderer((ModelBase)modelBiped, 0, 0);
        this.band2.addBox(3.5f, -7.0f, -3.5f, 1, 2, 8);
        this.band3 = new ModelRenderer((ModelBase)modelBiped, 0, 0);
        this.band3.addBox(-4.5f, -7.0f, -3.5f, 1, 2, 8);
        this.band4 = new ModelRenderer((ModelBase)modelBiped, 0, 0);
        this.band4.addBox(-4.5f, -7.0f, 4.0f, 9, 2, 1);
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        if (Ares.getAres().getUserManger().hasCosmetic(entitylivingbaseIn.getUniqueID().toString(), this.getCosmeticId()) || ConfigManager.settings.Bandana == 2 && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.pushMatrix();
            if (entitylivingbaseIn.isSneaking()) {
                GL11.glTranslated((double)0.0, (double)0.225, (double)0.0);
            }
            this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/bandana/bandana" + ConfigManager.settings.BandanaTexture + ".png"));
            this.band1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
            this.band1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
            this.band1.rotationPointX = 0.0f;
            this.band1.rotationPointY = 0.0f;
            this.band1.render(scale);
            this.band2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
            this.band2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
            this.band2.rotationPointX = 0.0f;
            this.band2.rotationPointY = 0.0f;
            this.band2.render(scale);
            this.band3.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
            this.band3.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
            this.band3.rotationPointX = 0.0f;
            this.band3.rotationPointY = 0.0f;
            this.band3.render(scale);
            this.band4.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
            this.band4.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
            this.band4.rotationPointX = 0.0f;
            this.band4.rotationPointY = 0.0f;
            this.band4.render(scale);
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public int getCosmeticId() {
        return 1;
    }
}

