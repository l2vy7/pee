/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticDragonWings
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
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
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticDragonWings
extends Cosmetic {
    private ModelRenderer wing;
    private ModelRenderer wingTip;
    private int textureWidth = 64;
    private int textureHeight = 32;
    boolean flying = false;

    public CosmeticDragonWings(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        ModelBiped modelBiped = new ModelBiped();
        int bw = this.textureWidth;
        int bh = this.textureWidth;
        this.textureWidth = 256;
        this.textureWidth = 256;
        this.wing = new ModelRenderer(playerRendererIn.mainModel, "wing");
        this.wing.setTextureSize(256, 256);
        this.wing.setRotationPoint(-12.0f, 5.0f, 2.0f);
        this.wing.isHidden = true;
        this.wingTip = new ModelRenderer(playerRendererIn.mainModel, "wingtip");
        this.wingTip.setTextureSize(256, 256);
        this.wingTip.setRotationPoint(-56.0f, 0.0f, 0.0f);
        this.wingTip.isHidden = true;
        this.wing.setTextureOffset(112, 136).addBox(-56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.wing.setTextureOffset(-56, 88).addBox(-56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wingTip.setTextureOffset(112, 88).addBox(-56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.wingTip.setTextureOffset(-56, 144).addBox(-56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wing.addChild(this.wingTip);
        this.textureWidth = bw;
        this.textureWidth = bh;
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        if (Ares.getAres().getUserManger().hasCosmetic(entitylivingbaseIn.getUniqueID().toString(), this.getCosmeticId()) || ConfigManager.settings.Wings == 2 && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.pushMatrix();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
            if (entitylivingbaseIn.isSneaking()) {
                GlStateManager.translate((float)0.0f, (float)0.04f, (float)0.0f);
            }
            float anSpeed = 100.0f;
            if (!entitylivingbaseIn.onGround || this.flying) {
                anSpeed = 10.0f;
                this.flying = true;
            }
            float f1 = limbSwingAmount + ageInTicks / anSpeed;
            float f2 = limbSwingAmount + ageInTicks / 100.0f;
            float f3 = f1 * (float)Math.PI * 2.0f;
            float f4 = 0.125f - (float)Math.cos(f3) * 0.2f;
            float fs5 = f2 * (float)Math.PI * 2.0f;
            float f5 = 0.125f - (float)Math.cos(fs5) * 0.2f;
            if (this.flying && (int)(f4 * 100.0f) == (int)(f5 * 100.0f)) {
                this.flying = false;
                anSpeed = 100.0f;
            }
            GlStateManager.color((float)255.0f, (float)255.0f, (float)255.0f);
            this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/wings/wings" + ConfigManager.settings.WingsTexture + ".png"));
            GlStateManager.scale((double)0.13, (double)0.13, (double)0.13);
            GlStateManager.translate((double)0.0, (double)-0.3, (double)1.1);
            GlStateManager.rotate((float)50.0f, (float)-50.0f, (float)0.0f, (float)0.0f);
            GlStateManager.color((float)255.0f, (float)255.0f, (float)255.0f);
            boolean x = false;
            boolean index = false;
            for (int i = 0; i < 2; ++i) {
                float f6 = f1 * (float)Math.PI * 2.0f;
                this.wing.rotateAngleX = 0.125f - (float)Math.cos(f6) * 0.2f;
                this.wing.rotateAngleY = 0.25f;
                this.wing.rotateAngleZ = (float)(Math.sin(f6) + 1.225) * 0.3f;
                this.wingTip.rotateAngleZ = -((float)(Math.sin(f6 + 2.0f) + 0.5)) * 0.75f;
                this.wing.isHidden = false;
                this.wingTip.isHidden = false;
                GlStateManager.color((float)255.0f, (float)255.0f, (float)255.0f);
                this.wing.render(scale);
                this.wing.isHidden = true;
                this.wingTip.isHidden = true;
                if (i != 0) continue;
                GlStateManager.scale((float)-1.0f, (float)1.0f, (float)1.0f);
            }
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public int getCosmeticId() {
        return 4;
    }
}

