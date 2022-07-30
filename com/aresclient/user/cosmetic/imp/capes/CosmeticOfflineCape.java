/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.imp.capes.CosmeticOfflineCape
 *  com.aresclient.utils.CapeAnimation
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.user.cosmetic.imp.capes;

import com.aresclient.utils.CapeAnimation;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CosmeticOfflineCape
implements LayerRenderer<AbstractClientPlayer> {
    private final RenderPlayer playerRenderer;
    static CapeAnimation anim;

    public CosmeticOfflineCape(RenderPlayer playerRendererIn) {
        this.playerRenderer = playerRendererIn;
        anim = new CapeAnimation(ConfigManager.settings.capepath, ConfigManager.settings.MaxFrames, 1);
    }

    public static void update() {
        anim = new CapeAnimation(ConfigManager.settings.capepath, ConfigManager.settings.MaxFrames, 1);
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
        if (entitylivingbaseIn.hasPlayerInfo() && !entitylivingbaseIn.isInvisible() && ConfigManager.settings.capemode.equals("offline") && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            if (!ConfigManager.settings.AnimatedCape) {
                entitylivingbaseIn.setLocationOfOfflineCape(new ResourceLocation(ConfigManager.settings.capepath));
            } else {
                entitylivingbaseIn.setLocationOfOfflineCape(anim.getTexture());
                anim.update();
            }
            this.playerRenderer.bindTexture(entitylivingbaseIn.getlocationOfOfflineCape());
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.125f);
            double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * (double)partialTicks - (entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * (double)partialTicks);
            double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * (double)partialTicks - (entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * (double)partialTicks);
            double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * (double)partialTicks - (entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * (double)partialTicks);
            float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
            double d3 = MathHelper.sin((float)(f * (float)Math.PI / 180.0f));
            double d4 = -MathHelper.cos((float)(f * (float)Math.PI / 180.0f));
            float f1 = (float)d1 * 10.0f;
            f1 = MathHelper.clamp_float((float)f1, (float)-6.0f, (float)32.0f);
            float f2 = (float)(d0 * d3 + d2 * d4) * 100.0f;
            float f3 = (float)(d0 * d4 - d2 * d3) * 100.0f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 165.0f) {
                f2 = 165.0f;
            }
            if (f1 < -5.0f) {
                f1 = -5.0f;
            }
            float f4 = entitylivingbaseIn.prevCameraYaw + (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
            f1 += MathHelper.sin((float)((entitylivingbaseIn.prevDistanceWalkedModified + (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified) * partialTicks) * 6.0f)) * 32.0f * f4;
            if (entitylivingbaseIn.isSneaking()) {
                f1 += 25.0f;
                GlStateManager.translate((float)0.0f, (float)0.142f, (float)-0.0178f);
            }
            GlStateManager.rotate((float)(6.0f + f2 / 2.0f + f1), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)(f3 / 2.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.rotate((float)(-f3 / 2.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.playerRenderer.getMainModel().renderOfflineCape(0.0625f);
            GlStateManager.popMatrix();
        }
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}

