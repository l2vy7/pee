/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.Cosmetic
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 */
package com.aresclient.user.cosmetic;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public abstract class Cosmetic
implements LayerRenderer<AbstractClientPlayer> {
    protected final ModelBiped playerModel;
    protected final RenderPlayer playerRenderer;

    public Cosmetic(RenderPlayer playerRendererIn) {
        this.playerRenderer = playerRendererIn;
        this.playerModel = playerRendererIn.getMainModel();
    }

    public abstract void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
        if (entitylivingbaseIn.hasPlayerInfo() && !entitylivingbaseIn.isInvisible()) {
            this.render(entitylivingbaseIn, p_177141_2_, p_177141_3_, partialTicks, p_177141_5_, p_177141_6_, p_177141_7_, scale);
        }
    }

    public boolean shouldCombineTextures() {
        return false;
    }

    public abstract int getCosmeticId();
}

