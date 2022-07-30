/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.imp.capes.AresCapeImageBuffer
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.ImageBufferDownload
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.user.cosmetic.imp.capes;

import java.awt.image.BufferedImage;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.util.ResourceLocation;

public class AresCapeImageBuffer
extends ImageBufferDownload {
    private AbstractClientPlayer player;
    private ResourceLocation resourceLocation;
    private boolean elytraOfCape;

    public AresCapeImageBuffer(AbstractClientPlayer player, ResourceLocation resourceLocation) {
        this.player = player;
        this.resourceLocation = resourceLocation;
    }

    public BufferedImage parseUserSkin(BufferedImage imageRaw) {
        return imageRaw;
    }

    public void skinAvailable() {
        if (this.player != null) {
            this.player.setLocationOfAresCape(this.resourceLocation);
            this.player.setElytraOfCape(this.elytraOfCape);
        }
        this.cleanup();
    }

    public void cleanup() {
        this.player = null;
    }

    public boolean isElytraOfCape() {
        return this.elytraOfCape;
    }
}

