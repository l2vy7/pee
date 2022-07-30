/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.CapeAnimation
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.utils;

import net.minecraft.util.ResourceLocation;

/*
 * Exception performing whole class analysis ignored.
 */
public class CapeAnimation {
    private final int framesPerSecond;
    private final ResourceLocation[] textures;
    private int currentFrame = 1;
    private long nextUpdate;

    public CapeAnimation(String folder, int frames, int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
        this.newUpdateTimeStamp();
        this.textures = new ResourceLocation[frames];
        for (int i = 0; i < frames; ++i) {
            this.textures[i] = CapeAnimation.location((String)(String.valueOf(folder) + i + ").png"));
        }
    }

    public ResourceLocation getTexture() {
        return this.textures[this.currentFrame];
    }

    public void newUpdateTimeStamp() {
        this.nextUpdate = System.currentTimeMillis() + (long)(this.framesPerSecond * 50);
    }

    public void update() {
        if (System.currentTimeMillis() > this.nextUpdate) {
            this.newUpdateTimeStamp();
            ++this.currentFrame;
            if (this.currentFrame > this.textures.length - 1) {
                this.currentFrame = 1;
            }
        }
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation("", path);
    }
}

