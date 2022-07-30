/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticWitchHat
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

public class CosmeticWitchHat
extends Cosmetic {
    private static final ResourceLocation witchTextures = new ResourceLocation("Ares/cosmetic/witch.png");
    private ModelRenderer witchHat;

    public CosmeticWitchHat(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        ModelBiped modelBiped = new ModelBiped();
        this.witchHat = new ModelRenderer((ModelBase)modelBiped).setTextureSize(40, 34);
        this.witchHat.setRotationPoint(-5.0f, -10.03125f, -5.0f);
        this.witchHat.setTextureOffset(0, 0).addBox(0.0f, 0.0f, 0.0f, 10, 2, 10);
        ModelRenderer modelrenderer = new ModelRenderer((ModelBase)modelBiped).setTextureSize(40, 34);
        modelrenderer.setRotationPoint(1.75f, -4.0f, 2.0f);
        modelrenderer.setTextureOffset(0, 12).addBox(0.0f, 0.0f, 0.0f, 7, 4, 7);
        modelrenderer.rotateAngleX = -0.05235988f;
        modelrenderer.rotateAngleZ = 0.02617994f;
        this.witchHat.addChild(modelrenderer);
        ModelRenderer modelrenderer1 = new ModelRenderer((ModelBase)modelBiped).setTextureSize(40, 34);
        modelrenderer1.setRotationPoint(1.75f, -4.0f, 2.0f);
        modelrenderer1.setTextureOffset(0, 23).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        modelrenderer1.rotateAngleX = -0.10471976f;
        modelrenderer1.rotateAngleZ = 0.05235988f;
        modelrenderer.addChild(modelrenderer1);
        ModelRenderer modelrenderer2 = new ModelRenderer((ModelBase)modelBiped).setTextureSize(40, 34);
        modelrenderer2.setRotationPoint(1.75f, -2.0f, 2.0f);
        modelrenderer2.setTextureOffset(0, 31).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.25f);
        modelrenderer2.rotateAngleX = -0.20943952f;
        modelrenderer2.rotateAngleZ = 0.10471976f;
        modelrenderer1.addChild(modelrenderer2);
        this.witchHat.isHidden = true;
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        if (Ares.getAres().getUserManger().hasCosmetic(entitylivingbaseIn.getUniqueID().toString(), this.getCosmeticId()) || ConfigManager.settings.WitchHat == 2 && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.pushMatrix();
            float f = 0.995f;
            GlStateManager.scale((float)f, (float)f, (float)f);
            this.playerRenderer.bindTexture(witchTextures);
            if (entitylivingbaseIn.isSneaking()) {
                GL11.glTranslated((double)0.0, (double)0.325, (double)0.0);
            }
            GlStateManager.rotate((float)netHeadYaw, (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)HeadPitch, (float)1.0f, (float)0.0f, (float)0.0f);
            this.witchHat.isHidden = false;
            this.witchHat.render(scale);
            this.witchHat.isHidden = true;
            GlStateManager.popMatrix();
        }
    }

    public int getCosmeticId() {
        return 6;
    }
}

