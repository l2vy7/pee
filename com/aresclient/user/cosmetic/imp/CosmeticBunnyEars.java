/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticBunnyEars
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

public class CosmeticBunnyEars
extends Cosmetic {
    private ModelRenderer ear1;
    private ModelRenderer ear2;

    public CosmeticBunnyEars(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        ModelBiped modelBiped = new ModelBiped();
        this.ear1 = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
        this.ear1.addBox(-2.5f, -12.0f, -3.5f, 2, 8, 2);
        this.ear2 = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
        this.ear2.addBox(0.5f, -12.0f, -3.5f, 2, 8, 2);
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        if (Ares.getAres().getUserManger().hasCosmetic(entitylivingbaseIn.getUniqueID().toString(), this.getCosmeticId()) || ConfigManager.settings.BunnyEars == 2 && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.pushMatrix();
            if (entitylivingbaseIn.isSneaking()) {
                GL11.glTranslated((double)0.0, (double)0.225, (double)0.0);
            }
            this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/BunnyEars/BunnyEars" + ConfigManager.settings.BunnyEarsTexture + ".png"));
            int i = 61680;
            int j = i % 65536;
            int k = i / 65536;
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)0.3f);
            this.ear1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
            this.ear1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
            this.ear1.rotationPointX = 0.0f;
            this.ear1.rotationPointY = 0.0f;
            this.ear1.render(scale);
            this.ear2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
            this.ear2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
            this.ear2.rotationPointX = 0.0f;
            this.ear2.rotationPointY = 0.0f;
            this.ear2.render(scale);
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public int getCosmeticId() {
        return 3;
    }
}

